package windowsView;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


import control.CIndex;
import valueObject.OIndex;

public class VIndex extends JTable {

	private static final long serialVersionUID = 1L;
	
	private CIndex cIndex;
	private DefaultTableModel model;
	
	public VIndex() {
		super();		
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		this.setPreferredScrollableViewportSize(new Dimension(300,150));
		this.setVisible(true);
		
	}

	public String getData(String fileName) {
		
		Vector<String> col =new Vector<String>();
		col.addElement("아이디");
		col.addElement("이름");
		col.addElement("파일이름");
	
		this.model = new DefaultTableModel(col,0);
		
		this.model.setNumRows(0);   //initialize 
		
		this.cIndex = new CIndex();
		
		Vector<OIndex> oIndices = this.cIndex.getAll(fileName);
		for(OIndex oIndex : oIndices) {
			Vector<String> row = new Vector<String>();
			row.addElement(oIndex.getId());
			row.addElement(oIndex.getName());
			row.addElement(oIndex.getFileName());
			
			model.addRow(row);

		}

		this.setModel(model);
		this.updateUI();
		
		////////////////////////////////////////////////////		
		this.addMouseListener(new java.awt.event.MouseListener() {
			
			private VIndex vIndex;
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(e.getClickCount() < 2) {
					vIndex = (VIndex) e.getSource();
					int rowIndex = vIndex.getSelectedRow();
					Object value = vIndex.getValueAt(rowIndex, 2);
					String fileN = (String) value;		
					System.out.println(fileN);					
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
		String fileN = null;		
		Object value = this.getValueAt(1, 2);		
		fileN = (String) value;
			
		return fileN;    
		
	}			
}
	

