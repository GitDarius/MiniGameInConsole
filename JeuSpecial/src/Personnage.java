import java.util.ArrayList;

public class Personnage extends Etre{


    int statsDegats;
    int statsPV;

    int stats;

    int niveau;

    int nbreBossTues = 0;

    ArrayList<Arme> inventaire = new ArrayList<>();


    public Personnage(int pv) {
        super(pv);
        statsDegats = 0;
        statsPV = 0;
        stats = 0;
    }

    @Override
    public String afficherEtre(int ligne, boolean animation) {
        String[] lignes = new String[16];
        lignes[0] = "                                        ";
        lignes[1] = "                                        ";
        lignes[2] = "                                        ";
        lignes[3] = "                                        ";
        lignes[4] = "                                        ";
        lignes[5] = "                                        ";
        lignes[6] = "                                        ";
        lignes[7] = "                   ___                  ";
        lignes[8] = "                 _/   \\_                ";
        lignes[9] = "               _/       \\               ";
        if(animation){
            lignes[10] = "              /       \\  \\              ";
        }else{
            lignes[10] = "              /       _  \\              ";
        }
        lignes[11] = "             |        @   |             ";
        lignes[12] = "             \\            /             ";
        lignes[13] = "             \\            /             ";
        lignes[14] = "              \\_        _/              ";
        lignes[15] = "                \\______/                ";


        return lignes[ligne];
    }

    public void levelUp() throws InterruptedException {
        stats += 2;
        niveau++;
        System.out.println("******************************");
        System.out.println("*                            *");
        System.out.println("* Vous avez monté de niveau! *");
        System.out.println("*                            *");
        System.out.println("******************************");
        Thread.sleep(1000);
    }

    public int getStatsDegats() {
        return statsDegats;
    }

    public void setStatsDegats(int statsDegats) {
        this.statsDegats = statsDegats;
    }

    public int getStatsPV() {
        return statsPV;
    }

    public void setStatsPV(int statsPV) {
        this.statsPV = statsPV;
    }

    public int getStats() {
        return stats;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getPv(){
        return (statsPV * 2) + 10;
    }

}
