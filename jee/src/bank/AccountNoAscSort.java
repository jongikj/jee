package bank;

import java.util.Comparator;

/**
 * @date   :2016. 7. 8.
 * @author :장종익
 * @file   :NameAscSort.java
 * @story  :이름으로 정렬하는 클래스
*/
public class AccountNoAscSort implements Comparator<AccountMemberBean> {

	@Override
	public int compare(AccountMemberBean first, AccountMemberBean second) {
		int a = 0;
		
		if (first.getAccountNo() > second.getAccountNo()) {
			a = 1;
		} else {
			if (first.getAccountNo() < second.getAccountNo()) {
				a = -1;
			} else {
				a = 0;
			}
		}
		return a;
	}
}
