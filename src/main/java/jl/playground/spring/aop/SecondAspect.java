package jl.playground.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;

@Aspect
public class SecondAspect implements Ordered{
	
	@Before("jl.playground.spring.aop.CommonPointCuts.doThis()")
	public void beforeDoThis(){
		System.out.println("Second Aspect before doing this");
	}
	
	@Before("jl.playground.spring.aop.CommonPointCuts.doArgs(str)")
	public void beforeDoArgs(String str){
		System.out.println(String.format("Second Aspect peeks at parameter (%s)",str));
	}
	
	@Override
	public int getOrder() {
		return 0;
	}
}
