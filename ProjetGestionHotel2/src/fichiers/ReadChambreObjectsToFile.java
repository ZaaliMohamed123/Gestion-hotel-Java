package fichiers;

import java.util.List;

import gestionHotel.Chambre;

public class ReadChambreObjectsToFile {
	
	public ReadChambreObjectsToFile(String filePath) {
		List<Chambre> chambreList = InitializeChambreObjectsToFile.intialiser(filePath);
		
		for (Chambre chambre : chambreList) {
            System.out.println(chambre);
        }
		
       
    }


    
    
}
