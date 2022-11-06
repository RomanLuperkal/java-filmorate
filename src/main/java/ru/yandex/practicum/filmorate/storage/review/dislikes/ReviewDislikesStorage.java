package ru.yandex.practicum.filmorate.storage.review.dislikes;

public interface ReviewDislikesStorage {

    void addDislike(Integer reviewId, Integer userId);

    void deleteDislike(Integer reviewId, Integer userId);
}
