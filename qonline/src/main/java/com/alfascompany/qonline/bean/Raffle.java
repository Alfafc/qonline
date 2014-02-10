package com.alfascompany.qonline.bean;

import java.io.Serializable;

import com.alfascompany.persistence.NotValidEntityException;
import com.alfascompany.persistence.PersistenceEntity;

public class Raffle extends PersistenceEntity<Raffle> implements Serializable {

	private static final long serialVersionUID = 2322369226395615347L;

	private String userId;
	private String name;
	private float percentageProfit;

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

	public float getPercentageProfit() {
		return percentageProfit;
	}

	public void setPercentageProfit(final float percentageProfit) {
		this.percentageProfit = percentageProfit;
	}

	public void validate() throws NotValidEntityException {

	}
}
