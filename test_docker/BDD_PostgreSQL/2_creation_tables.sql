
CREATE SEQUENCE public.editeur_id_editeur_seq;

CREATE TABLE public.editeur (
                id_editeur INTEGER NOT NULL DEFAULT nextval('public.editeur_id_editeur_seq'),
                nom VARCHAR(60) NOT NULL,
                adresse VARCHAR(100) NOT NULL,
                CONSTRAINT editeur_pk PRIMARY KEY (id_editeur)
);


ALTER SEQUENCE public.editeur_id_editeur_seq OWNED BY public.editeur.id_editeur;

CREATE SEQUENCE public.auteur_id_auteur_seq;

CREATE TABLE public.auteur (
                id_auteur INTEGER NOT NULL DEFAULT nextval('public.auteur_id_auteur_seq'),
                nom VARCHAR(60) NOT NULL,
                prenom VARCHAR(60),
                naissance DATE,
                nationalite VARCHAR(60),
                CONSTRAINT auteur_pk PRIMARY KEY (id_auteur)
);


ALTER SEQUENCE public.auteur_id_auteur_seq OWNED BY public.auteur.id_auteur;

CREATE SEQUENCE public.livre_id_livre_seq;

CREATE TABLE public.livre (
                id_livre INTEGER NOT NULL DEFAULT nextval('public.livre_id_livre_seq'),
                titre VARCHAR(60),
                genre VARCHAR(60) NOT NULL,
                date_parution DATE,
                nb_exemplaire INTEGER NOT NULL,
                CONSTRAINT livre_pk PRIMARY KEY (id_livre)
);


ALTER SEQUENCE public.livre_id_livre_seq OWNED BY public.livre.id_livre;

CREATE TABLE public.livre_manuscrit (
                id_auteur INTEGER NOT NULL,
                id_livre INTEGER NOT NULL,
                CONSTRAINT livre_manuscrit_pk PRIMARY KEY (id_auteur, id_livre)
);


CREATE TABLE public.livre_edition (
                id_livre INTEGER NOT NULL,
                id_editeur INTEGER NOT NULL,
                CONSTRAINT livre_edition_pk PRIMARY KEY (id_livre, id_editeur)
);


CREATE SEQUENCE public.utilisateur_id_utilisateur_seq;

CREATE TABLE public.utilisateur (
                id_utilisateur INTEGER NOT NULL DEFAULT nextval('public.utilisateur_id_utilisateur_seq'),
                nom VARCHAR(60) NOT NULL,
                prenom VARCHAR(60) NOT NULL,
                pseudo VARCHAR(60) NOT NULL,
                mot_de_passe VARCHAR(100) NOT NULL,
                rappel_option BOOLEAN DEFAULT true NOT NULL,
                CONSTRAINT utilisateur_pk PRIMARY KEY (id_utilisateur)
);


ALTER SEQUENCE public.utilisateur_id_utilisateur_seq OWNED BY public.utilisateur.id_utilisateur;

CREATE SEQUENCE public.reservation_id_reservation_seq;

CREATE TABLE public.reservation (
                id_reservation INTEGER NOT NULL DEFAULT nextval('public.reservation_id_reservation_seq'),
                date_reservation DATE NOT NULL,
                id_livre INTEGER NOT NULL,
                id_utilisateur INTEGER NOT NULL,
                date_alerte DATE,
                CONSTRAINT reservation_pk PRIMARY KEY (id_reservation)
);


ALTER SEQUENCE public.reservation_id_reservation_seq OWNED BY public.reservation.id_reservation;

CREATE SEQUENCE public.livre_emprunt_id_emprunt_seq;

CREATE TABLE public.livre_emprunt (
                id_emprunt INTEGER NOT NULL DEFAULT nextval('public.livre_emprunt_id_emprunt_seq'),
                date_emprunt DATE NOT NULL,
                prolongation BOOLEAN NOT NULL,
                id_utilisateur INTEGER NOT NULL,
                id_livre INTEGER NOT NULL,
                CONSTRAINT livre_emprunt_pk PRIMARY KEY (id_emprunt)
);

ALTER SEQUENCE public.livre_emprunt_id_emprunt_seq OWNED BY public.livre_emprunt.id_emprunt;

CREATE SEQUENCE public.coordonnee_utilisateur_id_coordonnee_seq;

CREATE TABLE public.coordonnee_utilisateur (
                id_coordonnee INTEGER NOT NULL DEFAULT nextval('public.coordonnee_utilisateur_id_coordonnee_seq'),
                adresse VARCHAR(100) NOT NULL,
                email VARCHAR(60) NOT NULL,
                id_utilisateur INTEGER NOT NULL,
                CONSTRAINT coordonnee_utilisateur_pk PRIMARY KEY (id_coordonnee)
);


ALTER SEQUENCE public.coordonnee_utilisateur_id_coordonnee_seq OWNED BY public.coordonnee_utilisateur.id_coordonnee;

ALTER TABLE public.livre_edition ADD CONSTRAINT editeur_livre_edite_fk
FOREIGN KEY (id_editeur)
REFERENCES public.editeur (id_editeur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.livre_manuscrit ADD CONSTRAINT auteur_livre_manuscrit_fk
FOREIGN KEY (id_auteur)
REFERENCES public.auteur (id_auteur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.livre_emprunt ADD CONSTRAINT livre_livre_emprunt_fk
FOREIGN KEY (id_livre)
REFERENCES public.livre (id_livre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.livre_edition ADD CONSTRAINT livre_livre_edite_fk
FOREIGN KEY (id_livre)
REFERENCES public.livre (id_livre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.livre_manuscrit ADD CONSTRAINT livre_livre_manuscrit_fk
FOREIGN KEY (id_livre)
REFERENCES public.livre (id_livre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation ADD CONSTRAINT livre_reservation_fk
FOREIGN KEY (id_livre)
REFERENCES public.livre (id_livre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.coordonnee_utilisateur ADD CONSTRAINT utilisateur_coordonnee_utilisateur_fk
FOREIGN KEY (id_utilisateur)
REFERENCES public.utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.livre_emprunt ADD CONSTRAINT utilisateur_livre_emprunt_fk
FOREIGN KEY (id_utilisateur)
REFERENCES public.utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation ADD CONSTRAINT utilisateur_reservation_fk
FOREIGN KEY (id_utilisateur)
REFERENCES public.utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
