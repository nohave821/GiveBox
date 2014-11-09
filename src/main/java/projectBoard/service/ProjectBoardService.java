package projectBoard.service;


import java.util.List;

import projectBoard.bean.ProjectBoardDTO;

public interface ProjectBoardService {

	int getProjectTotalArticle();
	
	void insertProjectBoard(ProjectBoardDTO projectBoardDTO);

	List<ProjectBoardDTO> getProjectBoardList(int pg);
	
	void updateHit(int seq);

	ProjectBoardDTO getArticle(int seq);

	void deleteProjectBoard(int seq);

	void giveProjectBoard(int startmoney, int seq);
}
