package com.petpet.repository;

import java.util.List;

import com.petpet.model.ForumBean;

public interface ForumRepository {

	List<ForumBean> findAll();

	ForumBean findByTextId(Integer textId);

	void save(ForumBean fb);

	ForumBean findById(Integer textId);
	
	void delete(Integer textId);

	ForumBean update(ForumBean fb);



}