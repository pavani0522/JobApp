package com.pavs.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.pavs.service.JobService.getJob(..))||execution(* com.pavs.service.JobService.getAllJobs(..))")
	public void logMethodCall(JoinPoint jp)
	{
		LOGGER.info("Method called "+ jp.getSignature().getName());
	}
	//after executing the advice
	@After("execution(* com.pavs.service.JobService.getJob(..))||execution(* com.pavs.service.JobService.getAllJobs(..))")
	public void logMethodExecuted(JoinPoint jp)
	{
		LOGGER.info("Method excecuted "+ jp.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.pavs.service.JobService.getJob(..))||execution(* com.pavs.service.JobService.getAllJobs(..))")
	public void logMethodExecutedsuccess(JoinPoint jp)
	{
		LOGGER.info("Method excecuted successfully "+ jp.getSignature().getName());
	}

	@AfterThrowing("execution(* com.pavs.service.JobService.getJob(..))||execution(* com.pavs.service.JobService.getAllJobs(..))")
	public void logMethodissues(JoinPoint jp)
	{
		LOGGER.info("Method has some execeptions "+ jp.getSignature().getName());
	}
}
