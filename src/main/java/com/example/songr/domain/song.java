package com.example.songr.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties({"album"})
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class song {

//    A Song has a title, a length (in seconds), a trackNumber, and the album on which that song appears.

    @Setter(value = AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    private String title;

    private double length;
    private int trackNumber;

    @ManyToOne
    Album album;

}