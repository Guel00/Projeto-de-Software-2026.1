package com.kinoin.model;

import com.kinoin.enums.MovieStatus;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String genre;
    private int ratingAge;
    private MovieStatus status;
    private double averageRating;
    private int totalRatings;
    private List<Review> reviews;

    // 1. O CONSTRUTOR AGORA É PRIVADO
    // Isso força o uso do Builder para criar um Movie
    private Movie(Builder builder) {
        this.title = builder.title;
        this.genre = builder.genre;
        this.ratingAge = builder.ratingAge;
        this.status = builder.status;
        this.averageRating = 0.0;
        this.totalRatings = 0;
        this.reviews = new ArrayList<>();
    }

    // --- MÉTODOS DE NEGÓCIO (MANTIDOS) ---
    public void addReview(Review review) {
        double newRating = review.getScore();
        double currentTotalPoints = this.averageRating * totalRatings;
        this.totalRatings++;
        this.averageRating = (currentTotalPoints + newRating) / this.totalRatings;
        this.reviews.add(review);
    }

    // --- GETTERS (MANTIDOS) ---
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getRatingAge() { return ratingAge; }
    public MovieStatus getMovieStatus() { return status; }
    public void setMovieStatus(MovieStatus status) { this.status = status; }
    public double getAverageRating() { return averageRating; }
    public int getTotalRatings() { return totalRatings; }

    // --- 2. A CLASSE ESTRUTURAL: BUILDER ---
    public static class Builder {
        private String title;
        private String genre;
        private int ratingAge;
        private MovieStatus status;

        // Métodos do Builder retornam o próprio Builder (Fluent Interface)
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder ratingAge(int ratingAge) {
            this.ratingAge = ratingAge;
            return this;
        }

        public Builder status(MovieStatus status) {
            this.status = status;
            return this;
        }

        // O método final que entrega o objeto pronto
        public Movie build() {
            return new Movie(this);
        }
    }
}