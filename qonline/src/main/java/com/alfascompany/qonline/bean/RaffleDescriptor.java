package com.alfascompany.qonline.bean;

import java.util.Date;

import com.alfascompany.persistence.AbstractEntityDescriptor;
import com.alfascompany.persistence.GenericAccessor;
import com.alfascompany.persistence.Property;

public class RaffleDescriptor extends AbstractEntityDescriptor<Raffle> {

	public final Property nameProperty = createProperty("name", new GenericAccessor<Raffle, String>() {

		@Override
		public String getTypedValue(final Raffle entity) {
			return entity.getName();
		}

		@Override
		public void setTypedValue(final Raffle entity, final String value) {
			entity.setName(value);
		}

	});

	public final Property profitPercentageProperty = createProperty("proper", new GenericAccessor<Raffle, Double>() {

		@Override
		public Double getTypedValue(final Raffle entity) {
			return entity.getProfitPercentage();
		}

		@Override
		public void setTypedValue(final Raffle entity, final Double value) {
			entity.setProfitPercentage(value);
		}

	});

	public final Property endDateProperty = createProperty("endd", new GenericAccessor<Raffle, Date>() {

		@Override
		public Date getTypedValue(final Raffle entity) {
			return entity.getEndDate();
		}

		@Override
		public void setTypedValue(final Raffle entity, final Date value) {
			entity.setEndDate(value);
		}

	});

	@Override
	public String getKind() {
		return "raffle";
	}

	@Override
	public Property[] getEntityProperties() {

		return mergeWithDefaultEntityProperties(new Property[] {
				nameProperty, profitPercentageProperty, endDateProperty
		});
	}

	@Override
	public Raffle getNewDomainEntityInstance() {
		return new Raffle();
	}

}
