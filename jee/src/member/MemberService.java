/**
 * 
 */
package member;

import java.util.List;

/**
 * @date   :2016. 6. 17.
 * @author :장종익
 * @file   :StudentService.java
 * @story  :
*/
public interface MemberService {
	public String regist(MemberBean bean);
	public String show();	// 안씀
	public String update(MemberBean bean);
	public String delete(String id);
	public int count();
	public MemberBean findById(String findID);
	public List<MemberBean> list();
	public List<MemberBean> findByName(String findName);
}
