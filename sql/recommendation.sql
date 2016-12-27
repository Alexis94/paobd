(select genre, nomartiste from titre inner join (select titreId as id from ecoute where pseudouser='alexis') as titresecoutes on titre.id = titresecoutes.id) /* Genre nomArtiste */

select * from titre where id not in (select titreid as id from ecoute where pseudouser='alexis');

select * from (select * from titre where id not in (select titreid as id from ecoute where pseudouser='alexis')) as titre inner join (select genre, nomartiste from titre inner join (select titreId as id from ecoute where pseudouser='alexis') as titresecoutes on titre.id = titresecoutes.id) as res on titre.genre=res.genre OR titre.nomartiste=res.nomartiste ORDER BY RANDOM() limit 10;
