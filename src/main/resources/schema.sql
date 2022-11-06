DROP TABLE IF EXISTS genre_films CASCADE;
DROP TABLE IF EXISTS friend_request CASCADE;
DROP TABLE IF EXISTS likes CASCADE;
DROP TABLE IF EXISTS person CASCADE;
DROP TABLE IF EXISTS film CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;
DROP TABLE IF EXISTS review_likes CASCADE;
DROP TABLE IF EXISTS review_dislikes CASCADE;

CREATE TABLE IF NOT EXISTS mpa (
                                   mpa_id integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                                   mpa_name varchar NOT NULL
);

CREATE TABLE IF NOT EXISTS film (
                                    film_id integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                                    name varchar NOT NULL,
                                    description varchar(200),
                                    release_date date,
                                    duration integer,
                                    mpa integer REFERENCES mpa (mpa_id) ON DELETE RESTRICT,
                                    CONSTRAINT valid_duration CHECK (duration > 0)
);

CREATE TABLE IF NOT EXISTS person (
                                    person_id integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                                    email varchar NOT NULL,
                                    login varchar NOT NULL,
                                    name varchar NOT NULL ,
                                    birthday date NOT NULL,
                                    CONSTRAINT valid_login CHECK (login <> ' ')
);

CREATE TABLE IF NOT EXISTS likes (
                                    person_id integer REFERENCES person (person_id) ON DELETE CASCADE ,
                                    film_id integer REFERENCES film (film_id) ON DELETE CASCADE ,
                                    PRIMARY KEY (person_id, film_id)
);

CREATE TABLE IF NOT EXISTS genre (
                                    genre_id integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                                    genre_name varchar NOT NULL
);

CREATE TABLE IF NOT EXISTS genre_films (
                                    film_id integer REFERENCES film (film_id) ON DELETE CASCADE,
                                    genre_id integer REFERENCES genre (genre_id) ON DELETE CASCADE,
                                    PRIMARY KEY (film_id, genre_id)
);

CREATE TABLE IF NOT EXISTS friend_request (
                                    sender_id integer REFERENCES person (person_id) ON DELETE CASCADE,
                                    addressee_id integer REFERENCES person (person_id) ON DELETE CASCADE,
                                    CONSTRAINT validate_request CHECK (sender_id <> addressee_id),
                                    PRIMARY KEY (sender_id, addressee_id)
);

CREATE TABLE IF NOT EXISTS reviews (
    review_id integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    content varchar,
    is_positive boolean,
    user_id integer REFERENCES person (person_id) ON DELETE CASCADE,
    film_id integer REFERENCES film (film_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS review_likes (
                                            review_id integer REFERENCES reviews (review_id) ON DELETE CASCADE,
                                            user_id integer REFERENCES person (person_id) ON DELETE CASCADE,
                                            PRIMARY KEY (review_id, user_id)
);

CREATE TABLE IF NOT EXISTS review_dislikes (
                                            review_id integer REFERENCES reviews (review_id) ON DELETE CASCADE,
                                            user_id integer REFERENCES person (person_id) ON DELETE CASCADE,
                                            PRIMARY KEY (review_id, user_id)
);