package storyBoard.dao;

import java.util.List;


import storyBoard.bean.StoryBoardDTO;


public interface StoryBoardDAO {

	int getTotalArticle();
	
	void insertStoryBoard(StoryBoardDTO storyBoardDTO);

	List<StoryBoardDTO> getStoryBoardList(int pg);
	
	void updateHit(int seq);

	StoryBoardDTO getArticle(int seq);

	void deleteStoryBoard(int seq);

	void giveStoryBoard(int startmoney, int seq);
}
