package jl.playground.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ColorPlayground {
	
	public static void main(String[] args) {
		System.out.println("Using ClassPathXmlApplicationContext");
		ApplicationContext context = new ClassPathXmlApplicationContext("color.xml");
		Color red = context.getBean("red", Color.class);
		Color blue = context.getBean("blue", Color.class);
		
		System.out.println(red);
		System.out.println(blue);
		
		ColorLibrary colorLib = context.getBean("colorLibrary",ColorLibrary.class);
		
		System.out.println(colorLib.getColor("blue"));
		
		Color protoTypeColor = context.getBean("protoColor",Color.class);
		System.out.println(protoTypeColor);
		
		System.out.println("Using AnnotationContext");
		AnnotationConfigApplicationContext aCtx = new AnnotationConfigApplicationContext();
		aCtx.register(ColorConfig.class);
		aCtx.refresh();
		Color red1  = aCtx.getBean("red",Color.class);
		Color red2  = aCtx.getBean("red",Color.class);
		Color color1 = aCtx.getBean("color",Color.class);
		Color color2 = aCtx.getBean("color",Color.class);
		System.out.printf("red1 hascode %s\n",red1.hashCode());
		System.out.printf("red2 hascode %s\n",red2.hashCode());
		
		System.out.println("java based config with prototype");
		System.out.println("color1 hashcode "+color1.hashCode());
		System.out.println("color2 hashcode "+ color2.hashCode());
		
		
	}
}
