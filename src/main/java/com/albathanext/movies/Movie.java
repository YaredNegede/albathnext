package com.albathanext.movies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String poster_path;

    private boolean adult;

    @Column(columnDefinition="TEXT")
    private String overview;

    private String release_date;

    private String original_title;

    private String original_language;

    private String title;

    private String backdrop_path;

    private double popularity;

    private int vote_count;

    private boolean video;

    private double vote_average;

}
