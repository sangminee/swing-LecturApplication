package Model;

import java.util.Scanner;

public class MLecture {
	private String id;        
	private String name;
	private String professor;
	private String credit;
	private String time;

	public MLecture() {
	
	}

	public boolean read(Scanner scanner) {			
		  if(scanner.hasNext()) {
     		this.id =scanner.next();
     		this.name =scanner.next();
			this.professor =scanner.next();
			this.credit =scanner.next();
			this.time =scanner.next();
			return true;       
		}
		return false;
	}

	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getProfessor() {return professor;}
	public void setProfessor(String professor) {this.professor = professor;}

	public String getCredit() {return credit;}
	public void setCredit(String credit) {this.credit = credit;}

	public String getTime() {return time;}
	public void setTime(String time) {this.time = time;}
		
}
		



