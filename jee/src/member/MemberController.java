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
		MemberService service = new MemberServiceImpl();
		
		MemberBean st = null;
		int confirm = 0;
		while (true) {
			switch (JOptionPane.showInputDialog("1.등록, 2.보기, 3.수정, 4.삭제, 0종료")) {
			case "1":
				String spec = JOptionPane.showInputDialog("ID,PW,이름,주민번호 -포함 뒤 첫째자리");
				String[] arr = spec.split(","); 
				service.registStudent(arr[0], arr[1], arr[2], arr[3]);
				break;
				
			case "2":
				JOptionPane.showMessageDialog(null, Constants.SCHOOL_NAME + ", " + service.showStudent());
				break;
				
			case "3":
				service.updateStudent(JOptionPane.showInputDialog("PW변경"));
				break;
				
			case "4":
				service.deleteStudent();
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