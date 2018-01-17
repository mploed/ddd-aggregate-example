package de.mploed.ddd.battery;

import java.util.ArrayList;
import java.util.List;

class CellBlock {
	private List<Cell> batteryCells;


	CellBlock(int amountOfCells, int capacityForCell) {
		this.batteryCells = new ArrayList<Cell>();
		for (int i = 0; i < amountOfCells; i++) {
			this.batteryCells.add(new Cell(capacityForCell));
		}

	}

	int getCapacity() {
		int capacity = 0;
		for(Cell cell : batteryCells) {
			capacity += cell.getMaxCapacity();
		}
		return capacity;
	}

	double getChargeLevel() {
		int overallChargeLevel = 0;

		for(Cell c : batteryCells) {
			overallChargeLevel += c.getCurrentCapacity();
		}

		return overallChargeLevel / batteryCells.size();
	}

	List<Cell> getBatteryCells() {
		return batteryCells;
	}
}
