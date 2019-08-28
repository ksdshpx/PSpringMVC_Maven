package cn.ksdshpx.springmvc.controllers.annotation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFulController {
	@PostMapping("book/doRequestBody")
	public String doRequestBody(@RequestBody String body) {
		System.out.println("获取request中的请求体:" + body);
		return body;
	}
}
