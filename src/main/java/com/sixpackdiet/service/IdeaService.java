package com.sixpackdiet.service;

import java.util.List;

import com.sixpackdiet.bean.Idea;

public interface IdeaService {
	public void saveIdea(Idea idea);
	public void deleteIdea(Idea idea);
	public List<Idea> findAll();
	public Idea findTopicForId(int topicId);
}
