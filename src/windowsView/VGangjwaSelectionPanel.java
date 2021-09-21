package windowsView;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VGangjwaSelectionPanel extends JPanel {
	//attributes
	private static final long serialVersionUID = 1L;
	
	//component		
	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vHakgwa;
	private VGangjwa vGangjwa;
	
	public VGangjwaSelectionPanel() {  
		super();

		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
	    this.setLayout(boxLayout);
	    
		JScrollPane scrollpane;		
		
		JPanel IndexPanel = new JPanel();
		BoxLayout boxLayout1 = new BoxLayout(IndexPanel, BoxLayout.Y_AXIS);
		IndexPanel.setLayout(boxLayout1);
		
		   this.vCampus =new VIndex();
	   	   scrollpane=new JScrollPane(this.vCampus);
		    IndexPanel.add(scrollpane);
		
		   this.vCollege =new VIndex();
		   scrollpane=new JScrollPane(this.vCollege);
		   IndexPanel.add(scrollpane);
		
		   this.vHakgwa =new VIndex();
		   scrollpane=new JScrollPane(this.vHakgwa);
		   IndexPanel.add(scrollpane);
		
		this.add(IndexPanel);
		
		//°­ÁÂ¼±ÅÃ
		this.vGangjwa =new VGangjwa();
		scrollpane=new JScrollPane(this.vGangjwa);
		this.add(scrollpane);	
		
	}
	
	public void initialize(String fileName) {
		String CampusFileName = this.vCampus.getData(fileName);
		if(CampusFileName !=null) {
			String CollegeFileName =this.vCollege.getData(CampusFileName);
			if(CollegeFileName != null) {
				String HakgwaFileName =this.vHakgwa.getData(CollegeFileName);
				 if(HakgwaFileName  != null) {
					 this.vGangjwa.getData(HakgwaFileName);
				 }
			}
		}
	}		
}

