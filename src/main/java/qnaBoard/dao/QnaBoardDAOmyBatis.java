package qnaBoard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import qnaBoard.bean.QnaBoardDTO;


@Repository
public class QnaBoardDAOmyBatis extends SqlSessionDaoSupport implements QnaBoardDAO {
	
	@Override
	public void insertQnaBoard(QnaBoardDTO qnaBoardDTO){
		getSqlSession().insert("QnaBoard.insertQnaBoard",qnaBoardDTO);
	}
	@Override
	public List<QnaBoardDTO> getQnaBoardList(int pg) {
		int endNum = 10;
		int startNum = pg*10-10;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("endNum", endNum);
		map.put("startNum", startNum);
				
		return getSqlSession().selectList("QnaBoard.getQnaBoardList",map);
	}

	@Override
	public int getQnaTotalArticle() {
		return (int)getSqlSession().selectOne("QnaBoard.getQnaTotalArticle");
	}

	@Override
	public void updateHit(int seq) {
		getSqlSession().update("QnaBoard.updateHit", seq);
		
	}

	@Override
	public QnaBoardDTO getArticle(int seq) {
		return (QnaBoardDTO)getSqlSession().selectOne("QnaBoard.getArticle", seq);      
	}

	@Override
	public void replyArticle(QnaBoardDTO qnaBoardDTO) {
		//원글
		QnaBoardDTO pBoardDTO=(QnaBoardDTO)getSqlSession().selectOne("QnaBoard.getArticle", qnaBoardDTO.getPseq());           
 		
		//글순서(step) update
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("ref", pBoardDTO.getRef());//원글 그룹번호
		map.put("step", pBoardDTO.getStep());//원글 step
		getSqlSession().update("QnaBoard.stepUpdate", map);

		//답글 insert
		qnaBoardDTO.setRef(pBoardDTO.getRef());
		qnaBoardDTO.setLev(pBoardDTO.getLev()+1);
		qnaBoardDTO.setStep(pBoardDTO.getStep()+1);
		getSqlSession().insert("QnaBoard.replyArticle", qnaBoardDTO);
		
		//답글수(reply) update
		getSqlSession().update("QnaBoard.replyUpdate", pBoardDTO.getSeq());	
	}
	
	@Override
	public int getRefArticle() {
		return (int)getSqlSession().selectOne("QnaBoard.getRefArticle");
	}

	@Override
	public void deleteQnaBoard(int seq) {
		getSqlSession().delete("QnaBoard.deleteQnaBoard", seq);
	}
	
}













