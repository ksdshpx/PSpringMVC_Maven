package cn.ksdshpx.springmvc.controllers.annotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	@RequestMapping(value = "/myajax.do")
	public void doAjax(HttpServletResponse response, String name, Integer age) throws IOException {
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		// JackSon将对象转换为json字符串
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(student);
		System.out.println(json);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		out.close();
	}

	@RequestMapping(value = "/myajaxbyfastjson.do")
	public void doAjaxByFastJson(HttpServletResponse response, String name, Integer age) throws IOException {
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		String json = JSONObject.toJSONString(student);
		System.out.println(json);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		out.close();
	}

	@RequestMapping(value = "/myajaxreturnstring.do", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String doAjaxByFastJson(String name, Integer age) throws IOException {
		return "Hello HttpMessageConverter:" + name;
	}

	@RequestMapping(value = "/myajaxreturnstu.do")
	@ResponseBody
	public Student doAjaxReturnStu() {
		Student student = new Student();
		student.setName("王五");
		student.setAge(30);
		return student;
	}
}
