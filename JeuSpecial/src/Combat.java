import java.util.Random;

public class Combat {

    Personnage personnage;

    Etre ennemi;

    boolean joueurGagne;

    boolean isBoss;

    int typeEnnemi;

    public Combat(Personnage personnage, boolean isBoss) {
        this.isBoss = isBoss;

        personnage.setDegatsRecus(0);

        this.personnage = personnage;

        if(!isBoss){
            Random ran = new Random();
            typeEnnemi = ran.nextInt(3);
            int degats = 2 + personnage.getNiveau();
            degats *= 0.5;
            ennemi = new Ennemi(10 + personnage.getNiveau(), typeEnnemi);
            switch (typeEnnemi){
                case 0:
                    ennemi.setArme(new EpeeLaser(degats));
                    ennemi.setNom("PatPat Le Mechant");
                    break;
                case 1:
                    ennemi.setArme(new Epee(degats));
                    ennemi.setNom("Marcello Bianchi");
                    break;
                case 2:
                    ennemi.setArme(new Poing(degats));
                    ennemi.setNom("Le garçon de la crypte");
                    break;
            }

        }else{
            ennemi = new Boss((personnage.nbreBossTues + 1) * 100);
            ennemi.setArme(new TrucKun((personnage.nbreBossTues + 1) * 50));
            ennemi.setNom("DA REAPER!!!");
        }

    }

    public Combat() {
    }


    public boolean demarrerCombat() throws InterruptedException {

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("          " + personnage.getNom() + " VS " + ennemi.getNom());
        System.out.println();
        System.out.println();
        Thread.sleep(1000);

        int tour = 1;

        annoncerCombat(isBoss);

        while(personnage.getPv() - personnage.getDegatsRecus() > 0 && ennemi.getPv() - ennemi.getDegatsRecus() > 0){
            afficherCombattants();
            afficherInfos();
            Thread.sleep(500);
            if(tour % 2 == 1){
                attaquerEnnemi();
                ennemi.degatsRecus += personnage.getArme().getDegats() + personnage.getStatsDegats();
            }else{
                attaquerPerso();
                personnage.degatsRecus += ennemi.getArme().getDegats();
            }
            Thread.sleep(300);
            tour++;
        }

        joueurGagne = personnage.getPv() - personnage.getDegatsRecus() > 0;

        affMort(joueurGagne);
        afficherInfos();
        Thread.sleep(1500);

        afficherGagnant(joueurGagne);
        Thread.sleep(1500);

        return joueurGagne;

    }

    private void annoncerCombat(boolean isBoss) throws InterruptedException {

        if(isBoss){
            System.out.println("          ****************************************          ");
            System.out.println("          *               FIGHT IN :             *          ");
            System.out.println("          *                                      *          ");
            System.out.println("          *                 ####                 *          ");
            System.out.println("          *                ##  ##                *          ");
            System.out.println("          *                   ###                *          ");
            System.out.println("          *                ##  ##                *          ");
            System.out.println("          *                 ####                 *          ");
            System.out.println("          *                                      *          ");
            System.out.println("          ****************************************          ");

            Thread.sleep(1000);

            System.out.println("          ****************************************          ");
            System.out.println("          *               FIGHT IN :             *          ");
            System.out.println("          *                                      *          ");
            System.out.println("          *                 ####                 *          ");
            System.out.println("          *                ##  ##                *          ");
            System.out.println("          *                   ##                 *          ");
            System.out.println("          *                  ##                  *          ");
            System.out.println("          *                ######                *          ");
            System.out.println("          *                                      *          ");
            System.out.println("          ****************************************          ");

            Thread.sleep(1000);

            System.out.println("          ****************************************          ");
            System.out.println("          *               FIGHT IN :             *          ");
            System.out.println("          *                                      *          ");
            System.out.println("          *                ####                  *          ");
            System.out.println("          *                  ##                  *          ");
            System.out.println("          *                  ##                  *          ");
            System.out.println("          *                  ##                  *          ");
            System.out.println("          *                ######                *          ");
            System.out.println("          *                                      *          ");
            System.out.println("          ****************************************          ");

            Thread.sleep(1000);
        }

        System.out.println("\n" +
                "   _____  ____  _ \n" +
                "  / ____|/ __ \\| |\n" +
                " | |  __| |  | | |\n" +
                " | | |_ | |  | | |\n" +
                " | |__| | |__| |_|\n" +
                "  \\_____|\\____/(_)\n" +
                "                  \n" +
                "                  \n");

        Thread.sleep(1000);


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }

    private void afficherCombattants(){
        for(int i = 0; i < 16; i++){
            System.out.print(personnage.afficherEtre(i, false));
            System.out.print(personnage.getArme().posture(i, true));
            System.out.print("          ");
            System.out.print(ennemi.getArme().posture(i, false));
            System.out.print(ennemi.afficherEtre(i, false));
            System.out.println();
        }
    }

    private void attaquerEnnemi(){
        for(int i = 0; i < 16; i++){
            System.out.print(personnage.afficherEtre(i, true));
            System.out.print("                                        ");
            System.out.print("          ");
            System.out.print("                                        ");
            System.out.print(personnage.getArme().animation(i, true));
            System.out.println();
        }
    }

    private void attaquerPerso(){
        for(int i = 0; i < 16; i++){
            System.out.print(ennemi.getArme().animation(i, false));
            System.out.print("                                        ");
            System.out.print("          ");
            System.out.print("                                        ");
            System.out.print(ennemi.afficherEtre(i, true));
            System.out.println();
        }
    }

    private void afficherInfos(){

        double partiePvPersonnage = personnage.getPv();
        partiePvPersonnage /= 50;
        double partiePvRestantsPerso = pvRestants("personnage")/partiePvPersonnage;


        double partiePvEnnemi = ennemi.getPv();
        partiePvEnnemi /= 50;
        double partiePvRestantsEnnemis = pvRestants("ennemi")/partiePvEnnemi;

        System.out.println();
        System.out.println();
        System.out.println();
        //Ligne 1
        System.out.print("         **********************************************************              ");
        System.out.print("          ");
        System.out.print("              **********************************************************              ");
        System.out.println();
        //Ligne 2
        System.out.print("         *");
        for(int i = 0; i < partiePvRestantsPerso; i++){
            System.out.print("♥");
        }
        for(int i = 0; i < 50 - partiePvRestantsPerso && i < 50; i++){
            System.out.print("☓");
        }
        System.out.print("*");
        System.out.print("                                      *");
        for(int i = 0; i < partiePvRestantsEnnemis; i++){
            System.out.print("♥");
        }
        for(int i = 0; i < 50 - partiePvRestantsEnnemis && i < 50; i++){
            System.out.print("☓");
        }
        System.out.print("*");
        System.out.println();
        //Ligne 3
        System.out.print("         *");
        for(int i = 0; i < partiePvRestantsPerso; i++){
            System.out.print("♥");
        }
        for(int i = 0; i < 50 - partiePvRestantsPerso && i < 50; i++){
            System.out.print("☓");
        }
        System.out.print("*");
        System.out.print("                                      *");
        for(int i = 0; i < partiePvRestantsEnnemis; i++){
            System.out.print("♥");
        }
        for(int i = 0; i < 50 - partiePvRestantsEnnemis && i < 50; i++){
            System.out.print("☓");
        }
        System.out.print("*");
        System.out.println();
        //Ligne 4
        System.out.print("         **********************************************************              ");
        System.out.print("          ");
        System.out.print("              **********************************************************              ");
        System.out.println();
        System.out.println();

    }

    private void afficherGagnant(boolean jouerGagne){
        if(jouerGagne){
            System.out.println();
            System.out.println();
            System.out.println("********************");
            System.out.println("*                  *");
            System.out.println("*     VICTOIRE !   *");
            System.out.println("*                  *");
            System.out.println("********************");
            System.out.println();
            System.out.println();
        }else{
            System.out.println();
            System.out.println();
            System.out.println("********************");
            System.out.println("*                  *");
            System.out.println("*     DÉFAITE !    *");
            System.out.println("*                  *");
            System.out.println("********************");
            System.out.println();
            System.out.println();
        }
    }

    private int pvRestants(String ennemiPersonnage){
        if(ennemiPersonnage.equals("personnage")){
            return personnage.getPv() - personnage.getDegatsRecus();
        }else{
            return ennemi.getPv() - ennemi.getDegatsRecus();
        }

    }

    private void affMort(boolean jouerGagne){
        if(jouerGagne){
            for(int i = 0; i < 16; i++){
                System.out.print(personnage.afficherEtre(i, true));
                System.out.print(personnage.getArme().posture(i, true));
                System.out.print("                                        ");
                System.out.print("          ");
                System.out.print("                                        ");
                System.out.print("                                        ");
                System.out.println();
            }
        }else{
            for(int i = 0; i < 16; i++){
                System.out.print("                                        ");
                System.out.print("                                        ");
                System.out.print("          ");
                System.out.print(ennemi.getArme().posture(i, false));
                System.out.print(ennemi.afficherEtre(i, true));
                System.out.println();
            }
        }
    }


}
