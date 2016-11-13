SELECT raiseNotice('Copy Data from artistes.csv...');
COPY ARTISTE FROM '/Users/Alexis/Documents/INSA/PAO/projet/data/artistes.csv' DELIMITER ',' CSV;

SELECT raiseNotice('Copy Data from albums.csv...');
COPY ALBUM FROM '/Users/Alexis/Documents/INSA/PAO/projet/data/albums.csv' DELIMITER ',' CSV;

SELECT raiseNotice('Copy Data from titres.csv...');
COPY TITRE FROM '/Users/Alexis/Documents/INSA/PAO/projet/data/titres.csv' DELIMITER ',' CSV;
