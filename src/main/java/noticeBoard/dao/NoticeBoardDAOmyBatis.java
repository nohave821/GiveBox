package noticeBoard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import noticeBoard.bean.NoticeBoardDTO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;


@Repository
public class NoticeBoardDAOmyBatis extends SqlSessionDaoSupport implements NoticeBoardDAO{

	@Override
	public int getTotalArticle() {
		return (int)getSqlSession().selectOne("NoticeBoard.getTotalArticle");
	}

	@Override
	public void insertNoticeBoard(NoticeBoardDTO noticeBoardDTO){
		getSqlSession().insert("NoticeBoard.insertNoticeBoard",noticeBoardDTO);
	}
	
	@Override
	public List<NoticeBoardDTO> getNoticeBoardList(int pg) {
		int endNum = 10;
		int startNum = pg*10-10;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("endNum", endNum);
		map.put("startNum", startNum);
				
		return getSqlSession().selectList("NoticeBoard.getNoticeBoardList",map);
	}

	@Override
	public void updateHit(int seq) {
		getSqlSession().update("NoticeBoard.updateHit", seq);
	}

	@Override
	public NoticeBoardDTO getArticle(int seq) {
		return (NoticeBoardDTO)getSqlSession().selectOne("NoticeBoard.getArticle", seq);      
	}

	@Override
	public void deleteNoticeBoard(int seq) {
		getSqlSession().delete("NoticeBoard.deleteNoticeBoard", seq);
	}
}
