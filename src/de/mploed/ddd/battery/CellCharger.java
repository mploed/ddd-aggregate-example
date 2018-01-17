package de.mploed.ddd.battery;


class CellCharger {
	int chargeLimit;
	boolean charging;

	CellCharger() {
		this.charging = false;
		this.chargeLimit = 100;
	}

	int getChargeLimit() {
		return chargeLimit;
	}

	boolean isCharging() {
		return charging;
	}

	CellBlock charge(CellBlock cellBlock, int kw) {
		this.charging = true;
		for (Cell cell : cellBlock.getBatteryCells()) {
			//do charging with some intelligent logic
			cell.charge(kw);
		}
		return cellBlock;
	}

	CellBlock stopCharge(CellBlock cellBlock) {
		this.charging = false;
		for (Cell cell : cellBlock.getBatteryCells()) {
			cell.stopCharge();
		}
		return cellBlock;
	}

}
