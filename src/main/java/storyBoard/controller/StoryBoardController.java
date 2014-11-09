package storyBoard.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import storyBoard.bean.StoryBoardDTO;
import storyBoard.bean.StoryBoardPaging;
import storyBoard.service.StoryBoardService;


@Controller
@RequestMapping("/storyBoard")
public class StoryBoardController {
	
	@Autowired
	private StoryBoardService storyBoardService;
	@Autowired
	private StoryBoardDTO storyBoardDTO;
	@Autowired
	private StoryBoardPaging storyBoardPaging;

	@RequestMapping("/storyBoardWriteForm")
	public ModelAndView storyBoardWriteForm(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/storyBoard/storyBoardWriteForm.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}
	
	@RequestMapping("/storyBoardWrite")
	public ModelAndView storyBoardWrite(@ModelAttribute StoryBoardDTO storyBoardDTO,@RequestParam MultipartFile img,HttpSession session) throws Exception{
		
		String fileName = img.getOriginalFilename();
//		String filePath = "/home/hosting_users/nohave821/tomcat/webapps/ROOT/storage";
		String filePath = "C:/dev/workspace/GiveBox/WebContent/storage";

		File destFile = new File(filePath,fileName);
		

		FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(destFile));

		storyBoardDTO.setImage1(fileName);
		
		storyBoardDTO.setId((String)session.getAttribute("memId"));
		
		storyBoardService.insertStoryBoard(storyBoardDTO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("display", "/storyBoard/storyBoardWriteOK.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}
	
	@RequestMapping("/storyBoardList")
	public ModelAndView storyBoardList(@RequestParam int pg, 
									   ModelMap map) {
		
		if(pg==0) pg=1;
		
		List<StoryBoardDTO> list = storyBoardService.getStoryBoardList(pg);
		
		storyBoardPaging.setCurrentPage(pg);
		storyBoardPaging.setPageBlock(3);
		storyBoardPaging.setPageSize(10);
		storyBoardPaging.makePagingHTML();
		
		map.put("list", list);
		map.put("pg",pg);
		map.put("storyBoardPaging", storyBoardPaging);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("display", "/storyBoard/storyBoardList.jsp");
		mav.setViewName("/main/index");
		return mav;
	}
	
	@RequestMapping("/storyBoardView")
	public ModelAndView storyboardView(@RequestParam int seq,@RequestParam int pg){
	
		storyBoardService.updateHit(seq);
		
		storyBoardDTO = storyBoardService.getArticle(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("storyBoardDTO", storyBoardDTO);
		mav.addObject("pg", pg);
		mav.addObject("display", "/storyBoard/storyBoardView.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}

	@RequestMapping("/storyBoardDelete")
	public ModelAndView qnaBoardDelete(@RequestParam int seq){

		storyBoardService.deleteStoryBoard(seq);

		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/storyBoard/storyBoardDelete.jsp");
		mav.setViewName("/main/index");

		return mav;
	}

	@RequestMapping("/storyBoardGive")
	public ModelAndView storyBoardGive(int startmoney,int seq){

		storyBoardService.giveStoryBoard(startmoney, seq);

		return new ModelAndView("redirect:/storyBoard/storyBoardList.do?pg=1");
	}
}
