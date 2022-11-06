package ru.yandex.practicum.filmorate.storage.review.likes;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewLikesDbStorage implements ReviewLikesStorage {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void addLike(Integer reviewId, Integer userId) {
        String sql = "INSERT INTO REVIEW_LIKES (REVIEW_ID, USER_ID) " +
                "VALUES (?, ?)";
        jdbcTemplate.update(sql, reviewId, userId);
    }

    @Override
    public void deleteLike(Integer reviewId, Integer userId) {
        String sql = "DELETE FROM REVIEW_LIKES WHERE REVIEW_ID = ? AND USER_ID = ?";
        jdbcTemplate.update(sql, reviewId, userId);
    }
}
