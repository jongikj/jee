/**
 * 
 */
package bank;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * @date   :2016. 6. 15.
 * @author :장종익
 * @file   :BankController.java
 * @story  :
*/
public class BankController {
	public static void main(String[] args) {
		AccountService service = new AccountServiceImpl();
		BankService bank = new BankServiceImpl();
		String spec = "";
		String[] arr = new String[3];
		AccountBean bean = new AccountBean();
		
		while (true) {
			switch (JOptionPane.showInputDialog(""
					+ "=====개인인터넷뱅킹=====\n"
					+ "1.개설, 2.입금, 3.조회, 4.출금, 5.통장내역, 6.해지\n "
					+ "=====은행창구=====\n"
					+ "11.개설, 12.조회(전체), 13.조회(계좌번호), 14.조회(이름), 15.조회(전체계좌수), "
					+ "16.수정(비밀번호), 17.해지, 0.종료")) {
			case "1":
				spec = JOptionPane.showInputDialog("이름,ID,PW");
				arr = spec.split(",");
				service.openAccount(arr[0], arr[1], arr[2]);
				break;

			case "2":
				String inputMoney = JOptionPane.showInputDialog("입금액 입력 : ");
				// account.setMoney(Integer.parseInt(inputMoney));
				service.deposit(Integer.parseInt(inputMoney));
				break;

			case "3":
				// JOptionPane.showMessageDialog(null, service.findAccount());
				break;

			case "4":
				String outputMoney = JOptionPane.showInputDialog("출금액 : ");
				JOptionPane.showMessageDialog(null, "잔액 : " + service.withdraw(Integer.parseInt(outputMoney)));
				break;

			case "5":
				JOptionPane.showMessageDialog(null, service.showAccount());
				break;

			case "6":
				service.deleteAccount();
				break;

			case "11":
				spec = JOptionPane.showInputDialog("이름,ID,PW");
				arr = spec.split(",");
				AccountBean acc = new AccountBean();
				acc.setAccountNo();
				acc.setName(arr[0]);
				acc.setId(arr[1]);
				acc.setPw(arr[2]);
				bank.openAccount(acc);
				break;

			case "12":
				JOptionPane.showMessageDialog(null, bank.accountList());
				break;
				
			case "13":
				String findAcc = JOptionPane.showInputDialog("검색하려는 계좌번호");
				bean = bank.findByAccountNo(findAcc);
				JOptionPane.showMessageDialog(null, (bean.getName() == null) ? "조회 계좌번호 없음" : bean.toString());
				break;
				
			case "14":
				String findName = JOptionPane.showInputDialog("검색하려는 이름");
				List<AccountBean> list = bank.findByName(findName);	// BankServiceImpl의 findByName 메소드가 List<AccountBean>기 때문에 리스트에 대입
				JOptionPane.showMessageDialog(null, (list.isEmpty()) ? "조회 계좌번호 없음" : list);
				break; // boolean isEmpty()는 객체가 비어있는지 판단한다

			case "15":
				JOptionPane.showMessageDialog(null, "전체계좌 수 : " + bank.count() + "개");
				break;

			case "16":
				String change = JOptionPane.showInputDialog("수정하려는 계좌번호,비밀번호");
				String[] changeArr = change.split(",");
				bean.setAccountNo(Integer.parseInt(changeArr[0]));
				bean.setPw(changeArr[1]);
				JOptionPane.showMessageDialog(null, bank.updateAccount(bean));
				break;

			case "17":
				String del = JOptionPane.showInputDialog("삭제하려는 계좌번호");
				JOptionPane.showMessageDialog(null, bank.deleteAccount(del));
				break;

			default:
				if (JOptionPane.showConfirmDialog(null, "Close?") == 0) {
				} else {
					continue;
				}
				return;
			}
		}
	}
}