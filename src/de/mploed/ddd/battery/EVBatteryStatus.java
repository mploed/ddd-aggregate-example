package de.mploed.ddd.battery;

public class EVBatteryStatus {
	private boolean charging;
	private int chargeLevelSet;
	private double currentChargeLevel;

	public EVBatteryStatus(boolean charging, int chargeLevelSet, double currentChargeLevel) {
		this.charging = charging;
		this.chargeLevelSet = chargeLevelSet;
		this.currentChargeLevel = currentChargeLevel;
	}

	public boolean isCharging() {
		return charging;
	}

	public int getChargeLevelSet() {
		return chargeLevelSet;
	}

	public double getCurrentChargeLevel() {
		return currentChargeLevel;
	}
}
