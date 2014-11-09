package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/main/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("display", "/template/body.jsp");
		
		return mav;
	}
	
	@RequestMapping("/introduce/about")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/main/index");
		mav.addObject("display", "/introduce/about.jsp");
		
		return mav;
	}
	
	@RequestMapping("/introduce/vision")
	public ModelAndView vision() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/main/index");
		mav.addObject("display", "/introduce/vision.jsp");
		
		return mav;
	}
	
}
