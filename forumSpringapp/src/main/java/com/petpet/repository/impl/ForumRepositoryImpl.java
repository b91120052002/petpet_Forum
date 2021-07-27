package com.petpet.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petpet.model.ForumBean;
import com.petpet.repository.ForumRepository;

@Repository
public class ForumRepositoryImpl implements ForumRepository {

	@Autowired
	EntityManager entityManager;

	
	
	@Override
	public List<ForumBean> findAll() {
		String hql = "FROM ForumBean ORDER BY create_time DESC";
		return entityManager.createQuery(hql, ForumBean.class).getResultList();
	}

	@Override
	public ForumBean findByTextId(Integer textId) {
		String hql = "FROM ForumBean t WHERE t.textId = :textId";
		ForumBean fb = null;
		try {
			fb = entityManager.createQuery(hql, ForumBean.class).setParameter("textId", textId).getSingleResult();
		} catch (NoResultException e) {
			;
		} catch (NonUniqueResultException e) {
			;
		}
		return fb;
	}

	@Override
	public void save(ForumBean fb) {
		entityManager.persist(fb);

	}

	@Override
	public ForumBean findById(Integer textId) {
		return entityManager.find(ForumBean.class, textId);
	}
	

	
	@Override
	public ForumBean update(ForumBean fb) {
		System.out.println("fb ="+fb);
		ForumBean result  = entityManager.find(ForumBean.class, fb.getTextId());
		if(result!=null) {
			result.setTitle(fb.getTitle());
			result.setText(fb.getText());
			result.setText_sub(fb.getText_sub());
			result.setText_type(fb.getText_type());
			
		}		
		System.out.println("result= "+result);
		return entityManager.merge(result);
	}
	
	@Override
	public void delete(Integer textId) {
		ForumBean fb = new ForumBean();
		fb.setTextId(textId);
		
		if (entityManager.contains(fb)) {
			entityManager.remove(fb);
		} else {
			entityManager.remove(entityManager.merge(fb));
		}
		
	}
}