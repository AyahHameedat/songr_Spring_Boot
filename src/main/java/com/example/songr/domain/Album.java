package com.example.songr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Album {
//    title, an artist, a songCount, a length (in seconds), and an imageUrl that is a link to that album’s art.

    @Setter(value = AccessLevel.NONE)
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    private String title;
    private String artist;
    private int songCount;
    private int length;
    private String imageUrl;


    @OneToMany(mappedBy = "album")
    private Set<song> songs;

}


