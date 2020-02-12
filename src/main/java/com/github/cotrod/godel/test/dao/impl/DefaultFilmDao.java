package com.github.cotrod.godel.test.dao.impl;

import com.github.cotrod.godel.test.dao.FilmDao;
import com.github.cotrod.godel.test.dao.converter.FilmConverter;
import com.github.cotrod.godel.test.dao.entity.Film;
import com.github.cotrod.godel.test.dao.repository.FilmRepository;
import com.github.cotrod.godel.test.model.FilmDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DefaultFilmDao implements FilmDao {
    private final FilmRepository filmRepository;

    public DefaultFilmDao(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<FilmDto> getFilmsByDirectorId(Long id) {
        List<Film> films = filmRepository.getFilmsByDirector_Id(id);
        return getDtoList(films);
    }

    @Override
    public List<FilmDto> getFilmsAfterDate(LocalDate date) {
        List<Film> films = filmRepository.getFilmsByReleaseDateGreaterThanEqual(date);
        return getDtoList(films);
    }

    @Override
    public List<FilmDto> getFilmsByDirectorIdAndAfterDate(Long id, LocalDate date) {
        List<Film> films = filmRepository.getFilmsByDirector_IdAndReleaseDateGreaterThanEqual(id, date);
        return getDtoList(films);
    }

    private List<FilmDto> getDtoList(List<Film> films) {
        List<FilmDto> filmDtoList = new ArrayList<>();
        if (films.size() > 0) {
            films.forEach(film -> filmDtoList.add(FilmConverter.toDto(film)));
        }
        return filmDtoList;
    }
}
