package windowsView;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import valueObject.OLecture;

public class VGangjwa extends JTable {

	private static final long serialVersionUID = 1L;
	
	private CLecture cLecture;
	private DefaultTableModel model;

	public VGangjwa() {
		super();		
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		this.setPreferredScrollableViewportSize(new Dimension(300,150));
		this.setVisible(true);
	}
	
	public String getData(String fileName) {
		Vector<String> col =new Vector<String>();
		col.addElement("아이디");
		col.addElement("강좌명");
		col.addElement("교수명");
		col.addElement("학점수");
		col.addElement("시간");
		
		this.model = new DefaultTableModel(col,0);
		
		this.model.setNumRows(0);   //initialize 
		
		this.cLecture = new CLecture();
		
		Vector<OLecture> oLectures = this.cLecture.getAll(fileName);
		for(OLecture oLecture : oLectures) {
			Vector<String> row = new Vector<String>();
			row.addElement(oLecture.getId());
			row.addElement(oLecture.getName());
			row.addElement(oLecture.getProfessor());
			row.addElement(oLecture.getCredit());
			row.addElement(oLecture.getTime());
			
			model.addRow(row);

		}
		this.setModel(model);
		this.updateUI();
		
		//////////////////////////////////////////////////////////////
		this.addMouseListener(new java.awt.event.MouseListener() {
			
			private VGangjwa vG;
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(e.getClickCount() < 2) {
					vG = (VGangjwa) e.getSource();
					 int row = vG.getSelectedRow();
//					  int col = vG.getSelectedColumn();
					  for (int i = 0; i < vG.getColumnCount(); i++) {
					   System.out.print(vG.getModel().getValueAt(row,i)+" "); 
					  }
					  System.out.print("\n");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//////////////////////////////////////////////////////////	
		
		return null;
		
	}

}
