package projectBoard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import projectBoard.bean.ProjectBoardDTO;

@Repository
public class ProjectBoardDAOmyBatis extends SqlSessionDaoSupport implements ProjectBoardDAO{

	@Override
	public int getTotalArticle() {
		return (int)getSqlSession().selectOne("ProjectBoard.getTotalArticle");
	}

	@Override
	public void insertProjectBoard(ProjectBoardDTO projectBoardDTO) {
		getSqlSession().insert("ProjectBoard.insertProjectBoard",projectBoardDTO);
		
	}

	@Override
	public List<ProjectBoardDTO> getProjectBoardList(int pg) {
		int endNum = 10;
		int startNum = pg*10-10;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("endNum", endNum);
		map.put("startNum", startNum);
		
		return getSqlSession().selectList("ProjectBoard.getProjectBoardList", map);
	}
	
	@Override
	public void updateHit(int seq) {
		getSqlSession().update("ProjectBoard.updateHit", seq);
		
	}

	@Override
	public ProjectBoardDTO getArticle(int seq) {
		return (ProjectBoardDTO)getSqlSession().selectOne("ProjectBoard.getArticle", seq);      
	}

	@Override
	public void deleteProjectBoard(int seq) {
		getSqlSession().delete("ProjectBoard.deleteProjectBoard", seq);
	}

	@Override
	public void giveProjectBoard(int startmoney, int seq) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("seq", seq);
		map.put("startmoney", startmoney);

		getSqlSession().update("ProjectBoard.giveProjectBoard", map);
	}
}
