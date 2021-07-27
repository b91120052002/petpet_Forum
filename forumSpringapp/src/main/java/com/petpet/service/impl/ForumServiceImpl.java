package com.petpet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petpet.model.ForumBean;
import com.petpet.repository.ForumRepository;
import com.petpet.service.ForumService;

@Service
@Transactional
public class ForumServiceImpl implements ForumService {
	
	@Autowired
	ForumRepository forumRepository;
	
	@Override
	public List<ForumBean>  findAll(){
		return forumRepository.findAll();
	}

	@Override
	public ForumBean findByTextId(Integer textId) {
		return forumRepository.findByTextId(textId);
	}

	@Override
	public void save(ForumBean fb) {
		forumRepository.save(fb);
		
	}

	@Override
	public ForumBean findById(Integer textId) {
		return forumRepository.findById(textId);
	}

	@Override
	public void delete(Integer textId) {
		forumRepository.delete(textId);		
	}

	@Override
	public ForumBean update(ForumBean fb) {
		
		return forumRepository.update(fb);
		
	}







}
