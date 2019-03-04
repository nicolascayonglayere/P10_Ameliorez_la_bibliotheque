
CREATE SEQUENCE editeur_id_editeur_seq;

CREATE TABLE editeur (
                id_editeur INTEGER NOT NULL DEFAULT nextval('editeur_id_editeur_seq'),
                nom VARCHAR(60) UNIQUE NOT NULL,
                adresse VARCHAR(100) NOT NULL,
                CONSTRAINT editeur_pk PRIMARY KEY (id_editeur)
);


ALTER SEQUENCE editeur_id_editeur_seq OWNED BY editeur.id_editeur;

CREATE SEQUENCE auteur_id_auteur_seq;

CREATE TABLE auteur (
                id_auteur INTEGER NOT NULL DEFAULT nextval('auteur_id_auteur_seq'),
                nom VARCHAR(60) NOT NULL,
                prenom VARCHAR(60),
                naissance DATE,
                nationalite VARCHAR(60),
                CONSTRAINT auteur_pk PRIMARY KEY (id_auteur)
);


ALTER SEQUENCE auteur_id_auteur_seq OWNED BY auteur.id_auteur;

CREATE SEQUENCE livre_id_livre_seq;

CREATE TABLE livre (
                id_livre INTEGER NOT NULL DEFAULT nextval('livre_id_livre_seq'),
                titre VARCHAR(60) UNIQUE,
                genre VARCHAR(60) NOT NULL,
                date_parution DATE,
                nb_exemplaire INTEGER NOT NULL,
                CONSTRAINT livre_pk PRIMARY KEY (id_livre)
);


ALTER SEQUENCE livre_id_livre_seq OWNED BY livre.id_livre;

CREATE TABLE livre_manuscrit (
                id_auteur INTEGER NOT NULL,
                id_livre INTEGER NOT NULL,
                CONSTRAINT livre_manuscrit_pk PRIMARY KEY (id_auteur, id_livre)
);


CREATE TABLE livre_edition (
                id_livre INTEGER NOT NULL,
                id_editeur INTEGER NOT NULL,
                CONSTRAINT livre_edition_pk PRIMARY KEY (id_livre, id_editeur)
);


CREATE SEQUENCE utilisateur_id_seq;

CREATE TABLE utilisateur (
                id_utilisateur INTEGER NOT NULL DEFAULT nextval('utilisateur_id_seq'),
                nom VARCHAR(60) NOT NULL,
                prenom VARCHAR(60) NOT NULL,
                pseudo VARCHAR(60) UNIQUE NOT NULL,
                mot_de_passe VARCHAR(100) NOT NULL,
                CONSTRAINT utilisateur_pk PRIMARY KEY (id_utilisateur)
);


ALTER SEQUENCE utilisateur_id_seq OWNED BY utilisateur.id_utilisateur;

CREATE SEQUENCE livre_emprunt_id_emprunt_seq;

CREATE TABLE livre_emprunt (
                id_emprunt INTEGER NOT NULL DEFAULT nextval('livre_emprunt_id_emprunt_seq'),
                date_emprunt DATE NOT NULL,
                prolongation BOOLEAN NOT NULL,
                id_utilisateur INTEGER NOT NULL,
                id_livre INTEGER NOT NULL,
                CONSTRAINT livre_emprunt_pk PRIMARY KEY (id_emprunt)
);

ALTER SEQUENCE livre_emprunt_id_emprunt_seq OWNED BY livre_emprunt.id_emprunt;

CREATE SEQUENCE coordonnee_utilisateur_id_seq;

CREATE TABLE coordonnee_utilisateur (
                id_coordonnee INTEGER NOT NULL DEFAULT nextval('coordonnee_utilisateur_id_seq'),
                adresse VARCHAR(100) NOT NULL,
                email VARCHAR(60) UNIQUE NOT NULL,
                id_utilisateur INTEGER NOT NULL,
                CONSTRAINT coordonnee_utilisateur_pk PRIMARY KEY (id_coordonnee)
);


ALTER SEQUENCE coordonnee_utilisateur_id_seq OWNED BY coordonnee_utilisateur.id_coordonnee;

ALTER TABLE livre_edition ADD CONSTRAINT editeur_livre_edite_fk
FOREIGN KEY (id_editeur)
REFERENCES editeur (id_editeur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE livre_manuscrit ADD CONSTRAINT auteur_livre_manuscrit_fk
FOREIGN KEY (id_auteur)
REFERENCES auteur (id_auteur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE livre_emprunt ADD CONSTRAINT livre_livre_emprunt_fk
FOREIGN KEY (id_livre)
REFERENCES livre (id_livre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE livre_edition ADD CONSTRAINT livre_livre_edite_fk
FOREIGN KEY (id_livre)
REFERENCES livre (id_livre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE livre_manuscrit ADD CONSTRAINT livre_livre_manuscrit_fk
FOREIGN KEY (id_livre)
REFERENCES livre (id_livre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE coordonnee_utilisateur ADD CONSTRAINT utilisateur_coordonnee_utilisateur_fk
FOREIGN KEY (id_utilisateur)
REFERENCES utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE livre_emprunt ADD CONSTRAINT utilisateur_livre_emprunt_fk
FOREIGN KEY (id_utilisateur)
REFERENCES utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
