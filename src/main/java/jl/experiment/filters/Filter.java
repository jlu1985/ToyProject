package jl.experiment.filters;

import org.apache.commons.lang3.StringUtils;

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
		return StringUtils.contains(t, getWord());
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

class NullFilter<T> implements Filter<T> {
	
	@SuppressWarnings("rawtypes")
	private static final Filter n = new NullFilter();
	private NullFilter() {
	}

	@Override
	public boolean filter(T t) {
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Filter<T> getInstance(){
		return (Filter<T>)n;
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
		return (left!=null)?left:NullFilter.getInstance();
	}

	protected Filter<T> getRight() {
		return (right!=null)?right:NullFilter.getInstance();
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
		this.f = t;
	}

	private Filter<T> f;

	private Filter<T> getReferenceFilter() {
		return (f != null) ? f : NullFilter.getInstance();
	}

	private FilterBuilder<T> setReferenceFilter(Filter<T> t) {
		this.f = t;
		return this;
	}
	public Filter<T> build() {
		return getReferenceFilter();
	}

	public FilterBuilder<T> and(Filter<T> t) {
		return setReferenceFilter(new LogicalAndFilter<T>(getReferenceFilter(), t));
	}

	public FilterBuilder<T> or(Filter<T> t) {
		return setReferenceFilter(new LogicalOrFilter<T>(getReferenceFilter(), t));
	}

	public FilterBuilder<T> negation() {
		return setReferenceFilter(new NegationFilter<T>(getReferenceFilter()));
	}
}
