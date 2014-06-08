package com.alfascompany.persistence;

import java.io.Serializable;
import java.util.Iterator;

import com.google.appengine.api.datastore.Entity;

public final class IteratorSerializable<T extends AbstractEntity> implements Iterator<T>, Serializable {

	private static final long serialVersionUID = 6431462711474323910L;

	private final Iterator<Entity> iterator;
	private final GAEDAO<T> GAEDAO;

	public IteratorSerializable() {

		this.iterator = null;
		this.GAEDAO = null;
	}

	public IteratorSerializable(final Iterator<Entity> iterator, final GAEDAO<T> GAEDAO) {

		this.iterator = iterator;
		this.GAEDAO = GAEDAO;
	}

	public boolean hasNext() {

		return iterator.hasNext();
	}

	public T next() {

		return GAEDAO.convertToDomainEntity(iterator.next());
	}

	public void remove() {

		iterator.remove();
	}

}
