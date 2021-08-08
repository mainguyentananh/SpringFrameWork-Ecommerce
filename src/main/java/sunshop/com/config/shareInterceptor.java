package sunshop.com.config;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import sunshop.com.model.loaiHangHoa;
import sunshop.com.service.loaiHangHoaService;

public class shareInterceptor implements HandlerInterceptor {

	@Autowired
	private loaiHangHoaService lhhs;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		List<loaiHangHoa> list_LoaiHangHoa = lhhs.getAllLoaiHangHoa();
		request.setAttribute("menu", list_LoaiHangHoa);
		return true;
	}

}
