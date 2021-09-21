package control;

import valueObject.OHwewon;
import valueObject.OLogin;
import dataAccessObject.DHwewonDeungrok;

public class CLogin {
	
	private DHwewonDeungrok dHwewonDeungrok;  
	
	public CLogin() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}
	
	public OHwewon validate(OLogin oLogin) {
		
		OHwewon oHwewon = this.dHwewonDeungrok.read(oLogin.getId());
		if(oHwewon != null) {
			if(oLogin.getPassword().contentEquals(oHwewon.getPassword())) {
				return oHwewon;
			}
		}
		
		return null;
	}
	
}
