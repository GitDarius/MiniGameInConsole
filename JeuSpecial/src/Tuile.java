import javax.swing.*;

public class Tuile {

    private int direction;

    //0 = Rien
    //1 = Coffre
    //2 = Monstre
    //3 = Boss
    //4 = Perso
    //5 = Special
    private int occupant;


    public Tuile() {
        occupant = 0;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getOccupant() {
        return occupant;
    }

    public void setOccupant(int occupant) {
        this.occupant = occupant;
    }

    public void afficherCase(int ligne){
        switch(occupant){
            case 0:
                System.out.print(tuile(ligne));
                break;
            case 1:
                System.out.print(tuileCoffre(ligne));
                break;
            case 2:
                System.out.print(tuileEnnemi(ligne));
                break;
            case 3:
                System.out.print(tuileBoss(ligne));
                break;
            case 4:
                System.out.print(tuilePerso(ligne));
                break;
            case 5:
                System.out.print(tuileArbre(ligne));
                break;
        }
    }

    private String tuile(int ligne){
        String[] lignes = new String[11];
        lignes[0] = "***********************";
        lignes[1] = "*                     *";
        lignes[2] = "*                     *";
        lignes[3] = "*                     *";
        lignes[4] = "*                     *";
        lignes[5] = "*                     *";
        lignes[6] = "*                     *";
        lignes[7] = "*                     *";
        lignes[8] = "*                     *";
        lignes[9] = "*                     *";
        lignes[10] = "*                     *";


        return lignes[ligne];
    }

    private String tuileBoss(int ligne){
        String[] lignes = new String[11];
        lignes[0] = "***********************";
        lignes[1] = "*                     *";
        lignes[2] = "*          +          *";
        lignes[3] = "*        qoOop        *";
        lignes[4] = "*        (===)        *";
        lignes[5] = "*       / \\ / \\       *";
        lignes[6] = "*      | [] [] |      *";
        lignes[7] = "*       \\  ^  /       *";
        lignes[8] = "*        |||||        *";
        lignes[9] = "*        |||||        *";
        lignes[10] = "*                     *";



        return lignes[ligne];
    }

    private String tuileEnnemi(int ligne){
        String[] lignes = new String[11];
        lignes[0] = "***********************";
        lignes[1] = "*                     *";
        lignes[2] = "*                     *";
        lignes[3] = "*        _____        *";
        lignes[4] = "*       /     \\       *";
        lignes[5] = "*      | () () |      *";
        lignes[6] = "*       \\  ^  /       *";
        lignes[7] = "*        |||||        *";
        lignes[8] = "*        |||||        *";
        lignes[9] = "*                     *";
        lignes[10] = "*                     *";



        return lignes[ligne];
    }

    private String tuilePerso(int ligne){
        String[] lignes = new String[11];
        lignes[0] = "***********************";
        lignes[1] = "*                     *";
        lignes[2] = "*         ###         *";
        lignes[3] = "*       #     #       *";
        lignes[4] = "*     ##       #      *";
        switch(direction){
            case 0:
                lignes[5] = "*    #  @    @  #     *";
                break;
            case 1:
                lignes[5] = "*    #       @  #     *";
                break;
            case 2:
                lignes[5] = "*    #  @       #     *";
                break;
            case 3:
                lignes[5] = "*    #          #     *";
                break;
        }
        lignes[6] = "*    #          #     *";
        lignes[7] = "*    #          #     *";
        lignes[8] = "*     #        #      *";
        lignes[9] = "*      ########       *";
        lignes[10] = "*                     *";



        return lignes[ligne];
    }

    private String tuileCoffre(int ligne){
        String[] lignes = new String[11];
        lignes[0] = "***********************";
        lignes[1] = "*                     *";
        lignes[2] = "*                     *";
        lignes[3] = "*     ___________     *";
        lignes[4] = "*    /           \\    *";
        lignes[5] = "*   |_____[o]_____|   *";
        lignes[6] = "*   |             |   *";
        lignes[7] = "*   |=_/\\_===_/\\_=|   *";
        lignes[8] = "*   |_____________|   *";
        lignes[9] = "*                     *";
        lignes[10] = "*                     *";


        return lignes[ligne];
    }

    private String tuileArbre(int ligne){
        String[] lignes = new String[11];
        lignes[0] = "***********************";
        lignes[1] = "*                     *";
        lignes[2] = "*         _-_         *";
        lignes[3] = "*      /~~   ~~\\      *";
        lignes[4] = "*   /~~         ~~\\   *";
        lignes[5] = "*  {               }  *";
        lignes[6] = "*   \\  _-     -_  /   *";
        lignes[7] = "*   " +
                "  ~  \\\\ //  ~     *";
        lignes[8] = "*  _- -   | | _- _    *";
        lignes[9] = "*    _ -  | |   -_    *";
        lignes[10] = "*        // \\\\        *";


        return lignes[ligne];
    }





}
