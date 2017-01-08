public class GeneralFunctions
 {
	public static double Deadzone(double value, double deadzone) 
	{
		if (Math.abs(value) < deadzone)
			value = 0;

		return value;
	}

	public static double LinearToExponential(double value, double exponent) 
	{
		value = Math.pow(Math.abs(value), exponent) * Math.signum(value);

		return value;
	}

	public static double Clamp(double value, double min, double max) 
	{
		if (value < min)
			value = min;
		else if (value > max)
			value = max;

		return value;
	}
}
