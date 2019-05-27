package cn.ksdshpx.springmvc.controllers.annotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.ksdshpx.springmvc.beans.Student;
import cn.ksdshpx.springmvc.beans.User;

@SessionAttributes(value = {"student"})
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

	@RequestMapping(value = "/myajaxreturnlist.do")
	@ResponseBody
	public List<Student> doAjaxReturnList() {
		ArrayList<Student> list = new ArrayList<>();
		Student student = new Student();
		student.setName("王五");
		student.setAge(30);
		Student student2 = new Student();
		student2.setName("赵六");
		student2.setAge(25);
		list.add(student);
		list.add(student2);
		return list;
	}

	@RequestMapping("/testPathVariable/delete/{id}")
	public String testPathVariable(@PathVariable("id") Integer id) {
		System.out.println("testPathVariable:" + id);
		return "success";
	}

	@RequestMapping("/forwardOtherProcess")
	public ModelAndView forwardOtherProcess(@RequestParam("name") String name, @RequestParam("age") Integer age) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.setViewName("forward:doForward.do");
		return mv;
	}

	@RequestMapping("/doForward.do")
	public String doForward() {
		System.out.println("doForward()...");
		return "mysuccess";
	}

	@RequestMapping("/testRedirectReturnModelAndView")
	public ModelAndView testRedirectReturnModelAndView(@RequestParam("name") String name,
			@RequestParam("age") Integer age) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.setViewName("redirect:/success.jsp");
		return mv;
	}
	
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String,Object> map) {
		Student student = new Student("zhangSan", 15);
		map.put("student", student);
		return "mysuccess";
	}

	/*
	@ModelAttribute
	public void getUser(@RequestParam("id") String id, Map<String, Object> map) {
		if (id != null) {
			// 模拟根据id从数据库中取得数据
			User user = new User(id, "zhangSan", "123456", "zhangSan@163.com");
			System.out.println("从数据库中获取:" + user);
			map.put("user", user);
		}
	}
	*/

	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user) {
		System.out.println("testModelAttribute:" + user);
		return "mysuccess";
	}

	@RequestMapping("/testView")
	public String testView() {
		System.out.println("testView");
		return "helloView";
	}
}
