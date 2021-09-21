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
			
        System.out.println("<<å���� �����ϱ⸦ ���Ѵٸ� (1)�����ϱ� (2)������û�������� �Ѿ��>>");
        int a2 = this.scanner.nextInt();
               
        if(a2 == 1) {	            	  
      	  deletWrite(fileName);	            	  	            	  
        }else {	            	  
          this.vSincheong.show(fileName);                   
          }		
	   }
		
///////////////////////////////�̸���� �����ϱ�/////////////////////////////////////////
	@SuppressWarnings("unlikely-arg-type")
	public Vector<OSugung> deletWrite(String fileName) {

		   Vector<OSugung> Sugung = this.cSugung.getAll(fileName);   //cSuJung�� ����
		   
		   for(OSugung lecture: Sugung) {    
			   System.out.println(
					   lecture.getId()
					   +" "+ lecture.getName()
			           +" "+ lecture.getProfessor()
			           +" "+ lecture.getCredit()
			           +" "+ lecture.getTime());
		   }
		   
		   System.out.println("<<�����Ϸ��� ������ Id�� �Է��Ͻÿ�.>>");
		   String id = this.scanner.next();		
		   
		try {
			//���� ���� �ʱ�ȭ
			BufferedWriter newfileName;
			newfileName = new BufferedWriter(new FileWriter(fileName));
			newfileName.close();
			
			//���� ����	  		   
		   for(OSugung lecture: Sugung) { 			   
			   if(lecture.getId().equals(id)) { 
				   Sugung.remove(lecture.getId()+" ");
				   Sugung.remove(lecture.getName()+" ");
				   Sugung.remove(lecture.getProfessor()+" ");
				   Sugung.remove(lecture.getCredit()+" ");
				   Sugung.remove(lecture.getTime()+"\n");
				   		
			   }else {
				   
			   //���� ���Ͽ� �ٽ� ���� 
			   this.dSugung.write(lecture, fileName);       //���� �����ϱ� 
		   }			   
		   }
		   
		   System.out.println("<<������ûȭ������ �Ѿ�ϴ�.>>");
		   this.vSincheong.show(fileName);

		} catch (IOException e) {
			e.printStackTrace();
		}		   
		 return null;	
	}

}
