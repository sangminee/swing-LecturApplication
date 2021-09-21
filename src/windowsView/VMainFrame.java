package windowsView;

import javax.swing.JFrame;

import constants.Config.FVMainFrame;
import valueObject.OLogin;

public class VMainFrame extends JFrame { 
	
	//attributes
	private static final long serialVersionUID = 1L;

	//components 
	private VMainPanel vMainPanel;   
	
	public VMainFrame()  { 	
		
		super("수강신청"); 
		//attributes 
        this.setLocation(FVMainFrame.location); 
		this.setSize(FVMainFrame.size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프로그램이 중단되면 그만해라
		
		//component 	
		this.vMainPanel= new VMainPanel();
		this.add(this.vMainPanel);     
	}

	private void initialize(OLogin oLogin) {
		//variable attributes
		
		//components initialize
		this.vMainPanel.initialize(oLogin);  	
	}

	
	public static void main(OLogin oLogin) {   
		VMainFrame vMain = new VMainFrame(); 
		vMain.initialize(oLogin); 
		vMain.setVisible(true); 
	}

}
