package model;

public enum StatusOfStudent {
	B, S;
	
	private static final String[] description = {"budžet", "samofinansiranje"};
	
	@Override
	public String toString() {
		return StatusOfStudent.description[this.ordinal()];
	}
}
