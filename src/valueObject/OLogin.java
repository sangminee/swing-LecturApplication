package valueObject;

public class OLogin {
	
	//구조를 정확하게 아는 것이 중요	
	private String id;        //=>무조건 비밀 =>stters getter사용 =>public 사용 x 
	private String password;	

	public OLogin() {
		
	}
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

}
