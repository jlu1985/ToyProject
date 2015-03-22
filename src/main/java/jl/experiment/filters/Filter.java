package jl.experiment.filters;

public interface Filter<T> {
	public boolean filter(T t);
}

abstract class StringMatchingFilter<T> implements Filter<String> {
	private String word;

	public StringMatchingFilter(String word) {
		this.word = word;
	}

	protected String getWord() {
		return (word != null) ? word : "";
	}
}

class ContainsFilter<T> extends StringMatchingFilter<String> implements
		Filter<String> {

	public ContainsFilter(String word) {
		super(word);
	}

	@Override
	public boolean filter(String t) {
		return t.contains(getWord());
	}

}

class ExactMatchFilter<T> extends StringMatchingFilter<String> implements
		Filter<String> {
	public ExactMatchFilter(String word) {
		super(word);
	}

	@Override
	public boolean filter(String t) {
		return getWord().equals(t);

	}
}

abstract class LogicalOperationFilter<T> implements Filter<T> {
	private Filter<T> left;
	private Filter<T> right;

	public LogicalOperationFilter(Filter<T> leftOperand, Filter<T> rightOperand) {
		this.left = leftOperand;
		this.right = rightOperand;
	}

	protected Filter<T> getLeft() {
		return left;
	}

	protected Filter<T> getRight() {
		return right;
	}
}

class NegationFilter<T> extends LogicalOperationFilter<T> {

	public NegationFilter(Filter<T> filter) {
		super(filter, filter);
	}

	@Override
	public boolean filter(T t) {
		return !getLeft().filter(t);
	}

}

class LogicalAndFilter<T> extends LogicalOperationFilter<T> {

	public LogicalAndFilter(Filter<T> leftOperand, Filter<T> rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	public boolean filter(T t) {
		return getLeft().filter(t) && getRight().filter(t);
	}

}

class LogicalOrFilter<T> extends LogicalOperationFilter<T> {

	public LogicalOrFilter(Filter<T> leftOperand, Filter<T> rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	public boolean filter(T t) {
		return getLeft().filter(t) || getRight().filter(t);
	}

}
class FilterBuilder<T> {
	public FilterBuilder(Filter<T> t) {
		this.f=t;
	}
	private Filter<T> f;
	public Filter<T> build(){return f;}
	
	public FilterBuilder<T> and(Filter<T>t){
		f = new LogicalAndFilter<T>(f, t);
		return this;
	}
	public FilterBuilder<T> or(Filter<T> t){
		f = new LogicalOrFilter<T>(f,t);
		return this;
	}
	public FilterBuilder<T> negation(){
		f = new NegationFilter<T>(f);
		return this;
		
	}
}
