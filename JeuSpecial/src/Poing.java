public class Poing extends Arme{




    public Poing(int degats) {
        super(degats);
    }

    @Override
    public String posture(int ligne, boolean isPersonnage) {
        String[] lignes = new String[16];
        if(isPersonnage){
             lignes[0] = "                                        ";
             lignes[1] = "                                        ";
             lignes[2] = "                                        ";
             lignes[3] = "                                        ";
             lignes[4] = "                                        ";
             lignes[5] = "                                        ";
             lignes[6] = "                                        ";
             lignes[7] = "                                        ";
             lignes[8] = "                   _______              ";
             lignes[9] = "         ---------'   ____)             ";
            lignes[10] = "                     (_____)            ";
            lignes[11] = "                     (_____)            ";
            lignes[12] = "                     (____)             ";
            lignes[13] = "         ---------.__(___)              ";
            lignes[14] = "                                        ";
            lignes[15] = "                                        ";
        }else{
             lignes[0] = "                                        ";
             lignes[1] = "                                        ";
             lignes[2] = "                                        ";
             lignes[3] = "                                        ";
             lignes[4] = "                                        ";
             lignes[5] = "                                        ";
             lignes[6] = "                                        ";
             lignes[7] = "                                        ";
             lignes[8] = "            _______                     ";
             lignes[9] = "           (____   '----------          ";
            lignes[10] = "          (_____)                       ";
            lignes[11] = "          (_____)                       ";
            lignes[12] = "           (____)                       ";
            lignes[13] = "            (___)__.----------          ";
            lignes[14] = "                                        ";
            lignes[15] = "                                        ";
        }



        return lignes[ligne];
    }

    @Override
    public String animation(int ligne, boolean isPersonnage) {
        String[] lignes = new String[16];
        if(isPersonnage){
            lignes[0] = "                                        ";
            lignes[1] = "                                        ";
            lignes[2] = "                                        ";
            lignes[3] = "                                        ";
            lignes[4] = "                                        ";
            lignes[5] = "                                        ";
            lignes[6] = "                                        ";
            lignes[7] = "                                        ";
            lignes[8] = "                   _______              ";
            lignes[9] = "         ---------'   ____)             ";
            lignes[10] = "                     (_____)            ";
            lignes[11] = "                     (_____)            ";
            lignes[12] = "                     (____)             ";
            lignes[13] = "         ---------.__(___)              ";
            lignes[14] = "                                        ";
            lignes[15] = "                                        ";
        }else{
            lignes[0] = "                                        ";
            lignes[1] = "                                        ";
            lignes[2] = "                                        ";
            lignes[3] = "                                        ";
            lignes[4] = "                                        ";
            lignes[5] = "                                        ";
            lignes[6] = "                                        ";
            lignes[7] = "                                        ";
            lignes[8] = "            _______                     ";
            lignes[9] = "           (____   '----------          ";
            lignes[10] = "          (_____)                       ";
            lignes[11] = "          (_____)                       ";
            lignes[12] = "           (____)                       ";
            lignes[13] = "            (___)__.----------          ";
            lignes[14] = "                                        ";
            lignes[15] = "                                        ";
        }


        return lignes[ligne];
    }

    public String affichage(int ligne) {
        String[] lignes = new String[16];
        lignes[0] = "                                        ";
        lignes[1] = "                                        ";
        lignes[2] = "                                        ";
        lignes[3] = "                                        ";
        lignes[4] = "                                        ";
        lignes[5] = "                                        ";
        lignes[6] = "                   _______              ";
        lignes[7] = "         ---------'   ____)             ";
        lignes[8] = "                     (_____)            ";
        lignes[9] = "                     (_____)            ";
        lignes[10] = "                     (____)             ";
        lignes[11] = "         ---------.__(___)              ";
        lignes[12] = "                                        ";
        lignes[13] = "                                        ";
        lignes[14] = "                                        ";
        lignes[15] = "                                        ";


        return lignes[ligne];
    }

    @Override
    public String getNom() {
        return "Poing";
    }
}
