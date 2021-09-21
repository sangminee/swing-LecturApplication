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
		super("ȸ�����");
		//attribute
		this.setLocation(FVMainFrame.location); 
		this.setSize(FVMainFrame.size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);//���α׷��� ��� �߰� �ϴ�
		this.setResizable(false); //������ �׻� �����ϰ� ����
		
		//component
		VRegisterPanel();
		
	}
	
	//component
	private void VRegisterPanel() {
		this.vRegisterPanel = new JPanel();
		this.add(this.vRegisterPanel);
		this.setContentPane(this.vRegisterPanel);
		this.vRegisterPanel.setLayout(null);	//layout �� ����� ����
		
		//Label(1) title
		JLabel title = new JLabel("ȸ������");  
		title.setBounds(580, 35, 100, 20);
		Font font = new Font("���� ���",Font.BOLD, 20);
		title.setFont(font);
		this.vRegisterPanel.add(title);
						
		//ȸ������
		JLabel label = new JLabel("ID(�й�)");
		this.IDcheckButton =new JButton("ID�ߺ�Ȯ��");
		this.IDcheckButton.setBounds(830,100,100,30);
		this.add(this.IDcheckButton);
		
		JLabel labelPW = new JLabel("��й�ȣ");
		JLabel labelPW2 = new JLabel("��й�ȣ ���Է�");
		JLabel labelName = new JLabel("�̸�");
		JLabel labelAdress = new JLabel("�ּ�");
		JLabel labelHawkgwa = new JLabel("�а�");
		
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
		
		//JPanel�� �߰�
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
		
		// button -ȸ������ 
		this.registerButton = new JButton("ȸ������");
		this.registerButton.setBounds(625,400,150,29);
		this.add(this.registerButton);
		event();
		}

	private void event() {
		//ID�ߺ� Ȯ�� ������ ��
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
								JOptionPane.showMessageDialog(null, "������ ���̵� �ֽ��ϴ�. �ٽ� �Է��ϼ���.");
							}
						}
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}			
		});
				
		//ȸ�����Թ�ư ������ �� 
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
					
					File newfile = new File("data/"+textfieldId.getText()+"�� �̸����");
					FileWriter fw = new FileWriter(newfile,true);
					fw.close();
					
					File newfile2 = new File("data/"+textfieldId.getText()+"�� ������û");
					FileWriter fw2 = new FileWriter(newfile2,true);
					fw2.close();
					JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.");			
					dispose();
						
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
											
			}
		});
			
	}
	
}
