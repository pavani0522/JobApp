package com.pavs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pavs.model.JobPost;
import com.pavs.service.JobService;

@RestController
public class TestController {

	@Autowired
	private JobService service;
	
	@GetMapping("jobposts")
	
	public List<JobPost> getAllJobs() {
		return service.getAllJobs();
	}
	
	@GetMapping("jobposts/{postId}")
	public JobPost getJob(@PathVariable("postId") int postId)
	{
		return service.getJob(postId);
		
	}
	
	
	
	  @PostMapping("jobposts") 
	  public JobPost addJob(@RequestBody JobPost jobPost) 
	  { 
		  service.addJob(jobPost);
		  
		  return service.getJob(jobPost.getPostId());
		  
	  }
	  @PutMapping("jobposts")
	 public JobPost update(@RequestBody JobPost jobPost)
			 {
				service.update(jobPost);
				return service.getJob(jobPost.getPostId());
				//return jobPost;
			 }
	  @DeleteMapping("jobposts/{postId}")
	  public String delete(@PathVariable int postId) {
		  service.delete(postId);
		  return "deleted";
	  }
	  @GetMapping("jobposts/keyword/{keyword}")
	  public List<JobPost> searchByKeyword(@PathVariable("keyword")String keyword ){
		return service.search(keyword); 
	  }
	  
	  @GetMapping("load")
	  public String loadData() {
		  
		  service.load();
		  return "Success";
	  }
	  
	  
}
