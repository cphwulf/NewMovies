select m.movie_id, m.movie_title, m.director, m.year, g.genre_title 
FROM movies m, genres g
WHERE m.genre_id = g.genre_id;
