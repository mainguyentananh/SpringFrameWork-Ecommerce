package sunshop.com.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sunshop.com.dao.chiTietDatHangDao;
import sunshop.com.model.chiTietDatHang;

@Repository
public class chiTietDatHangDaoImpl implements chiTietDatHangDao{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void saveChiTietDatHang(chiTietDatHang ctdh) {
		Session session = sessionfactory.getCurrentSession();
		session.save(ctdh);	
	}

	
}
