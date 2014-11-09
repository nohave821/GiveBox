package projectBoard.dao;

import java.util.List;

import projectBoard.bean.ProjectBoardDTO;

public interface ProjectBoardDAO {

	int getTotalArticle();

	void insertProjectBoard(ProjectBoardDTO projectBoardDTO);

	List<ProjectBoardDTO> getProjectBoardList(int pg);
	
	void updateHit(int seq);

	ProjectBoardDTO getArticle(int seq);

	void deleteProjectBoard(int seq);

	void giveProjectBoard(int startmoney, int seq);
}
