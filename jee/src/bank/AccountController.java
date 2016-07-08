/**
 * 
 */
package bank;

import javax.swing.JOptionPane;

/**
 * @date   :2016. 6. 15.
 * @author :장종익
 * @file   :BankController.java
 * @story  :
*/
public class AccountController {
	public static void main(String[] args) {
		AccountService service = AccountServiceImpl.getInstance();
		
		while(true) {
			switch(JOptionPane.showInputDialog("1.개설 2.입금 3.출금 4.수정 5.해지 6.조회(전체) 7.조회(계좌번호) 8.조회(이름) 9.조회(전체통장 수) 10.로그인 0.종료")){
				case "1" :
					String id = JOptionPane.showInputDialog("ID입력");
					JOptionPane.showMessageDialog(null, service.openAccount(id));
					break;
					
				case "2" :
					String deposit = JOptionPane.showInputDialog("입금할 계좌,금액");
					service.deposit(deposit);
					break;
					
				case "3" :
					String withdraw = JOptionPane.showInputDialog("출금할 계좌, 금액");
					JOptionPane.showMessageDialog(null, service.withdraw(withdraw));
					break;
					
				case "4" :
					AccountBean temp4 = new AccountBean();
					String update = JOptionPane.showInputDialog("ID,수정할 비밀번호");
					String[] arr4 = update.split(",");
					temp4.setId(arr4[0]);
					temp4.setPw(arr4[1]);
					JOptionPane.showMessageDialog(null, service.updateAccount(temp4));
					break;
					
				case "5" :
					String delete = JOptionPane.showInputDialog("삭제할 계좌번호");
					JOptionPane.showMessageDialog(null, service.deleteAccount(Integer.parseInt(delete)));
					break;
					
				case "6" :
					BankUI ui = new BankUI();
//					JOptionPane.showMessageDialog(null, service.accountList());
					break;
					
				case "7" :
					String account = JOptionPane.showInputDialog("조회할 계죄번호");
					JOptionPane.showMessageDialog(null, service.findByAccountNo(Integer.parseInt(account)));
					break;
					
				case "8" : 
					String name = JOptionPane.showInputDialog("조회할 이름");
					JOptionPane.showMessageDialog(null, service.findBy(name));
					break;
					
				case "9" :
					JOptionPane.showMessageDialog(null, service.count() + "명");
					break;
					
				case "10" :
					break;
					
				case "0" : 
					return;
					
				default :
					break;
			}
		}
	}
}