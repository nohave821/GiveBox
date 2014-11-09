package qnaBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qnaBoard.bean.QnaBoardDTO;
import qnaBoard.dao.QnaBoardDAO;

@Service
public class QnaBoardServiceImpl implements QnaBoardService{

	@Autowired
	private QnaBoardDAO qnaBoardDAO;
	
	@Override
	public void insertQnaBoard(QnaBoardDTO qnaBoardDTO) throws Exception {
		qnaBoardDAO.insertQnaBoard(qnaBoardDTO);
	}

	@Override
	public List<QnaBoardDTO> getQnaBoardList(int pg) {
		return qnaBoardDAO.getQnaBoardList(pg);
	}

	@Override
	public int getQnaTotalArticle() {
		return qnaBoardDAO.getQnaTotalArticle();
	}

	@Override
	public void updateHit(int seq) {
		qnaBoardDAO.updateHit(seq);
	}

	@Override
	public QnaBoardDTO getArticle(int seq) {
		return qnaBoardDAO.getArticle(seq);
	}

	@Override
	public void replyArticle(QnaBoardDTO qnaBoardDTO) {
		qnaBoardDAO.replyArticle(qnaBoardDTO);
	}

	@Override
	public int getRefArticle() {
		return qnaBoardDAO.getRefArticle();
	}

	@Override
	public void deleteQnaBoard(int seq) { qnaBoardDAO.deleteQnaBoard(seq); }

}
