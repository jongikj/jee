package bank;

import java.util.Comparator;

/**
 * @date   :2016. 7. 8.
 * @author :장종익
 * @file   :NameAscSort.java
 * @story  :이름으로 정렬하는 클래스
*/
public class NameAscSort implements Comparator<AccountMemberBean> {

	@Override
	public int compare(AccountMemberBean first, AccountMemberBean second) {
		return first.getName().compareTo(second.getName()); // first와 second의 name을 비교한다.
	}
}
