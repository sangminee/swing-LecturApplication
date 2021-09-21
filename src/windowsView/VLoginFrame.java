package windowsView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import constants.Config.FVMainFrame;
import valueObject.OLogin;

public class VLoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel vLoginPanel;
	
	private JTextField fieldId;
	private JPasswordField fieldPass;	
	private JButton loginButton;
	private JButton registerButton;
	
	@SuppressWarnings("unused")
	private VRegisterFrame vRegisterFrame;
	@SuppressWarnings("unused")
	private VMainFrame vMainFrame;

	public static void main(String[] args) {   
		VLoginFrame vLoginFrame = new VLoginFrame(); 
		vLoginFrame.setVisible(true); 		
	}

	public VLoginFrame()  { 
		super("�α���");	
		
		//attributes
		this.setLocation(FVMainFrame.location); 
		this.setSize(FVMainFrame.size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);//���α׷��� ��� �߰� �ϴ�
		this.setResizable(false); //������ �׻� �����ϰ� ����		
		//component
		VLoginPanel();
	}

	//component			
	private void VLoginPanel() {
		this.vLoginPanel = new JPanel();      
		this.add(this.vLoginPanel);
		this.vLoginPanel.setLayout(null);  //layout �� ����� ����
		
		// Label(1) title
		JLabel title = new JLabel("�α���");
		title.setBounds(580, 35, 100, 20);
		Font font = new Font("���� ���",Font.BOLD, 20);
		title.setFont(font);
		this.vLoginPanel.add(title);
			
		// Label(2) ID, Password
		JLabel id = new JLabel("ID  ");
		JLabel pw = new JLabel("Password  ");		
		fieldId = new JTextField(10);
		fieldPass = new JPasswordField(10);	
		
		id.setBounds(430, 100, 100, 20);
		pw.setBounds(430, 150, 100, 20);	
		fieldId.setBounds(600, 100, 200, 35);
		fieldPass.setBounds(600, 150, 200, 35);
		
		// button -�α���, ȸ������ 
		loginButton = new JButton("�α���");
		registerButton = new JButton("ȸ������");
		
		loginButton.setBounds(600, 200, 90, 29);
		registerButton.setBounds(700, 200, 90, 29);
		
		//�߰�
		this.vLoginPanel.add(id);
		this.vLoginPanel.add(fieldId);
		this.vLoginPanel.add(pw);
		this.vLoginPanel.add(fieldPass);
		this.vLoginPanel.add(loginButton);
		this.vLoginPanel.add(registerButton);			
		event();
		}
	
	public void event() {
		//ȸ������ ��ư ������ ��
		registerButton.addActionListener(new ActionListener() {
					
					@SuppressWarnings("unused")
					private VRegisterFrame vHewonDeoungrok;

					@Override
					public void actionPerformed(ActionEvent e) {
						vHewonDeoungrok = new VRegisterFrame();
						VRegisterFrame.main(null);
					}
				});

		//�α��� ��ư ������ ��
		loginButton.addActionListener( new ActionListener() {  
			
		private VMainFrame vMainFrame;
		private String id;
		private String pass;
		@SuppressWarnings("unused")
		private String name;
		@SuppressWarnings("unused")
		private String adress;
		@SuppressWarnings("unused")
		private String hawkgwa;
	
		private Scanner scanner;		
				
		@SuppressWarnings({ "static-access", "deprecation" })
		public void actionPerformed(ActionEvent e) {	
			try {
				File file = new File("window-Hewon");			
				this.scanner = new Scanner(file);
				Vector<String> check = new Vector<String>();
				
				if(scanner.hasNext()) {  //�̰��� ù��°�� �ι�° �ٿ� �ִ� ���� �д� �����̴�.
					while(true) {
						
						this.id =scanner.next();
				        this.pass=scanner.next();
						this.name=scanner.next();
				        this.adress=scanner.next();
				        this.hawkgwa=scanner.next(); 
				        
				        check.add(this.id);
				        check.add(this.pass);
				        check.add("\n");
				        
				        if(this.id.equals(fieldId.getText()) && this.pass.equals(fieldPass.getText())) {				        					        	
				        	break;	   
				        }				        
				       }  
				}
				System.out.println(check);
				
				if(this.id.equals(fieldId.getText()) && this.pass.equals(fieldPass.getText())) {
	            	   
	            	   OLogin oLogin =new OLogin();
	            	   oLogin.setId(fieldId.getText());
	            	   oLogin.setPassword(fieldPass.getText());
	            	   
	            	   this.vMainFrame= new VMainFrame();
	            	   this.vMainFrame.main(oLogin);
	            	   dispose();
				}
				
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog( null , "�α��� ����");
//				vLoginFrame.main(null);
			}
               
            }
    } );		
	
	}
	}

