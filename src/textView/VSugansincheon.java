package textView;

import java.io.File;
import java.util.Scanner;

import dataAccessObject.DSugung;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VSugansincheon {
	
	private Scanner scanner;

	private VIndex vCampus;           
	private VIndex vCollege;        
	private VIndex vDepartment;  
	
	private VLecture vLecture;      
	private VMiridamgi vMiridamgi;
	
	private DSugung dSugung;
	
	public VSugansincheon(Scanner scanner) {  
		this.scanner = scanner;
		this.vCampus =new VIndex(this.scanner);
		this.vCollege =new VIndex(this.scanner);
		this.vDepartment =new VIndex(this.scanner);
		this.vLecture =new VLecture(this.scanner);
		this.vMiridamgi =new VMiridamgi(this.scanner);
		this.dSugung =new DSugung();
	}

	public void show(OHwewon oHwewon) { 
	    System.out.println(oHwewon.getName()+"님 안녕하세요");
	    System.out.println("------------수강신청을 시작합니다-------------");
	      	    
		String campusFileName = this.vCampus.show("root","---------캠퍼스를");	
		if(campusFileName !=null) {
	       String collegeFileName = this.vCollege.show(campusFileName,"-----------대학을");	
	       if(collegeFileName !=null) {
	          String departmentFileName =this.vDepartment.show(collegeFileName,"------------학과를");
	          if(departmentFileName != null) {
	        	  
	        	  while(true) {
	              OLecture oLecture = this.vLecture.show(departmentFileName,"-----------강좌를");
	              //미리담기
	              String fileName ="user/"+oHwewon.getName();
				  File file = new File(fileName);
				  
	              if(file.exists()) {
	            	 System.out.println("파일존재"); 	  
	              }
	              
	              this.dSugung.add(oLecture,fileName);                 //add를 Dsusung에 만듬
	              
	              System.out.println("<<(1)강좌 계속 담기 (2)그만담기>>");
	              int a1 = this.scanner.nextInt();
	        	  	        	  
	              if(a1 == 2) {  
	            	  System.out.println("--------------책가방 그만담기-------------------");
	            	  this.vMiridamgi.show(fileName);            	  	              
	              }		              
	          }
	       }
		}

		}
	}
}
