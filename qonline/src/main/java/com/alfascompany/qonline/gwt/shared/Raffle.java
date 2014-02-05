package com.alfascompany.qonline.gwt.shared;

import com.alfascompany.persistence.PersistenceEntity;

public class Raffle extends PersistenceEntity {

	private String userId;
	private String name;
	private float percentageProfit;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public void setPercentageProfit(float percentageProfit) {
		this.percentageProfit = percentageProfit;
	}
}
