package com.alfascompany.ui;

public abstract class AbstractEntityView<T> extends AbstractView {

	protected abstract void bindEntityToControls(T entity);

	protected abstract void bindControlsToEntity(T entity);
}
