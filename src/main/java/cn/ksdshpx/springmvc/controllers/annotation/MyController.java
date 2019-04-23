package cn.ksdshpx.springmvc.controllers.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.ksdshpx.springmvc.beans.Student;

@Controller
@RequestMapping("/springmvc")
public class MyController {
	@RequestMapping(value = "/myhello", method = { RequestMethod.POST, RequestMethod.GET }, params = { "name=zhangSan",
			"age!=12" })
	public ModelAndView doHello() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", "zhangSan");
		mv.addObject("age", "12");
		mv.setViewName("success");
		return mv;
	}

	@RequestMapping("/testReceiveParam")
	public String testReceiveParam(HttpServletRequest request,
			@RequestParam(value = "rname", required = false) String name,
			@RequestParam(value = "rage", required = false) Integer age) {
		System.out.println(name + ":" + age);
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		return "success";
	}

	@RequestMapping("/testRequestParamByObject")
	public String testRequestParamByObject(Student student, HttpServletRequest request) {
		String name = student.getName();
		Integer age = student.getAge();
		System.out.println(name + ":" + age);
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		return "success";
	}
}
