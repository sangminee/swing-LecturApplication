package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Model.MHwewon;
import valueObject.OHwewon;

public class DHwewonDeungrok { 
	
	private MHwewon mHwewon;  

	public DHwewonDeungrok() {
	}
		
	public void save(OHwewon oHwewon) {
		try { 
		    File file = new File("hwewon");                      		
			FileWriter fileWriter = new FileWriter(file, true);    
			
			MHwewon mHwewon =new MHwewon();  			
			mHwewon.save(fileWriter, oHwewon);   
			fileWriter.close();                 
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	@SuppressWarnings("resource")
	public OHwewon read(String id) {
		try {
			File file =new File("hwewon");
			Scanner scanner =new Scanner(file);
			this.mHwewon =new MHwewon(); 
			
			while(mHwewon.read(scanner)) {
				if(this.mHwewon.getId().equals(id)) {
					OHwewon oHwewon = new OHwewon();
					oHwewon.set(this.mHwewon);   
					return oHwewon;
				}
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null; 	
	}
}

