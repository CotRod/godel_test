###Тестовое задание для Godel Technologies 

Скрипты для создания и заполнения таблиц находятся тут:
`src/main/resources/scripts.sql`

Приложение запускается из этого класса:
`src/main/java/com/github/cotrod/godel/test/TestApplication`

А тут его можно настроить:
`src/main/resources/application.yml`

А если захочется проверить работоспособность, то воспользовавшись rest api клиентом (ну, или в браузере), нужно "постучаться" по адресам:
___
`http://localhost:8081/film?directorId={id}` - Поиск фильмов по id режиссера
___
`http://localhost:8081/film?date={date}` - Поиск фильмов с даты выхода
___
`http://localhost:8081/film?directorId={id}&date={date}` - Поиск фильмов и по id, и с даты
___
Вместо {id} - должен быть id режиссера, а вместо {date} - дата в формате **ddMMyyyy**

- [X] REST API
- [X] Unit тесты
- [ ] Web User Interface (Возможно,будет чуть позже, но это не точно)

Have a nice day! :wink: