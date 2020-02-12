package com.github.cotrod.godel.test.req;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DefaultReq {
    private Long directorId;
    @DateTimeFormat(pattern = "ddMMyyyy")
    private LocalDate date;

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
