DROP TABLE IF EXISTS atpn61_bd.DEVELOPPEUR;

CREATE TABLE PROGRAMMEUR(
	ID INT AUTO_INCREMENT PRIMARY KEY,
    NOM VARCHAR(50),
    PRENOM VARCHAR(50),
    ADRESSE VARCHAR(50),
    PSEUDO VARCHAR(50),
    RESPONSABLE VARCHAR(50),
    HOBBY VARCHAR(50),
    ANAISSANCE INT,
	SALAIRE FLOAT,
    PRIME FLOAT
);

INSERT INTO PROGRAMMEUR (NOM, PRENOM, ADRESSE, PSEUDO, RESPONSABLE, HOBBY, ANAISSANCE, SALAIRE, PRIME)
VALUES
("Leroux", "Jean", "123 Rue des Chênes", "jleroux", "Steve Jobs", "Tennis", 1982, 55000, 2000),
("Petit", "Claire", "456 Allée des Roses", "cpetit", "Serge Brin", "Football", 1984, 52000, 1800),
("Moreau", "Emilie", "789 Boulevard des Pins", "emoreau", "Marie Curie", "Lecture", 1979, 60000, 2500),
("Blanc", "Lucas", "1010 Chemin des Tulipes", "lblanc", "Steve Jobs", "Cuisine", 1988, 58000, 2100),
("Lambert", "Isabelle", "1212 Rue des Orchidées", "ilambert", "Serge Brin", "Dessin", 1992, 54000, 1900),
("Rousseau", "Michel", "1414 Voie Principale", "mrousseau", "Marie Curie", "Jeux vidéo", 1981, 56000, 2200),
("Marchand", "Catherine", "1616 Allée des Vents", "cmarchand", "Steve Jobs", "Photographie", 1986, 59000, 2600),
("Dupont", "Philippe", "1818 Rue des Constellations", "pdupont", "Serge Brin", "Marche", 1995, 57000, 2000),
("Fontaine", "Nathalie", "2020 Chemin de la Rivière", "nfontaine", "Marie Curie", "Voyage", 1983, 63000, 2800),
("Dufresne", "François", "2222 Boulevard de la Mer", "fdufresne", "Steve Jobs", "Ski", 1990, 60000, 2500),
("Bertrand", "Caroline", "2424 Voie de la Lune", "cbertrand", "Serge Brin", "Natation", 1987, 55000, 2200),
("Ferrand", "Patrick", "2626 Rue du Soleil Levant", "pferrand", "Marie Curie", "Vélo", 1980, 59000, 2700),
("Robin", "Sophie", "2828 Allée des Érables", "srobin", "Steve Jobs", "Danse", 1984, 58000, 2300),
("Maurice", "Matthieu", "3030 Boulevard des Montagnes", "mmaurice", "Serge Brin", "Chant", 1989, 56000, 2100),
("Denis", "Eva", "3232 Route de la Forêt", "edenis", "Marie Curie", "Course", 1982, 57000, 2400),
("Brun", "Pierre-Alex", "3434 Rue des Ruisseaux", "pbrun", "Steve Jobs", "Pêche", 1993, 54000, 2000),
("Renard", "Iris", "3636 Allée des Champs", "irenard", "Serge Brin", "Musique", 1986, 61000, 2600),
("Olivier", "Michel", "3838 Boulevard des Galaxies", "molivier", "Marie Curie", "Lecture", 1978, 59000, 2300),
("Leroy", "Juliette", "4040 Route de la Plage", "jleroy", "Steve Jobs", "Peinture", 1985, 57000, 2200),
("Richard", "Sébastien", "4242 Rue de la Vallée", "srichard", "Serge Brin", "Jeux vidéo", 1991, 54000, 1900),
("Garnier", "Anne", "4444 Allée des Fougères", "agarnier", "Marie Curie", "Voyage", 1983, 58000, 2400),
("Simon", "Alexandre", "4646 Voie Lactée", "asimon", "Steve Jobs", "Randonnée", 1994, 59000, 2700),
("Lucas", "Nadia", "4848 Chemin des Aurores", "nlucas", "Serge Brin", "Photographie", 1980, 60000, 2500),
("Perrin", "Jean-Charles", "5050 Rue des Sapins", "jperrin", "Marie Curie", "Snowboard", 1988, 56000, 2100);

select * from programmeur;