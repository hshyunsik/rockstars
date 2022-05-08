package com.rockstars.finder;

import com.rockstars.finder.model.Artist;
import com.rockstars.finder.model.Song;
import com.rockstars.finder.api.ApiClient;
import com.rockstars.finder.repository.ArtistRepository;
import com.rockstars.finder.repository.SongRepository;
import com.rockstars.finder.service.FilterService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class FinderApplication {

	private ApiClient client;
	private FilterService service;

	private ArtistRepository artistRepository;
	private SongRepository songRepository;

	@Autowired
	public void setClient(ApiClient client) {
		this.client = client;
	}

	@Autowired
	public void setService(FilterService service){
		this.service = service;
	}

	@Autowired
	public void setArtistRepository(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}

	@Autowired
	public void setSongRepository(SongRepository songRepository) {
		this.songRepository = songRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FinderApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return (args) -> {
				Artist[] artists = client.retrieveArtists();
				Song[] songs = client.retrieveSongs();

				List<Artist> filteredArtists = service.filterArtists(artists, songs);
				List<Song> filteredSongs = service.filterSongs(songs);

				artistRepository.saveAll(filteredArtists);
				songRepository.saveAll(filteredSongs);

				log.info("json loaded");
		};
	}
}
