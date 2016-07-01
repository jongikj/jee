package member;


/**
 * @date   :2016. 6. 20.
 * @author :장종익
 * @file   :StudentServiceImpl.java
 * @story  :
*/
public class MemberServiceImpl implements MemberService{
	MemberBean st = null;
	MemberDAO dao = MemberDAO.getInstance();	// 4.DAO의 getInstance() 메소드를 호출한다 (싱글톤 패턴)
	private static MemberServiceImpl instance = new MemberServiceImpl();
	
	private MemberServiceImpl() {
	}
	
	public static MemberServiceImpl getInstance() {
		return instance;
	}

	@Override
	public String regist(MemberBean bean) {
		String msg = "";
		String sql = "insert into member(id, pw, name, reg_date, ssn)"
				+ "values('" + bean.getId() + "', '" + bean.getPw() + "', '" + bean.getName() + "', '"
				+ bean.getRegDate() + "', '" + bean.getSsn() + "')";
		int result = dao.exeUpdate(sql);
		
		if (result == 1 ){
			msg = "회원가입 축하합니다";
		} else {
			msg = "회원가입 실패";
		}
		return msg;
	}

	@Override
	public String show() {
		return st.toString();
	}

	@Override
	public void update(String pw) {
		st.setPw(pw);
	}

	@Override
	public void delete() {
		st = null;
	}

}
/*
String sqlCreate = "create table member("
		+ "id varchar2(20) primary key,"
		+ "pw varchar2(20),"
		+ "name varchar2(20),"
		+ "reg_date varchar2(20),"
		+ "ssn varchar2(10),"
		+ ")";
String sqlDrop = "drop table member";
 										*/