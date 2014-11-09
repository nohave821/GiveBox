package projectBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectBoard.bean.ProjectBoardDTO;
import projectBoard.dao.ProjectBoardDAO;

@Service
public class ProjectBoardServiceImpl implements ProjectBoardService{

	@Autowired
	private ProjectBoardDAO projectBoardDAO;

	@Override
	public int getProjectTotalArticle() {
		return projectBoardDAO.getTotalArticle();
	}
	
	@Override
	public void insertProjectBoard(ProjectBoardDTO projectBoardDTO) {
		projectBoardDAO.insertProjectBoard(projectBoardDTO);
	}

	@Override
	public void updateHit(int seq) {
		projectBoardDAO.updateHit(seq);
	}

	@Override
	public ProjectBoardDTO getArticle(int seq) {
		return projectBoardDAO.getArticle(seq);
	}

	@Override
	public List<ProjectBoardDTO> getProjectBoardList(int pg) {
		return projectBoardDAO.getProjectBoardList(pg);
	}

	@Override
	public void deleteProjectBoard(int seq) { projectBoardDAO.deleteProjectBoard(seq); }

	@Override
	public void giveProjectBoard(int startmoney, int seq) { projectBoardDAO.giveProjectBoard(startmoney, seq); }
}
