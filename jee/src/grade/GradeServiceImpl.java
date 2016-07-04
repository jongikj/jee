package grade;

import java.util.List;

public class GradeServiceImpl implements GradeService {
	private static GradeServiceImpl instance = new GradeServiceImpl();
	
	private GradeServiceImpl() {}
	
	public static GradeServiceImpl getInstance() {
		return instance;
	}

	@Override
	public int insert(GradeBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GradeBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(GradeBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GradeBean> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradeBean> findByHakjum(String hakjum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GradeBean findBySeq(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
}