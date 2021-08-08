package sunshop.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class adminController {

	@GetMapping(value = "/trangchu")
	public String trangChu() {
		return "trangchu-ad";
	}
	
	@GetMapping(value = "/403")
	public String accessDenied() {
	    return "403";
	  }
}
