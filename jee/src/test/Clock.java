package test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date   :2016. 7. 13.
 * @author :장종익
 * @file   :Clock.java
 * @story  :
*/

public class Clock {
	public String now(){
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
}
