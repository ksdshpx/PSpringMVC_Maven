package cn.ksdshpx.springmvc.controllers.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/springmvc")
public class MyController {
	@RequestMapping("/myhello.do")
	public ModelAndView doHello() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", "zhangSan");
		mv.addObject("age","12");
		mv.setViewName("success");
		return mv;
	}
}
