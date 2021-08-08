package sunshop.com.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import sunshop.com.model.hangHoa;

//scopedTarget.gioHangSession
@SessionScope
@Service
public class gioHangSession {
	@Autowired
	private hangHoaService hhs;
	
	Map<Integer,hangHoa> map = new HashMap<>();
	
	public void add(Integer id) {
		hangHoa p = map.get(id);
		if(p==null) {
			p = hhs.getHangHoaByMshh(id);
			p.setSoLuong(1);
			map.put(id, p);
		}else {
			p.setSoLuong(p.getSoLuong()+1);
		}
	}
	
	public void remove(Integer id) {
		map.remove(id);
	}
	
	public hangHoa getItem(Integer id) {
		return map.get(id);
	}
	
	
	public void clear() {
		map.clear();
	}
	
	public int getCount() {
		Collection<hangHoa> ps = this.getItems();
		int count = 0;
		for (hangHoa mp : ps) {
			count+=mp.getSoLuong();
		}
		return count;
	}
	
	
	public double getAmount() {
		Collection<hangHoa> ps = this.getItems();
		double thanhTien = 0;
		for (hangHoa mp : ps) {
			thanhTien+= (mp.getSoLuong() * mp.getGia() * (1-mp.getGiamGia()));
		}
		return thanhTien;
	}
	
	public Collection<hangHoa> getItems(){
		 return map.values();
	}
	
	
	
}
