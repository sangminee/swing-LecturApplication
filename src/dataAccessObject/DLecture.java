package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import Model.MLecture;
import valueObject.OLecture;

public class DLecture {

	private MLecture mLecture;
	private static final String PATHNAME="data/";   

	public DLecture() {
	}

	public Vector<OLecture> readAll(String fileName) {
		Vector<OLecture> lectures = new Vector<OLecture>();   
		try {
			File file =new File(PATHNAME +fileName);
			Scanner scanner =new Scanner(file);   
			this.mLecture =new MLecture();
			
			while(this.mLecture.read(scanner)) {				
				OLecture oLecture = new OLecture(); 
				oLecture.set(this.mLecture);   
				lectures.add(oLecture);  
			}		
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lectures;
	}

}
