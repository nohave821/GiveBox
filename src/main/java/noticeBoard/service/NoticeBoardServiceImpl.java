package noticeBoard.service;

import java.util.List;

import noticeBoard.bean.NoticeBoardDTO;
import noticeBoard.dao.NoticeBoardDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{

	@Autowired
	private NoticeBoardDAO noticeBoardDAO;
	
	@Override
	public int getNoticeTotalArticle() {
		return noticeBoardDAO.getTotalArticle();
	}
	
	@Override
	public void insertNoticeBoard(NoticeBoardDTO noticeBoardDTO) throws Exception {
		noticeBoardDAO.insertNoticeBoard(noticeBoardDTO);
	}

	@Override
	public List<NoticeBoardDTO> getNoticeBoardList(int pg) {
		return noticeBoardDAO.getNoticeBoardList(pg);
	}

	@Override
	public void updateHit(int seq) {
		noticeBoardDAO.updateHit(seq);
	}

	@Override
	public NoticeBoardDTO getArticle(int seq) {
		return noticeBoardDAO.getArticle(seq);
	}

	@Override
	public void deleteNoticeBoard(int seq) { noticeBoardDAO.deleteNoticeBoard(seq); }
}
