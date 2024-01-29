USE cbd_107572_ex2;

INSERT INTO cbd_107572_ex2.users (username, name, email, ts) VALUES ('gametheory', 'Alice Johnson', 'alice@example.com', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.users (username, name, email, ts) VALUES ('dashiegames', 'Bob Smith', 'bob@example.com', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.users (username, name, email, ts) VALUES ('cryaotic', 'Charlie Brown', 'charlie@example.com', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.users (username, name, email, ts) VALUES ('pewdiepie', 'Dave Davis', 'dave@example.com', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.users (username, name, email, ts) VALUES ('markiplier', 'Emily White', 'emily@example.com', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.users (username, name, email, ts) VALUES ('jacksepticeye', 'Frank Miller', 'frank@example.com', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.users (username, name, email, ts) VALUES ('vanoss', 'Grace Lee', 'grace@example.com', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.users (username, name, email, ts) VALUES ('ninja', 'Henry Turner', 'henry@example.com', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.users (username, name, email, ts) VALUES ('dantdm', 'Isabella Martinez', 'isabella@example.com', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.users (username, name, email, ts) VALUES ('stampylonghead', 'Jackson Johnson', 'jackson@example.com', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.users (username, name, email, ts) VALUES ('gamegrumps', 'John Peter', 'john@example.com', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.users (username, name, email, ts) VALUES ('vegetta777', 'Ines Vegeta', 'vegeta@example.com', toTimestamp(now()));

INSERT INTO cbd_107572_ex2.videos (id, author, name, description, tags, ts) VALUES (0, 'gametheory', 'Teoria dos Jogos: Historia Oculta', 'Analise de teorias e enredos ocultos', {'gaming', 'theory'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos (id, author, name, description, tags, ts) VALUES (1, 'dashiegames', 'Desafios de Super Mario Maker', 'Superando niveis criativos e desafiantes', {'gaming', 'Mario'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos (id, author, name, description, tags, ts) VALUES (2, 'cryaotic', 'Gameplays de Silent Hill', 'Explorando o terror psicologico de Silent Hill', {'gaming', 'horror'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos (id, author, name, description, tags, ts) VALUES (3, 'pewdiepie', 'Lets Play Outlast', 'Explorando o jogo de terror', {'gaming', 'horror'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos (id, author, name, description, tags, ts) VALUES (4, 'markiplier', 'Desafio do Five Nights at Freddys', 'Tentando completar desafios dificeis', {'gaming', 'challenge'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos (id, author, name, description, tags, ts) VALUES (5, 'jacksepticeye', 'Jogando Undertale', 'Uma jornada epica e emocionante', {'gaming', 'adventure'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos (id, author, name, description, tags, ts) VALUES (6, 'vanoss', 'Melhores momentos em GTA V', 'Diversao e loucuras no mundo aberto', {'gaming', 'funny'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos (id, author, name, description, tags, ts) VALUES (7, 'ninja', 'Tutorial avancado de Fortnite', 'Dicas para melhorar no jogo', {'gaming', 'tutorial'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos (id, author, name, description, tags, ts) VALUES (8, 'dantdm', 'Explorando Novas Atualizacoes do Minecraft', 'Review e analise das novidades', {'gaming', 'review'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos (id, author, name, description, tags, ts) VALUES (9, 'stampylonghead', 'Construindo uma cidade no Minecraft', 'Criando uma cidade do zero', {'gaming', 'building'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos (id, author, name, description, tags, ts) VALUES (10, 'gamegrumps', 'Desafio de jogos retro', 'Competicao entre jogos classicos', {'gaming', 'retro'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos (id, author, name, description, tags, ts) VALUES (11, 'vegetta777', 'Aventuras em Terraria', 'Exploracao e descobertas no jogo', {'gaming', 'exploration'}, toTimestamp(now()));


INSERT INTO cbd_107572_ex2.videos_by_author (id, author, name, description, tags, ts) VALUES (0, 'gametheory', 'Teoria dos Jogos: Historia Oculta', 'Analise de teorias e enredos ocultos', {'gaming', 'theory'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos_by_author (id, author, name, description, tags, ts) VALUES (1, 'dashiegames', 'Desafios de Super Mario Maker', 'Superando niveis criativos e desafiantes', {'gaming', 'Mario'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos_by_author (id, author, name, description, tags, ts) VALUES (2, 'cryaotic', 'Gameplays de Silent Hill', 'Explorando o terror psicologico de Silent Hill', {'gaming', 'horror'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos_by_author (id, author, name, description, tags, ts) VALUES (3, 'pewdiepie', 'Lets Play Outlast', 'Explorando o jogo de terror', {'gaming', 'horror'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos_by_author (id, author, name, description, tags, ts) VALUES (4, 'markiplier', 'Desafio do Five Nights at Freddys', 'Tentando completar desafios dificeis', {'gaming', 'challenge'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos_by_author (id, author, name, description, tags, ts) VALUES (5, 'jacksepticeye', 'Jogando Undertale', 'Uma jornada epica e emocionante', {'gaming', 'adventure'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos_by_author (id, author, name, description, tags, ts) VALUES (6, 'vanoss', 'Melhores momentos em GTA V', 'Diversao e loucuras no mundo aberto', {'gaming', 'funny'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos_by_author (id, author, name, description, tags, ts) VALUES (7, 'ninja', 'Tutorial avancado de Fortnite', 'Dicas para melhorar no jogo', {'gaming', 'tutorial'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos_by_author (id, author, name, description, tags, ts) VALUES (8, 'dantdm', 'Explorando Novas Atualizacoes do Minecraft', 'Review e analise das novidades', {'gaming', 'review'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos_by_author (id, author, name, description, tags, ts) VALUES (9, 'stampylonghead', 'Construindo uma cidade no Minecraft', 'Criando uma cidade do zero', {'gaming', 'building'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos_by_author (id, author, name, description, tags, ts) VALUES (10, 'gamegrumps', 'Desafio de jogos retro', 'Competicao entre jogos classicos', {'gaming', 'retro'}, toTimestamp(now()));
INSERT INTO cbd_107572_ex2.videos_by_author (id, author, name, description, tags, ts) VALUES (11, 'vegetta777', 'Aventuras em Terraria', 'Exploracao e descobertas no jogo', {'gaming', 'exploration'}, toTimestamp(now()));


INSERT INTO cbd_107572_ex2.comments (id, id_video, author, comment, ts) VALUES (1, 0, 'jacksepticeye', 'Great analysis!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments (id, id_video, author, comment, ts) VALUES (2, 1, 'jacksepticeye', 'Love your Mario skills!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments (id, id_video, author, comment, ts) VALUES (3, 2, 'dantdm', 'Silent Hill is so scary!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments (id, id_video, author, comment, ts) VALUES (4, 3, 'vanoss', 'Outlast gave me chills!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments (id, id_video, author, comment, ts) VALUES (5, 4, 'gametheory', 'FNAF is always a challenge!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments (id, id_video, author, comment, ts) VALUES (6, 5, 'gametheory', 'Undertale is epic indeed!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments (id, id_video, author, comment, ts) VALUES (7, 6, 'dashiegames', 'GTA V is hilarious!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments (id, id_video, author, comment, ts) VALUES (8, 7, 'pewdiepie', 'Fortnite tips were helpful!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments (id, id_video, author, comment, ts) VALUES (9, 8, 'vegetta777', 'Minecraft updates look great!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments (id, id_video, author, comment, ts) VALUES (10, 9, 'ninja', 'Building from scratch, amazing!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments (id, id_video, author, comment, ts) VALUES (11, 10, 'ninja', 'Retro games are the best!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments (id, id_video, author, comment, ts) VALUES (12, 11, 'vanoss', 'Terraria adventures are thrilling!', toTimestamp(now()));


INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (0, {'gametheory', 'dashiegames', 'cryaotic'});
INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (1, {'markiplier', 'jacksepticeye'});
INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (2, {'pewdiepie', 'markiplier'});
INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (3, {'jacksepticeye', 'vanoss', 'ninja'});
INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (4, {'ninja', 'dantdm', 'stampylonghead'});
INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (5, {'gamegrumps', 'vegetta777', 'gametheory'});
INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (6, {'cryaotic', 'markiplier'});
INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (7, {'dashiegames', 'gametheory'});
INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (8, {'jacksepticeye', 'dashiegames', 'vanoss'});
INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (9, {'gametheory', 'jacksepticeye'});
INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (10, {'vegetta777', 'dantdm', 'stampylonghead'});
INSERT INTO cbd_107572_ex2.followers (id_video, users) VALUES (11, {'pewdiepie', 'dantdm', 'stampylonghead'});

INSERT INTO cbd_107572_ex2.events (id_video, username, type, ts, instant) VALUES (2, 'pewdiepie', 'pause', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_107572_ex2.events (id_video, username, type, ts, instant) VALUES (2, 'pewdiepie', 'play', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_107572_ex2.events (id_video, username, type, ts, instant) VALUES (2, 'pewdiepie', 'stop', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_107572_ex2.events (id_video, username, type, ts, instant) VALUES (2, 'pewdiepie', 'pause', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_107572_ex2.events (id_video, username, type, ts, instant) VALUES (2, 'pewdiepie', 'play', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_107572_ex2.events (id_video, username, type, ts, instant) VALUES (2, 'pewdiepie', 'stop', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_107572_ex2.events (id_video, username, type, ts, instant) VALUES (9, 'cryaotic', 'pause', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_107572_ex2.events (id_video, username, type, ts, instant) VALUES (9, 'cryaotic', 'play', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_107572_ex2.events (id_video, username, type, ts, instant) VALUES (1, 'jacksepticeye', 'stop', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_107572_ex2.events (id_video, username, type, ts, instant) VALUES (1, 'vegetta777', 'stop', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_107572_ex2.events (id_video, username, type, ts, instant) VALUES (1, 'markiplier', 'stop', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_107572_ex2.events (id_video, username, type, ts, instant) VALUES (2, 'vegetta777', 'play', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_107572_ex2.events (id_video, username, type, ts, instant) VALUES (3, 'vegetta777', 'play', toTimestamp(now()), toTimestamp(now()));

INSERT INTO cbd_107572_ex2.ratings (id_video, rate) VALUES (1, 1);
INSERT INTO cbd_107572_ex2.ratings (id_video, rate) VALUES (2, 4);
INSERT INTO cbd_107572_ex2.ratings (id_video, rate) VALUES (2, 5);
INSERT INTO cbd_107572_ex2.ratings (id_video, rate) VALUES (4, 5);
INSERT INTO cbd_107572_ex2.ratings (id_video, rate) VALUES (6, 5);
INSERT INTO cbd_107572_ex2.ratings (id_video, rate) VALUES (6, 4);
INSERT INTO cbd_107572_ex2.ratings (id_video, rate) VALUES (7, 1);
INSERT INTO cbd_107572_ex2.ratings (id_video, rate) VALUES (8, 2);
INSERT INTO cbd_107572_ex2.ratings (id_video, rate) VALUES (9, 5);
INSERT INTO cbd_107572_ex2.ratings (id_video, rate) VALUES (10, 4);
INSERT INTO cbd_107572_ex2.ratings (id_video, rate) VALUES (11, 5);



INSERT INTO cbd_107572_ex2.comments_by_user (username, id_video, comment, ts) VALUES ('jacksepticeye', 0, 'Great analysis!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_user (username, id_video, comment, ts) VALUES ('jacksepticeye', 1, 'Love your Mario skills!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_user (username, id_video, comment, ts) VALUES ('dantdm', 2, 'Silent Hill is so scary!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_user (username, id_video, comment, ts) VALUES ('vanoss', 3, 'Outlast gave me chills!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_user (username, id_video, comment, ts) VALUES ('gametheory', 4, 'FNAF is always a challenge!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_user (username, id_video, comment, ts) VALUES ('gametheory', 5, 'Undertale is epic indeed!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_user (username, id_video, comment, ts) VALUES ('dashiegames', 6, 'GTA V is hilarious!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_user (username, id_video, comment, ts) VALUES ('pewdiepie', 7, 'Fortnite tips were helpful!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_user (username, id_video, comment, ts) VALUES ('vegetta777', 8, 'Minecraft updates look great!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_user (username, id_video, comment, ts) VALUES ('ninja', 9, 'Building from scratch, amazing!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_user (username, id_video, comment, ts) VALUES ('ninja', 10, 'Retro games are the best!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_user (username, id_video, comment, ts) VALUES ('vanoss', 11, 'Terraria adventures are thrilling!', toTimestamp(now()));


INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('jacksepticeye', 0, 'Great analysis!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('jacksepticeye', 1, 'Love your Mario skills!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('dantdm', 2, 'Silent Hill is so scary!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('vanoss', 3, 'Outlast gave me chills!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('gametheory', 4, 'FNAF is always a challenge!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('gametheory', 5, 'Undertale is epic indeed!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('dashiegames', 6, 'GTA V is hilarious!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('pewdiepie', 7, 'Fortnite tips were helpful!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('vegetta777', 8, 'Minecraft updates look great!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('ninja', 9, 'Building from scratch, amazing!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('ninja', 10, 'Retro games are the best!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('vegetta777', 10, 'Wow! Nice content!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('dashiegames', 10, 'Wow! Amazing man!', toTimestamp(now()));
INSERT INTO cbd_107572_ex2.comments_by_video (username, id_video, comment, ts) VALUES ('vanoss', 11, 'Terraria adventures are thrilling!', toTimestamp(now()));



INSERT INTO cbd_107572_ex2.video_ratings_summary (id_video, ratings) VALUES (1, [1]);
INSERT INTO cbd_107572_ex2.video_ratings_summary (id_video, ratings) VALUES (2, [4, 5]);
INSERT INTO cbd_107572_ex2.video_ratings_summary (id_video, ratings) VALUES (4, [5]);
INSERT INTO cbd_107572_ex2.video_ratings_summary (id_video, ratings) VALUES (6, [4, 5]);
INSERT INTO cbd_107572_ex2.video_ratings_summary (id_video, ratings) VALUES (7, [1]);
INSERT INTO cbd_107572_ex2.video_ratings_summary (id_video, ratings) VALUES (8, [2]);
INSERT INTO cbd_107572_ex2.video_ratings_summary (id_video, ratings) VALUES (9, [5]);
INSERT INTO cbd_107572_ex2.video_ratings_summary (id_video, ratings) VALUES (10, [4]);
INSERT INTO cbd_107572_ex2.video_ratings_summary (id_video, ratings) VALUES (11, [5]);