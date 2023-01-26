# *Java-Filmorate*

---

Описание проекта
-
Приложение представляет собой социальную сеть для просмотра фильмов по своим предпочтениям и рекомендациям друзей.


Использованные технологии:
-

- Java 11, Maven, Spring-Boot, H2 database, Lombok, JDBC, H2Database

Функционал приложения:
-
Приложение предоставляет возможность:

- Добавлять\редактировать\удалять пользователей\фильмы
- Оставлять отзывы на фильмы
- Оценивать фильмы
- Добавлять\удалять друзей
- Просматривать общих друзей
- Просматривать ленту событий по действиям друзей в соц. сети
- Формировать рекомендации к просмотру фильмов

2. ER диаграмма базы данных приложения:
![ER_diagram_for_filmorate](/assets/images/filmorate.png)

Инструкция по запуску:
-
1. Для запуска приложения необходимо подключиться базе данных H2:

- Connection type: Embedded
- path: ./db/filmorate.mv.db
- spring.datasource.username=sa
- spring.datasource.password=password

2. Для проверки функциональности и работоспособности приложения предусмотрены postman тесты:
   [filmorate-tests](https://github.com/RomanLuperkal/java-shareit/blob/main/postman/ShareIt-test.json)  

