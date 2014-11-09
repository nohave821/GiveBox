package qnaBoard.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import qnaBoard.bean.QnaBoardDTO;
import qnaBoard.bean.QnaBoardPaging;
import qnaBoard.service.QnaBoardService;


@Controller
@RequestMapping("/qnaBoard")
public class QnaBoardController {
	
	@Autowired
	private QnaBoardService qnaBoardService;
	@Autowired
	private QnaBoardDTO qnaBoardDTO;
	@Autowired
	private QnaBoardPaging qnaBoardPaging;
	
	@RequestMapping("/qnaBoardWriteForm")
	public ModelAndView qnaBoardWriteForm(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/qnaBoard/qnaBoardWriteForm.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}
	
	@RequestMapping("/qnaBoardWrite")
	public ModelAndView qnaBoardWrite(@RequestParam Map<String,String> map,HttpSession session) throws Exception{
		//세션
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		String subject = map.get("subject");
		String content = map.get("content");
		
		int ref=0;
		ref = qnaBoardService.getRefArticle()+1;
		
		//데이터 저장
		qnaBoardDTO.setId(id);
		qnaBoardDTO.setName(name);
		qnaBoardDTO.setEmail(email);
		qnaBoardDTO.setSubject(subject);
		qnaBoardDTO.setContent(content);
		qnaBoardDTO.setRef(ref);
		
		//DB-insert
		qnaBoardService.insertQnaBoard(qnaBoardDTO);
		
		//응답
		ModelAndView mav = new ModelAndView();
		mav.addObject("display", "/qnaBoard/qnaBoardWriteOk.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}
	
	@RequestMapping("/qnaBoardList")
	public ModelAndView qnaBoardList(@RequestParam int pg,ModelMap map){
		if(pg==0) pg=1;
		
		//DB-select 3블럭 5개씩
		List<QnaBoardDTO> list = qnaBoardService.getQnaBoardList(pg);
		
		//페이징
		qnaBoardPaging.setCurrentPage(pg);
		qnaBoardPaging.setPageBlock(3);
		qnaBoardPaging.setPageSize(10);
		qnaBoardPaging.makePagingHTML();
		
		map.put("list",list);
		map.put("pg",pg);
		map.put("qnaBoardPaging", qnaBoardPaging);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("display", "/qnaBoard/qnaBoardList.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}
	
	@RequestMapping("/qnaBoardView")
	public ModelAndView boardView(@RequestParam int seq,@RequestParam int pg){
	
		qnaBoardService.updateHit(seq);
		
		qnaBoardDTO = qnaBoardService.getArticle(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("qnaBoardDTO", qnaBoardDTO);
		mav.addObject("pg", pg);
		mav.addObject("display", "/qnaBoard/qnaBoardView.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}
	
	@RequestMapping("/qnaBoardReplyForm")
	public ModelAndView qnaBoardReplyForm(@RequestParam int pseq, @RequestParam int pg) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pseq", pseq);
		mav.addObject("pg", pg);
		mav.addObject("display","/qnaBoard/qnaBoardReplyForm.jsp");
		mav.setViewName("/main/index");

		return mav;
	}
	
	@RequestMapping("/qnaBoardReply")
	public ModelAndView qnaBoardReply(@ModelAttribute QnaBoardDTO qnaBoardDTO,HttpSession session){
		
		qnaBoardDTO.setId((String)session.getAttribute("memId"));
		qnaBoardDTO.setName((String)session.getAttribute("memName"));
		qnaBoardDTO.setEmail((String)session.getAttribute("memEmail"));
		
		qnaBoardService.replyArticle(qnaBoardDTO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("display", "/qnaBoard/qnaBoardWriteOk.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}

	@RequestMapping("/qnaBoardDirect")
	public ModelAndView qnaBoard(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/qnaBoard/qnaBoard.jsp");
		mav.setViewName("/main/index");

		return mav;
	}

	@RequestMapping("/qnaBoardDelete")
	public ModelAndView qnaBoardDelete(@RequestParam int seq){

		qnaBoardService.deleteQnaBoard(seq);

		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/qnaBoard/qnaBoardDelete.jsp");
		mav.setViewName("/main/index");

		return mav;
	}
}





