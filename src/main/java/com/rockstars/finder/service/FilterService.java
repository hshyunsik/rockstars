package com.rockstars.finder.service;

import com.rockstars.finder.model.Artist;
import com.rockstars.finder.model.Song;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FilterService {

  public List<Artist> filterArtists(Artist[] artists, Song[] songs) {
    return Arrays.stream(artists)
        .filter(artist -> Arrays.stream(songs)
            .anyMatch(song ->
                song.getGenre().contains("Metal")
                    && song.getArtist().equals(artist.getName())
            )
        )
        .collect(Collectors.toList());
  }

  public List<Song> filterSongs(Song[] songs) {
    return Arrays.stream(songs)
        .filter(song -> song.getYear() < 2016 )
        .collect(Collectors.toList());
  }
}
