package data;

public class Developpeur {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String responsable;
    private String hobby;
    private int aNaissance;
    private float salaire;
    private float prime;

    public Developpeur(int id, String nom, String prenom, String adresse, String responsable, String hobby, int aNaissance,
                       float salaire, float prime) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.responsable = responsable;
        this.hobby = hobby;
        this.aNaissance = aNaissance;
        this.salaire = salaire;
        this.prime = prime;

    }

    @Override
    public String toString() {
        return "Id : " + this.id + " \nNom : " + this.nom + " \nPrenom : " + this.prenom + " \nAdresse : " + this.adresse +
                "\nResponsable : " + this.responsable + "\nHobby : " + this.hobby + " \naNaissance : " + this.aNaissance
                + " \nSalaire : " + this.salaire + " \nPrime : " + this.prime + "\n";
    }

    public String getNom() {
        return this.nom;
    }

    public int getId() {
        return this.id;
    }
}
