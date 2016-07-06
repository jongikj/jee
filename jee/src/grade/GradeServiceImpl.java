package grade;

import java.util.List;

public class GradeServiceImpl implements GradeService {
	GradeDAO dao = GradeDAO.getInstance();
	private static GradeServiceImpl instance = new GradeServiceImpl();
	
	private GradeServiceImpl() {}
	
	public static GradeServiceImpl getInstance() {
		return instance;
	}

	@Override
	public String insert(GradeBean bean) {
		String msg = "";
		if (dao.insert(bean) == 1){
			msg = "추가성공";
		} else {
			msg = "추가실패";
		}
		return msg;
	}

	@Override
	public String update(String seq, String sub, GradeBean bean) {
		String msg = "";
		if (dao.update(seq, sub, bean) == 1) {
			msg = "수정완료";
		} else {
			msg = "수정실패";
		}
		return msg;
	}

	@Override
	public String delete(String seq) {
		String msg = "";
		if (dao.delete(seq) == 1) {
			msg = "삭제성공";
		} else {
			msg = "삭제실패";
		}
		return msg;
	}

	@Override
	public GradeBean findBySeq(String seq) {
		return dao.findBySeq(seq);
	}
	
	@Override
	public List<GradeBean> list() {
		List<GradeBean> list = dao.list();
		return list;
	}

	@Override
	public List<GradeBean> findById(String id) {
		return dao.findById(id);
	}


	@Override
	public int count(String examDate) {
		return dao.count(examDate);
	}
}