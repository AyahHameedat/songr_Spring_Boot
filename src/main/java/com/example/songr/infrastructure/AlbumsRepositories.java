package com.example.songr.infrastructure;

import com.example.songr.domain.Album;
import org.springframework.data.repository.CrudRepository;


public interface AlbumsRepositories extends CrudRepository<Album, Integer> {
}
