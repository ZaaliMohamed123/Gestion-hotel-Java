package fichiers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import gestionHotel.*;

public class WriteClientObjectsToFile {
	
	public  WriteClientObjectsToFile(List<Client> clientList){
        String filePath = "Les Clients.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Client client : clientList) {
                writer.write(client.toString());
                writer.newLine();
            }
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
