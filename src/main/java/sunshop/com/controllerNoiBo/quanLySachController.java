package sunshop.com.controllerNoiBo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import sunshop.com.model.hangHoa;
import sunshop.com.service.hangHoaService;
import sunshop.com.service.loaiHangHoaService;
import sunshop.com.service.paginationService;

@Controller
@RequestMapping(value = "/noibo")
public class quanLySachController {
	
	@Autowired
	private hangHoaService hhs;
	
	@Autowired
	private loaiHangHoaService lhhs;
	
	@Autowired
	private ServletContext app;
	
	@Autowired
	private paginationService pa;
	

	@GetMapping(value = "/quanlysach")
	public String quanLySach(Model md,@RequestParam(value = "page" ) Optional<Integer> page) {
		int pageSize = 4;
		List<hangHoa> l_sach = pa.phanTrang(page.orElse(0),pageSize);
		List<Integer> total =new ArrayList<>();
		int count_page =(int)Math.ceil(pa.countIRecord()/pageSize)+1; 
		for (int i = 1; i <= count_page; i++) {
			total.add(i);
		}
		md.addAttribute("total", total);
		md.addAttribute("l_sach", l_sach);
		return "quanlysach";
	}
	
	@GetMapping(value = "/themsach")
	public String themSach(Model md) {
		md.addAttribute("theloai", lhhs.getAllLoaiHangHoa());
		md.addAttribute("n_sach", new hangHoa());
		return "themsach";
	}
	
	@PostMapping(value = "/luusach",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public String luuSach(@ModelAttribute(value ="n_sach") hangHoa n_sach,@RequestParam(value = "file_hinh") MultipartFile file) throws IllegalStateException, IOException {
			
		 if(file.isEmpty()) {
			 n_sach.setHinh("444.png"); 
		 }else {
			 //transferto se tu tim. neu co roi n se khong them anh
			 String path = app.getRealPath("/resources/images/product"); 
			 File f = new File(path,file.getOriginalFilename());
			 file.transferTo(f);
			 n_sach.setHinh(f.getName());
		 }
		hhs.saveHangHoa(n_sach);
		return "redirect:/noibo/quanlysach";
	}
	
	
	@GetMapping(value = "/quanlysach/xoa/{id}")
	public String xoaSach(@PathVariable(value = "id") Integer id) {
		//Xóa file trên server - kiem tra neu no la hinh tam 444 thì khoi xoa
		if(!hhs.getHangHoaByMshh(id).getHinh().equalsIgnoreCase("444.png")) {
			String path = app.getRealPath("/resources/images/product"); 
			File f = new File(path,hhs.getHangHoaByMshh(id).getHinh());
			f.delete();
		}
		hhs.deleteHangHoa(id);
		return "redirect:/noibo/quanlysach";
	}
	
	
	@GetMapping(value = "/quanlysach/sua/{id}")
	public String suaSach(@PathVariable(value = "id") Integer id,Model md) {
		md.addAttribute("theloais", lhhs.getAllLoaiHangHoa());
		md.addAttribute("s_sach", hhs.getHangHoaByMshh(id));
		return "suasach";
	}
	
	
	@PostMapping(value = "/suasach",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public String luuSuaSach(@ModelAttribute(value ="s_sach") hangHoa s_sach,@RequestParam(value = "file_hinh") MultipartFile file) throws IllegalStateException, IOException {
			
		 if(!file.isEmpty()) {
			 String path = app.getRealPath("/resources/images/product"); 
			 File f = new File(path,file.getOriginalFilename());
			 file.transferTo(f);
			 
			 if(!s_sach.getHinh().equalsIgnoreCase("444.png")) {
				 File xoaAnh = new File(path,s_sach.getHinh());
				 xoaAnh.delete();
			 }
			 
			 s_sach.setHinh(f.getName());
		 }
		hhs.updateHangHoa(s_sach);
		return "redirect:/noibo/quanlysach";
	}
	
	
	
}
