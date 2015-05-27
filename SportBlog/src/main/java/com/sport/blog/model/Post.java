package com.sport.blog.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="post")
public class Post {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String text;
	@ManyToMany (fetch = FetchType.LAZY)
	@JoinTable(name= "postAndHashtag", joinColumns = {@JoinColumn(name="hashtag_id")}, 
	inverseJoinColumns={@JoinColumn (name="post_id")})
	
	private List<HashTag> hashTags;
	//@OneToMany(targetEntity=Rating.class, fetch = FetchType.LAZY, mappedBy="post_id")
	//private List <Rating> ratings;
	//@OneToMany(targetEntity=Comment.class, fetch = FetchType.LAZY, mappedBy = "post_id")
	//private List <Comment> comments;
	//@ManyToOne()
	//@JoinColumn (name="user_id")
	//User user;
	
	
	public Post(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public List<HashTag> getHashTags() {
		return hashTags;
	}
	public void setHashTags(List<HashTag> hashTags) {
		this.hashTags = hashTags;
	}
	/*
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
*/
}
