public class Ennemi extends Etre{

    Arme arme;

    int typeEnnemi;

    public Ennemi(int pv, int typeEnnemi) {
        super(pv);
        this.typeEnnemi = typeEnnemi;
    }

    @Override
    public String afficherEtre(int ligne, boolean animation) {
        String[] lignes = new String[16];
        switch (typeEnnemi){
            case 0:
                lignes[0] = "                                        ";
                lignes[1] = "                                        ";
                lignes[2] = "                                        ";
                lignes[3] = "                                        ";
                lignes[4] = "                                        ";
                lignes[5] = "                                        ";
                lignes[6] = "                                        ";
                lignes[7] = "                .-\"-.                   ";
                lignes[8] = "               /_ _  \\                  ";
                lignes[9] = "               \\@ @  /                  ";
                if(animation){
                    lignes[10] = "               (_> _)                   ";
                }else{
                    lignes[10] = "               (_= _)                   ";
                }
                lignes[11] = "                 `)(_                   ";
                lignes[12] = "                 /((_`)_,               ";
                lignes[13] = "                 \\__(/-\"                ";
                lignes[14] = "                __|||__                 ";
                lignes[15] = "               ((__|__))                ";
                break;
            case 1:
                if(animation){
                     lignes[0] = "                                        ";
                     lignes[1] = "                                        ";
                     lignes[2] = "               __                       ";
                     lignes[3] = "              (_ `-~~~~--.              ";
                     lignes[4] = "                ( _-  (   \\             ";
                     lignes[5] = "            \\   _)o)   (  |_            ";
                     lignes[6] = "               `-,__        )           ";
                     lignes[7] = "          _         )    )              ";
                     lignes[8] = "                   ---, `               ";
                     lignes[9] = "             /       ,^^^^_             ";
                    lignes[10] = "                     |   \\  \\           ";
                    lignes[11] = "                     |    \\^^\\          ";
                    lignes[12] = "                     ------```          ";
                    lignes[13] = "                    /________\\          ";
                    lignes[14] = "                      _| |__|           ";
                    lignes[15] = "                     /_//___|           ";
                }else{
                    lignes[0] = "                                        ";
                    lignes[1] = "                                        ";
                    lignes[2] = "                                        ";
                    lignes[3] = "                                        ";
                    lignes[4] = "               _----__ .                ";
                    lignes[5] = "              /______,  |               ";
                    lignes[6] = "                |    |   |              ";
                    lignes[7] = "               _O----|   |              ";
                    lignes[8] = "              `-     |___|              ";
                    lignes[9] = "               `__   _/                 ";
                    lignes[10] = "                 .' '~\\                 ";
                    lignes[11] = "                |    |_|                ";
                    lignes[12] = "                |____| |                ";
                    lignes[13] = "                |____```                ";
                    lignes[14] = "                  |_|_|                 ";
                    lignes[15] = "                 /_/___|                ";
                }

                break;
            case 2:
                lignes[0] = "                                        ";
                lignes[1] = "                                        ";
                lignes[2] = "                                        ";
                lignes[3] = "         .-.                            ";
                lignes[4] = "       .'    `.                         ";
                lignes[5] = "       :@ @   :                         ";
                if(animation){
                    lignes[6] = "       : O    `.                        ";
                }else{
                    lignes[6] = "       : -    `.                        ";
                }
                lignes[7] = "      :         ``.                     ";
                lignes[8] = "     :             `.                   ";
                lignes[9] = "    :  :         .   `.                 ";
                lignes[10] = "    :   :          ` . `.               ";
                lignes[11] = "     `.. :            `. ``;            ";
                lignes[12] = "        `:;             `:'             ";
                lignes[13] = "           :              `.            ";
                lignes[14] = "            `.              `.     .    ";
                lignes[15] = "              `'`'`'`---..,___`;.-'     ";
                break;


        }



        return lignes[ligne];
    }




}
