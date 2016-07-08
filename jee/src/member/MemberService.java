/**
 * 
 */
package member;

import java.util.List;

import global.CommonService;

/**
 * @date   :2016. 6. 17.
 * @author :장종익
 * @file   :StudentService.java
 * @story  :
*/
public interface MemberService extends CommonService{
	public String regist(MemberBean bean);
	public String update(MemberBean bean);
	public String delete(String id);
	public MemberBean findById(String id);
	public List<MemberBean> findByName(String findName);
	public String login(MemberBean bean);
}
