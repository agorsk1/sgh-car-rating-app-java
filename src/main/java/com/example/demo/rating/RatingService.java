package com.example.demo.rating;

import com.example.demo.rating.errors.IncorrectEmailException;
import com.example.demo.rating.errors.IncorrectRatingValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public void addRating(Rating rating) {

        if (!rating.getEmail().contains("@")){
            throw new IncorrectEmailException("email: " + rating.getEmail() + " is incorrect");

        } else if (rating.getRating() < 1 || rating.getRating() > 5) {
            throw new IncorrectRatingValueException("Rating must be from 1 to 5");
        } else
        {
            ratingRepository.save(rating);
        }


    }

}
