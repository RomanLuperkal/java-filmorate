package ru.yandex.practicum.filmorate.validation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.Review;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.storage.film.FilmStorage;
import ru.yandex.practicum.filmorate.storage.review.ReviewStorage;
import ru.yandex.practicum.filmorate.storage.user.UserStorage;

@Slf4j
@Component
@AllArgsConstructor
public class Validation {

    public static void validateReviewId(ReviewStorage reviewStorage, Integer reviewId) {
        if (reviewStorage.getAllReviews().stream().map(Review::getReviewId).noneMatch(x -> x.equals(reviewId))) {
            log.warn("user entered invalid id of review = " + reviewId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "review with id = " + reviewId + " not found");
        }
    }

    public static void validateCountOfLimit(Integer count) {
        if (count <= 0) {
            log.warn("user entered invalid count = " + count);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid value of count = " + count);
        }
    }

    public static void validateFilmId(FilmStorage filmStorage, Integer filmId) {
        if (filmId <= 0) {
            log.warn("user entered invalid id of film = " + filmId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "film with id = " + filmId + " not found");
        }
        if (filmStorage.getFilmsList().stream().map(Film::getId).noneMatch(x -> x.equals(filmId))) {
            log.warn("user entered invalid id of film = " + filmId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "film with id = " + filmId + " not found");
        }
    }

    public static void validateUserId(UserStorage userStorage, Integer userId) {
        if (userId <= 0) {
            log.warn("user entered invalid id of user = " + userId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user with id = " + userId + " not found");
        }
        if (userStorage.getUsersList().stream().map(User::getId).noneMatch(x -> x.equals(userId))) {
            log.warn("user entered invalid id of user = " + userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user with id = " + userId + " not found");
        }
    }
}
