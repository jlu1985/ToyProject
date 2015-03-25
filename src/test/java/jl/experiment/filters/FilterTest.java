package jl.experiment.filters;

import static org.junit.Assert.*;

import org.junit.Test;

public class FilterTest {

	private Filter<String> test;
	
	private final String HELLO_WORLD = "Hello World";
	
	
	
	@Test
	public void caseSensitiveContains() {
		test = new FilterBuilder<String>(new ContainsFilter<String>("world")).build();
		
		assertFalse(test.filter(HELLO_WORLD));
	}
	@Test
	public void groupTest(){
		test = new FilterBuilder<String>(new ContainsFilter<String>("World")).or(new ExactMatchFilter<String>("abc")).build();
		assertTrue(test.filter(HELLO_WORLD));
	}
	@Test
	public void negationTest(){
		FilterBuilder<String> builder = new FilterBuilder<String>(new ExactMatchFilter<String>(HELLO_WORLD)).negation();
		
		test = builder.build();
		
		assertTrue(test.filter("does not match"));
	}

	@Test
	public void deepFiltering(){
		
		test = new FilterBuilder<String>(new ExactMatchFilter<>("Hello World")).or(new ContainsFilter<>("ell")).or(new NegationFilter<>(new ContainsFilter<>("abc"))).build();
		Filter<String> group = new FilterBuilder<>(new ContainsFilter<>("wo")).or(new ContainsFilter<>("ld")).and(test).build();
		
		assertTrue(group.filter(HELLO_WORLD	));
		}


	@Test
	public void testLambda() {
		test = new FilterBuilder<String>(string -> string.equals(HELLO_WORLD)).build();
		assertTrue(test.filter(HELLO_WORLD));
	}
	
	@Test
	public void testNull(){
		test = new FilterBuilder<String>(null).build();
		assertFalse(test.filter(null));
	}
}