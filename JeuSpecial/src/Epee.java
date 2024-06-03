public class Epee extends Arme{

    public Epee(int degats) {
        super(degats);
    }

    @Override
    public String posture(int ligne, boolean isPersonnage) {
        String[] lignes = new String[16];
        if(isPersonnage){
             lignes[0] = "     /\\                                 ";
             lignes[1] = "    /  \\                                ";
             lignes[2] = "    |  |                                ";
             lignes[3] = "    |  |                                ";
             lignes[4] = "    |  |                                ";
             lignes[5] = "    |  |                                ";
             lignes[6] = "    |  |                                ";
             lignes[7] = "   _|  |_                               ";
             lignes[8] = "  |__  __|                              ";
             lignes[9] = "  ___||__                               ";
            lignes[10] = " /     __\\                              ";
            lignes[11] = "|      ___|                             ";
            lignes[12] = "|      ___|                             ";
            lignes[13] = "\\________/                              ";
            lignes[14] = "     ()⠀⠀⠀⠀                             ";
            lignes[15] = "       ⠀⠀⠀⠀                             ";
        }else{
             lignes[0] = "                                 /\\     ";
             lignes[1] = "                                /  \\    ";
             lignes[2] = "                                |  |    ";
             lignes[3] = "                                |  |    ";
             lignes[4] = "                                |  |    ";
             lignes[5] = "                                |  |    ";
             lignes[6] = "                                |  |    ";
             lignes[7] = "                               _|  |_   ";
             lignes[8] = "                              |__  __|  ";
             lignes[9] = "                               __||___  ";
            lignes[10] = "                              /__     \\ ";
            lignes[11] = "                             |___      |";
            lignes[12] = "                             |___      |";
            lignes[13] = "                             \\________/ ";
            lignes[14] = "       ⠀⠀⠀⠀                       ()    ";
            lignes[15] = "       ⠀⠀⠀⠀                             ";
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
             lignes[9] = "      _______       _                   ";
            lignes[10] = "     /       \\     | |                  ";
            lignes[11] = "    |         |____| |______________    ";
            lignes[12] = "  ()|         |____   ______________/   ";
            lignes[13] = "     \\_______/     | |                  ";
            lignes[14] = "                   |_|                  ";
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
             lignes[9] = "                     _       _______    ";
            lignes[10] = "                    | |     /       \\   ";
            lignes[11] = "      ______________| |____|         |  ";
            lignes[12] = "     \\______________   ____|         |()";
            lignes[13] = "                    | |     \\_______/   ";
            lignes[14] = "                    |_|                 ";
            lignes[15] = "                                        ";
        }

        return lignes[ligne];
    }

    @Override
    public String affichage(int ligne) {
        String[] lignes = new String[16];
         lignes[0] = "       ⠀⠀⠀⠀        /*\\         ⠀⠀⠀⠀     ";
         lignes[1] = "       ⠀⠀⠀⠀       /   \\        ⠀⠀⠀⠀     ";
         lignes[2] = "       ⠀⠀⠀⠀       |   |        ⠀⠀⠀⠀     ";
         lignes[3] = "       ⠀⠀⠀⠀       |   |        ⠀⠀⠀⠀     ";
         lignes[4] = "       ⠀⠀⠀⠀       |   |        ⠀⠀⠀⠀     ";
         lignes[5] = "       ⠀⠀⠀⠀       |   |        ⠀⠀⠀⠀     ";
         lignes[6] = "       ⠀⠀⠀⠀       |   |        ⠀⠀⠀⠀     ";
         lignes[7] = "       ⠀⠀⠀⠀       |   |        ⠀⠀⠀⠀     ";
         lignes[8] = "       ⠀⠀⠀⠀       |   |        ⠀⠀⠀⠀     ";
         lignes[9] = "       ⠀⠀⠀⠀       |   |         ⠀⠀⠀     ";
        lignes[10] = "       ⠀⠀⠀⠀       |   |         ⠀⠀⠀     ";
        lignes[11] = "       ⠀⠀⠀⠀      _|   |_        ⠀⠀⠀     ";
        lignes[12] = "       ⠀⠀⠀⠀     |__   __|       ⠀⠀⠀     ";
        lignes[13] = "       ⠀⠀⠀⠀        | |          ⠀⠀⠀⠀    ";
        lignes[14] = "       ⠀⠀⠀⠀        | |          ⠀⠀⠀⠀    ";
        lignes[15] = "       ⠀⠀⠀⠀        (◆)⠀⠀⠀       ⠀⠀⠀⠀    ";

        return lignes[ligne];
    }

    @Override
    public String getNom() {
        return "Excalibur";
    }
}
