package com.company.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
public class LogAdvice {

	@Around( "execution(* com.company.unit.*Controller.*(..))"
			+" or execution(* com.company.mapper.*Mapper.*(..))") // after(메서드 호출후에 사용) + before(메서드 호출전에 사용)
	// 컨트롤러랑 맵퍼에 들어가 있는 모든 메소드를 호출 전후로 사용하겠다.
	public Object logTime( ProceedingJoinPoint pjp) {
		log.info("... @Around multi-settion 이전 : ");
		long start = System.currentTimeMillis();
		log.info("... Target : "+ pjp.getTarget());
		log.info("... param : "+ Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		try { result = pjp.proceed(); } catch (Throwable e) { e.printStackTrace(); }
		
		long end = System.currentTimeMillis();
		log.info("... Time : "+ (end+start));
		log.info("... @Around multi-settion 이후 : ");
		return result;
	}
}
