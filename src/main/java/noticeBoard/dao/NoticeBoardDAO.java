package noticeBoard.dao;

import java.util.List;

import noticeBoard.bean.NoticeBoardDTO;

public interface NoticeBoardDAO {

	int getTotalArticle();

	void insertNoticeBoard(NoticeBoardDTO noticeBoardDTO) throws Exception;

	List<NoticeBoardDTO> getNoticeBoardList(int pg);

	void updateHit(int seq);

	NoticeBoardDTO getArticle(int seq);

	void deleteNoticeBoard(int seq);

}
