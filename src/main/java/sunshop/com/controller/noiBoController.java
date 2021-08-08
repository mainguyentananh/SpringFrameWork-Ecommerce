package sunshop.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/noibo")
public class noiBoController {

	@GetMapping(value = "/trangchu")
	public String trangChu() {
		return "trangchu-ad";
	}
	
	
}
