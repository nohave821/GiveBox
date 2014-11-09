package member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController{
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberDTO memberDTO;
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String id,@RequestParam String pwd,HttpSession session){
		
		MemberDTO memberDTO = memberService.loginArticle(id,pwd);
		
		if(memberDTO!=null){

			session.setAttribute("memId", id);
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			session.setMaxInactiveInterval(10 * 60);
			
			return new ModelAndView("redirect:/main/index.do");
		}else{
			ModelAndView mav = new ModelAndView();
			mav.addObject("display","/member/loginFail.jsp");
			mav.setViewName("/main/index");
			return mav;
		}
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session){
		session.invalidate();
		
		return new ModelAndView("redirect:/main/index.do");
	}
	
	@RequestMapping("/writeForm")
	public ModelAndView writeForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/main/index");
		mav.addObject("display", "/member/writeForm.jsp");
		
		return mav;
	}
	
	@RequestMapping("write")
	public ModelAndView write(@ModelAttribute MemberDTO memberDTO,HttpSession session) throws Exception{

		memberService.insertMember(memberDTO);
		

		ModelAndView mav = new ModelAndView();
		mav.addObject("display", "/member/writeOk.jsp");
		mav.setViewName("/main/index");
		
		return mav;
	}
	
	@RequestMapping("/checkId")
	public ModelAndView checkId(String id){
		
		String check = memberService.checkId(id);
		ModelAndView mav = new ModelAndView();
		
		if(check!=null){
			mav.addObject("id",id);
			mav.setViewName("/member/checkIdFail");
		}else{
			mav.addObject("id",id);
			mav.setViewName("/member/checkIdOk");
		}
		
		return mav;
	}
	
	@RequestMapping("/checkPost")
	public ModelAndView checkPost(String dong){
		
		List<ZipcodeDTO> list=null;
		if(dong != null &&  !dong.equals(""))  
			list = memberService.getZipcodeList(dong);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("/member/checkPost");
		return mav;
	}
	
}









