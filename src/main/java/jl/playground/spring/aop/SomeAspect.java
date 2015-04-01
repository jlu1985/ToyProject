package jl.playground.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.Ordered;

@Aspect
public class SomeAspect implements Ordered{

	@Before("jl.playground.spring.aop.CommonPointCuts.doThis()")
	public void beforeDoThis(){
		System.out.println("First Aspect before doing this");
	}
	
	@Before("jl.playground.spring.aop.CommonPointCuts.doArgs(str)")
	public void beforeDoArgs(String str){
		System.out.println(String.format("First Aspect peeks at parameter (%s)",str));
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		
		SomeClass classBean = context.getBean(SomeClass.class);
		classBean.doThis("Hellp Spring AOP");
	}

	@Override
	public int getOrder() {
		return 3;
	}
}
