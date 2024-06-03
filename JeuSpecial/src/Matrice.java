import java.util.ArrayList;
import java.util.Random;

public class Matrice {


    int[] caseSpeciale = {0, 0};

    public int tabLongueur;

    public int tabLargeur;

    public int vision = 2;

    public Tuile[][] tab;

    public Matrice(int longueur, int largeur) {
        tabLongueur = longueur;
        tabLargeur = largeur;
        tab = new Tuile[tabLargeur][tabLongueur];
        initialiserCases();
        //tab[tabLargeur/2][tabLongueur/2].setOccupant(4);
        tab[tabLargeur - 1][0].setOccupant(4);
        tab[tabLargeur - 1][tabLongueur - 1].setOccupant(3);
        tab[0][0].setOccupant(3);
        tab[0][tabLongueur - 1].setOccupant(3);
        assignerCases();
    }



    public int getTabLongueur() {
        return tabLongueur;
    }

    public void setTabLongueur(int tabLongueur) {
        this.tabLongueur = tabLongueur;
    }

    public int getTabLargeur() {
        return tabLargeur;
    }

    public void setTabLargeur(int tabLargeur) {
        this.tabLargeur = tabLargeur;
    }

    public Tuile getTuile(int y, int x) {
        return tab[y][x];
    }

    private void initialiserCases(){
        for(int i = 0; i < tabLargeur; i ++){
            for(int j = 0; j < tabLongueur; j++){
                tab[i][j] = new Tuile();
            }
        }
    }

    public void assignerCases(){
        //Arbres
        assignerTuiles(5, 5);
        //Bosses
        assignerTuiles(3, 3);
        //Monstres
        assignerTuiles(2, 40);
        //Coffres
        assignerTuiles(1, 15);
    }

    public void repeupler(){
        //Monstres
        assignerTuiles(2, 40);
        //Coffres
        assignerTuiles(1, 15);
    }

    public int nombreTuilesType(int type){

        int nbreBoss = 0;

        for(int i = 0; i < tabLargeur; i++){
            for(int j = 0; j < tabLongueur; j++){
                if(tab[i][j].getOccupant() == type){
                    nbreBoss ++;
                }
            }
        }

        return nbreBoss;

    }

    private void assignerTuiles(int type, int limite){

        Random ran = new Random();

        while(nombreTuilesType(type) < limite && nombreTuilesType(0) > 0){

            int y = ran.nextInt(tabLargeur);
            int x = ran.nextInt(tabLongueur);

            if(tab[y][x].getOccupant() == 0){
                tab[y][x].setOccupant(type);
            }

        }


    }

    public void afficherJeu(boolean afficherJeuComplet){
        if(afficherJeuComplet){
            for(int i = 0; i < tabLargeur; i ++){
                for(int j = 0; j < 11; j++){
                    for(int k = 0; k < tabLongueur; k++){
                        tab[i][k].afficherCase(j);
                    }
                    System.out.println();
                }
            }
            for(int i = 0; i < tabLongueur; i++){
                System.out.print("***********************");
            }
            System.out.println();
        }else{

            int xG = cooPerso("x") - vision;
            if(xG < 0){
                xG = 0;
            }
            int xD = cooPerso("x") + (vision + 1);
            if(xD >= tabLargeur){
                xD = tabLargeur;
            }
            int yH = cooPerso("y") - vision;
            if(yH < 0){
                yH = 0;
            }
            int yB = cooPerso("y") + (vision + 1);
            if(yB >= tabLongueur){
                yB = tabLongueur;
            }

            for(int i = yH; i < yB; i++){
                for(int j = 0; j < 11; j++){
                    for(int k = xG; k < xD; k++){
                        tab[i][k].afficherCase(j);
                    }
                    System.out.println();
                }
            }
            for(int i = 0; i < xD - xG; i++){
                System.out.print("***********************");
            }
            System.out.println();

        }


    }

    public int cooPerso(String xy){

        int x = 0;
        int y = 0;


        for(int i = 0; i < tabLargeur; i++){
            for(int j = 0; j < tabLongueur; j++){
                if(tab[j][i].getOccupant() == 4){
                    x = i;
                    y = j;
                }
            }
        }

        if(xy.equals("x")){
            return x;
        }else{
            return y;
        }

    }

    public void bouger(int direction){

        boolean changementFait = false;
        boolean aBouge = false;


        int x = cooPerso("x");
        int y = cooPerso("y");


        if(caseSpeciale[0] == 1){
            tab[y][x].setOccupant(caseSpeciale[1]);
            caseSpeciale[0] = 0;
            changementFait = true;
        }

        switch(direction){
            case 0:
                if(y + 1 < tabLargeur){
                    if(tab[y + 1][x].getOccupant() > 4){
                        caseSpeciale[0] = 1;
                        caseSpeciale[1] = tab[y + 1][x].getOccupant();
                    }
                    tab[y + 1][x].setOccupant(4);
                    tab[y + 1][x].setDirection(direction);
                    aBouge = true;
                }
                break;
            case 1:
                if(x + 1 < tabLongueur){
                    if(tab[y][x + 1].getOccupant() > 4){
                        caseSpeciale[0] = 1;
                        caseSpeciale[1] = tab[y][x + 1].getOccupant();
                    }
                    tab[y][x + 1].setOccupant(4);
                    tab[y][x + 1].setDirection(direction);
                    aBouge = true;
                }
                break;
            case 2:
                if(x > 0){
                    if(tab[y][x - 1].getOccupant() > 4){
                        caseSpeciale[0] = 1;
                        caseSpeciale[1] = tab[y][x - 1].getOccupant();
                    }
                    tab[y][x - 1].setOccupant(4);
                    tab[y][x - 1].setDirection(direction);
                    aBouge = true;
                }
                break;
            case 3:
                if(y > 0){
                    if(tab[y - 1][x].getOccupant() > 4){
                        caseSpeciale[0] = 1;
                        caseSpeciale[1] = tab[y - 1][x].getOccupant();
                    }
                    tab[y - 1][x].setOccupant(4);
                    tab[y - 1][x].setDirection(direction);
                    aBouge = true;
                }
                break;
        }

        if(!changementFait && aBouge){
            tab[y][x].setOccupant(0);
        }

    }

    public void appliquerCases(ArrayList<String> infos){
        for(int i = 0; i < tabLargeur; i++){
            for(int j = 0; j < tabLongueur; j++){
                tab[i][j].setOccupant(Integer.parseInt(String.valueOf(infos.get(i).charAt(j))));
            }
        }


    }



}
