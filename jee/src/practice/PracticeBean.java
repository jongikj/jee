package practice;

import java.io.Serializable;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :PracticeBean.java
 * @story  :
*/
public class PracticeBean implements Serializable{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
