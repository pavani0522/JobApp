package com.pavs.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
	private static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);
	@Around("execution(* com.pavs.service.JobService.getAllJobs(..))")
	//when using around we need to return obj cant just say void
	public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
		
		long start=System.currentTimeMillis();
		 Object obj= jp.proceed();
		
		long end= System.currentTimeMillis();
		LOGGER.info("Time taken:  "+ (end-start)+ " ms");
		
		return obj;
	}

}
