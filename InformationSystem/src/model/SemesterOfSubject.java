package model;

public enum SemesterOfSubject {
	/** REFERENCA: Materijali za vežbe (v0 -> VEZBE_03_Date-enum-kolekcije-sortiranje.pdf) */
	LETNJI, ZIMSKI;
	
	private static final String[] description = {"Letnji","Zimski"};
	
	public String toString() {
		return SemesterOfSubject.description[this.ordinal()];
	}
}
