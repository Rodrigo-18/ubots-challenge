package br.com.ubots.movie;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Movie {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @Size(max = 20)
    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;
    
    @NotBlank
    @Column(nullable = false)
    private String synopsis;
    
    @Column(nullable = false)
    private Double score = 0.0;
    
    public Movie(){}
    
    public Movie(String name, String synopsis, Double score) {
        this.name = name;
        this.synopsis = synopsis;
        this.score = score;
    }
    
    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Double getScore() {
        return score;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setScore(Double score) {
        this.score = score;
    }
    


}
