package sunshop.com.dao;

import java.util.List;

import sunshop.com.model.loaiHangHoa;

public interface loaiHangHoaDao {
	public List<loaiHangHoa> getAllLoaiHangHoa();
	public void updateLoaiHangHoa(loaiHangHoa lhh);
	public void deleteLoaiHangHoa(int mlhh);
	public void saveLoaiHangHoa(loaiHangHoa lhh);
	public loaiHangHoa getLoaiHangHoaByMlhh(int mlhh);
}
