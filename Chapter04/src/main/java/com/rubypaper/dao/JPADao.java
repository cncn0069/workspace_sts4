package com.rubypaper.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Board2;

public class JPADao {
	private EntityManagerFactory emf;
	
	public JPADao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void addData(EntityManagerFactory emf) {
		
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		try {
			
		tx.begin();
			
			for(int i = 0; i < 10;i++) {
				
				Board board = new Board();
				board.setTitle("JPA 제목" + String.valueOf(i));
				board.setWriter("관리자" + String.valueOf(i));
				board.setContent("JPA 글 등록 잘 되네요" + String.valueOf(i));
				board.setCreateDate(new Date(0));
				board.setCnt(0L);
				//글 등록
				em.persist(board);
			}
			
		tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		em.close();
		
	}
	
	public void searchData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		
		try {
			Board searchBoard = em.find(Board.class, 1L);
			System.out.println("---> " + searchBoard.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		em.close();
	}
	
	public void jqlData(EntityManagerFactory emf) {
		
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select b from Board b order by b.seq desc";
		List<Board> boardList = 
				em.createQuery(jpql, Board.class).getResultList();
		
		for(Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
		
		
	}
	
	public void updateData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			
			tx.begin();
			
			Board board = em.find(Board.class, 2L);
			board.setTitle("검색한 게시글의 제목 수정");
				
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			tx.rollback();
			
		}finally {
			em.close();
		}
	}
	
	public void deleteData(EntityManagerFactory emf) {
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Board board = em.find(Board.class, 1L);
			em.remove(board);
			
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
		
		em.close();
		
		
		
		
	}
}
