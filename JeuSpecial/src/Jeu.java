import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jeu {


    //Message bienvenue = ligne 93
    boolean quitter;

    int pointeur = 0;

    boolean decisionPrise = false;

    boolean afficherJeuComplet = false;

    Personnage personnage;

    boolean excaliburObtenu = false;

    boolean epeeLaserObtenu = false;

    Fichier fichier = new Fichier();

    Matrice tabJeu;

    public Jeu() {
        quitter = false;
        personnage = new Personnage(10);
        personnage.setArme(new Poing(2));
        personnage.inventaire.add(personnage.arme);
        tabJeu = new Matrice(20, 20);
    }

    public void accueuil() throws InterruptedException {

        Scanner clavier = new Scanner(System.in);

        decisionPrise = false;
        pointeur = 0;
        boolean sortir = false;

        while(!sortir){
            while(!decisionPrise){

                affAcueuil();

                String choix = clavier.nextLine();

                switch(choix.toUpperCase()){
                    case "W":
                        if(pointeur == 0){
                            pointeur = 3;
                        }else{
                            pointeur--;
                        }
                        break;
                    case "S":
                        if(pointeur == 3){
                            pointeur = 0;
                        }else{
                            pointeur++;
                        }
                        break;
                    case "":
                        decisionPrise = true;
                        break;
                    case "JOUER":
                        decisionPrise = true;
                        pointeur = 0;
                        break;
                    case "PARAMETRES":
                        decisionPrise = true;
                        pointeur = 1;
                        break;
                    case "BLAGUES":
                        decisionPrise = true;
                        pointeur = 2;
                        break;
                    case "QUITTER":
                        decisionPrise = true;
                        pointeur = 3;
                        break;
                    default:
                        System.out.println("s, w pour descendre/monter la flèche. Entrée pour séléctionner le choix. :)");
                }
            }

            switch(pointeur){
                case 0:
                    //Quitter est deja a false
                    //msgBienvenue();
                    sortir = true;
                    break;
                case 1:
                    parametres();
                    decisionPrise = false;
                    break;
                case 2:
                    afficherBlagues();
                    decisionPrise = false;
                    break;
                case 3:
                    quitter = true;
                    sortir = true;
                    break;
            }
        }




    }

    private void affAcueuil(){

        String jouer = "*          Jouer          *";
        String parametres = "*        Parametres       *";
        String blagues = "*         Blagues         *";
        String quitter = "*         Quitter         *";

        switch(pointeur){
            case 0:
                jouer =      "*     ---> Jouer <---     *";
                break;
            case 1:
                parametres = "*   ---> Parametres <---  *";
                break;
            case 2:
                blagues = "*    ---> Blagues <---    *";
                break;
            case 3:
                quitter = "*    ---> Quitter <---    *";

        }

        System.out.println("***************************");
        System.out.println(jouer);
        System.out.println(parametres);
        System.out.println(blagues);
        System.out.println(quitter);
        System.out.println("***************************");
    }

    public void bouger() throws InterruptedException, IOException {
        Scanner clavier = new Scanner(System.in);
        String choix = "";
        boolean choixPasFait = true;
        while(choixPasFait){
            boolean bouger = false;
            choixPasFait = false;
            System.out.print("À vous: ");
            choix = clavier.nextLine();

            switch(trouverValeurCase(choix)){
                case 0:
                    bouger = true;
                    break;
                case 1:
                    ouvrirCoffre();
                    bouger = true;
                    break;
                case 2:
                    Combat combatEnnemi = new Combat(personnage, false);
                    if(combatEnnemi.demarrerCombat()){
                        for(int i = 0; i < personnage.nbreBossTues + 1; i++){
                            personnage.levelUp();
                        }
                        if(combatEnnemi.typeEnnemi == 0 && !epeeLaserObtenu){
                            personnage.inventaire.add(new EpeeLaser(5));
                            epeeLaserObtenu = true;
                            System.out.println("\n" +
                                    "  _   _                       _ _                                    _ _ _ \n" +
                                    " | \\ | |                     | | |                                  | | | |\n" +
                                    " |  \\| | ___  _   ___   _____| | | ___    __ _ _ __ _ __ ___   ___  | | | |\n" +
                                    " | . ` |/ _ \\| | | \\ \\ / / _ \\ | |/ _ \\  / _` | '__| '_ ` _ \\ / _ \\ | | | |\n" +
                                    " | |\\  | (_) | |_| |\\ V /  __/ | |  __/ | (_| | |  | | | | | |  __/ |_|_|_|\n" +
                                    " |_| \\_|\\___/ \\__,_| \\_/ \\___|_|_|\\___|  \\__,_|_|  |_| |_| |_|\\___| (_|_|_)\n" +
                                    "                                                                           \n" +
                                    "                                                                           \n");


                        }
                        Thread.sleep(3000);
                        bouger = true;
                    }
                    break;
                case 3:
                    Combat combatBoss = new Combat(personnage, true);
                    if(combatBoss.demarrerCombat()){
                        personnage.levelUp();
                        personnage.levelUp();
                        personnage.levelUp();
                        personnage.levelUp();
                        personnage.levelUp();
                        if(personnage.nbreBossTues == 0){
                            personnage.inventaire.add(new TrucKun(50));
                            System.out.println("\n" +
                                    "  _   _                       _ _                                    _ _ _ \n" +
                                    " | \\ | |                     | | |                                  | | | |\n" +
                                    " |  \\| | ___  _   ___   _____| | | ___    __ _ _ __ _ __ ___   ___  | | | |\n" +
                                    " | . ` |/ _ \\| | | \\ \\ / / _ \\ | |/ _ \\  / _` | '__| '_ ` _ \\ / _ \\ | | | |\n" +
                                    " | |\\  | (_) | |_| |\\ V /  __/ | |  __/ | (_| | |  | | | | | |  __/ |_|_|_|\n" +
                                    " |_| \\_|\\___/ \\__,_| \\_/ \\___|_|_|\\___|  \\__,_|_|  |_| |_| |_|\\___| (_|_|_)\n" +
                                    "                                                                           \n" +
                                    "                                                                           \n");
                        }
                        Thread.sleep(3000);
                        personnage.nbreBossTues++;
                        bouger = true;
                    }
                    break;
                case 5:
                    afficherBlagues();
                    bouger = true;
                    break;
            }

            if(bouger){
                switch(choix.toUpperCase()){
                    case "W":
                        tabJeu.bouger(3);
                        break;
                    case "A":
                        tabJeu.bouger(2);
                        break;
                    case "S":
                        tabJeu.bouger(0);
                        break;
                    case "D":
                        tabJeu.bouger(1);
                        break;
                    case "Q":
                    case "QUITTER":
                        quitter = true;
                        break;
                    case "M":
                    case "MENU":
                        Menu();
                        break;
                    case "U":
                    case "STATISTIQUES":
                    case "STATISTIQUE":
                    case "STATS":
                        statistiques();
                        break;
                    case "P":
                    case "PARAMETRES":
                    case "PARAMETRE":
                        parametres();
                        break;
                    case "T":
                    case "TUTORIEL":
                    case "TUTO":
                        tutoriel();
                        break;
                    case "B":
                    case "BLAGUES":
                        afficherBlagues();
                        break;
                    case "I":
                    case "INVENTAIRE":
                        inventaire();
                        break;
                    default:
                        System.out.println("Entrée invalide. Besoin d'aide? Entrez T pour avoir la liste des touches");
                        choixPasFait = true;
                        break;
                }
            }
        }

    }

    public boolean isQuitter() {
        return quitter;
    }

    public void setQuitter(boolean quitter) {
        this.quitter = quitter;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public void ouvrirCoffre() throws InterruptedException {

        Random ran = new Random();

        switch(ran.nextInt(10)){

            case 0:
            case 1:
            case 2:
            case 3:
                personnage.levelUp();
                break;
            case 4:
            case 5:
                System.out.println("*****************************");
                System.out.println("*                           *");
                System.out.println("* OH NON! C'est un piège!!! *");
                System.out.println("*                           *");
                System.out.println("*****************************");
                Thread.sleep(3000);
                Combat combat = new Combat(personnage, false);
                combat.demarrerCombat();
                break;
            case 6:
            case 7:
            case 8:
                System.out.println();
                System.out.println();
                System.out.println("************************");
                System.out.println("*                      *");
                System.out.println("* Le coffre est vide ! *");
                System.out.println("*                      *");
                System.out.println("************************");
                System.out.println();
                System.out.println();
                Thread.sleep(3000);
                break;
            case 9:

                if(!excaliburObtenu){
                    personnage.inventaire.add(new Epee(10));
                    excaliburObtenu = true;
                    System.out.println("**********************************");
                    System.out.println("*                                *");
                    System.out.println("* Vous avez trouve Excalibur !!! *");
                    System.out.println("*                                *");
                    System.out.println("**********************************");
                }else{
                    System.out.println();
                    System.out.println();
                    System.out.println("*****************************************");
                    System.out.println("*                                       *");
                    System.out.println("* Le coffre est malheuresement vide ;-; *");
                    System.out.println("*                                       *");
                    System.out.println("*****************************************");
                    System.out.println();
                    System.out.println();
                }
                Thread.sleep(3000);
        }

    }

    public int trouverValeurCase(String choix){

        int x = tabJeu.cooPerso("x");
        int y = tabJeu.cooPerso("y");

        int valeurCase = 0;

        switch(choix.toUpperCase()){
            case "W":
                if(y > 0){
                    valeurCase = tabJeu.tab[y - 1][x].getOccupant();
                }
                break;
            case "A":
                if(x > 0){
                    valeurCase = tabJeu.tab[y][x - 1].getOccupant();
                }
                break;
            case "S":
                if(y + 1 < tabJeu.tabLargeur){
                    valeurCase = tabJeu.tab[y + 1][x].getOccupant();
                }
                break;
            case "D":
                if(x + 1 < tabJeu.tabLongueur){
                    valeurCase = tabJeu.tab[y][x + 1].getOccupant();
                }
                break;
        }

        return valeurCase;


    }

    public void statistiques(){
        pointeur = 0;
        boolean retour = false;
        Scanner clavier = new Scanner(System.in);
        while(!retour){
            decisionPrise = false;
            while(!decisionPrise){
                affStatistiques();
                String choix = clavier.nextLine();
                switch (choix.toUpperCase()){
                    case "W":
                        if(pointeur == 0){
                            pointeur = 2;
                        }else{
                            pointeur--;
                        }
                        break;
                    case "S":
                        if(pointeur == 2){
                            pointeur = 0;
                        }else{
                            pointeur++;
                        }
                        break;
                    case "":
                        decisionPrise = true;
                        break;
                    default:
                        System.out.println("s, w pour naviguer. Entree pour selecitonner le choix. :)");
                }
            }

            switch(pointeur){
                case 0:
                    if(personnage.getStats() > 0){
                        personnage.statsPV++;
                        personnage.stats--;
                    }
                    break;
                case 1:
                    if(personnage.getStats() > 0){
                        personnage.statsDegats++;
                        personnage.stats--;
                    }
                    break;
                case 2:
                    retour = true;
            }

        }
    }

    public void affStatistiques(){
        System.out.println();
        System.out.println();
        System.out.println("****************************");
        System.out.println("*       STATISTIQUES       *");
        System.out.println("*--------------------------*");
        System.out.printf("*              PV: %-8s", personnage.getStatsPV());
        System.out.println("*");
        System.out.printf("*          Degats: %-8s", personnage.getStatsDegats());
        System.out.println("*");
        System.out.printf("* Points de stats: %-8s", personnage.getStats());
        System.out.println("*");
        System.out.println("****************************");
        System.out.println();

        String ajoutPv = "      + 1 en PV";
        String ajoutDegats = "      + 1 en Degats";
        String retour = "      Retour";

        switch(pointeur){
            case 0:
                ajoutPv = " ---> + 1 en PV";
                break;
            case 1:
                ajoutDegats = " ---> + 1 en Degats";
                break;
            case 2:
                retour = " ---> Retour";
                break;
        }

        System.out.println(ajoutPv);
        System.out.println(ajoutDegats);
        System.out.println(retour);
    }

    public void Menu() throws InterruptedException, IOException {
        boolean retour  = false;
        Scanner clavier = new Scanner(System.in);
        while(!retour){
            decisionPrise = false;
            pointeur = 0;
            while(!decisionPrise){
                afficherMenu();

                String choix = clavier.nextLine();

                switch (choix.toUpperCase()){
                    case "W":
                        if(pointeur == 0){
                            pointeur = 6;
                        }else{
                            pointeur--;
                        }
                        break;
                    case "S":
                        if(pointeur == 6){
                            pointeur = 0;
                        }else{
                            pointeur++;
                        }
                        break;
                    case "":
                        decisionPrise = true;
                        break;
                    case "RETOUR":
                        decisionPrise = true;
                        pointeur = 0;
                        break;
                    case "STATISTIQUES":
                    case "STATISTIQUE":
                        decisionPrise = true;
                        pointeur = 1;
                        break;
                    case "INVENTAIRE":
                        decisionPrise = true;
                        pointeur = 2;
                        break;
                    case "SAUVEGARDER":
                        decisionPrise = true;
                        pointeur = 3;
                        break;
                    case "CHARGER SAUVEGARDE":
                        decisionPrise = true;
                        pointeur = 4;
                        break;
                    case "PARAMETRES":
                    case "PARAMETRE":
                        decisionPrise = true;
                        pointeur = 5;
                        break;
                    case "QUITTER":
                        decisionPrise = true;
                        pointeur = 6;
                        break;
                    default:
                        System.out.println("s, w pour descendre/monter la flèche. Entrée pour séléctionner le choix. :)");
                }



            }

            switch (pointeur){
                case 0:
                    retour = true;
                    break;
                case 1:
                    statistiques();
                    break;
                case 2:
                    inventaire();
                    break;
                case 3:
                    sauvegarder();
                    break;
                case 4:
                    chargerSauvegarde();
                    break;
                case 5:
                    parametres();
                    break;
                case 6:
                    retour = true;
                    quitter = true;
                    break;
            }

        }



    }

    public void afficherMenu(){

        String retour =  "*         Retour         *";
        String statistiques = "*      Statistiques      *";
        String inventaire = "*       Inventaire       *";
        String sauvegarder = "*       Sauvegarder      *";
        String charger = "*   Charger Sauvegarde   *";
        String parametres = "*       Parametres       *";
        String quitter = "*        Quitter         *";


        switch(pointeur){
            case 0:
                retour = "*    ---> Retour <---    *";
                break;
            case 1:
                statistiques = "* ---> Statistiques <--- *";
                break;
            case 2:
                inventaire = "*  ---> Inventaire <---  *";
                break;
            case 3:
                sauvegarder = "*  ---> Sauvegarder <--- *";
                break;
            case 4:
                charger = "* > Charger Sauvegarde < *";
                break;
            case 5:
                parametres = "*  ---> Parametres <---- *";
                break;
            case 6:
                quitter = "*   ---> Quitter <---    *";
                break;


        }

        System.out.println("**************************");
        System.out.println(retour);
        System.out.println(statistiques);
        System.out.println(inventaire);
        System.out.println(sauvegarder);
        System.out.println(charger);
        System.out.println(parametres);
        System.out.println(quitter);
        System.out.println("**************************");
    }

    public void parametres() throws InterruptedException {
        pointeur = 0;
        boolean retour  = false;
        Scanner clavier = new Scanner(System.in);
        while(!retour){
            decisionPrise = false;
            while(!decisionPrise){
                afficherParametres();

                String choix = clavier.nextLine();

                switch (choix.toUpperCase()){
                    case "W":
                        if(pointeur == 0){
                            pointeur = 2;
                        }else{
                            pointeur--;
                        }
                        break;
                    case "S":
                        if(pointeur == 2){
                            pointeur = 0;
                        }else{
                            pointeur++;
                        }
                        break;
                    case "":
                        decisionPrise = true;
                        break;
                    default:
                        System.out.println("s, w pour naviguer. Entree pour selecitonner le choix. :)");
                }

            }

            switch (pointeur){
                case 0:
                    afficherJeuComplet = !afficherJeuComplet;
                    break;
                case 1:
                    changerVision();
                    break;
                case 2:
                    System.out.println("Retourne");
                    retour = true;
                    break;
            }

        }
    }

    public void afficherParametres() throws InterruptedException {

        String voirTouteMap = String.format("*       Voir toute la map: %-12s", afficherJeuComplet);
        voirTouteMap += "*";
        String retour = "*                Retour                *";
        String changerVision = "*      Modifier le champ de vision     *";

        switch(pointeur){
            case 0:
                voirTouteMap = String.format("*  ---> Voir toute la map: %-5s", afficherJeuComplet);
                voirTouteMap += " <---  *";
                break;
            case 1:
                changerVision = "* ---> Modifier le champ de vision <-- *";
                break;
            case 2:
                retour = "*           ---> Retour <---           *";
                break;
        }
        System.out.println("****************************************");
        System.out.println("*               Parametres             *");
        System.out.println(voirTouteMap);
        System.out.println(changerVision);
        System.out.println(retour);
        System.out.println("****************************************");
    }

    public void afficherBlagues() throws InterruptedException {
        Random ran = new Random();
        switch(ran.nextInt(8)){
            case 0:
                System.out.print("Tu connais la blague à deux balles ?");
                Thread.sleep(3000);
                System.out.println(" Elle tue !");
                Thread.sleep(3000);
                break;
            case 1:
                System.out.println("Deux sardines se baladent quand l'une dit à l'autre : - Et si on allait en boîte ?");
                Thread.sleep(3000);
                break;
            case 2:
                System.out.println("Deux coccinelles font leur jogging. Soudain, l'une d'elles s'arrête et s'exclame : - Attends ! J'ai un point de côté.");
                Thread.sleep(3000);
                break;
            case 3:
                System.out.println("Sur une route, un escargot voit passer une limace et s'écrie : - Wow, la belle décapotable !");
                Thread.sleep(3000);
                break;
            case 4:
                System.out.println("Deux cons sont en voiture, soudain, la conductrice se met à crier : - Au secours, on n'a plus de frein ! - Ce n'est pas grave, dit l'autre. Il y a un stop en bas de la rue.");
                Thread.sleep(3000);
                break;
            case 5:
                System.out.print("Un chat prend un autre chat en photo et lui dit : - Souris ! L'autre chat sursaute : - Où ça, où ça ?");
                Thread.sleep(3000);
                break;
            case 6:
                System.out.print("Qu'est-ce qui a deux bosses et qu'on trouve au pôle Nord ?");
                Thread.sleep(3000);
                System.out.println(" Un chameau qui est vraiment perdu.");
                Thread.sleep(3000);
                break;
            case 7:
                System.out.print("Qu'est-ce qui est jaune et qui est dans l'arbre ?");
                Thread.sleep(3000);
                System.out.println(" La voiture du facteur qui a raté le virage.");
                Thread.sleep(3000);
                break;
        }
    }

    public void msgBienvenue() throws InterruptedException {

        Scanner clavier = new Scanner(System.in);

        System.out.println();
        System.out.println("        _\n" +
                "       / \\      _-'\n" +
                "     _/|  \\-''- _ /\n" +
                "__-' { |          \\\n" +
                "    /             \\\n" +
                "    /       \"o.  |o }\n" +
                "    |            \\ ;\n" +
                "                  ',\n" +
                "       \\_         __\\\n" +
                "         ''-_    \\.//\n" +
                "           / '-____'\n" +
                "          /\n" +
                "        _'\n" +
                "      _-'");
        System.out.println();
        Thread.sleep(500);

        String message = "Bienvenue jeune aventurier, le monde a besoin de ton aide. Trois faucheuses sont descendues sur terre et terrorisent la population. ";
        String message2 = "Tuez les et devenez un héros. Faites attention, elles ont répandu leurs monstres partout. Faudra avancer avec prudence. ";
        String message3 = "Mais avant de partir, quel est votre nom?: ";
        String message4 = "Bienvenue . Bonne chance pour la suite de votre aventure. ";

        for(int i = 0; i < 28; i++){
            System.out.print(message.charAt(i));
            Thread.sleep(50);
        }
        Thread.sleep(500);
        for(int i = 28; i < 58; i++){
            System.out.print(message.charAt(i));
            Thread.sleep(50);
        }
        Thread.sleep(500);
        for(int i = 58; i < 132; i++){
            System.out.print(message.charAt(i));
            Thread.sleep(50);
        }
        System.out.println();
        Thread.sleep(500);
        for(int i = 0; i < 30; i++){
            System.out.print(message2.charAt(i));
            Thread.sleep(50);
        }
        Thread.sleep(500);
        for(int i = 30; i < 48; i++){
            System.out.print(message2.charAt(i));
            Thread.sleep(50);
        }
        Thread.sleep(500);
        for(int i = 48; i < 90; i++){
            System.out.print(message2.charAt(i));
            Thread.sleep(50);
        }
        Thread.sleep(500);
        for(int i = 90; i < 120; i++){
            System.out.print(message2.charAt(i));
            Thread.sleep(50);
        }
        System.out.println();
        Thread.sleep(500);
        for(int i = 0; i < 22; i++){
            System.out.print(message3.charAt(i));
            Thread.sleep(50);
        }
        Thread.sleep(500);
        for(int i = 22; i < 43; i++){
            System.out.print(message3.charAt(i));
            Thread.sleep(50);
        }

        do{
            personnage.setNom(clavier.nextLine());
            if(personnage.getNom().length() < 1){
                System.out.println("Aucun nom mis");
                System.out.print("Réesssayez: ");
            }else if(personnage.getNom().length() > 20){
                System.out.println("Maximum de 20 characteres");
                System.out.print("Réesssayez: ");
            }
        }while(personnage.getNom().length() < 1 || personnage.getNom().length() > 20);

        Thread.sleep(500);
        for(int i = 0; i < 10; i++){
            System.out.print(message4.charAt(i));
            Thread.sleep(50);
        }

        for(int i = 0; i < personnage.getNom().length(); i++){
            System.out.print(personnage.getNom().charAt(i));
            Thread.sleep(50);
        }
        System.out.print(". ");
        Thread.sleep(500);
        for(int i = 12; i < 58; i++){
            System.out.print(message4.charAt(i));
            Thread.sleep(50);
        }
        System.out.println();
        Thread.sleep(500);
        System.out.println();
        System.out.println();
        System.out.println();

    }

    public void msgFin() throws  InterruptedException {
        System.out.println();
        String message = "Merci de nous avoir sauvé valeureux combatant. Tu seras toujours le bienvenu parmi nous et en cas de besoin, nous serons toujours la pour toi.";
        System.out.println();
        System.out.println("        _\n" +
                "       / \\      _-'\n" +
                "     _/|  \\-''- _ /\n" +
                "__-' { |          \\\n" +
                "    /             \\\n" +
                "    /       \"o.  |o }\n" +
                "    |            \\ ;\n" +
                "                  ',\n" +
                "       \\_         __\\\n" +
                "         ''-_    \\.//\n" +
                "           / '-____'\n" +
                "          /\n" +
                "        _'\n" +
                "      _-'");

        for(int i = 0; i < 46; i++){
            System.out.print(message.charAt(i));
            Thread.sleep(50);
        }
        Thread.sleep(500);
        for(int i = 46; i < 88; i++){
            System.out.print(message.charAt(i));
            Thread.sleep(50);
        }
        Thread.sleep(500);
        for(int i = 88; i < 109; i++){
            System.out.print(message.charAt(i));
            Thread.sleep(50);
        }
        Thread.sleep(500);
        for(int i = 109; i < 142; i++){
            System.out.print(message.charAt(i));
            Thread.sleep(50);
        }
        Thread.sleep(500);


        System.out.println();
        System.out.println(" .----------------.  .----------------.  .----------------.    .----------------.  .-----------------. .----------------. \n" +
                "| .--------------. || .--------------. || .--------------. |  | .--------------. || .--------------. || .--------------. |\n" +
                "| |  _________   | || |  ____  ____  | || |  _________   | |  | |  _________   | || | ____  _____  | || |  ________    | |\n" +
                "| | |  _   _  |  | || | |_   ||   _| | || | |_   ___  |  | |  | | |_   ___  |  | || ||_   \\|_   _| | || | |_   ___ `.  | |\n" +
                "| | |_/ | | \\_|  | || |   | |__| |   | || |   | |_  \\_|  | |  | |   | |_  \\_|  | || |  |   \\ | |   | || |   | |   `. \\ | |\n" +
                "| |     | |      | || |   |  __  |   | || |   |  _|  _   | |  | |   |  _|  _   | || |  | |\\ \\| |   | || |   | |    | | | |\n" +
                "| |    _| |_     | || |  _| |  | |_  | || |  _| |___/ |  | |  | |  _| |___/ |  | || | _| |_\\   |_  | || |  _| |___.' / | |\n" +
                "| |   |_____|    | || | |____||____| | || | |_________|  | |  | | |_________|  | || ||_____|\\____| | || | |________.'  | |\n" +
                "| |              | || |              | || |              | |  | |              | || |              | || |              | |\n" +
                "| '--------------' || '--------------' || '--------------' |  | '--------------' || '--------------' || '--------------' |\n" +
                " '----------------'  '----------------'  '----------------'    '----------------'  '----------------'  '----------------' ");






    }

    public void tutoriel() throws InterruptedException {

        System.out.println("W: Monter\n" +
                "S: Descendre\n" +
                "A: Aller à gauche\n" +
                "D: Aller à droite\n" +
                "\n" +
                "M: Ouvrir le menu\n" +
                "U: Voir les statistiques\n" +
                "P: Ouvrir les parametres\n" +
                "B: Voir une blague aléatoire\n" +
                "I: Ouvrir l'inventaire\n" +
                "Q: quitter");
        Thread.sleep(5000);

    }

    public void afficherInventaire() throws InterruptedException {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\n" +
                " .----------------.  .-----------------. .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.  .----------------. \n" +
                "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n" +
                "| |     _____    | || | ____  _____  | || | ____   ____  | || |  _________   | || | ____  _____  | || |  _________   | || |     ____     | || |  _______     | || |  ____  ____  | |\n" +
                "| |    |_   _|   | || ||_   \\|_   _| | || ||_  _| |_  _| | || | |_   ___  |  | || ||_   \\|_   _| | || | |  _   _  |  | || |   .'    `.   | || | |_   __ \\    | || | |_  _||_  _| | |\n" +
                "| |      | |     | || |  |   \\ | |   | || |  \\ \\   / /   | || |   | |_  \\_|  | || |  |   \\ | |   | || | |_/ | | \\_|  | || |  /  .--.  \\  | || |   | |__) |   | || |   \\ \\  / /   | |\n" +
                "| |      | |     | || |  | |\\ \\| |   | || |   \\ \\ / /    | || |   |  _|  _   | || |  | |\\ \\| |   | || |     | |      | || |  | |    | |  | || |   |  __ /    | || |    \\ \\/ /    | |\n" +
                "| |     _| |_    | || | _| |_\\   |_  | || |    \\ ' /     | || |  _| |___/ |  | || | _| |_\\   |_  | || |    _| |_     | || |  \\  `--'  /  | || |  _| |  \\ \\_  | || |    _|  |_    | |\n" +
                "| |    |_____|   | || ||_____|\\____| | || |     \\_/      | || | |_________|  | || ||_____|\\____| | || |   |_____|    | || |   `.____.'   | || | |____| |___| | || |   |______|   | |\n" +
                "| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |\n" +
                "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n" +
                " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \n");
        System.out.println();
        System.out.println();
        if(personnage.inventaire.size() < 2){
            System.out.print("╔════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("\n" +
                    "║  _____ _   _ _   _ _____ _   _ _____ ___  ___________ _____   _   _ ___________ _____  ║\n" +
                    "║ |_   _| \\ | | | | |  ___| \\ | |_   _/ _ \\|_   _| ___ \\  ___| | | | |_   _|  _  \\  ___| ║\n" +
                    "║   | | |  \\| | | | | |__ |  \\| | | |/ /_\\ \\ | | | |_/ / |__   | | | | | | | | | | |__   ║\n" +
                    "║   | | | . ` | | | |  __|| . ` | | ||  _  | | | |    /|  __|  | | | | | | | | | |  __|  ║\n" +
                    "║  _| |_| |\\  \\ \\_/ / |___| |\\  | | || | | |_| |_| |\\ \\| |___  \\ \\_/ /_| |_| |/ /| |___  ║\n" +
                    "║  \\___/\\_| \\_/\\___/\\____/\\_| \\_/ \\_/\\_| |_/\\___/\\_| \\_\\____/   \\___/ \\___/|___/ \\____/  ║");
            System.out.print("╚════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println();
            System.out.println();
            System.out.println();
            Thread.sleep(3000);
        }else{
            for(int i = 0; i < personnage.inventaire.size(); i++){
                System.out.print("╔════════════════════════════════════════╗");
            }
            System.out.println();
            for(int i = 0; i < personnage.inventaire.size(); i++){
                String ligne = String.format("║ %-39s", personnage.inventaire.get(i).getNom());
                System.out.print(ligne);
                System.out.print("║");
            }
            System.out.println();
            for(int i = 0; i < personnage.inventaire.size(); i++){
                String ligne = String.format("║ Degats: %-31s", personnage.inventaire.get(i).getDegats());
                System.out.print(ligne);
                System.out.print("║");
            }
            System.out.println();
            for(int i = 0; i < personnage.inventaire.size(); i++){
                String armeOn = "";
                if(personnage.inventaire.get(i) == personnage.arme){
                    armeOn = "(Arme équipée)";
                }

                String ligne = String.format("║ %-39s", armeOn);
                System.out.print(ligne);
                System.out.print("║");
            }
            System.out.println();
            for(int i = 0; i < personnage.inventaire.size(); i++){
                System.out.print("║----------------------------------------║");
            }
            System.out.println();
            for(int i = 0; i < 16; i++){
                for(int j = 0; j < personnage.inventaire.size(); j++){
                    System.out.print("║");
                    System.out.print(personnage.inventaire.get(j).affichage(i));
                    System.out.print("║");
                }
                System.out.println();
            }

            for(int i = 0; i < personnage.inventaire.size(); i++){
                System.out.print("╚════════════════════════════════════════╝");
            }
            System.out.println();
        }

    }


    public void inventaire() throws InterruptedException {
        System.out.println();
        pointeur = 0;
        boolean retour = false;
        Scanner clavier = new Scanner(System.in);
        while(!retour){
            afficherInventaire();
            if(personnage.inventaire.size() < 2){
                retour = true;
            }else{
                decisionPrise = false;
                while(!decisionPrise){
                    affOptionsInv();
                    String choix = clavier.nextLine();
                    switch (choix.toUpperCase()){
                        case "W":
                            if(pointeur == 0){
                                pointeur = personnage.inventaire.size();
                            }else{
                                pointeur--;
                            }
                            break;
                        case "S":
                            if(pointeur == personnage.inventaire.size()){
                                pointeur = 0;
                            }else{
                                pointeur++;
                            }
                            break;
                        case "":
                            decisionPrise = true;
                            break;
                        default:
                            System.out.println("s, w pour naviguer. Entree pour selecitonner le choix. :)");
                    }
                }

                if(pointeur == personnage.inventaire.size()){
                    retour = true;
                }else{
                    personnage.arme = personnage.inventaire.get(pointeur);
                }
            }

        }

    }

    public void affOptionsInv(){
        System.out.println();
        System.out.println();
        System.out.println("Options: ");
        String[] inventaire = new String[personnage.inventaire.size()];
        for(int i = 0; i < personnage.inventaire.size(); i++){
            inventaire[i] = "      Équiper " + personnage.inventaire.get(i).getNom();
        }
        String retour = "      Retour";

        if(pointeur == personnage.inventaire.size()){
            retour = " ---> Retour";
        }else{
            inventaire[pointeur] =" ---> Équiper " + personnage.inventaire.get(pointeur).getNom();
        }

        for(int i = 0; i < personnage.inventaire.size(); i++){
            System.out.println(inventaire[i]);
        }
        System.out.println(retour);
        System.out.println();



    }

    public void appliquerDimensions() throws IOException {
        int largeur = 0;
        int longueur;

        ArrayList<String> infos = fichier.getJeuInfos();

        longueur = infos.get(0).length();

        for(int i = 0; !infos.get(i).equals(";"); i++){
            largeur = i;
        }

        personnage.nom = infos.get(largeur + 2);
        personnage.statsDegats = Integer.parseInt(infos.get(largeur + 3));
        personnage.statsPV = Integer.parseInt(infos.get(largeur + 4));
        personnage.stats = Integer.parseInt(infos.get(largeur + 5));
        personnage.niveau = Integer.parseInt(infos.get(largeur + 6));
        personnage.nbreBossTues = Integer.parseInt(infos.get(largeur + 7));

        System.out.println(infos.get(largeur + 7).length());

        for(int i = 0; i < infos.get(largeur + 8).length(); i++){
            switch (Integer.parseInt(String.valueOf(infos.get(largeur + 8).charAt(i)))){
                case 0:
                    personnage.inventaire.add(new EpeeLaser(5));
                    break;
                case 1:
                    personnage.inventaire.add(new Epee(10));
                    break;
                case 2:
                    personnage.inventaire.add(new TrucKun(50));
                    break;
            }
        }

    }

    public void ecrireFichier(String nomFichier) throws FileNotFoundException {

        FileOutputStream sortieFichier = new FileOutputStream(nomFichier);

        PrintStream sortie = new PrintStream(sortieFichier);

        for(int i = 0; i < tabJeu.tabLargeur; i++){
            for(int j = 0; j < tabJeu.tabLongueur; j++){
                sortie.print(tabJeu.getTuile(i, j).getOccupant());
            }
            sortie.println();
        }
        sortie.println(";");
        sortie.println(personnage.nom);
        sortie.println(personnage.statsDegats);
        sortie.println(personnage.statsPV);
        sortie.println(personnage.stats);
        sortie.println(personnage.niveau);
        sortie.println(personnage.nbreBossTues);

        for(int i = 1; i < personnage.inventaire.size(); i++){
            switch (personnage.inventaire.get(i).getNom()){
                case "Épée Laser":
                    sortie.print(0);
                    break;
                case "Excalibur":
                    sortie.print(1);
                    break;
                case "Isekai's nightmare: THE TRUC-KUN!!!":
                    sortie.print(2);
                    break;
            }
        }
        sortie.println();

    }

    public void sauvegarder() throws FileNotFoundException {

        Scanner clavier = new Scanner(System.in);

        System.out.print("Ecrivez le nom de la sauvegarde ou n'entrez rien pour ne pas sauvegarder: ");

        String choix = clavier.nextLine();

        boolean continuer = true;

        if(fichier.fichierValide(choix + ".txt")){
            System.out.print("Sauvegarde en double. Voulez-vous supprimer l'autre? (O)ui/(N)on: ");
            String ouiNon = clavier.nextLine();

            switch (ouiNon.toUpperCase()){
                case "OUI":
                case "O":
                    break;
                default:
                    continuer = false;
            }

        }


        if(!choix.equals("") && continuer){
            choix += ".txt";
            ecrireFichier(choix);
            System.out.println("Sauvegardé avec succès");
        }else{
            System.out.println("Sauvegarde annulée avec succès");
        }


    }

    public void chargerSauvegarde() throws IOException {
        //https://stackoverflow.com/questions/60650841/fetch-the-list-of-all-txt-files-in-directory-and-sub-directory-and-add-it-to-a-l

        File folder = new File("C:\\Users\\2258286\\OneDrive - Collège de Bois-de-Boulogne\\École BdeB\\Anciens cours\\Session 2\\Programmation Objets\\JeuSpecial");

        File[] files = folder.listFiles();

        ArrayList<String> filesList = new ArrayList<>();

        assert files != null;
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                filesList.add(file.getName());
            }
        }


        pointeur = 0;
        boolean retour = false;
        Scanner clavier = new Scanner(System.in);
        while(!retour){
            decisionPrise = false;
            while(!decisionPrise){
                afficherFicTxt(filesList);
                String choix = clavier.nextLine();
                switch (choix.toUpperCase()){
                    case "W":
                        if(pointeur == 0){
                            pointeur = filesList.size() + 1;
                        }else{
                            pointeur--;
                        }
                        break;
                    case "S":
                        if(pointeur == filesList.size() + 1){
                            pointeur = 0;
                        }else{
                            pointeur++;
                        }
                        break;
                    case "":
                        decisionPrise = true;
                        break;
                    default:
                        System.out.println("s, w pour naviguer. Entree pour selecitonner le choix. :)");
                }
            }

            if (pointeur != filesList.size() + 1) {
                fichier.startFichier(filesList.get(pointeur));
                appliquerDimensions();
                tabJeu.appliquerCases(getLigneInfos());
            }
            retour = true;

        }

    }

    public ArrayList<String> getLigneInfos() throws IOException {

        return fichier.getJeuInfos();
    }

    public void afficherFicTxt(ArrayList<String> filesList){

        for(int i = 0; i < filesList.size(); i++){
            if(i == pointeur){
                System.out.println(" ---> " + filesList.get(i));
            }else{
                System.out.println("      " + filesList.get(i));
            }
        }

        if(pointeur == filesList.size() + 1){
            System.out.println(" ---> Retourner");
        }else{
            System.out.println("      Retourner");
        }


    }

    public void changerVision(){
        Scanner clavier = new Scanner(System.in);

        int choix = tabJeu.vision;

        System.out.println("Entrez la nouvelle portée de vision: ");

        boolean entreeValide;

        do{
            entreeValide = true;
            try{
                choix = clavier.nextInt();
            }catch (Exception e){
                System.out.println("Entrée invalide. Réessayez: ");
                entreeValide = false;
            }
        }while(!entreeValide);

        tabJeu.vision = choix;

    }

}
