package converter;

public enum Length {
	
	/* value of each unit */
	 Mile(1609.344),
	 Kilometer(1000.0),
	 Meter(1.0),
	 Centimeter(0.0100),
	 Foot(0.30480),
	 Wa(2.00000),
	 AU(1495978707e2);
	
	/* attributes of the enum members */
	private final double value;
	 
	/* enum constructor must be private */
	private Length(double value) { this.value = value; }
	
	/* get the value */
	public double getValue() { return this.value; }
}
