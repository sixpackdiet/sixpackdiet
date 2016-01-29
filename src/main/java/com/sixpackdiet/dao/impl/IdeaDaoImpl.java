package com.sixpackdiet.dao.impl;

import java.util.List;

import javax.persistence.NamedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sixpackdiet.bean.Idea;
import com.sixpackdiet.dao.IdeaDao;

@Repository
public class IdeaDaoImpl implements IdeaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveIdea(Idea idea) {
		Session session = getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		try {
			System.out.println("---> "+idea.getIdea1());
			System.out.println("---> "+idea.getIdea2());
			System.out.println("---> "+idea.getIdea3());
			System.out.println("---> "+idea.getTopic());
			session.save(idea);
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
	public List<Idea> findAll() {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		List<Idea> ideas=null;
		//Query query = session.getNamedQuery("Idea.findAllIdeas");
		Query query = session.createQuery("from Idea");
		ideas =  (List<Idea>) query.list();
		tx.commit();
		session.close();

		return ideas;
	}

	@Override
	public Idea findTopicForId(int id) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx =  session.beginTransaction();
		Query query = session.getNamedQuery("Idea.GetTopicForId");
		query.setInteger("id", id);
		Idea idea = (Idea)query.list().get(0);
		tx.commit();
		session.close();
		return idea;
	}

	@Override
	public void deleteIdea(Idea idea) {
		Session session = getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		try {
			System.out.println("---> "+idea.getIdea1());
			System.out.println("---> "+idea.getIdea2());
			System.out.println("---> "+idea.getIdea3());
			System.out.println("---> "+idea.getTopic());
			session.delete(idea);
			tx.commit();
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
			System.out.println(ex.getMessage());	
		} finally {
			session.close();
		}
		
	}
}