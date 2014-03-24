package com.alfascompany.persistence;

import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

public class GAEQuery<EntityType extends AbstractEntity> extends AbstractQuery<EntityType> {

	private Filter filter;

	private GAEQuery(final Filter filter) {

		this.filter = filter;
	}

	public static <EntityType2 extends AbstractEntity, PropertyType> GAEQuery<EntityType2> create(
			final Property property, final Operator operator, final PropertyType value) throws Exception {

		return new GAEQuery<EntityType2>(createFilter(property, operator, value));
	}

	private static <EntityType2 extends AbstractEntity, PropertyType> Filter createFilter(final Property property,
			final Operator operator, final PropertyType value) throws Exception {

		return new FilterPredicate(property.getKey(), toFilterOperator(operator), value);
	}

	private static FilterOperator toFilterOperator(final Operator operator) throws Exception {

		switch (operator) {
		case Equal:
			return FilterOperator.EQUAL;
		case GreaterOrEqualThan:
			return FilterOperator.GREATER_THAN_OR_EQUAL;
		case GreaterThan:
			return FilterOperator.GREATER_THAN;
		case LessOrEqualThan:
			return FilterOperator.LESS_THAN_OR_EQUAL;
		case LessThan:
			return FilterOperator.LESS_THAN;
		default:
			throw new Exception("Cannot convert Operator to FilterOperator.");
		}

	}

	@Override
	public <PropertyType> AbstractQuery<EntityType> filterAnd(final GenericProperty<EntityType, PropertyType> property,
			final Operator operator, final PropertyType value) throws Exception {

		filter = CompositeFilterOperator.and(filter, createFilter(property, operator, value));
		return this;
	}

	@Override
	public <PropertyType> AbstractQuery<EntityType> filterOr(GenericProperty<EntityType, PropertyType> property,
			final Operator operator, PropertyType value) throws Exception {

		filter = CompositeFilterOperator.or(filter, createFilter(property, operator, value));
		return this;
	}

	public Query buildGAEQuery(final String key) {

		final Query query = new Query(key);
		query.setFilter(filter);
		return query;
	}

}
