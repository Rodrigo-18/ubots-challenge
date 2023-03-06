package br.com.ubots.score;

import br.com.ubots.movie.Movie;
import java.io.Serializable;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


import static javax.persistence.GenerationType.IDENTITY;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;


@Entity
public class Score implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Movie movie;
    
    @DecimalMax("5.0") @DecimalMin("0.0") 
    @Column(nullable = false)
    private Double value;
    
    public Score(){}
    
    public Score(Double value) {
        this.value = value;
    }
    
    public Long getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Double getValue() {
        return value;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setValue(Double value) {
        this.value = value;
    }
    

    
    
}


