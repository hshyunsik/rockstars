package com.rockstars.finder.controller;

import com.rockstars.finder.model.Artist;
import com.rockstars.finder.model.Song;
import com.rockstars.finder.repository.ArtistRepository;
import com.rockstars.finder.repository.SongRepository;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/artists")
@Slf4j
public class FinderController {

  ArtistRepository artistRepository;
  SongRepository songRepository;

  @Autowired
  public void setSongRepository(SongRepository songRepository) {
    this.songRepository = songRepository;
  }

  @Autowired
  public void setArtistRepository(ArtistRepository artistRepository) {
    this.artistRepository = artistRepository;
  }

  @GetMapping(path = "/artists/{name}")
  public ResponseEntity<Artist> findArtistByName(@PathVariable String name) {
    return new ResponseEntity<>(artistRepository.findByName(name), HttpStatus.OK);
  }

  @GetMapping(path = "/songs/{genre}")
  public ResponseEntity<List<Song>> findSongsByGenre(@PathVariable String genre) {
    return new ResponseEntity<>(songRepository.findSongsByGenre(genre), HttpStatus.OK);
  }

  @PostMapping(path = "/artists/create")
  public @ResponseBody
  ResponseEntity<String> createArtist(@RequestParam("name") String name) {
    Artist artist = new Artist(name);
    try {
      artistRepository.save(artist);
    } catch (Exception e) {
      return new ResponseEntity<>("Your artist already exists", HttpStatus.BAD_REQUEST);
    }
    // Test twice
    return new ResponseEntity<>("Your artist has been succesfully added", HttpStatus.OK);
  }

  @PostMapping(path = "/songs/create")
  public @ResponseBody
  ResponseEntity<String> createSong(@Valid @RequestBody Song song) {
    Song newSong = new Song(song.getName(), song.getYear(), song.getArtist(),
        song.getShortname(), song.getBpm(), song.getDuration(), song.getGenre(), song.getSpotifyId()
        , song.getAlbum());
    songRepository.save(newSong);
    return new ResponseEntity<>("Your song has been succesfully created", HttpStatus.OK);
  }

  @PutMapping(path = "artists/update")
  public @ResponseBody
  ResponseEntity<String> updateArtist(@RequestBody @Valid Artist artist) {
    artistRepository.save(artist);
    return new ResponseEntity<>("Your artist has been succesfully updated", HttpStatus.OK);
  }

  @PutMapping(path = "songs/update")
  public @ResponseBody
  ResponseEntity<String> updateSong(@Valid @RequestBody Song song) {
    songRepository.save(song);
    return new ResponseEntity<>("Your song has been succesfully updated", HttpStatus.OK);
  }

  @DeleteMapping(path = "artists/")
  public @ResponseBody
  ResponseEntity<String> deleteArtist(@RequestParam("id") Long id) {
    artistRepository.deleteById(id);
    return new ResponseEntity<>("Your artist has been succesfully deleted", HttpStatus.OK);
  }

  @DeleteMapping(path = "songs/")
  public @ResponseBody
  ResponseEntity<String> deleteSong(@RequestParam("id") Long id) {
    songRepository.deleteById(id);
    return new ResponseEntity<>("Your artist has been succesfully deleted", HttpStatus.OK);
  }
}
