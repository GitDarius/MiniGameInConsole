import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichier {

    private FileInputStream fichier;

    String nomFichier;

    public Fichier() {
    }

    public boolean fichierValide(String nomFichier){
        boolean fichierValide = true;

        try {
            this.fichier = new FileInputStream(nomFichier);
        } catch (IOException ex) {
            fichierValide = false;
        }

        return fichierValide;

    }

    public void startFichier(String nomFichier) throws FileNotFoundException {
        fichier = new FileInputStream(nomFichier);
        this.nomFichier = nomFichier;
    }

    public ArrayList<String> getJeuInfos() throws IOException {

        startFichier(nomFichier);

        ArrayList<String> infos = new ArrayList<>();

        Scanner lecteurFichier = new Scanner(this.fichier);

        while (lecteurFichier.hasNext()){
            infos.add(lecteurFichier.nextLine());
        }

        fichier.close();

        return infos;

    }





}
