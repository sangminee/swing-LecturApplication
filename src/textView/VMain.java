package textView;

import java.util.Scanner;

public class VMain {
	
	@SuppressWarnings("unused")
	private Scanner scanner;	
	private VInitial initial;       
	
	public VMain(Scanner scanner) {
		this.scanner =scanner;	                     
		this.initial =new VInitial(scanner);      
	}

	public void run() {
		System.out.println("LMain::run()");
		this.initial.show();		
	}

	public static void main(String[] args) {   
		Scanner scanner = new Scanner(System.in); 
		VMain main = new VMain(scanner);    
		main.run();
		scanner.close();  

	}

}
