package storyBoard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import storyBoard.bean.StoryBoardDTO;


@Repository
public class StoryBoardDAOmyBatis extends SqlSessionDaoSupport implements StoryBoardDAO{

	@Override
	public int getTotalArticle() {
		return (int)getSqlSession().selectOne("StoryBoard.getTotalArticle");
	}

	@Override
	public void insertStoryBoard(StoryBoardDTO storyBoardDTO) {
		getSqlSession().insert("StoryBoard.insertStoryBoard",storyBoardDTO);
		
	}

	@Override
	public List<StoryBoardDTO> getStoryBoardList(int pg) {
		int endNum = 10;
		int startNum = pg*10-10;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("endNum", endNum);
		map.put("startNum", startNum);
		
		return getSqlSession().selectList("StoryBoard.getStoryBoardList", map);
	}
	
	@Override
	public void updateHit(int seq) {
		getSqlSession().update("StoryBoard.updateHit", seq);
		
	}

	@Override
	public StoryBoardDTO getArticle(int seq) {
		return (StoryBoardDTO)getSqlSession().selectOne("StoryBoard.getArticle", seq);      
	}
	
	@Override
	public void deleteStoryBoard(int seq) {
		getSqlSession().delete("StoryBoard.deleteStoryBoard", seq);
	}

	@Override
	public void giveStoryBoard(int startmoney, int seq) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("seq", seq);
		map.put("startmoney", startmoney);

		getSqlSession().update("StoryBoard.giveStoryBoard", map);
	}
}
