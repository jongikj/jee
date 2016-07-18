/**
 * 
 */
package member;

import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.JOptionPane;

import global.Constants;
import sun.print.resources.serviceui;


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
			switch(JOptionPane.showInputDialog(""
					+ "--- 회원이 보는 화면 ---\n"
					+ "1.회원가입 2.로그인 3.내정보보기 4.내정보수정(비번) 5.탈퇴 0.종료\n"
					+ "--- 관리자 화면 ---\n"
					+ "11.회원목록 12.검색(ID) 13.검색(이름) 14.회원수(성별) 15.회원수")){
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
				MemberBean tempBean2 = new MemberBean();
				String input2 = JOptionPane.showInputDialog("ID,PW");
				String[] inputArr2 = input2.split(",");
				tempBean2.setId(inputArr2[0]);
				tempBean2.setPw(inputArr2[1]);
				String result2 = service.login(tempBean2);
				JOptionPane.showMessageDialog(null, result2);
				break;
				
			case "3":
				break;
				
			case "4":
				MemberBean tempBean3 = new MemberBean();
				String tempStr3 = JOptionPane.showInputDialog("ID,PW");
				String[] tempArr3 = tempStr3.split(",");
				tempBean3.setId(tempArr3[0]);
				tempBean3.setPw(tempArr3[1]);
				service.update(tempBean3);
				break;
				
			case "5":
				String tempStr4 = JOptionPane.showInputDialog("삭제할 ID");
//				JOptionPane.showMessageDialog(null, service.delete(tempStr4));
				break;
				
			case "11":
				JOptionPane.showMessageDialog(null, service.list());
				break;
				
			case "12" :
				String findID = JOptionPane.showInputDialog("조회할 ID");
				JOptionPane.showMessageDialog(null, service.findById(findID));
				break;
				
			case "13" :
				String findName = JOptionPane.showInputDialog("조회할 이름");
				JOptionPane.showMessageDialog(null, service.findByName(findName));
				break;
				
			case "14":
				break;
				
			case "15":
				int count = service.count();
				JOptionPane.showMessageDialog(null, count + "명");
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