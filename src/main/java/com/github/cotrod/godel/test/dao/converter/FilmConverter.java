package com.github.cotrod.godel.test.dao.converter;

import com.github.cotrod.godel.test.dao.entity.Film;
import com.github.cotrod.godel.test.model.FilmDto;

public class FilmConverter {
    public static FilmDto toDto(Film film){
        FilmDto filmDto = new FilmDto();
        filmDto.setFirstName(film.getDirector().getFirstName());
        filmDto.setLastName(film.getDirector().getLastName());
        filmDto.setBirthDate(film.getDirector().getBirthDate());
        filmDto.setFilmName(film.getFilmName());
        filmDto.setReleaseDate(film.getReleaseDate());
        filmDto.setGenre(film.getGenre());
        return filmDto;
    }
}
