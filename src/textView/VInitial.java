package textView;

import java.util.Scanner;

import valueObject.OHwewon;

public class VInitial {
	
       private Scanner scanner;                   
       private VHwewonDeungrok hwewonDeungrok;   
       private VLogin login;
       
       private VSugansincheon vSugansincheon;
  
       public VInitial(Scanner scanner) {                   
    	   this.scanner=scanner;                            
    	   this.hwewonDeungrok =new VHwewonDeungrok(this.scanner);  
    	   this.login =new VLogin(this.scanner);
       }
       
       public void show() {
    	   
    		System.out.println("---------------���� ����� ���� �ϼ���---------------");
    	    System.out.println("�α���(1), ȸ�����(2)");

			String input = this.scanner.next();
		
   	        if(input.equals("1")) {        
   	        	OHwewon oHwewon =this.login.show(); 
   	        	
   	        	if(oHwewon !=null) {     	    
   	        		
   	        		this.vSugansincheon = new VSugansincheon(this.scanner);  
   	        		this.vSugansincheon.show(oHwewon);   
   	        	}
   	        	  	        	
   	        } else if (input.equals("2")) {	        
   	        	
	          this.hwewonDeungrok.show();    
	          show();
	          
           } else {
    	    System.out.println("�߸� �Է��ϼ̽��ϴ�.�־��� ���ڸ� �Է��ϼ���.");
    	    show();
           }
    }
}



