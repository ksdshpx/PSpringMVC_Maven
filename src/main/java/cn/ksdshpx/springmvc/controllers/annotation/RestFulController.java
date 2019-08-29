package cn.ksdshpx.springmvc.controllers.annotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.ksdshpx.springmvc.beans.Book;
import cn.ksdshpx.springmvc.beans.Book2;
import cn.ksdshpx.springmvc.beans.Person;

@RestController
public class RestFulController {
	@PostMapping("book/doRequestBody")
	public String doRequestBody(@RequestBody String body) {
		System.out.println("获取request中的请求体:" + body);
		return body;
	}

	@PostMapping("book/requestbodyxml")
	public String doRequestBodyXml(@RequestBody Book book) {
		System.out.println("接收的xml数据为:" + book);
		return book.toString();
	}

	@PostMapping("book/requestbodyjson")
	public String doRequestBodyJson(@RequestBody Book2 book) {
		System.out.println("接收的Json数据为:" + book);
		return book.toString();
	}
	
	@GetMapping(value = "book/outxml",produces = "application/xml;charset=UTF-8")
	public Person outXml() {
		Person person = new Person();
		person.setName("张三");
		person.setAge(30);
		return person;
	}
	
	@GetMapping(value = "book/outjson",produces = "application/json;charset=UTF-8")
	public Person outJson() {
		Person person = new Person();
		person.setName("张三");
		person.setAge(30);
		return person;
	}
}
