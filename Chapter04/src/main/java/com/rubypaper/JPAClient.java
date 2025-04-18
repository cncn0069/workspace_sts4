package com.rubypaper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rubypaper.dao.JPADao;

public class JPAClient {
	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("Chapter04");
		
		JPADao dao = new JPADao(emf);
		
		dao.addData(emf);
		dao.searchData(emf);
		dao.updateData(emf);
		dao.deleteData(emf);
		dao.jqlData(emf);
		
		emf.close();
	}
}
