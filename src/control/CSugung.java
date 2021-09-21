package control;

import java.util.Vector;

import dataAccessObject.DSugung;
import valueObject.OSugung;

public class CSugung {

	private DSugung dSugung;
	public CSugung() {
		this.dSugung = new DSugung();
	}

	public Vector<OSugung> getAll(String fileName) {		
		Vector<OSugung> Sugung = this.dSugung.readAll(fileName); 
		return Sugung;
	}
	
	public Vector<OSugung> twogetAll(String newFile) {		
		Vector<OSugung> Sugung = this.dSugung.readAll(newFile); 
		return Sugung;

}
}
