package member;

/**
 * @date :2016. 6. 30.
 * @author :장종익
 * @file :MemberMain.java
 * @story :
 */
public class MemberMain {
	public static void main(String[] args) {
		MemberBean m = new MemberBean(); //생성자를 이용한 인스턴스 생성
		MemberBean m2 = new MemberBean(); //생성자를 이용한 인스턴스 생성
		
		try {
			MemberBean m3 =  (MemberBean) Class.forName("member.MemberBean").newInstance();		// 리플렉션
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m.setId("hong");
		m.setName("홍길동");
		m.setPw("1");
		
		m2.setId(m.getId());
		
		System.out.println(m.toString());
	}
}
