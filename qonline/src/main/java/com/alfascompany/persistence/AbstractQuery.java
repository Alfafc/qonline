package com.alfascompany.persistence;

public abstract class AbstractQuery<EntityType extends AbstractEntity> {

	public enum Operator {
		Equal, GreaterThan, GreaterOrEqualThan, LessOrEqualThan, LessThan
	};

	public abstract <PropertyType> AbstractQuery<EntityType> filterAnd(
			final GenericProperty<EntityType, PropertyType> property, final Operator operator, final PropertyType value)
			throws Exception;

	public abstract <PropertyType> AbstractQuery<EntityType> filterOr(
			final GenericProperty<EntityType, PropertyType> property, final Operator operator, final PropertyType value)
			throws Exception;

}
