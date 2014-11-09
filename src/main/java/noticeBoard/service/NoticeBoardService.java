package noticeBoard.service;

import java.util.List;

import noticeBoard.bean.NoticeBoardDTO;


public interface NoticeBoardService {

	int getNoticeTotalArticle();
	
	void insertNoticeBoard(NoticeBoardDTO noticeBoardDTO) throws Exception;

	List<NoticeBoardDTO> getNoticeBoardList(int pg);

	void updateHit(int seq);

	NoticeBoardDTO getArticle(int seq);

	void deleteNoticeBoard(int seq);
}
