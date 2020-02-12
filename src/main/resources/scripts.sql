create schema cinema;
-- creating tables
create table director
(
	id bigint(64) auto_increment,
	first_name varchar(64) not null,
	last_name varchar(64) not null,
	birth_date date not null,
	constraint director_pk
		primary key (id)
);

create table film
(
	id bigint(64) auto_increment,
	director_id bigint(64) not null,
	film_name varchar(64) not null,
	release_date date not null,
	genre varchar(15) not null,
	constraint film_pk
		primary key (id),
	constraint film_director_id_fk
		foreign key (director_id) references director (id)
);
-- filling them
INSERT INTO cinema.director (id, first_name, last_name, birth_date)
VALUES (1, 'firstDirector', 'withManyFilms', '1967-02-03');
INSERT INTO cinema.director (id, first_name, last_name, birth_date)
VALUES (2, 'secondDirector', 'withoutFilms', '2020-02-11');
INSERT INTO cinema.director (id, first_name, last_name, birth_date)
VALUES (3, 'thirdDirector', 'twoFilmsInOneDate', '2011-11-11');
INSERT INTO cinema.director (id, first_name, last_name, birth_date)
VALUES (4, 'fourthDirector', 'hasOnlyOneFilm', '1970-01-08');

INSERT INTO cinema.film (director_id, film_name, release_date, genre)
VALUES (1, 'firFilmFirstDir', '2020-02-10', 'COMEDY');
INSERT INTO cinema.film (director_id, film_name, release_date, genre)
VALUES (1, 'secFilmFirstDir', '2020-02-11', 'ACTION');
INSERT INTO cinema.film (director_id, film_name, release_date, genre)
VALUES (1, 'thrFilmFirstDir', '2020-02-13', 'CRIME');
INSERT INTO cinema.film (director_id, film_name, release_date, genre)
VALUES (1, 'fouFilmFirstDir', '2020-02-14', 'COMEDY');
INSERT INTO cinema.film (director_id, film_name, release_date, genre)
VALUES (3, 'firFilmThirdDir', '2020-02-11', 'ACTION');
INSERT INTO cinema.film (director_id, film_name, release_date, genre)
VALUES (3, 'secFilmThirdDir', '2020-02-11', 'CRIME');
INSERT INTO cinema.film (director_id, film_name, release_date, genre)
VALUES (4, 'onlyOneFIlm', '2020-02-09', 'COMEDY');
