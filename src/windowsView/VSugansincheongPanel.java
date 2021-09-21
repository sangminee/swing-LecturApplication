package windowsView;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import valueObject.OLogin;

public class VSugansincheongPanel extends JPanel {
	//attributes
	private static final long serialVersionUID = 1L;

	//component
	private VGangjwaSelectionPanel vGangwaSelectionPanel; //JPanel
	private VGangjwa vMiridamgi;  
	private VGangjwa vSincheong;  
	
	public VSugansincheongPanel() {
		super();
		//attributes
		
		//components
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);  
		
		this.vGangwaSelectionPanel= new VGangjwaSelectionPanel();
		this.add(this.vGangwaSelectionPanel,BorderLayout.WEST);
		
		JPanel miriSincheongPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(miriSincheongPanel, BoxLayout.Y_AXIS);
		miriSincheongPanel.setLayout(boxLayout);
		
		
		    JScrollPane scrollPane;
		    this.vMiridamgi= new VGangjwa();
		    scrollPane = new JScrollPane(this.vMiridamgi);
		    miriSincheongPanel.add(scrollPane);		
		    JButton button =new JButton("미리담기");
		    miriSincheongPanel.add(button); //버튼
		
		    this.vSincheong= new VGangjwa();
		    scrollPane = new JScrollPane(this.vSincheong); 
		    miriSincheongPanel.add(scrollPane);		    
		    
		    
		this.add(miriSincheongPanel,BorderLayout.EAST);
	}
	
	public void initialize(OLogin oLogin) {
		this.vGangwaSelectionPanel.initialize("root");	

		this.vMiridamgi.getData(oLogin.getId()+"의 미리담기");
		this.vSincheong.getData(oLogin.getId()+"의 수강신청");

	}
	
}
