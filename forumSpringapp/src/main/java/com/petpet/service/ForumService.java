package com.petpet.service;

import java.util.List;

import com.petpet.model.ForumBean;

public interface ForumService {

	List<ForumBean> findAll();

	ForumBean findByTextId(Integer textId);

	void save(ForumBean fb);

	ForumBean findById(Integer textId);
	
	void delete(Integer textId);

	ForumBean update(ForumBean fb);

}