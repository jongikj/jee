/**
 * 
 */
package bank2;

/**
 * @date   :2016. 6. 20.
 * @author :장종익
 * @file   :AccountServiceImpl.java
 * @story  :계좌 인터페이스
*/
public class AccountServiceImpl implements AccountService {
	// 1.개설, 2.입금, 3.조회, 4.출금, 5.통장내역, 6.해지
	AccountBean account;

	public void openAccount(String name, String id, String pw) {
		account = new AccountBean(name, id, pw);
	}

	public void deposit(int inputMoney) {
		int money = account.getMoney();
		money += inputMoney;
		account.setMoney(money);
	}

	public void findAccount() {
		// TODO Auto-generated method stub

	}

	public String withdraw(int output) {
		String result = "잔액부족";
		int money = account.getMoney();
		if (output <= money) {
			money -= output;
			account.setMoney(money);
			result = String.valueOf(account.getMoney());
		}
		return result;
	}

	public String showAccount() {
		return account.toString();
	}

	public void deleteAccount() {
		account = null;
	}
}
