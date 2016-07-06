package bank2;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @date   :2016. 6. 27.
 * @author :장종익
 * @file   :BankServiceImpl.java
 * @story  :
*/
public class BankServiceImpl implements BankService {	// 오프라인에서 진행하는 상황..
	List<AccountBean> list;	// 검색이 용이
	
	public BankServiceImpl() {
		list = new Vector<AccountBean>(); // 생성자를 이용해서 객체 생성시 리스트를 생성한다.
	}
	
	@Override
	public void openAccount(AccountBean bean) { // 11.개설(은행창구개설)
		list.add(bean);
	}

	@Override
	public List<AccountBean> accountList() { // 12.전체조회
		return list;
	}

	@Override
	public AccountBean findByAccountNo(String searchAcc) {
		AccountBean bean = new AccountBean();
		int i = 0;
		for (; i < list.size(); i++) {
			if (String.valueOf(list.get(i).getAccountNo()).equals(searchAcc)) {
				bean = list.get(i);
				break;
			}
		}
		return bean;
	}

	@Override
	public List<AccountBean> findByName(String name) {
		List<AccountBean> list = new ArrayList<AccountBean>();	// temp
		for (int i = 0; i < this.list.size(); i++) {
			if (name.equals(this.list.get(i).getName())) {
				list.add(this.list.get(i));
			}
		}
		return list;
	}

	@Override
	public int count() {
		return list.size();
	}

	@Override
	public String updateAccount(AccountBean bean) { // 15
		String result = "";
		AccountBean temp = this.findByAccountNo(String.valueOf(bean.getAccountNo()));
		if (temp.getName() == null) {
			result = "계좌번호가 존재하지 않습니다.";
		} else {
			temp.setPw(bean.getPw());
			result = "비밀번호가 변경되었습니다.";
		}
		return result;
	}

	@Override
	public String deleteAccount(String acc) {
		String result = "";
		AccountBean temp = this.findByAccountNo(acc);
		if (temp.getName() == null){
			result = "계좌번호가 존재하지 않습니다.";
		} else {
			list.remove(temp);
			result = "계좌가 삭제되었습니다.";
		}
		return result;
	}
}