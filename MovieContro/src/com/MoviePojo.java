package com;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviePojo {
    private String movieName;
    private String movieId;
    private String movieRating;
    private Double score;
    private String actors;
    private Double price;
}
