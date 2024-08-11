package dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Appuser;
import util.*;

public class UserDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();

	public boolean validateUsername(String username) {
		String hql = "select username from Appuser user where username = :uname";
		Query query = session.createQuery(hql);
		query.setString("uname", username);
		Object results = query.uniqueResult();

		if (results != null) {
			return true;
		} else
			return false;
	}

	public Map<String, String> saveUser(Appuser appuser) throws Exception {
		Map<String, String> map = new HashMap<>();
		try {
			if (validateUsername(appuser.getUsername())) {
				map.put("message", "User name already exist!");
				map.put("result", "F");
				return map;
			}

			session.beginTransaction();

			session.save(appuser);
			System.out.println("Appuser save successfully = " + appuser);
			closeTransaction(session);
			map.put("result", "S");
		} catch (Exception e) {
			map.put("message", e.getMessage());
			map.put("result", "F");
		}
		return map;
	}

	public void closeTransaction(Session session) {
		session.getTransaction().commit();
		session.close();
	}

}