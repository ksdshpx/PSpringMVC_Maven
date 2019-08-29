package cn.ksdshpx.springmvc.controllers.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author peng.x
 * @date 2019年7月28日 上午9:08:29
 */
@Controller
public class RestController {

	// @RequestMapping(value = "/some")
	@GetMapping("/some")
	@ResponseBody
	public String doSome() {
		System.out.println("RestController.doSome()...");
		return "RestController doSome...";
	}

	@RequestMapping("/book/{bookId}/{isbn}")
	@ResponseBody
	public String doPathVariable(@PathVariable("bookId") Integer id, @PathVariable("isbn") String isbn) {
		System.out.println("book id:" + id + ",isbn:" + isbn);
		return "book id:" + id + ",isbn:" + isbn;
	}

	@RequestMapping(value = "/spring/{name:[a-z]+}-{version:\\d\\.\\d}")
	@ResponseBody
	public String doRegExpression(@PathVariable("name") String name, @PathVariable("version") String version) {
		System.out.println("name:" + name + ",version:" + version);
		return "name:" + name + ",version:" + version;
	}

	// @RequestMapping(value = "book/doput", method = RequestMethod.PUT)
	@PutMapping(value = "book/doput",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String doPut() {
		return "处理put请求";
	}

	// @RequestMapping(value = "book/dodelete", method = RequestMethod.DELETE)
	@DeleteMapping(value = "book/dodelete",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String doDelete() {
		return "处理delete请求";
	}
}
