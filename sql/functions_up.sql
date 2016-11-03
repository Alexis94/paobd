CREATE OR REPLACE FUNCTION raiseNotice(notice_message text) RETURNS VOID as $$
BEGIN
    RAISE NOTICE '%', notice_message;
END;
$$ language plpgsql;

CREATE OR REPLACE FUNCTION artisteExists(nomArtiste VARCHAR(15)) RETURNS BOOL AS $$
  BEGIN
    IF (EXISTS(select 1 FROM ARTISTE A WHERE A.nom=nomArtiste)) THEN
      RETURN TRUE;
    ELSE
      RETURN FALSE;
    END IF;
  END
$$ LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION insertNewArtist() RETURNS TRIGGER as $$
  BEGIN
    IF (NOT artisteExists(NEW.nomArtiste)) THEN
      RAISE NOTICE 'Artiste inexistant. Insertion de la nouvelle ligne dans la table Artiste';
      INSERT INTO ARTISTE VALUES (NEW.nomArtiste);
    END IF;
    RETURN NEW;
  END
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER CHECK_INSERT_ARTISTE_TITRE
  BEFORE INSERT ON ARTISTE_TITRE
  FOR EACH ROW
  EXECUTE PROCEDURE insertNewArtist();

CREATE TRIGGER CHECK_INSERT_ARTISTE_ALBUM
  BEFORE INSERT ON ARTISTE_ALBUM
  FOR EACH ROW
  EXECUTE PROCEDURE insertNewArtist();
