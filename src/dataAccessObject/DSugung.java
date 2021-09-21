package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import Model.MSugung;
import valueObject.OLecture;
import valueObject.OSugung;

public class DSugung {
	
	private MSugung mSugung;

	public DSugung() {
	}

	public Vector<OSugung> readAll(String fileName) {
		Vector<OSugung> Sugung = new Vector<OSugung>();   
		
		try {
			File Miri =new File(fileName);			
			Scanner scanner =new Scanner(Miri);  
			this.mSugung =new MSugung();
			
			while(this.mSugung.read(scanner)) {				
				OSugung oSugung = new OSugung(); 
				oSugung.set(this.mSugung);   
				Sugung.add(oSugung);        
			}		
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return Sugung;
	}
	
	// 1)미리담기 파일에 강좌 담기
	public String add(OLecture oLecture, String fileName) {		
		
		try { 		                           		
			FileWriter fileWriter = new FileWriter(fileName, true); 
			
			fileWriter.write(oLecture.getId()+" ");
			fileWriter.write(oLecture.getName()+" ");
			fileWriter.write(oLecture.getProfessor()+" ");
			fileWriter.write(oLecture.getCredit()+" ");
			fileWriter.write(oLecture.getTime()+" ");
			fileWriter.write("\n");
   
			fileWriter.close();     

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; 	
	}
	
	// 2)수정한 미리담기 파일 다시 쓰기
	public String write(OSugung lecture, String fileName) {
		try { 		                           		
			FileWriter fileWriter = new FileWriter(fileName,true); 
			
			fileWriter.write(lecture.getId()+" ");
			fileWriter.write(lecture.getName()+" ");
			fileWriter.write(lecture.getProfessor()+" ");
			fileWriter.write(lecture.getCredit()+" ");
			fileWriter.write(lecture.getTime()+" ");
			fileWriter.write("\n");
   
			fileWriter.close();     

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; 
		
	}

	// 3) 수강신청 파일에 강좌 담기
	public String update(OSugung lecture, String newFile) {
		try { 		                           		
			FileWriter fileWriter = new FileWriter(newFile, true); 
			
			fileWriter.write(lecture.getId()+" ");
			fileWriter.write(lecture.getName()+" ");
			fileWriter.write(lecture.getProfessor()+" ");
			fileWriter.write(lecture.getCredit()+" ");
			fileWriter.write(lecture.getTime()+" ");
			fileWriter.write("\n");
   
			fileWriter.close();     

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; 
		
	}

}
