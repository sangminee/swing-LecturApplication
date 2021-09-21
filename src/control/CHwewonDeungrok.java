package control;

import valueObject.OHwewon;

import dataAccessObject.DHwewonDeungrok;

public class CHwewonDeungrok {
	
	private DHwewonDeungrok dHwewonDeungrok;   
	public CHwewonDeungrok() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}
	
	//ȸ�� ������ DHwewonDeungrok�� ����
	public void saveHwewon(OHwewon oHwewon) {		
		this.dHwewonDeungrok.save(oHwewon);		
	}	
	
	//Ư���� ���̵��� ������ �б� ����.
	public OHwewon readHwewon(String id) {
		OHwewon oHwewon = this.dHwewonDeungrok.read(id);
		return oHwewon;
	}
	
}
