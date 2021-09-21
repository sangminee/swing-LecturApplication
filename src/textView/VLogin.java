package textView;

import java.util.Scanner;

import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class VLogin {
	
	private Scanner scanner;             
	private CLogin cLogin;  

	public VLogin(Scanner scanner) {     
		this.scanner=scanner;
		this.cLogin = new CLogin();
	}
	
	public OHwewon show() {  

    	System.out.println("--------------아이디와 비밀번호를 입력하세요---------------");   	
    	OLogin oLogin =new OLogin();
    	
    	
		System.out.print("ID(학번): "); 
		String id = scanner.next();
		oLogin.setId(id);
		
		System.out.print("비밀번호: "); 
		String password = scanner.next();
		oLogin.setPassword(password);
		
		//수강신청화면으로 들어가면 실행됨
  	    OHwewon oHwewon = this.cLogin.validate(oLogin);
  	    if(oHwewon !=null) { 	    	
  	    	return oHwewon;  	    	
  	    }else {
  	    	System.out.print("아이디와 비밀번호가 올바르지 않습니다.");
  	    	System.out.println("");
  	    	show();
  	    	return null;
  	    }
  	    
	}

}
