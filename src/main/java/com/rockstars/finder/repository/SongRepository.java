package com.rockstars.finder.repository;

import com.rockstars.finder.model.Artist;
import com.rockstars.finder.model.Song;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
  List<Song> findSongsByGenre(String genre);
}
