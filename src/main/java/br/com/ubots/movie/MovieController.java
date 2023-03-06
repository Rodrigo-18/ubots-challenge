package br.com.ubots.movie;

import io.swagger.annotations.Api;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.*;

@RestController
public class MovieController {
    
    @Autowired
    MovieRepository movieRepository;
    
    @GetMapping("/movies")
    ResponseEntity<List<Movie>> allMovies() {
       List<Movie> movies = movieRepository.findAll(); 
       return ResponseEntity.ok(movies);
    }
    
    @PostMapping("/movies")
    ResponseEntity<Movie> newMovie(@RequestBody @Valid Movie newMovieRequest) {
        return ResponseEntity.ok(movieRepository.save(newMovieRequest));
    }
    
    @PutMapping("/movies/{movieId}")
    ResponseEntity<Movie> updateMovie(@PathVariable("movieId") Long id, @RequestBody @Valid Movie movie) {
        Movie movieO = movieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, format("Course with code %s not found", movie)));
        movie.setId(movieO.getId());
        return ResponseEntity.ok(movieRepository.save(movie));
    }
    
    @DeleteMapping("/movies/{movieId}")
    ResponseEntity<Void> deleteMovie(@PathVariable("movieId") Long id ) {
        if(!movieRepository.existsById(id)) return new ResponseEntity<>(NOT_FOUND); 
        movieRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
}

