package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;

	@Override
	public List<Student> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.student");
		Query query = entityManager.createNativeQuery(sb.toString(), Student.class);
		@SuppressWarnings("unchecked")
		List<Student> resultset = query.getResultList();
		return resultset;
	}

	@Override
	public Student findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Student student = entityManager.find(Student.class, code);
		return student;
	}

	@Transactional
	public int save(Student s, Integer newRow) throws DataAccessException {
		try {
			if (newRow == 1)
				entityManager.persist(s);
			else
				entityManager.merge(s);
			entityManager.flush();
			return 1;
		} catch (Throwable e) {
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	@Transactional
	public int delete(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Student studentD = entityManager.find(Student.class, code);
		try {
			if (entityManager.contains(studentD)) {
				entityManager.remove(studentD);
			} else {
				entityManager.remove(entityManager.merge(studentD));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}

}