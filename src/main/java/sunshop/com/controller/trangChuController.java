package sunshop.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sunshop.com.model.hangHoa;
import sunshop.com.service.gioHangSession;
import sunshop.com.service.hangHoaService;
import sunshop.com.service.loaiHangHoaService;
import sunshop.com.service.paginationService;

@Controller
public class trangChuController {
	
	@Autowired
	private hangHoaService hhs;
	
	@Autowired
	private loaiHangHoaService lhhs;
	
	@Autowired
	private gioHangSession session;
	
	@Autowired
	private paginationService pa;
	
	
	@RequestMapping(value = "/trangchu",method = RequestMethod.GET)
	public String trangChu(Model md,@RequestParam(value = "page") Optional<Integer> page) {
		int pageSize = 4;
		session.getCount();	
		List<hangHoa> list_product = pa.phanTrang(page.orElse(0),pageSize);
		
		List<Integer> total =new ArrayList<>();
		int count_page =(int)Math.ceil(pa.countIRecord()/pageSize)+1; 
		
		for (int i = 1; i <= count_page; i++) {
			total.add(i);
		}
		
		
		md.addAttribute("total", total);
		md.addAttribute("list_product", list_product);
		return "trangchu";
	}
	
	@RequestMapping(value = "/danhmuc/{mslh}",method = RequestMethod.GET)
	public String sachTheoDanhMuc(@PathVariable(value ="mslh") int id,Model md) {
		List<hangHoa> list_product = hhs.getListHangHoaByMlhh(id);
		String tenDanhMuc = lhhs.getLoaiHangHoaByMlhh(id).getTenLoaiHang();
		md.addAttribute("list_product", list_product);
		md.addAttribute("tenDanhMuc", tenDanhMuc);
		return "trangchu";
			
	}
	
	@RequestMapping(value = "/chitietsach/{mshh}",method = RequestMethod.GET)
	public String chiTietSach(@PathVariable(value ="mshh") int id,Model md) {
		hangHoa chiTietSach = hhs.getHangHoaByMshh(id);
		
		
		List<hangHoa> sachTuongTu = hhs.getListHangHoaByMlhh(chiTietSach.getMaSoLoaiHang().getId());
		int i = 0;
		while (i < sachTuongTu.size() ) {
			
			if(chiTietSach.getId() == sachTuongTu.get(i).getId())
			{
				sachTuongTu.remove(i);
				break;
			}
			i++;
		}
		md.addAttribute("chiTietSach", chiTietSach);
		md.addAttribute("sachTuongTu", sachTuongTu);
		return "chitietsach";
			
	}
	
	@RequestMapping(value = "/search",method = RequestMethod.POST)
	public String search(Model md,@RequestParam("sach") String sach) {
		List<hangHoa> list_product = hhs.search(sach);	
		md.addAttribute("list_product", list_product);
		return "trangchu";
	}

	
	
	@RequestMapping(value = "/giohang",method = RequestMethod.GET)
	public String gioHang(){
		return "giohang";
	}
	
}
