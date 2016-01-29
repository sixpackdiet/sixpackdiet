package com.sixpackdiet.dao;

import java.util.List;

import com.sixpackdiet.bean.Idea;

public interface IdeaDao {
	public void saveIdea(Idea idea);
	
	public List<Idea> findAll();
	
	public Idea findTopicForId(int id);

	public void deleteIdea(Idea idea);
}
