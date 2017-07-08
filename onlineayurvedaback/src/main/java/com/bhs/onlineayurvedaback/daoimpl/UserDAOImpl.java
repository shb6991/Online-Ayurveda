package com.bhs.onlineayurvedaback.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bhs.onlineayurvedaback.dao.UserDAO;
import com.bhs.onlineayurvedaback.dto.Address;
import com.bhs.onlineayurvedaback.dto.Cart;
import com.bhs.onlineayurvedaback.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> list() {
		String selectAllUsers = "FROM User";
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllUsers, User.class);
		return query.getResultList();

	}
	

	@Override
	public boolean addUser(User user) {
		try {

			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean addAddress(Address address) {

		try {

			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateCart(Cart cart) {
		try {

			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public User getByEmail(String email) {
		
		String selectQuery = "FROM User WHERE email = :email";
		
		try{
			
			return sessionFactory.getCurrentSession().createQuery(selectQuery, User.class).setParameter("email", email)
					.getSingleResult();
		}
		
		catch(Exception ex){
			//ex.printStackTrace(); 
			return null;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND billing = :billing";
		
		
		try{
			
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class).setParameter("user", user).setParameter("billing", true)
					.getSingleResult();
		}
		
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}
	
	
	
	

	@Override
	public List<Address> listShippingAddresses(User user) {
		
		String selectQuery = "FROM Address WHERE user = :user AND shipping = :shipping";
		
		
		try{
			
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class).setParameter("user", user).setParameter("shipping", true)
					.getResultList();
		}
		
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}


	@Override
	public User getById(int userId) {
		
		String selectQuery = "FROM User WHERE id = :userId";
		
		try{
			return sessionFactory.getCurrentSession().createQuery(selectQuery, User.class).setParameter("userId", userId).getSingleResult();
			
		}
		catch (Exception ex) {
		
			ex.printStackTrace();
			return null;
		}
		
		
	}


	@Override
	public Cart getCartById(int cartId) {
		String selectQuery = "FROM Cart WHERE id = :cartId";

		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Cart.class).setParameter("cartId",cartId)
					.getSingleResult();
		} catch (Exception ex) {
			 ex.printStackTrace();
			return null;
		}
	}	
	
}
