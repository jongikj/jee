package test;

import bank.AccountBean;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :ReflectionTest.java
 * @story  :
*/
public class ReflectionTest2 {
	public static void main(String[] args) {
		try {
			AccountBean acc = (AccountBean) Class.forName("bank.AccountBean").newInstance();
			acc.setAccountNo(123456);
			acc.setId("HONG");
			acc.setMoney(4000);
			acc.setName("홍길동");
			acc.setPw("456456");
			System.out.println(acc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}