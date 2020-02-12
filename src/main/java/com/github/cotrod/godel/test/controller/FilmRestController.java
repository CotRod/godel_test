package com.github.cotrod.godel.test.controller;

import com.github.cotrod.godel.test.dao.FilmDao;
import com.github.cotrod.godel.test.model.FilmDto;
import com.github.cotrod.godel.test.req.DefaultReq;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmRestController {
    FilmDao filmDao;

    public FilmRestController(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @GetMapping
    public ResponseEntity<List<FilmDto>> getFilms(DefaultReq req) {
        List<FilmDto> filmDtoList;
        if (req.getDate() != null && req.getDirectorId() != null) {
            filmDtoList = filmDao.getFilmsByDirectorIdAndAfterDate(req.getDirectorId(), req.getDate());
        } else if (req.getDirectorId() != null) {
            filmDtoList = filmDao.getFilmsByDirectorId(req.getDirectorId());
        } else if (req.getDate() != null) {
            filmDtoList = filmDao.getFilmsAfterDate(req.getDate());
        } else {
            filmDtoList = new ArrayList<>();
        }
        return filmDtoList.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(filmDtoList, HttpStatus.OK);
    }
}
