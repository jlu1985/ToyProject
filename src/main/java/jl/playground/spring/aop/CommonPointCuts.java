package jl.playground.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonPointCuts {
	
	@Pointcut("execution(String jl.playground.spring.aop.SomeClass.doThis(String))")
	public void doThis(){};
	
	@Pointcut("execution(String jl.playground.spring.aop.SomeClass.doThis(String)) && args(str)")
	public void doArgs(String str){};
}
