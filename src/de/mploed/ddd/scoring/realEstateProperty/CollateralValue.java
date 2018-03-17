package de.mploed.ddd.scoring.realEstateProperty;

import java.math.BigDecimal;

class CollateralValue {
	CollateralValue(int value) {
		this.value = value;
	}

	private int value;

	int getValue() {
		return value;
	}
}
