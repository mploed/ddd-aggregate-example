package de.mploed.ddd.battery;

import java.util.UUID;

class BatteryRootEntity {
	private UUID serialNumber;
	private CellBlock cellBlock;
	private CellCharger cellCharger;

	BatteryRootEntity(int amountOfCells, int capacityForCell) {
		this.serialNumber = UUID.randomUUID();
		this.cellBlock = new CellBlock(amountOfCells, capacityForCell);
		this.cellCharger = new CellCharger();
	}

	void startCharging(int kw) {
		this.cellBlock = cellCharger.charge(cellBlock, kw);
	}

	void stopCharging() {
		this.cellBlock = cellCharger.stopCharge(cellBlock);

	}

	EVBatteryInformation getInformation() {
		return new EVBatteryInformation(serialNumber, cellBlock.getCapacity());
	}

	EVBatteryStatus getCurrentBatteryStatus() {
		return new EVBatteryStatus(cellCharger.isCharging(), cellCharger.getChargeLimit(), cellBlock.getChargeLevel());
	}

}
