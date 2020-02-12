package com.github.cotrod.godel.test.dao.impl;

import com.github.cotrod.godel.test.configuration.GodelTestConfiguration;
import com.github.cotrod.godel.test.dao.FilmDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ContextConfiguration(classes = GodelTestConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DefaultFilmDaoTest {
    @Autowired
    FilmDao filmDao;

    @Test
    void getFilmsByDirectorId() {
        assertEquals(4, filmDao.getFilmsByDirectorId(1L).size());
        assertEquals(0, filmDao.getFilmsByDirectorId(2L).size());
        assertEquals(2, filmDao.getFilmsByDirectorId(3L).size());
        assertEquals(1, filmDao.getFilmsByDirectorId(4L).size());
    }

    @Test
    void getFilmsAfterDate() {
        assertEquals(7,filmDao.getFilmsAfterDate(LocalDate.parse("09022020", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
        assertEquals(2,filmDao.getFilmsAfterDate(LocalDate.parse("13022020", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
        assertEquals(0,filmDao.getFilmsAfterDate(LocalDate.parse("15022020", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
    }

    @Test
    void getFilmsByDirectorIdAndAfterDate() {
        assertEquals(2, filmDao.getFilmsByDirectorIdAndAfterDate(1L,LocalDate.parse("12022020", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
        assertEquals(2, filmDao.getFilmsByDirectorIdAndAfterDate(1L,LocalDate.parse("13022020", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
        assertEquals(0, filmDao.getFilmsByDirectorIdAndAfterDate(2L,LocalDate.parse("13022020", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
        assertEquals(2, filmDao.getFilmsByDirectorIdAndAfterDate(3L,LocalDate.parse("10022020", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
    }
}