package com.css.post.details;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesDAO {
	@Autowired
	 LikeRepo likeRepo;
	
	/*save a Like */
	
	public LikeModel saveLike(LikeModel likes)
	{
		return likeRepo.save(likes);
		
	}
	
	/*search all likes */
	
	public List<LikeModel> findAll()
	{
		return likeRepo.findAll();
	}
	
	
	/* get likes for a particular Like */
	
	public Optional<LikeModel> getLikedetailsByLikeid(Long likeid)
	{
		return likeRepo.findById(likeid);
	}
	
	
	/* delete or unlike a post */
	
	 public void delete(LikeModel like)
	 {
		 likeRepo.delete(like);
	 }
	

}
