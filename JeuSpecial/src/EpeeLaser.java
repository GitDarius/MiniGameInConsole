public class EpeeLaser extends Arme{

    public EpeeLaser(int degats) {
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
            lignes[8] = "                                        ";
            lignes[9] = "                                        ";
            lignes[10] = "                                        ";
            lignes[11] = "                                        ";
            lignes[12] = "    [O\\\\\\\\\\[=======================-    ";
            lignes[13] = "                                        ";
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
            lignes[8] = "                                        ";
            lignes[9] = "                                        ";
            lignes[10] = "                                        ";
            lignes[11] = "                                        ";
            lignes[12] = "    -=======================]/////0]    ";
            lignes[13] = "                                        ";
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
            lignes[8] = "                                        ";
            lignes[9] = "                                        ";
            lignes[10] = "                                        ";
            lignes[11] = "                                        ";
            lignes[12] = "    [O\\\\\\\\\\[=======================-    ";
            lignes[13] = "                                        ";
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
            lignes[8] = "                                        ";
            lignes[9] = "                                        ";
            lignes[10] = "                                        ";
            lignes[11] = "                                        ";
            lignes[12] = "    -=======================]/////0]    ";
            lignes[13] = "                                        ";
            lignes[14] = "                                        ";
            lignes[15] = "                                        ";

        }

        return lignes[ligne];
    }

    @Override
    public String affichage(int ligne) {
        String[] lignes = new String[16];
        lignes[0] = "                                        ";
        lignes[1] = "                                        ";
        lignes[2] = "                                        ";
        lignes[3] = "                                        ";
        lignes[4] = "                                        ";
        lignes[5] = "                                        ";
        lignes[6] = "                                        ";
        lignes[7] = "                                        ";
        lignes[8] = "    [0/////[=======================-    ";
        lignes[9] = "                                        ";
        lignes[10] = "                                        ";
        lignes[11] = "                                        ";
        lignes[12] = "                                        ";
        lignes[13] = "                                        ";
        lignes[14] = "                                        ";
        lignes[15] = "                                        ";

        return lignes[ligne];
    }

    @Override
    public String getNom() {
        return "Épée Laser";
    }
}
