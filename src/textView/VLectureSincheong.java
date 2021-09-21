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
		   Vector<OSugung> Sugung = this.cSugung.getAll(fileName);   //cSuJung�� ����

		   String newFile =fileName+"_������û";
		   File file = new File(newFile);
		   if(file.exists()) {
          	 System.out.println("��������"); 	  
            }
		   
		   System.out.println("----------------�̸������ ���µ�------------------");
		   for(OSugung lecture: Sugung) {    
			   System.out.println(
					   lecture.getId()
					   +" "+ lecture.getName()
			           +" "+ lecture.getProfessor()
			           +" "+ lecture.getCredit()
			           +" "+ lecture.getTime());
		   }
		   
		   System.out.println("-----------�̸���⿡ ���� ���� �� ���ϴ� ���� ������û�ϱ�---------------");
		   
		   while(true) {
			   String id =this.scanner.next();
			   for(OSugung lecture: Sugung) {
				   if(lecture.getId().equals(id)) {
					   this.dSugung.update(lecture,newFile);       //���Ϳ��� ���� ���� ���ο� ������û���¿� ÷�� 
					   System.out.println("<<(1) ���� �� ��� (2) �׸����>>");
					   int aa =this.scanner.nextInt();
					   
					   if(aa == 2) {
						   System.out.println("--------------------������û�� ���µ�-------------------");
						   
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
