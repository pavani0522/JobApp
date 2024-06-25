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
	//we have to mention expression in before
	//return-type fully-qualified-classname(includes package also).method-name(args..)
	//if we want to call this method for all the methods in service class we can say *
	//execution is after when of the mentioned ,this should happen
	//the before is the advice here and what in ()pointcut
	//point cut is expression to specify when you want advice to be called
// called before executing the advice
	// all the methods below are advices and before,after ,around are advices
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
