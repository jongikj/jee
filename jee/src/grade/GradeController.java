package grade;

import java.util.Scanner;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JOptionPane;

/**
 * @date   :2016. 6. 8.
 * @author :장종익
 * @file   :Avg.java
 * @story  :
*/
public class GradeController {
	/**
	 * 클라이언트에서 프로그램 개발 요청이 왔습니다.
	 * 이름과 국, 영, 수 세과목 점수를 입력받아서
	 * [홍길동 : 총점 ***점, 평균 ***점, 학점 : F]
	 * 을 출력하는 프로그램을 만들어주세요.
	 * 단 평균은 소수점 이하는 절삭합니다.
	 * 평균 점수가 90점 이상이면 A
	 * 80점 이상이면 B
	 * 70점 이상이면 C
	 * 60점 이상이면 D
	 * 50점 이상이면 E
	 * 50점 미만이면 F 입니다 라고
	 * 출력되게 해주세요
	 * 단, switch-case 문을 이용.
	 * */
	public static void main(String[] args) {
		GradeService service = GradeServiceImpl.getInstance();
		GradeDAO dao = GradeDAO.getInstance();
		
		while (true) {
			switch (JOptionPane.showInputDialog(
					"1추가 2수정 3삭제 4전체조회 5학점조회(SEQ) 6시퀀스조회(ID입력받고) 7응시생수(시험일자별) 0종료")) {
			case "1":
				GradeBean temp1 = new GradeBean();
				String intputID = JOptionPane.showInputDialog("자바,SQL,HTML,자바스크립트,ID,날짜");
				String[] addArr1 = intputID.split(",");
				temp1.setJava(Integer.parseInt(addArr1[0]));
				temp1.setSql(Integer.parseInt(addArr1[1]));
				temp1.setHtml(Integer.parseInt(addArr1[2]));
				temp1.setJavascript(Integer.parseInt(addArr1[3]));
				temp1.setId(addArr1[4]);
				temp1.setExamDate(addArr1[5]);
				JOptionPane.showMessageDialog(null, service.insert(temp1));
				break;

			case "2":
				GradeBean temp2 = new GradeBean();
				String sub = "";
				String upSeq = JOptionPane.showInputDialog("점수 수정할 시퀀스");
				switch (JOptionPane.showInputDialog("1.자바, 2.SQL, 3.HTML, 4.자바스크립트")){
				case "1": 
					String java = JOptionPane.showInputDialog("자바 점수 수정");
					sub = "java";
					temp2.setJava(Integer.parseInt(java));
					service.update(upSeq, sub, temp2);
					break;
				
				case "2":
					String sql = JOptionPane.showInputDialog("SQL 점수 수정");
					sub = "sql";
					temp2.setSql(Integer.parseInt(sql));
					JOptionPane.showMessageDialog(null, service.update(upSeq, sub, temp2));
					break;
				
				case "3": 
					String html = JOptionPane.showInputDialog("HTML 점수 수정");
					sub = "html";
					temp2.setHtml(Integer.parseInt(html));
					service.update(upSeq, sub, temp2);
					break;
				
				case "4": 
					String javascript = JOptionPane.showInputDialog("자바스크립트 점수 수정");
					sub = "javascript";
					temp2.setJavascript(Integer.parseInt(javascript));
					service.update(upSeq, sub, temp2);
					break;
				}
				break;
				
			case "3":
				String inputSeq = JOptionPane.showInputDialog("삭제할 시퀀스");
				JOptionPane.showMessageDialog(null, service.delete(inputSeq));
				break;
				
			case "4":
				GradeUI ui = new GradeUI();
				break;
				
			case "5":
				String seq = JOptionPane.showInputDialog("조회할 SEQ");
				JOptionPane.showMessageDialog(null, service.findBySeq(seq));
				break;
				
			case "6":
				String id = JOptionPane.showInputDialog("조회할 ID");
				JOptionPane.showMessageDialog(null, service.findBy(id));
				break;
				
			case "7":
				String examDate = JOptionPane.showInputDialog("조회하려는 시험일자 (예:2016-05)");
				JOptionPane.showMessageDialog(null, service.count(examDate) + "명");
				break;
				
			case "0":
				return;

			default:
				break;
			}
		}
	}
}