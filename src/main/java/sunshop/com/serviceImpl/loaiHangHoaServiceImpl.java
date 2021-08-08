package sunshop.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sunshop.com.dao.loaiHangHoaDao;
import sunshop.com.model.loaiHangHoa;
import sunshop.com.service.loaiHangHoaService;

@Service
@Transactional
public class loaiHangHoaServiceImpl implements loaiHangHoaService{

	@Autowired
	private loaiHangHoaDao lhhd;

	@Override
	public List<loaiHangHoa> getAllLoaiHangHoa() {
		return lhhd.getAllLoaiHangHoa();
	}

	@Override
	public void updateLoaiHangHoa(loaiHangHoa lhh) {
		lhhd.updateLoaiHangHoa(lhh);
	}

	@Override
	public void deleteLoaiHangHoa(int mlhh) {
		lhhd.deleteLoaiHangHoa(mlhh);
	}

	@Override
	public void saveLoaiHangHoa(loaiHangHoa lhh) {
		lhhd.saveLoaiHangHoa(lhh);
	}

	@Override
	public loaiHangHoa getLoaiHangHoaByMlhh(int mlhh) {
		return lhhd.getLoaiHangHoaByMlhh(mlhh);
	}
	
}
