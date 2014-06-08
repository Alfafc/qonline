package com.alfascompany.persistence;

import java.io.Serializable;
import java.util.Iterator;

import com.google.appengine.api.datastore.Entity;

public final class IterableSerializable<T extends AbstractEntity> implements Iterable<T>, Serializable {

	private static final long serialVersionUID = -2623585732048958339L;

	private final Iterator<Entity> iterator;
	private final GAEDAO<T> GAEDAO;

	public IterableSerializable() {

		this.iterator = null;
		this.GAEDAO = null;
	}

	public IterableSerializable(final Iterator<Entity> iterator, final GAEDAO<T> GAEDAO) {

		this.iterator = iterator;
		this.GAEDAO = GAEDAO;
	}

	public Iterator<T> iterator() {

		return new IteratorSerializable<T>(iterator, GAEDAO);
	}
}
