package utils;

public class Constantes {
    public static String requeteInsertionJeuDeDonnee = "INSERT INTO PROGRAMMEUR (NOM, PRENOM, ADRESSE, PSEUDO, RESPONSABLE, HOBBY, ANAISSANCE, SALAIRE, PRIME)\n" +
            "VALUES\n" +
            "(\"Leroux\", \"Jean\", \"123 Rue des Chênes\", \"jleroux\", \"Steve Jobs\", \"Tennis\", 1982, 55000, 2000),\n" +
            "(\"Petit\", \"Claire\", \"456 Allée des Roses\", \"cpetit\", \"Serge Brin\", \"Football\", 1984, 52000, 1800),\n" +
            "(\"Moreau\", \"Emilie\", \"789 Boulevard des Pins\", \"emoreau\", \"Marie Curie\", \"Lecture\", 1979, 60000, 2500),\n" +
            "(\"Blanc\", \"Lucas\", \"1010 Chemin des Tulipes\", \"lblanc\", \"Steve Jobs\", \"Cuisine\", 1988, 58000, 2100),\n" +
            "(\"Lambert\", \"Isabelle\", \"1212 Rue des Orchidées\", \"ilambert\", \"Serge Brin\", \"Dessin\", 1992, 54000, 1900),\n" +
            "(\"Rousseau\", \"Michel\", \"1414 Voie Principale\", \"mrousseau\", \"Marie Curie\", \"Jeux vidéo\", 1981, 56000, 2200),\n" +
            "(\"Marchand\", \"Catherine\", \"1616 Allée des Vents\", \"cmarchand\", \"Steve Jobs\", \"Photographie\", 1986, 59000, 2600),\n" +
            "(\"Dupont\", \"Philippe\", \"1818 Rue des Constellations\", \"pdupont\", \"Serge Brin\", \"Marche\", 1995, 57000, 2000),\n" +
            "(\"Fontaine\", \"Nathalie\", \"2020 Chemin de la Rivière\", \"nfontaine\", \"Marie Curie\", \"Voyage\", 1983, 63000, 2800),\n" +
            "(\"Dufresne\", \"François\", \"2222 Boulevard de la Mer\", \"fdufresne\", \"Steve Jobs\", \"Ski\", 1990, 60000, 2500),\n" +
            "(\"Bertrand\", \"Caroline\", \"2424 Voie de la Lune\", \"cbertrand\", \"Serge Brin\", \"Natation\", 1987, 55000, 2200),\n" +
            "(\"Ferrand\", \"Patrick\", \"2626 Rue du Soleil Levant\", \"pferrand\", \"Marie Curie\", \"Vélo\", 1980, 59000, 2700),\n" +
            "(\"Robin\", \"Sophie\", \"2828 Allée des Érables\", \"srobin\", \"Steve Jobs\", \"Danse\", 1984, 58000, 2300),\n" +
            "(\"Maurice\", \"Matthieu\", \"3030 Boulevard des Montagnes\", \"mmaurice\", \"Serge Brin\", \"Chant\", 1989, 56000, 2100),\n" +
            "(\"Denis\", \"Eva\", \"3232 Route de la Forêt\", \"edenis\", \"Marie Curie\", \"Course\", 1982, 57000, 2400),\n" +
            "(\"Brun\", \"Pierre-Alex\", \"3434 Rue des Ruisseaux\", \"pbrun\", \"Steve Jobs\", \"Pêche\", 1993, 54000, 2000),\n" +
            "(\"Renard\", \"Iris\", \"3636 Allée des Champs\", \"irenard\", \"Serge Brin\", \"Musique\", 1986, 61000, 2600),\n" +
            "(\"Olivier\", \"Michel\", \"3838 Boulevard des Galaxies\", \"molivier\", \"Marie Curie\", \"Lecture\", 1978, 59000, 2300),\n" +
            "(\"Leroy\", \"Juliette\", \"4040 Route de la Plage\", \"jleroy\", \"Steve Jobs\", \"Peinture\", 1985, 57000, 2200),\n" +
            "(\"Richard\", \"Sébastien\", \"4242 Rue de la Vallée\", \"srichard\", \"Serge Brin\", \"Jeux vidéo\", 1991, 54000, 1900),\n" +
            "(\"Garnier\", \"Anne\", \"4444 Allée des Fougères\", \"agarnier\", \"Marie Curie\", \"Voyage\", 1983, 58000, 2400),\n" +
            "(\"Simon\", \"Alexandre\", \"4646 Voie Lactée\", \"asimon\", \"Steve Jobs\", \"Randonnée\", 1994, 59000, 2700),\n" +
            "(\"Lucas\", \"Nadia\", \"4848 Chemin des Aurores\", \"nlucas\", \"Serge Brin\", \"Photographie\", 1980, 60000, 2500),\n" +
            "(\"Perrin\", \"Jean-Charles\", \"5050 Rue des Sapins\", \"jperrin\", \"Marie Curie\", \"Snowboard\", 1988, 56000, 2100);";

    public static final String requeteDeSelectionDesProgrammeurs = "Select * FROM PROGRAMMEUR";

    public static final String requeteFlushDb = "TRUNCATE TABLE PROGRAMMEUR";

    public static final String requeteDeSuppression = "DELETE FROM PROGRAMMEUR";
}
