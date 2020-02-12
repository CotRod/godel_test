package com.github.cotrod.godel.test.configuration;

import com.github.cotrod.godel.test.dao.FilmDao;
import com.github.cotrod.godel.test.dao.impl.DefaultFilmDao;
import com.github.cotrod.godel.test.dao.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.github.cotrod.godel.test.dao.repository")
@EntityScan("com.github.cotrod.godel.test.dao.entity")
@PropertySource("classpath:/application.yml")
public class GodelTestConfiguration {
    @Autowired
    private FilmRepository filmRepository;

    @Bean
    public FilmDao filmDao() {
        return new DefaultFilmDao(filmRepository);
    }
}
