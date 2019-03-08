package com.css.post.details;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/postlikes")
public class LikesController {
	@Autowired
	LikesDAO likesDAO;
	
	/*save a like details */
	@PostMapping("/like")
	public LikeModel createLike(@RequestBody LikeModel postlike)
	{
		return likesDAO.saveLike(postlike);
	}
	
	/*get all likes*/
	
	@GetMapping("/likes")
	public List<LikeModel> getAllLikes()
	{
		return likesDAO.findAll();
		
	}
	
	/* get a like details */
	
	@GetMapping("/likedby/{likeid}")
	public Optional<LikeModel> getlikeByid(@PathVariable(value="likeid") Long likeid)
	{
		
		return likesDAO.getLikedetailsByLikeid(likeid);
	}
	
/*calling one service from another */
	
	@GetMapping("/like/{id}")
	 public LikeModel getLikedetailsbyPost(@PathVariable(value="likeid") Long likeid){
		
		Map<String, Long> uriVariables=new HashMap<>();
		uriVariables.put("likeid", likeid);
		ResponseEntity<LikeModel> responseEntity = new RestTemplate().getForEntity("localhost:8000/socialposts/posts/{likeid}", 
				LikeModel.class, uriVariables);
		
		LikeModel response = responseEntity.getBody();
		
		return new LikeModel(likeid,response.getLikedby(),response.getId());
		
		
		
		
		
	}
	
	
	
}

