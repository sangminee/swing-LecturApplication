package windowsView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

public class VRegisterFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel vRegisterPanel;
		
	private JTextField textfieldId;
	private JPasswordField Pw1;
	private JPasswordField Pw2;
	private JTextField textfieldName;
	private JTextField textfieldAdress;
	private JTextField textfieldHawkgwa;
	private JButton registerButton;
	private JButton IDcheckButton;
	
	public static void main(String[] args){;
	VRegisterFrame vHewonDeoungrok = new VRegisterFrame(); 
	vHewonDeoungrok.setVisible(true); 
	   }

	public VRegisterFrame() {
		super("회원등록");
		//attribute
		this.setLocation(FVMainFrame.location); 
		this.setSize(FVMainFrame.size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);//프로그램이 가운데 뜨게 하는
		this.setResizable(false); //사이즈 항상 일정하게 고정
		
		//component
		VRegisterPanel();
		
	}
	
	//component
	private void VRegisterPanel() {
		this.vRegisterPanel = new JPanel();
		this.add(this.vRegisterPanel);
		this.setContentPane(this.vRegisterPanel);
		this.vRegisterPanel.setLayout(null);	//layout 내 맘대로 조정
		
		//Label(1) title
		JLabel title = new JLabel("회원가입");  
		title.setBounds(580, 35, 100, 20);
		Font font = new Font("맑은 고딕",Font.BOLD, 20);
		title.setFont(font);
		this.vRegisterPanel.add(title);
						
		//회원가입
		JLabel label = new JLabel("ID(학번)");
		this.IDcheckButton =new JButton("ID중복확인");
		this.IDcheckButton.setBounds(830,100,100,30);
		this.add(this.IDcheckButton);
		
		JLabel labelPW = new JLabel("비밀번호");
		JLabel labelPW2 = new JLabel("비밀번호 재입력");
		JLabel labelName = new JLabel("이름");
		JLabel labelAdress = new JLabel("주소");
		JLabel labelHawkgwa = new JLabel("학과");
		
		textfieldId = new JTextField(10);
		Pw1 = new JPasswordField(10);
		Pw2 = new JPasswordField(10);
		textfieldName = new JTextField(10);
		textfieldAdress = new JTextField(20);
		textfieldHawkgwa = new JTextField(20);
		
		label.setBounds(430, 100, 100, 20);		
		labelPW.setBounds(430, 150, 100, 20);
		labelPW2.setBounds(430, 200, 100, 20);
		labelName.setBounds(430, 250, 100, 20);
		labelAdress.setBounds(430, 300, 100, 20);	
		labelHawkgwa.setBounds(430, 350, 100, 20);
				
		textfieldId.setBounds(600, 100, 200, 35);						
		Pw1.setBounds(600, 150, 200, 35);
		Pw2.setBounds(600, 200, 200, 35);				
		textfieldName.setBounds(600, 250, 200, 35);				
		textfieldAdress.setBounds(600, 300, 200, 35);
		textfieldHawkgwa.setBounds(600, 350, 200, 35);
		
		//JPanel에 추가
		this.vRegisterPanel.add(label);
		this.vRegisterPanel.add(labelPW);
		this.vRegisterPanel.add(labelPW2);
		this.vRegisterPanel.add(labelName);
		this.vRegisterPanel.add(labelAdress);
		this.vRegisterPanel.add(labelHawkgwa);
		
		this.vRegisterPanel.add(textfieldId);
		this.vRegisterPanel.add(Pw1);
		this.vRegisterPanel.add(Pw2);
		this.vRegisterPanel.add(textfieldName);
		this.vRegisterPanel.add(textfieldAdress);
		this.vRegisterPanel.add(textfieldHawkgwa);
		
		// button -회원가입 
		this.registerButton = new JButton("회원가입");
		this.registerButton.setBounds(625,400,150,29);
		this.add(this.registerButton);
		event();
		}

	private void event() {
		//ID중복 확인 눌렀을 때
		this.IDcheckButton.addActionListener(new ActionListener() {

			private String id;
			@SuppressWarnings("unused")
			private String pass;
			@SuppressWarnings("unused")
			private String name;
			@SuppressWarnings("unused")
			private String adress;
			@SuppressWarnings("unused")
			private String hawkgwa;

			private Scanner scanner;
			
			public boolean read(Scanner scanner) {			
				  if(scanner.hasNext()) {
		     		this.id =scanner.next();
		     		this.pass =scanner.next();
		     		this.name =scanner.next();
					this.adress =scanner.next();	
					this.hawkgwa =scanner.next();
					return true;       
				}
				return false;
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {				
					File file = new File("window-Hewon");
					
					Vector<String> check = new Vector<String>();
					
					try {
						scanner = new Scanner(file);						
						while(read(scanner)) {
							check.add(this.id);
						}
						
						scanner.close();

						for(String checkID:check) {
							if(checkID.equals(textfieldId.getText())) {
								JOptionPane.showMessageDialog(null, "동일한 아이디가 있습니다. 다시 입력하세요.");
							}
						}
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}			
		});
				
		//회원가입버튼 눌렀을 때 
		this.registerButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {										
					BufferedWriter file = new BufferedWriter(new FileWriter("window-Hewon",true));
					file.write(textfieldId.getText()+"\n");
					file.write(Pw1.getText()+"\n");
					file.write(textfieldName.getText()+"\n");
					file.write(textfieldAdress.getText()+"\n");
					file.write(textfieldHawkgwa.getText()+"\n");
					file.close();
					
					File newfile = new File("data/"+textfieldId.getText()+"의 미리담기");
					FileWriter fw = new FileWriter(newfile,true);
					fw.close();
					
					File newfile2 = new File("data/"+textfieldId.getText()+"의 수강신청");
					FileWriter fw2 = new FileWriter(newfile2,true);
					fw2.close();
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");			
					dispose();
						
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
											
			}
		});
			
	}
	
}
