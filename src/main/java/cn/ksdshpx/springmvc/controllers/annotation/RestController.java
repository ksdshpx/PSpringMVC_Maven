package cn.ksdshpx.springmvc.controllers.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author peng.x
 * @date 2019年7月28日 上午9:08:29
 */
@Controller
public class RestController {

	@RequestMapping(value = "/some")
	@ResponseBody
	public String doSome() {
		System.out.println("RestController.doSome()...");
		return "RestController doSome...";
	}

	@RequestMapping("/book/{bookId}")
	@ResponseBody
	public String doPathVariable(@PathVariable("bookId") Integer id) {
		System.out.println("book id:" + id);
		return "book id:" + id;
	}
}
