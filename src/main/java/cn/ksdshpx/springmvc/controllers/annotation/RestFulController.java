package cn.ksdshpx.springmvc.controllers.annotation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.ksdshpx.springmvc.beans.Book;

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
}
