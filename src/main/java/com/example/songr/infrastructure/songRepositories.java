package com.example.songr.infrastructure;

import com.example.songr.domain.song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface songRepositories extends JpaRepository<song, Long> {
//    List<song> findAllByAlbum_Id(Long id);
}
