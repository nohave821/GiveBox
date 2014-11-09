package storyBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import storyBoard.bean.StoryBoardDTO;
import storyBoard.dao.StoryBoardDAO;

@Service
public class StoryBoardServiceImpl implements StoryBoardService{
	
	@Autowired
	private StoryBoardDAO storyBoardDAO;

	@Override
	public int getStoryTotalArticle() {
		return storyBoardDAO.getTotalArticle();
	}
	
	@Override
	public void insertStoryBoard(StoryBoardDTO storyBoardDTO) {
		storyBoardDAO.insertStoryBoard(storyBoardDTO);
	}


	@Override
	public List<StoryBoardDTO> getStoryBoardList(int pg) {
		return storyBoardDAO.getStoryBoardList(pg);
	}
	
	@Override
	public void updateHit(int seq) {
		storyBoardDAO.updateHit(seq);
	}

	@Override
	public StoryBoardDTO getArticle(int seq) {
		return storyBoardDAO.getArticle(seq);
	}

	@Override
	public void deleteStoryBoard(int seq) { storyBoardDAO.deleteStoryBoard(seq); }

	@Override
	public void giveStoryBoard(int startmoney, int seq) { storyBoardDAO.giveStoryBoard(startmoney, seq); }

}
