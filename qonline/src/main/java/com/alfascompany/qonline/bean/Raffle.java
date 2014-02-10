package com.alfascompany.qonline.bean;

import java.io.Serializable;
import java.util.Date;

import com.alfascompany.persistence.NotValidEntityException;
import com.alfascompany.persistence.PersistenceEntity;
import com.alfascompany.ui.AppStrings;
import com.alfascompany.utils.StringUtils;
import com.alfascompany.utils.TimeUtils;

public class Raffle extends PersistenceEntity<Raffle> implements Serializable {

	private static final long serialVersionUID = 2322369226395615347L;

	private static final int QONLINE_PERCETANGE_PROFIT = 5;

	private String userId;
	private String name;
	private float profitPercentage;
	private Date endDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getProfitPercentage() {
		return profitPercentage;
	}

	public void setProfitPercentage(final float profitPercentage) {
		this.profitPercentage = profitPercentage;
	}

	public float getPercentagePrice() {
		return 100 - profitPercentage - QONLINE_PERCETANGE_PROFIT;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}

	public void validate() throws NotValidEntityException {

		if (StringUtils.isNull(userId))
			throw new NotValidEntityException(AppStrings.messages.userIsNotValid());
		if (StringUtils.isNull(name))
			throw new NotValidEntityException(AppStrings.messages.nameCannotBeEmpty());
		if (profitPercentage <= 0 || profitPercentage > 50)
			throw new NotValidEntityException(AppStrings.messages.profitPercentageMustBe());
		if (!TimeUtils.between(endDate, 10, 40))
			throw new NotValidEntityException(AppStrings.messages.endDateMustBe());
	}
}
