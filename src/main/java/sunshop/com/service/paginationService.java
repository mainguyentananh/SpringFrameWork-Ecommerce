package sunshop.com.service;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sunshop.com.model.hangHoa;

@Service
@Transactional
public class paginationService {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	public List<hangHoa> phanTrang(Integer item,Integer pageSize){
		Session session = sessionfactory.getCurrentSession();
		item=pageSize*(item-1);
		if(item <= 1) {
			item = 0; 
		}
		List<hangHoa> list  = session.createQuery("from hangHoa",hangHoa.class)
				.setFirstResult(item).setMaxResults(pageSize).list();
		return list;
	}
	
	
	public Long countIRecord() {
		Session session = sessionfactory.getCurrentSession();
		String hql = "select count(*) from hangHoa";
		Long count = (Long) session.createQuery(hql).uniqueResult();
		return count;
	}
	
	
}
