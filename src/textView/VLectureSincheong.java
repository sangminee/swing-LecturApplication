package textView;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

import control.CSugung;
import dataAccessObject.DSugung;
import valueObject.OSugung;

public class VLectureSincheong {
	
	private Scanner scanner;
	private DSugung dSugung;
	private CSugung cSugung;

	public VLectureSincheong(Scanner scanner) {
		this.scanner =scanner;
		this.dSugung = new DSugung();
		this.cSugung = new CSugung();
	}

	public void show(String fileName) {
		   Vector<OSugung> Sugung = this.cSugung.getAll(fileName);   //cSuJung과 연결

		   String newFile =fileName+"_수강신청";
		   File file = new File(newFile);
		   if(file.exists()) {
          	 System.out.println("파일존재"); 	  
            }
		   
		   System.out.println("----------------미리담기한 강좌들------------------");
		   for(OSugung lecture: Sugung) {    
			   System.out.println(
					   lecture.getId()
					   +" "+ lecture.getName()
			           +" "+ lecture.getProfessor()
			           +" "+ lecture.getCredit()
			           +" "+ lecture.getTime());
		   }
		   
		   System.out.println("-----------미리담기에 담은 강좌 중 원하는 강좌 수강신청하기---------------");
		   
		   while(true) {
			   String id =this.scanner.next();
			   for(OSugung lecture: Sugung) {
				   if(lecture.getId().equals(id)) {
					   this.dSugung.update(lecture,newFile);       //벡터에서 읽은 값을 새로운 수강신청강좌에 첨가 
					   System.out.println("<<(1) 강좌 더 담기 (2) 그만담기>>");
					   int aa =this.scanner.nextInt();
					   
					   if(aa == 2) {
						   System.out.println("--------------------수강신청한 강좌들-------------------");
						   
	                       Vector<OSugung> endSugung = this.cSugung.getAll(newFile);
	                       
		                    for(OSugung endlecture: endSugung) {    
			                  System.out.println(
					                       endlecture.getId()
					                      +" "+ endlecture.getName()
			                             +" "+ endlecture.getProfessor()
			                             +" "+ endlecture.getCredit()
			                             +" "+ endlecture.getTime());
		                         }		                  
					   }		   
				   }
			   }
		   }
	}

}
