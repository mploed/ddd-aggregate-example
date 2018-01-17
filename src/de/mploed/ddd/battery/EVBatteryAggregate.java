package de.mploed.ddd.battery;


public class EVBatteryAggregate {
	private BatteryRootEntity batteryRootEntity;


	public EVBatteryAggregate() {

		this.batteryRootEntity = new BatteryRootEntity(70, 1);
	}

	public void startCharging(int kw) {
		this.batteryRootEntity.startCharging(kw);
	}

	public void stopCharging() {
		this.batteryRootEntity.stopCharging();

	}

	public EVBatteryInformation getInformation() {
		return this.batteryRootEntity.getInformation();
	}

	public EVBatteryStatus getCurrentBatteryStatus() {
		return this.batteryRootEntity.getCurrentBatteryStatus();
	}
}
