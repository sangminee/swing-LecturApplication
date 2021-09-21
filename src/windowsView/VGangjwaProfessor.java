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

	//고정적인 것들 
	public VGangjwaProfessor() {
        super();
        //attributes - 구조적으로 전혀 변화되지 않고, 고정되는 속성
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		//table 사이즈 줄이기 -scroll때문인데 Jtable의 hegiht를 줄이면 된다.
		this.setPreferredScrollableViewportSize(new Dimension(400,150));

		//components
		this.model = (DefaultTableModel) this.getModel();
		model.addColumn("강좌명");
		model.addColumn("강사명");
		model.addColumn("시간");
		
		//associations
	}

	//초기화 - 프로그램을 돌렸을 때 초기화 시키는 코드를 분리해 놓은 것
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
		 this.updateUI();   //다시 그려라
		 return null;
	}
}


