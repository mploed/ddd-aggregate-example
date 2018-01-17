package de.mploed.ddd.battery;

import java.util.UUID;

public class EVBatteryInformation {
	private UUID id;
	private int capacity;

	public EVBatteryInformation(UUID id, int capacity) {
		this.id = id;
		this.capacity = capacity;
	}

	public UUID getId() {
		return id;
	}

	public int getCapacity() {
		return capacity;
	}

}
