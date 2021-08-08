package sunshop.com.service;

import java.util.List;

import sunshop.com.model.hangHoa;

public interface hangHoaService {
	public List<hangHoa> getAllHangHoa();
	public void updateHangHoa(hangHoa hh);
	public void deleteHangHoa(int mshh);
	public void saveHangHoa(hangHoa hh);
	public hangHoa getHangHoaByMshh(int mshh);
	public List<hangHoa> getListHangHoaByMlhh(int Mlhh);
	public List<hangHoa> search(String sach);

}
