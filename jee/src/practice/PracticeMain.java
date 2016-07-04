package practice;

import javax.swing.JOptionPane;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :PracticeMain.java
 * @story  :
*/
public class PracticeMain {
	public static void main(String[] args) {
		PracticeService service = PracticeServiceImpl.getInstance();
		
		while(true){
			switch (JOptionPane.showInputDialog("1.추가 0.종료")){
			case "1" :
				PracticeBean tempBean = new PracticeBean();
				String str = JOptionPane.showInputDialog("이름");
				tempBean.setName(str);
				service.regist(tempBean);
				break;
				
			case "0" :
				return;
			}
		}
	}
}
