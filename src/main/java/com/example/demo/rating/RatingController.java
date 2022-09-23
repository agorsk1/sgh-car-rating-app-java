package com.example.demo.rating;

import com.example.demo.rating.errors.IncorrectEmailException;
import com.example.demo.rating.errors.IncorrectRatingValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/rating")
public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> conflict(DataIntegrityViolationException e) {
        String message = NestedExceptionUtils.getMostSpecificCause(e).getMessage();
        return new ResponseEntity<Object>(
                message, new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IncorrectEmailException.class)
    public ResponseEntity<?> conflict(IncorrectEmailException e) {
        String message = NestedExceptionUtils.getMostSpecificCause(e).getMessage();
        return new ResponseEntity<Object>(
                message, new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IncorrectRatingValueException.class)
    public ResponseEntity<?> conflict(IncorrectRatingValueException e) {
        String message = NestedExceptionUtils.getMostSpecificCause(e).getMessage();
        return new ResponseEntity<Object>(
                message, new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @PostMapping
    public void registerNewCar(@RequestBody Rating rating) {
        ratingService.addRating(rating);
    }
}
