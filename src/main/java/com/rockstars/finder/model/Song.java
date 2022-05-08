package com.rockstars.finder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="artist_id")
  @JsonProperty("Id")
  private Long id;

  @Column(name="artist_name", nullable=false)
  @JsonProperty("Name")
  private String name;

  @JsonProperty("Year")
  private int year;

  @JsonProperty("Artist")
  private String artist;

  @JsonProperty("Shortname")
  private String shortname;

  @JsonProperty("Bpm")
  private int bpm;

  @JsonProperty("Duration")
  private int duration;

  @JsonProperty("Genre")
  private String genre;

  @JsonProperty("SpotifyId")
  private String spotifyId;

  @JsonProperty("Album")
  private String album;

  public Song(String name, int year, String artist, String shortname, int bpm, int duration,
      String genre, String spotifyId, String album) {
    this.name = name;
    this.year = year;
    this.artist = artist;
    this.shortname = shortname;
    this.bpm = bpm;
    this.duration = duration;
    this.genre = genre;
    this.spotifyId = spotifyId;
    this.album = album;
  }

  public Song(Long id, String name, int year, String artist, String shortname, int bpm,
      int duration, String genre, String spotifyId, String album) {
    this.id = id;
    this.name = name;
    this.year = year;
    this.artist = artist;
    this.shortname = shortname;
    this.bpm = bpm;
    this.duration = duration;
    this.genre = genre;
    this.spotifyId = spotifyId;
    this.album = album;
  }

  public Song(){}
}
