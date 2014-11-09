package noticeBoard.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import noticeBoard.bean.NoticeBoardDTO;
import noticeBoard.bean.NoticeBoardPaging;
import noticeBoard.service.NoticeBoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/noticeBoard")
public class NoticeBoardController {
	
	@Autowired
	private NoticeBoardService noticeBoardService;
	@Autowired
	private NoticeBoardDTO noticeBoardDTO;
	@Autowired
	private NoticeBoardPaging noticeBoardPaging;
	
	
	@RequestMapping("/noticeBoardWriteForm")
	public ModelAndView noticeBoardWriteForm(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/noticeBoard/noticeBoardWriteForm.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}
	
	@RequestMapping("/noticeBoardWrite")
	public ModelAndView noticeBoardWrite(@RequestParam Map<String,String> map,HttpSession session) throws Exception{
		//세션
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		String subject = map.get("subject");
		String content = map.get("content");
		
		
		//데이터 저장
		noticeBoardDTO.setId(id);
		noticeBoardDTO.setName(name);
		noticeBoardDTO.setEmail(email);
		noticeBoardDTO.setSubject(subject);
		noticeBoardDTO.setContent(content);
		
		//DB-insert
		noticeBoardService.insertNoticeBoard(noticeBoardDTO);
		
		//응답
		ModelAndView mav = new ModelAndView();
		mav.addObject("display", "/noticeBoard/noticeBoardWriteOk.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}
	
	@RequestMapping("/noticeBoardList")
	public ModelAndView noticeBoardList(@RequestParam int pg, 
			                      ModelMap map){
		if(pg==0) pg=1;
		
		//DB-select 3블럭 5개씩
		List<NoticeBoardDTO> list = noticeBoardService.getNoticeBoardList(pg);
		
		//페이징
		noticeBoardPaging.setCurrentPage(pg);
		noticeBoardPaging.setPageBlock(3);
		noticeBoardPaging.setPageSize(10);
		noticeBoardPaging.makePagingHTML();
		
		map.put("list",list);
		map.put("pg",pg);
		map.put("noticeBoardPaging", noticeBoardPaging);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("display", "/noticeBoard/noticeBoardList.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}
	
	@RequestMapping("/noticeBoardView")
	public ModelAndView boardView(@RequestParam int seq,@RequestParam int pg){
	
		noticeBoardService.updateHit(seq);
		
		noticeBoardDTO = noticeBoardService.getArticle(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeBoardDTO", noticeBoardDTO);
		mav.addObject("pg", pg);
		mav.addObject("display", "/noticeBoard/noticeBoardView.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}

	@RequestMapping("/noticeBoardDelete")
	public ModelAndView qnaBoardDelete(@RequestParam int seq){

		noticeBoardService.deleteNoticeBoard(seq);

		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/noticeBoard/noticeBoardDelete.jsp");
		mav.setViewName("/main/index");

		return mav;
	}
}
