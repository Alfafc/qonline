package com.alfascompany.qonline.bean;

import java.io.Serializable;
import java.util.Date;

import com.alfascompany.persistence.AbstractEntity;
import com.alfascompany.persistence.NotValidEntityException;
import com.alfascompany.ui.AppStrings;
import com.alfascompany.utils.StringUtils;
import com.alfascompany.utils.TimeUtils;

public class Raffle extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 2322369226395615347L;

	private static final int QONLINE_PERCETANGE_PROFIT = 5;

	private String name;
	private double profitPercentage;
	private Date endDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getProfitPercentage() {
		return profitPercentage;
	}

	public void setProfitPercentage(final double profitPercentage) {
		this.profitPercentage = profitPercentage;
	}

	public double getPercentagePrice() {
		return 100 - profitPercentage - QONLINE_PERCETANGE_PROFIT;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	public String getEndDateAsString() {
		return (endDate == null) ? "" : endDate.toString();
	}

	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public void validate() throws NotValidEntityException {

		if (StringUtils.isNullOrEmpty(name))
			throw new NotValidEntityException(AppStrings.messages.nameCannotBeEmpty());
		if (profitPercentage <= 0 || profitPercentage > 50)
			throw new NotValidEntityException(AppStrings.messages.profitPercentageMustBe());
		if (!TimeUtils.between(endDate, 10, 40))
			throw new NotValidEntityException(AppStrings.messages.endDateMustBe());
	}

}
