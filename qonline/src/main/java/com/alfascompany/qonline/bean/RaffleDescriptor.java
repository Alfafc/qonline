package com.alfascompany.qonline.bean;

import java.util.Date;

import com.alfascompany.persistence.AbstractEntityDescriptor;
import com.alfascompany.persistence.Property;
import com.alfascompany.persistence.GenericAccessor;

public class RaffleDescriptor extends AbstractEntityDescriptor<Raffle> {

	@Override
	public String getKind() {
		return "raffle";
	}

	@Override
	public Property[] getEntityProperties() {

		return new Property[] {
				createIdProperty(), createCreationDateProperty(), createLastModifiedDateProperty(),
				createProperty("name", new GenericAccessor<Raffle, String>() {

					@Override
					public String getTypedValue(final Raffle entity) {
						return entity.getName();
					}

					@Override
					public void setTypedValue(final Raffle entity, final String value) {
						entity.setName(value);
					}

				}), createProperty("proper", new GenericAccessor<Raffle, Float>() {

					@Override
					public Float getTypedValue(final Raffle entity) {
						return entity.getProfitPercentage();
					}

					@Override
					public void setTypedValue(final Raffle entity, final Float value) {
						entity.setProfitPercentage(value);
					}

				}), createProperty("endd", new GenericAccessor<Raffle, Date>() {

					@Override
					public Date getTypedValue(final Raffle entity) {
						return entity.getEndDate();
					}

					@Override
					public void setTypedValue(final Raffle entity, final Date value) {
						entity.setEndDate(value);
					}

				})
		};
	}

	@Override
	public Raffle getNewDomainEntityInstance() {
		return new Raffle();
	}

}
