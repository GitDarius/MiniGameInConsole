public class TrucKun extends Arme{


    public TrucKun(int degats) {
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
            lignes[11] = "        ____________  ___               ";
            lignes[12] = "       |            ||   \\_             ";
            lignes[13] = "       |            ||  |__\\____        ";
            lignes[14] = "       |____________||          )       ";
            lignes[15] = "       \\___/OO\\___/OO\\____/O\\___|       ";
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
            lignes[11] = "               ___  ____________        ";
            lignes[12] = "             _/   ||            |       ";
            lignes[13] = "        ____/__|  ||            |       ";
            lignes[14] = "       )          ||____________|       ";
            lignes[15] = "       |___/O\\____/OO\\___/OO\\___/       ";
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
            lignes[11] = "        ____________  ___               ";
            lignes[12] = "       |            ||   \\_             ";
            lignes[13] = "       |            ||  |__\\____        ";
            lignes[14] = "       |____________||          )       ";
            lignes[15] = "       \\___/OO\\___/OO\\____/O\\___|       ";
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
            lignes[11] = "               ___  ____________        ";
            lignes[12] = "             _/   ||            |       ";
            lignes[13] = "        ____/__|  ||            |       ";
            lignes[14] = "       )          ||____________|       ";
            lignes[15] = "       |___/O\\____/OO\\___/OO\\___/       ";
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
         lignes[6] = "        ____________  ___               ";
         lignes[7] = "       |            ||   \\_             ";
         lignes[8] = "       |            ||  |__\\____        ";
         lignes[9] = "       |____________||          )       ";
        lignes[10] = "       \\___/OO\\___/OO\\____/O\\___|       ";
        lignes[11] = "                                        ";
        lignes[12] = "                                        ";
        lignes[13] = "                                        ";
        lignes[14] = "                                        ";
        lignes[15] = "                                        ";

        return lignes[ligne];
    }

    @Override
    public String getNom() {
        return "Isekai's nightmare: THE TRUC-KUN!!!";
    }
}
