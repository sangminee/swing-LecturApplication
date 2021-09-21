package textView;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import control.CSugung;
import dataAccessObject.DSugung;
import valueObject.OSugung;

public class VMiridamgi {
	
	private Scanner scanner;
	private DSugung dSugung;
	private CSugung cSugung;
	
	private VLectureSincheong vSincheong;
	
	public VMiridamgi(Scanner scanner) {
		this.scanner =scanner;
		this.dSugung = new DSugung();
		this.cSugung = new CSugung();
		this.vSincheong =new VLectureSincheong(this.scanner);
	}
	
	public void show(String fileName) {      	
			
        System.out.println("<<책가방 수정하기를 원한다면 (1)수정하기 (2)수강신청페이지로 넘어가기>>");
        int a2 = this.scanner.nextInt();
               
        if(a2 == 1) {	            	  
      	  deletWrite(fileName);	            	  	            	  
        }else {	            	  
          this.vSincheong.show(fileName);                   
          }		
	   }
		
///////////////////////////////미리담기 수정하기/////////////////////////////////////////
	@SuppressWarnings("unlikely-arg-type")
	public Vector<OSugung> deletWrite(String fileName) {

		   Vector<OSugung> Sugung = this.cSugung.getAll(fileName);   //cSuJung과 연결
		   
		   for(OSugung lecture: Sugung) {    
			   System.out.println(
					   lecture.getId()
					   +" "+ lecture.getName()
			           +" "+ lecture.getProfessor()
			           +" "+ lecture.getCredit()
			           +" "+ lecture.getTime());
		   }
		   
		   System.out.println("<<삭제하려는 강좌의 Id를 입력하시오.>>");
		   String id = this.scanner.next();		
		   
		try {
			//기존 파일 초기화
			BufferedWriter newfileName;
			newfileName = new BufferedWriter(new FileWriter(fileName));
			newfileName.close();
			
			//강의 삭제	  		   
		   for(OSugung lecture: Sugung) { 			   
			   if(lecture.getId().equals(id)) { 
				   Sugung.remove(lecture.getId()+" ");
				   Sugung.remove(lecture.getName()+" ");
				   Sugung.remove(lecture.getProfessor()+" ");
				   Sugung.remove(lecture.getCredit()+" ");
				   Sugung.remove(lecture.getTime()+"\n");
				   		
			   }else {
				   
			   //기존 파일에 다시 쓰기 
			   this.dSugung.write(lecture, fileName);       //여기 수정하기 
		   }			   
		   }
		   
		   System.out.println("<<수강신청화면으로 넘어갑니다.>>");
		   this.vSincheong.show(fileName);

		} catch (IOException e) {
			e.printStackTrace();
		}		   
		 return null;	
	}

}
