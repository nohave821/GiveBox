package qnaBoard.dao;

import java.util.List;

import qnaBoard.bean.QnaBoardDTO;

public interface QnaBoardDAO {

	void insertQnaBoard(QnaBoardDTO qnaBoardDTO) throws Exception;

	List<QnaBoardDTO> getQnaBoardList(int pg);

	int getQnaTotalArticle();

	void updateHit(int seq);

	QnaBoardDTO getArticle(int seq);

	void replyArticle(QnaBoardDTO qnaBoardDTO);

	int getRefArticle();

	void deleteQnaBoard(int seq);

}
