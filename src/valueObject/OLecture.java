package valueObject;

import Model.MLecture;

public class OLecture {
	
	private String id;       
	private String name;
	private String professor;
	private String credit;
	private String time;

	public void set(MLecture mLecture) {
		this.id =mLecture.getId();
		this.name =mLecture.getName();
		this.professor=mLecture.getProfessor();
		this.credit=mLecture.getCredit();
		this.time=mLecture.getTime();
	}
	
	public String getProfessor() {return professor;}
	public void setProfessor(String professor) {this.professor = professor;}

	public String getTime() {return time;}
	public void setTime(String time) {this.time = time;}
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	public String getCredit() {return credit;}
	public void setCredit(String credit) {this.credit = credit;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
}
