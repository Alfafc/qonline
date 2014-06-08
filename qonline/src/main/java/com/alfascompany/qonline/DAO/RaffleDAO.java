package com.alfascompany.qonline.DAO;

import com.alfascompany.persistence.AbstractQuery.Operator;
import com.alfascompany.persistence.GAEDAO;
import com.alfascompany.persistence.GAEQuery;
import com.alfascompany.qonline.bean.Raffle;
import com.alfascompany.qonline.bean.RaffleDescriptor;
import com.alfascompany.utils.TimeUtils;

public class RaffleDAO extends GAEDAO<Raffle> {

	private static final long serialVersionUID = -4706600637269526156L;

	private final RaffleDescriptor descriptor;

	protected RaffleDAO() {
		super(new RaffleDescriptor());

		descriptor = (RaffleDescriptor) getEntityDescriptor();
	}

	public Iterable<Raffle> getLastWorldWideRaffles() throws Exception {

		final GAEQuery<Raffle> query = GAEQuery.create(descriptor.lastModifiedDateProperty, Operator.GreaterOrEqualThan,
				TimeUtils.parseDate("140305090000000"));
		return getEntities(query, 50);
	}
}
