package windowsView;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import valueObject.OIndex;
import valueObject.OLecture;


public class VGangjwaProfessor extends JTable {

	private static final long serialVersionUID = 1L;

	//associations
	private CLecture cLecture;
	private DefaultTableModel model;

	//�������� �͵� 
	public VGangjwaProfessor() {
        super();
        //attributes - ���������� ���� ��ȭ���� �ʰ�, �����Ǵ� �Ӽ�
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		//table ������ ���̱� -scroll�����ε� Jtable�� hegiht�� ���̸� �ȴ�.
		this.setPreferredScrollableViewportSize(new Dimension(400,150));

		//components
		this.model = (DefaultTableModel) this.getModel();
		model.addColumn("���¸�");
		model.addColumn("�����");
		model.addColumn("�ð�");
		
		//associations
	}

	//�ʱ�ȭ - ���α׷��� ������ �� �ʱ�ȭ ��Ű�� �ڵ带 �и��� ���� ��
	public void initialize() {
		 this.model.setNumRows(0);
	}
		 
    public OLecture getData(String fileName) {		
		 this.cLecture = new CLecture();		 
		 Vector<OLecture> oLectures = this.cLecture.getAll(fileName);		 
		 
		 String[] row =new String[model.getColumnCount()];		 
		 
		 for(OLecture oLecture: oLectures) {
			 row[0] = oLecture.getName();
			 row[1] = oLecture.getProfessor();
			 row[2] = oLecture.getTime();
			 model.addRow(row);
		 }		 
		 this.updateUI();   //�ٽ� �׷���
		 return null;
	}
}


