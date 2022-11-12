package ru.yandex.practicum.filmorate.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.yandex.practicum.filmorate.dto.FilmDto;
import ru.yandex.practicum.filmorate.model.Film;

@Mapper
public interface FilmMapper {
    FilmMapper mapper = Mappers.getMapper(FilmMapper.class);
    Film toFilm(FilmDto filmDto);
    FilmDto toFilmDto(Film film);
}
