package br.com.ubots.score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScoreRepository extends JpaRepository<Score, Long>{
    
    @Query("SELECT AVG(s.value) FROM Score s WHERE s.movie.id = ?1")
    Double getScore(Long movieId);
}
