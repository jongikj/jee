/**
 * 
 */
package bank;

import java.util.List;

/**
 * @date   :2016. 6. 20.
 * @author :장종익
 * @file   :AccountService.java
 * @story  :
*/
public interface AccountService {
	// 1.개설
	public abstract void openAccount(AccountBean bean);
	// 2.입금
	public void deposit(int inputMoney);
	// 3.출금
	public String withdraw(int output);
	// UPDATE : 4.수정 .. 사용자의 요청에 의해 비번만 전환가능
	public String updateAccount(AccountBean bean);
	// 5.해지
	public void deleteAccount();
	// READ : 6.조회 (전체)
	public List<AccountBean> accountList();
	// READ : 7.조회 (계좌번호)
	public AccountBean findByAccountNo(String searchAcc);
	// READ : 8.조회 (이름)
	public List<AccountBean> findByName(String name);
	// READ : 9.조회 (전체통장 수)
	public int count();
	
}
