package control;

import valueObject.OHwewon;

import dataAccessObject.DHwewonDeungrok;

public class CHwewonDeungrok {
	
	private DHwewonDeungrok dHwewonDeungrok;   
	public CHwewonDeungrok() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}
	
	//회원 정보를 DHwewonDeungrok에 저장
	public void saveHwewon(OHwewon oHwewon) {		
		this.dHwewonDeungrok.save(oHwewon);		
	}	
	
	//특정한 아이디의 정보를 읽기 위함.
	public OHwewon readHwewon(String id) {
		OHwewon oHwewon = this.dHwewonDeungrok.read(id);
		return oHwewon;
	}
	
}
