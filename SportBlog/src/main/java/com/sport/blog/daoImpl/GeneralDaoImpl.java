package com.sport.blog.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sport.blog.dao.GeneralDAO;
import com.sport.blog.util.HibernateUtil;

public abstract class GeneralDaoImpl<E> implements GeneralDAO<E> {

	private Class<E> elementClass;

	public GeneralDaoImpl(Class<E> elementClass) {
		this.elementClass = elementClass;

	}

	public void addElement(E element) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			session.save(element);
			transaction.commit();
		} finally {
			if ((session != null) && (session.isOpen())) {
				session.close();
			}
		}
	}

	public void updateElement(E element) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			session.update(element);
			transaction.commit();
		} finally {
			if ((session != null) && (session.isOpen())) {
				session.close();
			}
		}
	}

	public E getElementByID(Integer elementId) {
		Session session = null;
		E element = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			element = (E) session.get(elementClass, elementId);
		} finally {
			if ((session != null) && (session.isOpen())) {
				session.close();
			}
		}
		return element;
	}

	public List<E> getAllElements() {
		Session session = null;
		List<E> elements = new ArrayList<E>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			elements = session.createCriteria(elementClass).list();
		} finally {
			if ((session != null) && (session.isOpen())) {
				session.close();
			}
		}
		return elements;
	}

	public void deleteElement(E element) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(element);
			transaction.commit();
		} finally {
			if ((session != null) && (session.isOpen())) {
			}
		}
	}
}
