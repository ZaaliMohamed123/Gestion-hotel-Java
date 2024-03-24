package fichiers ;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import gestionHotel.Chambre;

public class WriteChambreObjectsToFile {

    public  WriteChambreObjectsToFile(List<Chambre> chambreList){
        String filePath = "Les Chambres.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Chambre chambre : chambreList) {
                writer.write(chambre.toString());
                writer.newLine();
            }
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
