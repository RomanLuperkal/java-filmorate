package ru.yandex.practicum.filmorate.storage.review.dislikes;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewDislikesDbStorage implements ReviewDislikesStorage {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void addDislike(Integer reviewId, Integer userId) {
        String sql = "INSERT INTO REVIEW_DISLIKES (REVIEW_ID, USER_ID) " +
                "VALUES (?, ?)";
        jdbcTemplate.update(sql, reviewId, userId);
    }

    @Override
    public void deleteDislike(Integer reviewId, Integer userId) {
        String sql = "DELETE FROM REVIEW_DISLIKES WHERE REVIEW_ID = ? AND USER_ID = ?";
        jdbcTemplate.update(sql, reviewId, userId);
    }
}
