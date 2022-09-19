package com.example.demo.rating;

import com.example.demo.rating.errors.IncorrectEmailException;
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

        if (rating.getEmail().contains("@")){
            ratingRepository.save(rating);
        } else {
            throw new IncorrectEmailException("email" + rating.getEmail() + "is incorrect");
        }


    }

}
