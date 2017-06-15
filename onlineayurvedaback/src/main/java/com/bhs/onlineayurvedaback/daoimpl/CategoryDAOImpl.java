package com.bhs.onlineayurvedaback.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bhs.onlineayurvedaback.dao.CategoryDAO;
import com.bhs.onlineayurvedaback.dto.Category;

@Repository("categoryDAO")

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired

	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// adding first category to the db

		category.setId(1);
		category.setName("Ayurvedic Medecines");
		category.setDescription("description for the medecines");
		category.setImageURL("CAT_1.jpg");

		categories.add(category); // adding our category into categories
									// ArrayList.

		// adding second category to the db
		category = new Category();
		category.setId(2);
		category.setName("Ayurvedic panchakarma");
		category.setDescription("description for the panchakrma");
		category.setImageURL("CAT_2.jpg");

		categories.add(category); // adding our category into categories
									// ArrayList.

		// adding tird category to the db
		category = new Category();
		category.setId(3);
		category.setName("Balm");
		category.setDescription("description for the balm");
		category.setImageURL("CAT_3.jpg");

		categories.add(category); // adding our category into categories
									// ArrayList.

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {

		// enhanced for loop

		for (Category category : categories) {
			if (category.getId() == id)
				return category;
		}

		return null; // if nothing is related to category find return nothing

	}

	@Override
	@Transactional
	public boolean add(Category category) {
		try {

			// add category to the table

			sessionFactory.getCurrentSession().persist(category);

			return true;

		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		//return false;
	}

}
