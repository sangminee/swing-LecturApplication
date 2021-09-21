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
	    System.out.println(oHwewon.getName()+"�� �ȳ��ϼ���");
	    System.out.println("------------������û�� �����մϴ�-------------");
	      	    
		String campusFileName = this.vCampus.show("root","---------ķ�۽���");	
		if(campusFileName !=null) {
	       String collegeFileName = this.vCollege.show(campusFileName,"-----------������");	
	       if(collegeFileName !=null) {
	          String departmentFileName =this.vDepartment.show(collegeFileName,"------------�а���");
	          if(departmentFileName != null) {
	        	  
	        	  while(true) {
	              OLecture oLecture = this.vLecture.show(departmentFileName,"-----------���¸�");
	              //�̸����
	              String fileName ="user/"+oHwewon.getName();
				  File file = new File(fileName);
				  
	              if(file.exists()) {
	            	 System.out.println("��������"); 	  
	              }
	              
	              this.dSugung.add(oLecture,fileName);                 //add�� Dsusung�� ����
	              
	              System.out.println("<<(1)���� ��� ��� (2)�׸����>>");
	              int a1 = this.scanner.nextInt();
	        	  	        	  
	              if(a1 == 2) {  
	            	  System.out.println("--------------å���� �׸����-------------------");
	            	  this.vMiridamgi.show(fileName);            	  	              
	              }		              
	          }
	       }
		}

		}
	}
}
