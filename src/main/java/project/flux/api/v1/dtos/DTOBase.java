package project.flux.api.v1.dtos;

public abstract class DTOBase<A, T> {
	public abstract A parse(T entity);
	public abstract T format();
}
