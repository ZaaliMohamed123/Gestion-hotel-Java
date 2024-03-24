package fichiers;


import java.util.List;

import gestionHotel.*;

public class ReadClientObjectsToFile {
	
	public ReadClientObjectsToFile(String filePath) {
		List<Client> clientList = InitializeClientObjectsToFile.initialiser(filePath);

		for (Client client : clientList) {
            System.out.println(client);
        }
		
        
    }
 
	
}
