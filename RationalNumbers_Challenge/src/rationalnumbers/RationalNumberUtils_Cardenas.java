package rationalnumbers;

public class RationalNumberUtils_Cardenas 
{
	// rv = r1+r2, where + is regular numerical addition
	//add(RatNum r1, RatNum r2) //Returns the RatNum r1 + r2 
	public static RationalNumber add(RationalNumber r1, RationalNumber r2)
	{
		int a = r1.getNumerator();
		int b = r1.getDenominator();
		int c = r2.getNumerator();
		int d = r2.getDenominator();
		
		int num = a*d + b*c;
		int denom = b*d;
		
		RationalNumber ratNum = new RationalNumberImpl_Cardenas (num,denom);
		
		return ratNum;
	}
	
	
	// rv = r1-r2, where - is regular numerical addition
	//subtract(RatNum r1, RatNum r2) //Returns the RatNum r1 –  r2 
	public static RationalNumber subtract(RationalNumber r1, RationalNumber r2)
	{
		int a = r1.getNumerator();
		int b = r1.getDenominator();
		int c = r2.getNumerator();
		int d = r2.getDenominator();

		int num = a*d - b*c;
		int denom = b*d;
		
		RationalNumber ratNum = new RationalNumberImpl_Cardenas (num,denom);
		
		return ratNum;
	}
	
	// rv = r1*r2, where * is regular numerical addition
	//multiply(RatNum r1, RatNum r2) //Returns the RatNum r1 * r2 
	public static RationalNumber multiply(RationalNumber r1, RationalNumber r2)
	{
		int a = r1.getNumerator();
		int b = r1.getDenominator();
		int c = r2.getNumerator();
		int d = r2.getDenominator();
		
		int num = a*c;
		int denom = b*d;
		
		RationalNumber ratNum = new RationalNumberImpl_Cardenas (num,denom);
		
		return ratNum;
	}
	
	// rv = r1/r2, where / is regular numerical addition
	//divide(RatNum r1, RatNum r2) //Returns the RatNum r1 / r2 
	public static RationalNumber divide(RationalNumber r1, RationalNumber r2)
	{
		int a = r1.getNumerator();
		int b = r1.getDenominator();
		int c = r2.getNumerator();
		int d = r2.getDenominator();
		
		int num = a*d;
		int denom = b*c;
		
		RationalNumber ratNum = new RationalNumberImpl_Cardenas (num,denom);
		
		return ratNum;
	}
	
	// rv = -r1, where - is regular numerical addition
	//negate(RatNum r1) //Returns the RatNum –r1 
	public static RationalNumber negate(RationalNumber r1)
	{
		int a = r1.getNumerator();
		int b = r1.getDenominator();
		
//		int num = -1 * a;
//		int denom = b;
		
		// negation: -(a)
		RationalNumber ratNum = new RationalNumberImpl_Cardenas (-1*a,b);
		
		return ratNum;
	}
	
	 //Returns true if and only if r1 = r2 as        //rational numbers
	public static boolean equals(RationalNumber r1, RationalNumber r2)
	{
		boolean isEqual = false;
		if (r1.getNumerator()==r2.getNumerator() && r1.getDenominator() == r2.getDenominator())
		{
			isEqual = true;
		}
		
		return isEqual;
		
	}
	

}
