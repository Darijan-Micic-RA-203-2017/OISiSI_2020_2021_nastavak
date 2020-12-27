package model;

public enum TitleOfProfessor {
	/** REFERENCA: Materijali za vežbe (v0 -> VEZBE_03_Date-enum-kolekcije-sortiranje.pdf) */
	BSC, MSC, MR, DR, PROF_DR ;
	
	private static final String[] description = {"BSc", "MSc","mr","dr","prof. dr"};
	
	public String toString() {
		return TitleOfProfessor.description[this.ordinal()];
	}
}
