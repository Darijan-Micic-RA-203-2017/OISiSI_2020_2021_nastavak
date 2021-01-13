package model;

public enum StatusOfStudent {
	/** REFERENCA: Materijali za vežbe (v0 -> VEZBE_03_Date-enum-kolekcije-sortiranje.pdf) */
	B, S;
	
	private static final String[] description = {"B", "S"};
	
	public String toString() {
		return StatusOfStudent.description[this.ordinal()];
	}
}
