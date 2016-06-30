package global;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * @date :2016. 6. 30.
 * @author :장종익
 * @file :FileEx.java
 * @story :
 */
public class FileEx {
	public static void main(String[] args) {
		File file = null;
		FileWriter fw = null;	// File 객체가 있어야 사용가능
		FileReader fr = null;	// 한줄을 읽음
		BufferedWriter bw = null;	
		BufferedReader br = null;	//여러줄을 읽음
		String msg = "";
		
		try {
			while (true) {
				switch (JOptionPane.showInputDialog("1.생성 2.쓰기 3.읽기 4.수정 5.삭제 0.종료")) {
				case "1":
					String fileName = JOptionPane.showInputDialog("파일명?");
					file = new File("C:\\eclipse\\workspace\\" + fileName + ".txt");
					fw = new FileWriter(file, true);
					fr = new FileReader(file);
					bw = new BufferedWriter(fw);
					br = new BufferedReader(fr);
					break;

				case "2":
					msg = JOptionPane.showInputDialog("입력내용");
					bw.write(msg);
					bw.newLine();
					fw.flush();
					bw.flush(); // input의 마지막 동작
					break;
					
				case "3":
					while((msg = br.readLine()) != null){
						JOptionPane.showMessageDialog(null, msg);
					}
					fr.close();
					br.close();
					break;
					
				case "4":
					String updateFileName = JOptionPane.showInputDialog("수정하려는 파일명");
					File updateFile = new File("C:\\eclipse\\workspace\\" + updateFileName + ".txt");
					bw = new BufferedWriter(new FileWriter(updateFile));
					String updateMsg = JOptionPane.showInputDialog("수정메세지");
					bw.write(updateMsg);
					bw.flush();
					break;
					
				case "5":
					String delFileName = JOptionPane.showInputDialog("삭제하려는 파일명?");
					File delFile = new File("C:\\eclipse\\workspace\\" + delFileName + ".txt");
					delFile.delete();
					break;
					
				case "6":
					break;
					
				case "0":
					fw.close();
					fr.close();
					return;
					
				default:
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.flush();
				bw.flush();
				fw.close();
				bw.close();
				fr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
