import javax.print.attribute.HashDocAttributeSet;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        //Déclaration Jeu
        Jeu jeu = new Jeu();
        //Menu accueuiil
        jeu.accueuil();
        //Lancement Jeu
        while(!jeu.isQuitter() && jeu.personnage.nbreBossTues != 3){
            //Affiche le tableau
            jeu.tabJeu.afficherJeu(jeu.afficherJeuComplet);
            //Jouer decision
            jeu.bouger();
            //Respawn si des troupes tuées
            jeu.tabJeu.repeupler();
        }
        if(jeu.personnage.nbreBossTues >= 3){
            jeu.msgFin();
        }



    }

}