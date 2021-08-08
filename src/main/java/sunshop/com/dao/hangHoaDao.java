package sunshop.com.dao;

import java.util.List;

import sunshop.com.model.hangHoa;

public interface hangHoaDao {
	public List<hangHoa> getAllHangHoa();
	public void updateHangHoa(hangHoa hh);
	public void deleteHangHoa(int mshh);
	public void saveHangHoa(hangHoa hh);
	public hangHoa getHangHoaByMshh(int mshh);
	public List<hangHoa> getListHangHoaByMlhh(int mlhh);
	public List<hangHoa> search(String sach);

}
