package com.github.cotrod.godel.test.dao.repository;

import com.github.cotrod.godel.test.dao.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> getFilmsByReleaseDateGreaterThanEqual(LocalDate date);

    List<Film> getFilmsByDirector_Id(Long id);

    List<Film> getFilmsByDirector_IdAndReleaseDateGreaterThanEqual(Long id, LocalDate date);
}
