package com.bhs.onlineayurvedaback.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bhs.onlineayurvedaback.dao.CartlineDAO;
import com.bhs.onlineayurvedaback.dto.CartLine;


@Repository("cartlineDAO")
@Transactional
public class CartLineDAOImpl implements CartlineDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CartLine> list(int cartid) {

		String selectCartItems="FROM CartLine WHERE cartid = :cartid ";

		Query query=sessionFactory.getCurrentSession().createQuery(selectCartItems,CartLine.class).setParameter("cartid", cartid);
		return query.getResultList();
		
		//		Query query = sessionFactory.getCurrentSession().createQuery(selectCartItems,CartLine.class).setParameter("cartid",cartid);
		//		return query.getResultList();

	
	}

	@Override
	public boolean add(CartLine cartline) {
		try{
			//Add new cartline to database
			sessionFactory.getCurrentSession().persist(cartline);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}	
		
	}
	
	@Override
	public boolean update(CartLine cartline) {
		try{
			//update single cartline
			sessionFactory.getCurrentSession().update(cartline);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(CartLine cartline) {
		try{
			//Deleting Product from cart
			sessionFactory.getCurrentSession().delete(cartline);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public CartLine ifExists(int cartId, int prodId) {
		String selectQuery = "FROM CartLine WHERE cartId = :cartId AND prodId = :prodId";

		try {
			
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,CartLine.class)
					.setParameter("cartId",cartId)
					.setParameter("prodId",prodId)
					.getSingleResult();
					
			
		} catch (Exception ex) {
		    ex.printStackTrace();
			return null;
		}
	
	}

	@Override
	public CartLine getById(int id) {
		try{
			return sessionFactory.getCurrentSession().get(CartLine.class,Integer.valueOf(id));	
			}
			catch(Exception ex){
				ex.printStackTrace();
				
			}
			return null;
	}

	
}
