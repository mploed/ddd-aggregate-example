package de.mploed.ddd.scoring;

public class ApplicationNumber {
	private String applicatioNumber;

	public ApplicationNumber(String applicatioNumber) {
		this.applicatioNumber = applicatioNumber;
	}

	@Override
	public String toString() {
		return "ApplicationNumber{" +
				"applicatioNumber='" + applicatioNumber + '\'' +
				'}';
	}
}
