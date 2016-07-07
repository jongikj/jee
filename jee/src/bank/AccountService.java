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
	public String openAccount(String id);
	// 2.입금
	public void deposit(String deposit);
	// 3.출금
	public String withdraw(String withdraw);
	// UPDATE : 4.수정 .. 사용자의 요청에 의해 비번만 전환가능
	public String updateAccount(AccountBean bean);
	// 5.해지
	public String deleteAccount(int accountNo);
	// READ : 6.조회 (전체)
	public List<AccountBean> accountList();	//빅빈을 사용한다 빈은 사용하지 않는다
	// READ : 7.조회 (계좌번호)
	public AccountBean findByAccountNo(int searchAcc);
	// READ : 8.조회 (이름)
	public List<AccountBean> findByName(String name);
	// READ : 9.조회 (전체통장 수)
	public int count();
	// 필요에 따라 생성하는 메소드
	public int restMoney(int accountNo);
}
