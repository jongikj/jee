package member;

import java.util.List;

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
	
		int result = dao.insert(bean);
		
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
	public String update(MemberBean bean) {
		String result = "";
		if (dao.update(bean) == 1) {
			result = "수정 성공";
		} else {
			result = "수정 실패";
		}
		return result;
	}

	@Override
	public String delete(String id) {
		String result = "";
		if (dao.delete(id) == 1) {
			result = "삭제성공";
		} else {
			result = "삭제실패";
		}
		return result;
	}
	
	public int count(){
		return dao.count();
	}

	@Override
	public MemberBean findById(String findID) {
		return dao.findById(findID);
	}

	@Override
	public List<MemberBean> list() {
		return dao.list();
	}

	@Override
	public List<MemberBean> findByName(String findName) {
		return dao.findByName(findName);
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