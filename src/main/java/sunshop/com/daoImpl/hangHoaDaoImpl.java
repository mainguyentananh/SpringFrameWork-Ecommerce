package sunshop.com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sunshop.com.dao.hangHoaDao;
import sunshop.com.model.hangHoa;

@Repository
public class hangHoaDaoImpl implements hangHoaDao{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<hangHoa> getAllHangHoa() {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From hangHoa";
		List<hangHoa> l_hangHoa = session.createQuery(hql,hangHoa.class).list();
		return l_hangHoa;
	}
	
	@Override
	public List<hangHoa> getListHangHoaByMlhh(int mlhh) {
		Session session = sessionfactory.getCurrentSession();
		List<hangHoa> l_hangHoa = session.createQuery("from hangHoa where maSoLoaiHang.id=:mlhh",hangHoa.class).setParameter("mlhh",mlhh).list();
		return l_hangHoa;
	}

	@Override
	public void updateHangHoa(hangHoa hh) {
		Session session = sessionfactory.getCurrentSession();
		session.update(hh);	
	}

	@Override
	public void deleteHangHoa(int mshh) {
		Session session = sessionfactory.getCurrentSession();
		session.delete(getHangHoaByMshh(mshh));	
	}

	@Override
	public void saveHangHoa(hangHoa hh) {
		Session session = sessionfactory.getCurrentSession();
		session.save(hh);	
	}

	@Override
	public hangHoa getHangHoaByMshh(int mshh) {
		Session session = sessionfactory.getCurrentSession();
		hangHoa hh = session.get(hangHoa.class, mshh);
		return hh;
	}

	@Override
	public List<hangHoa> search(String sach) {
		Session session = sessionfactory.getCurrentSession();
		List<hangHoa> l_hangHoa = session.createQuery("from hangHoa where tenHangHoa like  :sach",hangHoa.class)
				.setParameter("sach",'%'+sach+'%').list();
		return l_hangHoa;
	}

	


}
