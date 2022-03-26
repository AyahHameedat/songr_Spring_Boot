package com.example.songr.infrastructure;

import com.example.songr.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface AlbumsRepositories extends JpaRepository<Album, Long> {
}
