package practice;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :PracticeServiceImpl.java
 * @story  :
*/
public class PracticeServiceImpl implements PracticeService{
	PracticeBean bean = null;
	PracticeDAO dao = PracticeDAO.getInstance();
	private static PracticeServiceImpl instance = new PracticeServiceImpl();
	
	private PracticeServiceImpl() {}
	
	public static PracticeServiceImpl getInstance() {
		return instance;
	}

	@Override
	public void regist(PracticeBean bean) {
		String sql = "insert into practice(id) values('" + bean.getName() + "')";
		dao.executeUpdate(sql);
	}
}
