package fichiers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gestionHotel.Client;

public class InitializeClientObjectsToFile {
	
	public static List<Client> initialiser(String filePath) {
        List<Client> clientList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                Client chambre = parseClientFromString(line);
                clientList.add(chambre);
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientList;
    }

	public static Client parseClientFromString(String line) {
        String[] parts = line.split(", ");
        
        
        String nom = parts[0].substring(parts[0].indexOf(':') + 1);
        String prenom = parts[1].substring(parts[1].indexOf(':') + 1);
        String CIN = parts[2].substring(parts[2].indexOf(':') + 1);
        String ville = parts[3].substring(parts[3].indexOf(':') + 1);
        String pays = parts[4].substring(parts[4].indexOf(':') + 1, parts[4].indexOf("]"));

        return new Client( nom, prenom,CIN , ville, pays);
    }
}
