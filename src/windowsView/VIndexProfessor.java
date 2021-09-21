package windowsView;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import control.CIndex;
import valueObject.OIndex;

public class VIndexProfessor extends JTable {

	private static final long serialVersionUID = 1L;

	//associations
	private CIndex cIndex;
	private DefaultTableModel model;
	
	public VIndexProfessor() {
        super();
        Vector<String> header = new Vector<String>();
        header.addElement("이름");
        header.addElement("파일이름");

        this.model= new DefaultTableModel(header,0);
        this.setModel(this.model);
        
        this.cIndex = new CIndex();
        
        
//        //attributes 
//		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
//		this.setPreferredScrollableViewportSize(new Dimension(150,100));  //table 사이즈 줄이기
//		
//		//components
//		this.model = (DefaultTableModel) this.getModel(); //원본데이터를 건들지 않고 table의 매개변수인 model에 있는 데이터를 변경합니다
//		model.addColumn("이름");			
//
//		//associations

	}
	
	public void initialize(String fileName) {
		this.model.setRowCount(0);
		
		Vector<OIndex> oIndices = this.cIndex.getAll(fileName);
		
		for(OIndex oIndex:oIndices) {
			Vector<String> row = new Vector<String>();
			row.add(oIndex.getName());
			row.add(oIndex.getFileName());
			
		}
		
		if(oIndices.size()>0) {
			this.getSelectionModel().addSelectionInterval(0,0);
		}
	}
	
	//초기화 - 프로그램을 돌렸을 때 초기화 시키는 코드를 분리해 놓은 것
//	public void initialize() {
//		 this.model.setNumRows(0);
//	}
//	
//	public String getData(String fileName) {	
//		
//		this.cIndex = new CIndex();		 
//		 Vector<OIndex> oIndices = this.cIndex.getAll(fileName);		 
//		 String[] row =new String[model.getColumnCount()];	
//		 
//		 for(OIndex oIndex: oIndices) {
//			 row[0] = oIndex.getFileName();
//			 model.addRow(row);		
//		 }		 		 
//		 this.updateUI();   //다시 그려라			 
//		 /////////////////////테이블완성//////////////////////////
//		 ListSelectionModel rowSelect = this.getSelectionModel();
//		 rowSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		 rowSelect.addListSelectionListener(new ListSelectionListener() {
//			 
//			private String newfileName;
//			private VIndex vIndex;
//
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				if(! rowSelect.isSelectionEmpty()) {
//					
//					ListSelectionModel lsm =(ListSelectionModel) e.getSource();	
//					int rowIndex =lsm.getMinSelectionIndex();  //테이블 행번호
//					JOptionPane.showMessageDialog(null, "선택한 열"+rowIndex);					
//					this.newfileName = row[rowIndex];
//					System.out.println(this.newfileName);
//    				this.vIndex.getNewfileName(this.newfileName);			
//    				
//				}				
//			}		 
//		 }); 			 
//		 return null;
//	}
//
//	public String getNewfileName(String fileName) {
//		return getNewfileName(fileName);
//	}
}




//String selected = null;
//if (oIndices.size() > 0) {       	 
//   this.getSelectionModel().addSelectionInterval(0, 0);
//   selected = oIndices.get(0).getFileName();
// 
//}
//	 
//	@Override
//	public void valueChanged(ListSelectionEvent e) {
//		int colIndex=0;
//		if(! rowSelect.isSelectionEmpty()) {
//			ListSelectionModel lsm =(ListSelectionModel) e.getSource();				
//			int rowIndex =lsm.getMinSelectionIndex();  //테이블 행번호
////			JOptionPane.showMessageDialog(null, lsm);
////			System.out.println(row[rowIndex][colIndex]);
//			
////			//GET SELECCTED ROW
////			String selected =null;
////			int selectedRow= rowSelect.getMinSelectionIndex();
////								
//		}
//		

//this.getSelectionModel().removeListSelectionListener(this.listSelectionHandler);
//String selected = null;
//if (oIndices.size() > 0) {       	 
//   this.getSelectionModel().addSelectionInterval(0, 0);
//   selected = oIndices.get(0).getFileName();
//   
//}
//this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
