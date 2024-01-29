// 7. Permitir a pesquisa de todos os videos de determinado autor;

// 8. Permitir a pesquisa de comentarios por utilizador, ordenado inversamente pela data;

// 9. Permitir a pesquisa de comentarios por videos, ordenado inversamente pela data;

// 10. Permitir a pesquisa do rating medio de um video e quantas vezes foi votado;



// 1. Os ultimos 3 comentarios introduzidos para um video;
select * from comments_by_video where id_video=10 limit 3;

// 2. Lista das tags de determinado video;
select id, tags from videos where id=5;

// 3. Todos os videos com a tag Aveiro;
// without  filtering this query is not possible
// because the tags are not primary key

// 4. Os ultimos 5 eventos de determinado video realizados por um utilizador;
select * from events where username='pewdiepie' and id_video=2 limit 5;

// 5. Videos partilhados por determinado utilizador (maria1987, por exemplo) num determinado periodo de tempo (Agosto de 2017, por exemplo);
select * from videos_by_author where author='gametheory' and ts > '2022-08-11';

// 6. Os ultimos 10 videos, ordenado inversamente pela data da partilhada;
// It's not feasible to execute the query due to the limitations imposed by the clustering key. 
// Additionally, Cassandra doesn't support global querying.

// 7. Todos os seguidores (followers) de determinado video;
select users from followers where id_video=5;

// 8. Todos os comentarios (dos videos) que determinado utilizador esta a seguir (following);
// not possible because cassandra doesn't support joins

// 9. Os 5 videos com maior rating;
// not possible because cassandra does not allow global querying

// 10. Uma query que retorne todos os videos e que mostre claramente a forma pela qual estao ordenados;
select * from videos;

// 11. Lista com as Tags existentes e o numero de videos catalogados com cada uma delas;
// not possible, would need to create another table with tags as primary keys
// and a set of video ids as a field

// 12. Todos os ratings de determinado video
SELECT id_video, ratings FROM video_ratings_summary WHERE id_video = 2;


// 13. Todos os ratings de determinado video
SELECT * FROM events WHERE id_video = 3;
