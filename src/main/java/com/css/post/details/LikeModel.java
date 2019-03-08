package com.css.post.details;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="AllLikes")
@EntityListeners(AuditingEntityListener.class)

public class LikeModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long likeid;
	
	@NotBlank
	private String likedby;
	
	
	private Long id;

	public Long getLikeid() {
		return likeid;
	}

	public void setLikeid(Long likeid) {
		this.likeid = likeid;
	}

	public String getLikedby() {
		return likedby;
	}

	public void setLikedby(String likedby) {
		this.likedby = likedby;
	}

	public Long getId() {
		return id;
	}

	public LikeModel(Long likeid, @NotBlank String likedby, Long id) {
		super();
		this.likeid = likeid;
		this.likedby = likedby;
		this.id = id;
	}
	public LikeModel()
	{
		
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
