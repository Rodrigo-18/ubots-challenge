package br.com.ubots.score;
import br.com.ubots.movie.Movie;
import br.com.ubots.movie.MovieRepository;

import static java.lang.String.format;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.http.HttpStatus.*;

@RestController
public class ScoreController {
    @Autowired
    ScoreRepository scoreRepository;
    
    @Autowired
    MovieRepository movieRepository;
    
    @PostMapping("/movies/score/{movieId}")
    ResponseEntity<Score> newMovie(@PathVariable("movieId") Long id, @RequestBody @Valid Score newScoreRequest) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, format("Course with code %s not found", id)));
        newScoreRequest.setMovie(movie);
        scoreRepository.save(newScoreRequest);
        movie.setScore(scoreRepository.getScore(id));
        movieRepository.save(movie);
        return ResponseEntity.ok(newScoreRequest);
    }
}




