public class Boss extends Etre{


    public Boss(int pv) {
        super(pv);
    }

    @Override
    public String afficherEtre(int ligne, boolean animation) {
        String[] lignes = new String[16];
         lignes[0] = "                     ___               ";
         lignes[1] = "                    /   \\\\             ";
         if(animation){
             lignes[2] = "               /\\\\ | ^ ^ \\\\            ";
         }else{
             lignes[2] = "               /\\\\ | . . \\\\            ";
         }
         lignes[3] = "             ////\\\\|     ||            ";
         lignes[4] = "           ////   \\\\ ___//\\            ";
         lignes[5] = "          ///      \\\\      \\           ";
         lignes[6] = "         ///       |\\\\      |          ";
         lignes[7] = "        //         | \\\\  \\   \\         ";
         lignes[8] = "        /          |  \\\\  \\   \\        ";
         lignes[9] = "                   |   \\\\ /   /        ";
        lignes[10] = "                   |    \\/   /         ";
        lignes[11] = "                   |     \\\\/|          ";
        lignes[12] = "                   |      \\\\|          ";
        lignes[13] = "                   |       \\\\          ";
        lignes[14] = "                   |        |          ";
        lignes[15] = "                   |_________\\         ";


        return lignes[ligne];
    }


}
