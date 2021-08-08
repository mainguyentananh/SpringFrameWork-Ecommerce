package sunshop.com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sunshop.com.dao.loaiHangHoaDao;
import sunshop.com.model.loaiHangHoa;

@Repository
public class loaiHangHoaDaoImpl implements loaiHangHoaDao{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<loaiHangHoa> getAllLoaiHangHoa() {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From loaiHangHoa";
		List<loaiHangHoa> l_loaiHangHoa = session.createQuery(hql,loaiHangHoa.class).list();
		return l_loaiHangHoa;
	}

	@Override
	public void updateLoaiHangHoa(loaiHangHoa lhh) {
		Session session = sessionfactory.getCurrentSession();
		session.update(lhh);	
	}

	@Override
	public void deleteLoaiHangHoa(int mlhh) {
		Session session = sessionfactory.getCurrentSession();
		session.delete(getLoaiHangHoaByMlhh(mlhh));
		
	}

	@Override
	public void saveLoaiHangHoa(loaiHangHoa lhh) {
		Session session = sessionfactory.getCurrentSession();
		session.save(lhh);
		
	}

	@Override
	public loaiHangHoa getLoaiHangHoaByMlhh(int mlhh) {
		Session session = sessionfactory.getCurrentSession();
		loaiHangHoa lhh = session.get(loaiHangHoa.class, mlhh);
		return lhh;
	}

}
