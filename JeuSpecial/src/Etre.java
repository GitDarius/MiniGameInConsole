public abstract class Etre {


    int pv;

    int degatsRecus;

    String nom;

    Arme arme;

    public abstract String afficherEtre(int ligne, boolean animation);

    public Etre(int pv) {
        this.pv = pv;
    }


    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getDegatsRecus() {
        return degatsRecus;
    }

    public void setDegatsRecus(int degatsRecus) {
        this.degatsRecus = degatsRecus;
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
