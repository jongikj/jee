/**
 * 
 */
package member;

import javax.swing.JOptionPane;

import global.Constants;


/**
 * @date   :2016. 6. 16.
 * @author :장종익
 * @file   :SchoolController.java
 * @story  :
*/
public class MemberController {
	public static void main(String[] args) {
		MemberService service = MemberServiceImpl.getInstance(); 
		
		MemberBean st = null;
		int confirm = 0;
		while (true) {
			switch (JOptionPane.showInputDialog("1.등록, 2.보기, 3.수정, 4.삭제, 0종료")) {
			case "1":
				MemberBean tempBean = new MemberBean();
				String spec = JOptionPane.showInputDialog("ID,PW,이름,주민번호 -포함 뒤 첫째자리");
				String[] arr = spec.split(","); 
				tempBean.setId(arr[0]);
				tempBean.setPw(arr[1]);
				tempBean.setName(arr[2]);
				tempBean.setSsn(arr[3]);
				tempBean.setRegDate();
				String result = service.regist(tempBean);
				JOptionPane.showMessageDialog(null, result);
				break;
				
			case "2":
				JOptionPane.showMessageDialog(null, Constants.SCHOOL_NAME + ", " + service.show());
				break;
				
			case "3":
				service.update(JOptionPane.showInputDialog("PW변경"));
				break;
				
			case "4":
				service.delete();
				break;
				
			case "0":
				confirm = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?");
				if (confirm == 0) {
				} else {
					continue;
				}
				return;
			default:
				break;
			}
		}
	}
}