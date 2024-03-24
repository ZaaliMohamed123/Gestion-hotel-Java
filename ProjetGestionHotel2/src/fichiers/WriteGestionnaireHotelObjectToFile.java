package fichiers;

import java.io.*;

import java.util.List;


import gestionHotel.*;

public class WriteGestionnaireHotelObjectToFile {
	
	public static void WriteToFile(List<GestionnaireHotel> gs) throws Exception {
		String filePath = "Les Gestionnaires d'hotel.txt";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
        	for(GestionnaireHotel g : gs) {
        		writer.write(g.toString());
        		writer.newLine();
        	}
        	writer.close();
        	
        }catch(Exception e) {
        	e.printStackTrace();
        	
        }
	}

	
	
	
}

