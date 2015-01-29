package jl.playground.spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ColorConfig {
	
	@Bean
	public Color red() {
		Color red = new Color();
		red.setHCL("001");
		red.setId("1");
		red.setRGB("FF0000");
		return red;
	}
	
	@Bean
	@Scope("prototype")
	public Color color() {
		return new Color();
	}
}
