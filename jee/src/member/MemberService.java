/**
 * 
 */
package member;

/**
 * @date   :2016. 6. 17.
 * @author :장종익
 * @file   :StudentService.java
 * @story  :
*/
public interface MemberService {
	public String regist(MemberBean bean);
	public String show();
	public void update(String pw);
	public void delete();
}
