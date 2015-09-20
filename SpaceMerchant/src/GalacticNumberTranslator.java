
public enum GalacticNumberTranslator {
	I (1),
	V (5),
	X(10),
	L(50),
	C (100),
	D (500),
	M(1000);
	
	private final int decimalValue;
	
	private GalacticNumberTranslator(int value) {
		this.decimalValue = value;
	}

	public int getDecimalValue() {
		return decimalValue;
	}
}
