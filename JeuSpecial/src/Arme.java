public abstract class Arme {

    protected int degats;

    public abstract String getNom();

    public abstract String posture(int ligne, boolean isPersonnage);

    public abstract String animation(int ligne, boolean isPersonnage);

    public abstract String affichage(int ligne);


    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public Arme(int degats) {
        this.degats = degats;
    }



}
