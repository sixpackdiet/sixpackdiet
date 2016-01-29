package com.sixpackdiet.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sixpackdiet.bean.FoodItem;
import com.sixpackdiet.dao.FoodItemDao;


@Repository
public class FoodItemDaoImpl implements FoodItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(FoodItem foodItem) {
		Session session = getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		try {
			System.out.println("---> "+foodItem.getName());
			System.out.println("---> "+foodItem.getCalories());
			System.out.println("---> "+foodItem.getQuantity());
			session.save(foodItem);
			tx.commit();
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
			System.out.println(ex.getMessage());	
		} finally {
			session.close();
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public FoodItem findFoodItemForId(int foodItemId) {
		Session session = getSessionFactory().openSession();
		Transaction tx =  session.beginTransaction();
		Query query = session.getNamedQuery("FoodItem.GetFoodItemForId");
		query.setInteger("id", foodItemId);
		FoodItem foodItem = (FoodItem)query.list().get(0);
		tx.commit();
		session.close();
		return foodItem;
	}

	@Override
	public void deleteFoodItem(FoodItem foodItem) {
		Session session = getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		try {
			System.out.println("---> "+foodItem.getCalories());
			System.out.println("---> "+foodItem.getName());
			session.delete(foodItem);
			tx.commit();
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
			System.out.println(ex.getMessage());	
		} finally {
			session.close();
		}
	}

	@Override
	public List<FoodItem> findAll() {
		Session session = getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		List<FoodItem> foodItems=null;
		Query query = session.createQuery("from FoodItem");
		foodItems =  (List<FoodItem>) query.list();
		tx.commit();
		session.close();

		return foodItems;
	}

}