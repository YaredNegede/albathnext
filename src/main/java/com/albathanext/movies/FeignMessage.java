package com.albathanext.movies;

import lombok.Data;

import java.util.List;

@Data
public class FeignMessage {
    private boolean success;
    private int status_code;
    private String status_message;
    private int page;
    private List<Movie> results;
    private int total_pages;
    private int total_results;
}
