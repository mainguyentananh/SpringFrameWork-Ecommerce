package sunshop.com.controllerNoiBo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sunshop.com.model.loaiHangHoa;
import sunshop.com.service.loaiHangHoaService;

@Controller
@RequestMapping(value = "/noibo")
public class theLoaiSachController {

	@Autowired
	private loaiHangHoaService lhhs;
	
	@GetMapping(value = "/theloaisach")
	public String quanLyTheLoaiSach(Model md) {
		List<loaiHangHoa> l_theLoaiSach = lhhs.getAllLoaiHangHoa(); 
		md.addAttribute("l_theLoaiSach", l_theLoaiSach);
		return "theloaisach";
	}
	
	@GetMapping(value = "/theloaisach/xoa/{id}")
	public String xoaLoaiSach(@PathVariable(value = "id") Integer id) {
		lhhs.deleteLoaiHangHoa(id);
		return "redirect:/noibo/theloaisach";
	}

	@GetMapping(value = "/theloaisach/sua/{id}")
	public String suaTheLoai(@PathVariable(value = "id") Integer id,Model md) {
		md.addAttribute("theloai", lhhs.getLoaiHangHoaByMlhh(id));
		return "suatheloai";
	}
	
	@PostMapping(value = "/suatheloai")
	public String luuTheLoaiSachDaSua(@ModelAttribute(value = "theloai") loaiHangHoa lhh) {
		lhhs.updateLoaiHangHoa(lhh);
		return "redirect:/noibo/theloaisach"; 
	}
	
	@GetMapping(value = "/themtheloai")
	public String themTheLoai(Model md) {
		md.addAttribute("loaiSachMoi", new loaiHangHoa());
		return "themtheloai"; 
	}
	
	@PostMapping(value = "/luutheloai")
	public String luuTheLoaiSach(@ModelAttribute(value = "loaiSachMoi") loaiHangHoa lhh) {
		lhhs.saveLoaiHangHoa(lhh);
		return "redirect:/noibo/theloaisach"; 
	}
}
