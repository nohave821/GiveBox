package projectBoard.controller;

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

import projectBoard.bean.ProjectBoardDTO;
import projectBoard.bean.ProjectBoardPaging;
import projectBoard.service.ProjectBoardService;

@Controller
@RequestMapping("/projectBoard")
public class ProjectBoardController {
	
	@Autowired
	private ProjectBoardService projectBoardService;
	@Autowired
	private ProjectBoardDTO projectBoardDTO;
	@Autowired
	private ProjectBoardPaging projectBoardPaging;

	@RequestMapping("/projectBoardWriteForm")
	public ModelAndView projectBoardWriteForm(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/projectBoard/projectBoardWriteForm.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}
	
	@RequestMapping("/projectBoardWrite")
	public ModelAndView projectBoardWrite(@ModelAttribute ProjectBoardDTO projectBoardDTO,@RequestParam MultipartFile img,HttpSession session) throws Exception{
		
		String fileName = img.getOriginalFilename();
//		String filePath = "/home/hosting_users/nohave821/tomcat/webapps/ROOT/storage";
		String filePath = "C:/dev/workspace/GiveBox/WebContent/storage";

		File destFile = new File(filePath,fileName);

		FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(destFile));

		projectBoardDTO.setImage1(fileName);
		
		projectBoardDTO.setId((String)session.getAttribute("memId"));
		
		projectBoardService.insertProjectBoard(projectBoardDTO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("display", "/projectBoard/projectBoardWriteOK.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}
	
	@RequestMapping("/projectBoardList")
	public ModelAndView projectBoardList(@RequestParam int pg,ModelMap map) {
		
		if(pg==0) pg=1;
		
		List<ProjectBoardDTO> list = projectBoardService.getProjectBoardList(pg);
		
		projectBoardPaging.setCurrentPage(pg);
		projectBoardPaging.setPageBlock(3);
		projectBoardPaging.setPageSize(10);
		projectBoardPaging.makePagingHTML();
		
		map.put("list", list);
		map.put("pg",pg);
		map.put("projectBoardPaging", projectBoardPaging);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("display", "/projectBoard/projectBoardList.jsp");
		mav.setViewName("/main/index");
		return mav;
	}
	
	@RequestMapping("/projectBoardView")
	public ModelAndView projectboardView(@RequestParam int seq,@RequestParam int pg){
	
		projectBoardService.updateHit(seq);
		
		projectBoardDTO = projectBoardService.getArticle(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectBoardDTO", projectBoardDTO);
		mav.addObject("pg", pg);
		mav.addObject("display", "/projectBoard/projectBoardView.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}

	@RequestMapping("/projectBoardDelete")
	public ModelAndView projectBoardDelete(@RequestParam int seq){

		projectBoardService.deleteProjectBoard(seq);

		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/projectBoard/projectBoardDelete.jsp");
		mav.setViewName("/main/index");

		return mav;
	}

	@RequestMapping("/projectBoardGive")
	public ModelAndView projectBoardGive(int startmoney,int seq){

		projectBoardService.giveProjectBoard(startmoney, seq);

		return new ModelAndView("redirect:/projectBoard/projectBoardList.do?pg=1");
	}
}
