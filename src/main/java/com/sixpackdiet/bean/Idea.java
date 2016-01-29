
package com.sixpackdiet.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@Entity
@NamedQuery (name="Idea.GetTopicForId", query="from Idea where id = :id")
public class Idea {
	@Id 
	
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	private String topic;
	private String idea1;
	private String idea2;
	private String idea3;
	private Date submitDate;
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getIdea1() {
		return idea1;
	}
	public void setIdea1(String idea1) {
		this.idea1 = idea1;
	}
	public String getIdea2() {
		return idea2;
	}
	public void setIdea2(String idea2) {
		this.idea2 = idea2;
	}
	public String getIdea3() {
		return idea3;
	}
	public void setIdea3(String idea3) {
		this.idea3 = idea3;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	
}