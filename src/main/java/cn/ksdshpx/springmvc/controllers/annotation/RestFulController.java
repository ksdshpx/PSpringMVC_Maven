package cn.ksdshpx.springmvc.controllers.annotation;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import cn.ksdshpx.springmvc.beans.Book;
import cn.ksdshpx.springmvc.beans.Book2;
import cn.ksdshpx.springmvc.beans.Human;
import cn.ksdshpx.springmvc.beans.Person;
import cn.ksdshpx.springmvc.beans.View;

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

	@GetMapping(value = "book/outxml", produces = "application/xml;charset=UTF-8")
	public Person outXml() {
		Person person = new Person();
		person.setName("张三");
		person.setAge(30);
		return person;
	}

	@GetMapping(value = "book/outjson", produces = "application/json;charset=UTF-8")
	public Person outJson() {
		Person person = new Person();
		person.setName("张三");
		person.setAge(30);
		return person;
	}

	@GetMapping(value = "book/outjson2", produces = "application/json;charset=UTF-8")
	@JsonView(View.Summary.class)
	public Human outJson2() {
		Human human = new Human();
		human.setName("李四");
		human.setAge(20);
		human.setSex("男");
		human.setWeight(80);
		human.setBirthday(new Date());
		return human;
	}

	@GetMapping("book/outstatus")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteBook() {
		System.out.println("deleteBook()...");
	}
}
