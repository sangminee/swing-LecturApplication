package valueObject;

import Model.MIndex;

public class OIndex {
	
	//구조를 정확하게 아는 것이 중요	
	private String id;        //=>무조건 비밀 =>stters getter사용 =>public 사용 x 
	private String name;
	private String fileName;
	

	public void set(MIndex mIndex) {  
		this.id =mIndex.getId();
		this.name =mIndex.getName();
		this.fileName=mIndex.getFileName();
	}

	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getFileName() {return fileName;}
	public void setFileName(String fileName) {this.fileName = fileName;}
	
}
