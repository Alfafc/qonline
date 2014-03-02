package com.alfascompany.ui;

import com.google.gwt.user.client.ui.Panel;

public abstract class AbstractEntityView<EntityType, ContainerType extends Panel> extends AbstractView<ContainerType> {

	public AbstractEntityView(final ContainerType container) {
		super(container);
	}

	protected abstract void bindEntityToControls(final EntityType entity);

	protected abstract void bindControlsToEntity(final EntityType entity);
}
