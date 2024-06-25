package com.pavs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.pavs.model.JobPost;

@Repository

public interface JobRepo extends JpaRepository<JobPost, Integer> {

	List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
	
	
	
}
	
/*
 * List<JobPost> jobs= new ArrayList<>();
 * 
 * 
 * public JobRepo(){ jobs.add(new JobPost(1,"Java Dev",
 * " must have exp in corejava and adv java",5, List.of("CORE JAVA", "J2EE",
 * "Springboot", "HIBERNATE")));
 * 
 * jobs.add(new JobPost(2, "UI DEV",
 * "Exp in building reactive and responsive web applications", 3,
 * List.of("java Script", "TypeScript","React","Angular"))); }
 * 
 * 
 * public List<JobPost> getAllJobs(){ return jobs;
 * 
 * }
 * 
 * 
 * public void addJob(JobPost job) { // TODO Auto-generated method stub
 * jobs.add(job); System.out.println(jobs);
 * 
 * }
 * 
 * 
 * public JobPost getJob(int postId) { // TODO Auto-generated method stub
 * for(JobPost job:jobs) { if(job.getPostId()== postId) return job;
 * 
 * }
 * 
 * 
 * 
 * return null; }
 * 
 * 
 * public JobPost update(JobPost jobPost) { // TODO Auto-generated method stub
 * for(JobPost jobPost2:jobs) { if(jobPost2.getPostId()== jobPost.getPostId()) {
 * jobPost.setPostProfile(jobPost.getPostProfile());
 * jobPost2.setPostDesc(jobPost.getPostDesc());
 * jobPost2.setReqExperience(jobPost.getReqExperience());
 * jobPost2.setPostTechStack(jobPost.getPostTechStack());
 * 
 * } }
 * 
 * return jobPost; }
 * 
 * 
 * public void delete(int postId) { // TODO Auto-generated method stub
 * for(JobPost job:jobs) { if(job.getPostId()==postId) { jobs.remove(postId); }
 * }
 * 
 * } }
 */