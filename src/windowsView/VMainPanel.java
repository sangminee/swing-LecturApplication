package windowsView;

import javax.swing.JPanel;

import constants.Config.FVMainPanel;
import valueObject.OLogin;

public class VMainPanel extends JPanel {

	//attributes
	private static final long serialVersionUID = 1L;

	//component
	private VSugansincheongPanel vSugansincheong;
	
	public VMainPanel() {
		super(); 
		
		//attributes
		this.setBackground(FVMainPanel.background);  
		
		//components
		this.vSugansincheong = new VSugansincheongPanel();
		this.add(this.vSugansincheong);
	}

	public void initialize(OLogin oLogin) {
		this.vSugansincheong.initialize(oLogin); //자식초기화	
	}

}
