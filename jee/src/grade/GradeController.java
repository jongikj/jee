package grade;

import java.util.Scanner;

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
					"1추가 2수정 3삭제 4전체조회 5학점조회 6시퀀스조회 7응시생수 0종료")) {
			case "1":
				break;

			case "2":
				break;
				
			case "3":
				break;
				
			case "4":
				break;
				
			case "5":
				break;
				
			case "6":
				break;
				
			case "7":
				break;
				
			case "0":
				return;

			default:
				break;
			}
		}
	}
}
