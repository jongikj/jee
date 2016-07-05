package grade;

import java.util.List;

public interface GradeService {
	// 총 7개의 기본패턴
	//exeU
	public String insert(GradeBean bean);
	public String update(String sub, GradeBean bean);
	public String delete(String seq);
	//exeQ
	public List<GradeBean> list();
	public List<GradeBean> findById(String id);
	public GradeBean findBySeq(String seq);
	public int count(String date);
}
