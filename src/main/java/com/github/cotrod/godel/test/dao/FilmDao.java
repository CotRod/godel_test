package com.github.cotrod.godel.test.dao;

import com.github.cotrod.godel.test.model.FilmDto;

import java.time.LocalDate;
import java.util.List;

public interface FilmDao {
    List<FilmDto> getFilmsByDirectorId(Long id);

    List<FilmDto> getFilmsAfterDate(LocalDate date);

    List<FilmDto> getFilmsByDirectorIdAndAfterDate(Long id, LocalDate date);
}
