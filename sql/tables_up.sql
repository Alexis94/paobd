CREATE TYPE GENRE_MUSIQUE AS ENUM(
  'pop', 'rock', 'jazz', 'blues', 'electronique'
);

CREATE TABLE UTILISATEUR(
  id VARCHAR(10) PRIMARY KEY,
  motDePasse VARCHAR(25) NOT NULL,
  pseudo VARCHAR(15) NOT NULL,
  nom VARCHAR(15),
  prenom VARCHAR(15),
  age INTEGER CONSTRAINT age_constraint CHECK (age > 0 AND age < 99)
);

CREATE TABLE TITRE(
  id VARCHAR(10) PRIMARY KEY,
  nom VARCHAR(25) NOT NULL,
  duree INTEGER NOT NULL
);

CREATE TABLE ALBUM(
  nom VARCHAR(25) PRIMARY KEY,
  genre GENRE_MUSIQUE,
  annee INTEGER CONSTRAINT year_constraint CHECK (annee > 0 AND annee < 3000)
);

CREATE TABLE ARTISTE(
  nom VARCHAR(15) PRIMARY KEY,
  nationalite VARCHAR(50)
);

CREATE TABLE ARTISTE_TITRE(
  titreId VARCHAR(10) REFERENCES TITRE(id),
  nomArtiste VARCHAR(15) REFERENCES ARTISTE(nom),
  PRIMARY KEY (titreId, nomArtiste)
);

CREATE TABLE ARTISTE_ALBUM(
  nomArtiste VARCHAR(15) REFERENCES ARTISTE(nom),
  nomAlbum VARCHAR(25) REFERENCES  ALBUM(nom),
  PRIMARY KEY (nomArtiste, nomAlbum)
);

CREATE TABLE LISTE_TITRE(
  userId VARCHAR(10) REFERENCES UTILISATEUR(id),
  titreId VARCHAR(10) REFERENCES TITRE(id),
  PRIMARY KEY (userId, titreId)
);

CREATE TABLE LISTE_ALBUM(
  userId VARCHAR(10) REFERENCES UTILISATEUR(id),
  nomAlbum VARCHAR(25) REFERENCES ALBUM(nom),
  PRIMARY KEY (userId, nomAlbum)
);

CREATE TABLE LISTE_ARTISTE(
  userId VARCHAR(10) REFERENCES UTILISATEUR(id),
  nomArtiste VARCHAR(15) REFERENCES ARTISTE(nom),
  PRIMARY KEY (userId, nomArtiste)
);

CREATE TABLE ECOUTE(
  id VARCHAR(10),
  dateEcoute DATE,
  titreId VARCHAR(10) REFERENCES TITRE(id),
  PRIMARY KEY (id, dateEcoute)
);

CREATE TABLE PLAYLIST(
  id VARCHAR(10) PRIMARY KEY,
  userId VARCHAR(10) REFERENCES UTILISATEUR(id)
);

CREATE TABLE PLAYLIST_TITRE(
  titreId VARCHAR(10) REFERENCES TITRE(id),
  playlistId VARCHAR(10) REFERENCES PLAYLIST(id),
  PRIMARY KEY (titreId, playlistId)
);
