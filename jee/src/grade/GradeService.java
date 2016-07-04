package grade;

import java.util.List;

public interface GradeService {
	// 총 7개의 기본패턴
	//exeU
	public int insert(GradeBean bean);
	public int update(GradeBean bean);
	public int delete(GradeBean bean);
	//exeQ
	public List<GradeBean> list();
	public List<GradeBean> findByHakjum(String hakjum);
	public GradeBean findBySeq(int seq);
	public int count();
}
