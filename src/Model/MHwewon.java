package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.OHwewon;

public class MHwewon {
	
	private String id;
	private String password;
	private String name;
	private String address;
	private String hwakgwa;

	
	public boolean read(Scanner scanner) {				
		if(scanner.hasNext()) {
			this.id =scanner.next();
			this.password =scanner.next();
			this.name =scanner.next();
			this.address =scanner.next();
			this.hwakgwa =scanner.next();
			return true;       
		}
		return false;
	}
	
	public void save(FileWriter fileWriter, OHwewon oHwewon) {		
		this.set(oHwewon);  
		
		try {                                 
			fileWriter.write(id);      
			fileWriter.write("\n");
			fileWriter.write(password);
			fileWriter.write("\n");
			fileWriter.write(name);
			fileWriter.write("\n");
			fileWriter.write(address);
			fileWriter.write("\n");
			fileWriter.write(hwakgwa);
			fileWriter.write("\n");

		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
		
	private void set(OHwewon oHwewon) {  
		this.id =oHwewon.getId();
		this.password =oHwewon.getPassword();
		this.name =oHwewon.getName();
		this.address =oHwewon.getAddress();
		this.hwakgwa =oHwewon.getHwakgwa();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHwakgwa() {
		return hwakgwa;
	}
	public void setHwakgwa(String hwakgwa) {
		this.hwakgwa = hwakgwa;
	}

}


