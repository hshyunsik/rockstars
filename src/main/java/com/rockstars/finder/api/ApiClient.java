package com.rockstars.finder.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rockstars.finder.model.Artist;
import com.rockstars.finder.model.Song;
import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Named
@Slf4j
public class ApiClient {

  RestTemplate restTemplate;
  ObjectMapper mapper;

  public ApiClient(){
    this.restTemplate = new RestTemplate();
    this.mapper = new ObjectMapper();
  }

  public Artist[] retrieveArtists() throws IOException {
    Artist[] artists = mapper.readValue(new File(getArtistsPath()), Artist[].class);
    return artists;
  }

  public Song[] retrieveSongs() throws IOException {
    Song[] songs = mapper.readValue(new File(getSongsPath()), Song[].class);
    return songs;
  }

  private String getArtistsPath() {
    return "./src/main/resources/artists.json";
  }

  private String getSongsPath() {
    return "./src/main/resources/songs.json";
  }
}
