/**
 * 
 */
package member;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * @date   :2016. 6. 16.
 * @author :장종익
 * @file   :Student.java
 * @story  :
*/
public class MemberBean {
	private String id, pw, name, regDate, gender, ssn, profileImg;
	private int birth;
	
	public MemberBean() {}
	
	public MemberBean(String name, String id, String pw, String ssn) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.ssn = ssn;
		this.gender = null;
		this.regDate = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
		String[] arr = new String[2];
		
		arr = ssn.split("-");

		if (Integer.parseInt(arr[1]) == 0 || Integer.parseInt(arr[1]) == 9) {
			JOptionPane.showMessageDialog(null, "뒷자리에 0이나 9는 올 수 없습니다.");
		}

		switch (Integer.parseInt(arr[1]) % 2) {
		case 1:
			this.gender = "남";
			break;
		default:
			this.gender = "여";
			break;
		}
	}
	
	public void setSsn(String ssn){
		this.ssn = ssn;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setRegDate() {
		this.regDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
	}
	
	public void setRegDate(String regDate){
		this.regDate = regDate;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}
	
	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getId() {
		return this.id;
	}
	
	public String getPw(){
		return this.pw;
	}

	public String getName() {
		return this.name;
	}

	public String getRegDate() {
		return this.regDate;
	}

	public String getGender() {
		return this.gender;
	}

	public String getSsn() {
		return this.ssn;
	}

	public int getBirth() {
		return this.birth;
	}

	@Override
	public String toString() {
		return "id=" + id + ", pw=" + pw + ", 이름=" + name + ", 등록일=" + regDate + ", 성별=" + gender
				+ ", 주민번호=" + ssn + ", 나이=" + birth;
	}
}