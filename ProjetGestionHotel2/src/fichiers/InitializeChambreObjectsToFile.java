package fichiers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gestionHotel.Chambre;

public class InitializeChambreObjectsToFile {

 
	public static List<Chambre> intialiser(String filePath) {
        List<Chambre> chambreList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                Chambre chambre = parseChambreFromString(line);
                chambreList.add(chambre);
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chambreList;
    }

    private static Chambre parseChambreFromString(String line) {
        
        String[] parts = line.split(", ");
        int numChambre = Integer.parseInt(parts[0].substring(parts[0].indexOf(':') + 1));
        String type = parts[1].substring(parts[1].indexOf(':') + 1);
        String etat = parts[2].substring(parts[2].indexOf(':') + 1);
        int nombreLits = Integer.parseInt(parts[3].substring(parts[3].indexOf(':') + 1));
        double prix = Double.parseDouble(parts[4].substring(parts[4].indexOf(':') + 1, parts[4].indexOf(" DH")));

        return new Chambre(numChambre, type, etat, nombreLits, prix);
    }

    
    
}
