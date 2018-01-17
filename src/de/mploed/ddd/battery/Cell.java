package de.mploed.ddd.battery;

class Cell {

	private int chargeKW;
	private boolean charging;
	private int maxCapacity;
	private int currentCapacity;

	Cell(int capacity) {
		this.maxCapacity = capacity;
		this.currentCapacity = capacity;
		this.charging = false;
		this.chargeKW = 0;
	}

	void charge(int kw) {
		this.chargeKW = kw;
		this.charging = charging;
		currentCapacity++;
	}

	int getChargeKW() {
		return chargeKW;
	}

	boolean isCharging() {
		return charging;
	}

	int getMaxCapacity() {
		return maxCapacity;
	}

	int getCurrentCapacity() {
		return currentCapacity;
	}

	void stopCharge() {
		chargeKW = 0;
		this.charging = false;
	}
}
