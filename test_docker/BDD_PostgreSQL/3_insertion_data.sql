
--table auteur--
BEGIN TRANSACTION;
INSERT INTO auteur (nom, prenom, naissance, nationalite) VALUES ('Camus', 'Albert', '1913/10/07', 'fran�ais' );
INSERT INTO auteur (nom, prenom, naissance, nationalite) VALUES ('Tournier', 'Michel', '1924/12/19', 'fran�ais' );
INSERT INTO auteur (nom, prenom, naissance, nationalite) VALUES ('Jaworski', 'Jean-Philippe', '1969/04/21', 'fran�ais' );
INSERT INTO auteur (nom, prenom, naissance, nationalite) VALUES ('Damasio', 'Alain', '1969/08/01', 'fran�ais' );

COMMIT;

--table utilisateur--
BEGIN TRANSACTION;
INSERT INTO utilisateur (nom, prenom, pseudo, mot_de_passe, rappel_option) VALUES ('ncg', 'nicolas', 'yogj', '$2a$10$vT0yVNyzdsD7pd8AkffGs.d7qYouFog5X2WYu5GV7JnVZGbn4ODRW', true);--'yogj');--
INSERT INTO utilisateur (nom, prenom, pseudo, mot_de_passe, rappel_option) VALUES ('abdsc', 'nicole', 'nico', '$2a$10$k0PSZOmw9i1uwVXP7NU6SOzt/zdsKK3bYjAtCNsbd3FmyTkff44M.', true);--'nico');--
INSERT INTO utilisateur (nom, prenom, pseudo, mot_de_passe, rappel_option) VALUES ('qsdfg', 'benoit', 'ben', '$2a$10$eKSM8qNOl5hm0pCEdQV9xuAEqFWY1DRv/isj/adra43fWwqJG/Sea', false);--'ben');--
INSERT INTO utilisateur (nom, prenom, pseudo, mot_de_passe, rappel_option) VALUES ('wxcvb', 'andre', 'dede', '$2a$10$SH/.My9UumGA3LMpQ5U69eMp..30dJ5l1H.UQd2sD6ruSJBrJLL1C', false);--'dede');--
COMMIT;

--table coordonnee_utilisateur--
BEGIN TRANSACTION;
INSERT INTO coordonnee_utilisateur (adresse, email, id_utilisateur) VALUES ('mon adresse', 'ncg2103@yahoo.fr', 1);
INSERT INTO coordonnee_utilisateur (adresse, email, id_utilisateur) VALUES ('mon adresse de Nicole', 'nicole@yahoo.fr', 2);
INSERT INTO coordonnee_utilisateur (adresse, email, id_utilisateur) VALUES ('mon adresse de Ben', 'ben3@yahoo.fr', 3);
INSERT INTO coordonnee_utilisateur (adresse, email, id_utilisateur) VALUES ('mon adresse de andre', 'andre@yahoo.fr', 4);
COMMIT;

--table editeur--
BEGIN TRANSACTION;
INSERT INTO editeur (nom, adresse) VALUES ('Gallimard', '5 RUE GASTON GALLIMARD 75007 PARIS');
INSERT INTO editeur (nom, adresse) VALUES ('Les moutons electriques', '13 impasse Pierre-Melin 33800 Bordeaux');
INSERT INTO editeur (nom, adresse) VALUES ('La Volte', '53, rue de Perthuis 92140 Clamart');
COMMIT;

--table livre--
BEGIN TRANSACTION;
INSERT INTO livre (titre, genre, date_parution, nb_exemplaire) VALUES ('La peste', 'roman', '1947/01/01', 5);
INSERT INTO livre (titre, genre, date_parution, nb_exemplaire) VALUES ('L''etranger', 'roman', '1942/01/01', 8);
INSERT INTO livre (titre, genre, date_parution, nb_exemplaire) VALUES ('Gagner la guerre', 'heroic-fantasy', '2009/01/01', 3);
INSERT INTO livre (titre, genre, date_parution, nb_exemplaire) VALUES ('Vendredi ou les limbes du pacifique', 'roman','1967/01/01', 5);
INSERT INTO livre (titre, genre, date_parution, nb_exemplaire) VALUES ('La zone du dehors', 'sciences-fiction', '2007/01/01', 2);
COMMIT;

--table livre_edition--
BEGIN TRANSACTION;
INSERT INTO livre_edition (id_livre, id_editeur) VALUES (1, 1);
INSERT INTO livre_edition (id_livre, id_editeur) VALUES (2, 1);
INSERT INTO livre_edition (id_livre, id_editeur) VALUES (3, 2);
INSERT INTO livre_edition (id_livre, id_editeur) VALUES (4, 1);
INSERT INTO livre_edition (id_livre, id_editeur) VALUES (5, 3);
COMMIT;

--table livre_manuscrit--
BEGIN TRANSACTION;
INSERT INTO livre_manuscrit (id_livre, id_auteur) VALUES (1, 1);
INSERT INTO livre_manuscrit (id_livre, id_auteur) VALUES (2, 1);
INSERT INTO livre_manuscrit (id_livre, id_auteur) VALUES (3, 3);
INSERT INTO livre_manuscrit (id_livre, id_auteur) VALUES (4, 2);
INSERT INTO livre_manuscrit (id_livre, id_auteur) VALUES (5, 4);
COMMIT;

--table livre_emprunt--
BEGIN TRANSACTION;
INSERT INTO livre_emprunt (date_emprunt, prolongation, id_utilisateur, id_livre) VALUES ('2019/01/01', true, 1, 1);
INSERT INTO livre_emprunt (date_emprunt, prolongation, id_utilisateur, id_livre) VALUES ('2019/01/01', true, 2, 5);
INSERT INTO livre_emprunt (date_emprunt, prolongation, id_utilisateur, id_livre) VALUES ('2019/01/01', false, 3, 5);
COMMIT;

--table reservation--
BEGIN TRANSACTION;
INSERT INTO reservation (date_reservation, id_livre, id_utilisateur, date_alerte) VALUES ('2019/01/31', 5, 1, null);
COMMIT;