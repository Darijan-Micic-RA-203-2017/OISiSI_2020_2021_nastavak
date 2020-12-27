package model;

public enum CallingOfProfessor {
	/** REFERENCA: Materijali za vežbe (v0 -> VEZBE_03_Date-enum-kolekcije-sortiranje.pdf) */
	SARADNIK_U_NASTAVI,ASISTENT,ASISTENT_SA_DOKTORATOM,DOCENT,VANREDNI_PROFESOR,REDOVNI_PROFESOR,PROFESOR_EMERITUS;
	
	private static final String[] description = {"saradnik u nastavi", "asistent","asistent sa doktoratom",
			"docent","vanredni profesor", "redovni profesor","profesor emeritus"};
	
	public String toString() {
		return CallingOfProfessor.description[this.ordinal()];
	}
}
