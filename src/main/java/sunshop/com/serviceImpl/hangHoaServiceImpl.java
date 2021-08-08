package sunshop.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sunshop.com.dao.hangHoaDao;
import sunshop.com.model.hangHoa;
import sunshop.com.service.hangHoaService;

@Service
@Transactional
public class hangHoaServiceImpl implements hangHoaService{
	
	@Autowired
	private hangHoaDao hhd;

	@Override
	public List<hangHoa> getAllHangHoa() {
		return hhd.getAllHangHoa();
	}

	@Override
	public void updateHangHoa(hangHoa hh) {
		hhd.updateHangHoa(hh);
	}

	@Override
	public void deleteHangHoa(int mshh) {
		hhd.deleteHangHoa(mshh);
	}

	@Override
	public void saveHangHoa(hangHoa hh) {
		hhd.saveHangHoa(hh);
	}

	@Override
	public hangHoa getHangHoaByMshh(int mshh) {
		return hhd.getHangHoaByMshh(mshh);
	}

	@Override
	public List<hangHoa> getListHangHoaByMlhh(int Mlhh) {
		return hhd.getListHangHoaByMlhh(Mlhh);
	}

	@Override
	public List<hangHoa> search(String sach) {
		return hhd.search(sach);
	}


	
	
}
