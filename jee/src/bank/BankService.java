package bank;

import java.util.List;

/**
 * @date   :2016. 6. 27.
 * @author :장종익
 * @file   :BankService.java
 * @story  :
*/
public interface BankService {	// 오프라인에서 개설하는 상황
	//  CREATE : 11.개설
	public void openAccount(AccountBean bean);
	// READ : 12.조회 (전체)
	public List<AccountBean> accountList();
	// READ : 13.조회 (계좌번호)
	public AccountBean findByAccountNo(String searchAcc);
	// READ : 14.조회 (이름)
	public List<AccountBean> findByName(String name);
	// READ : 15.조회 (전체통장 수)
	public int count();
	// UPDATE : 16.수정 .. 사용자의 요청에 의해 비번만 전환가능
	public String updateAccount(AccountBean bean);
	// DELETE : 17.해지
	public String deleteAccount(String acc);
}