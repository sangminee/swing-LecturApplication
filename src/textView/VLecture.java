package textView;

import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import valueObject.OLecture;

public class VLecture {
	
	private Scanner scanner;
	private CLecture cLecture;

	public VLecture(Scanner scanner) {
		this.scanner =scanner;
		this.cLecture = new CLecture();
	}

	//강좌선택
	public OLecture show(String fileName, String message) {
		   System.out.println(message + "선택 하세요.");

		   Vector<OLecture> lectures = this.cLecture.getAll(fileName);
		   for(OLecture lecture: lectures) {    
			   System.out.println(
					   lecture.getId()
					   +" "+ lecture.getName()
			           +" "+ lecture.getProfessor()
			           +" "+ lecture.getCredit()
			           +" "+ lecture.getTime());
		   }

		   String id = this.scanner.next();
		   
		   for(OLecture lecture: lectures) {    			 
			   if(lecture.getId().equals(id)) {    
				   return lecture;   
			   }
		   }

		 return null;
	}

}
