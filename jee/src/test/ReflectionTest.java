package test;

import member.MemberBean;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :ReflectionTest.java
 * @story  :
*/
public class ReflectionTest {
	public static void main(String[] args) {
//		MemberBean mem = new MemberBean();
//		Class klass = null;
		
		try {
			MemberBean mem = (MemberBean) Class.forName("member.MemberBean").newInstance();
			mem.setId("hong");
			mem.setName("홍길동");
			mem.setPw("1");
			System.out.println(mem.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}