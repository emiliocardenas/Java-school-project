package rationalnumbers;

// TURN ASSERTIONS ON PLEASE!!

public class RationalNumberImpl_Cardenas implements RationalNumber 
{
	
	private int numerator;
	private int denominator;
	
	//pre: a anb b are both integers
	//pre: b =! 0
	//post: if a = 0, b = 1 
	//post: getDenominator(): rv>0.
	public RationalNumberImpl_Cardenas(int a, int b)
	{
		
		assert b != 0 : "ERROR, the DENOMINATOR != 0 TRY AGAIN!"; 

		if (b<0)
		{
			b = b * -1;
			a = a * -1;
		
		}
		
		//reduce()-->// Reduce the rational number instance to simplest form (reduce form).

		if(a != 0)
		{
			int common = gcd (Math.abs(a),b);
			a = a / common;
			b = b / common;
		}
		//If numerator equals 0, denominator equals 1.
		else
		{
			b=1;
		}
		
		this.numerator = a;
		this.denominator = b;
	}
	
	
	
	//post: rv(numerator) is the numerator of the reduced form of this rational number 
	//Ex: since 5/3 is the reduced form of 10/6, (10/6).getNumerator() = 5 
	public int getNumerator() {
		
		return numerator;
	}

	//post condition: getDenominator(): rv>0
	//rv is the numerator of the reduced form of this rational number 
	//Ex: since 5/3 is the reduced form of 10/6, (10/6).getDenominator() = 3 
	public int getDenominator() {
		
		return denominator;
	}

	//rv is the double equivalent of this rational number 
	//Ex: (5/10).getValue() = 0.5 
	public double getValue()
	{
		double rv = (double)numerator/denominator;
		return rv;
		
	}
	
	//greatest common divisor helper method
	public int gcd (int num1, int num2)
	{
		while (num1 != num2)
		{
			if (num1 > num2)
			{
				num1 = num1 - num2;
			}
			else
			{
				num2 = num2 - num1;
			}
		}
	      return num1;
	 }
	
	
	
	public String toString()
	{
		 return numerator + "/" + denominator;
    }
	

//	// TESTING!!!!!!!!!!!!!!!
//	public static void main(String[]args)
//	{
//		int a = 10;
//		int b = 6;
//		int c = 1;
//		int d = 2;
//		RationalNumber rr = new RationalNumberImpl_Cardenas(0,3);
//		System.out.println("Numerator:" + rr.getNumerator() + " Denominator:" + rr.getDenominator() + " Value:" + rr.getValue());
//		System.out.println("Value of the Rational Number: " + rr.toString());
//		
//		// Utils Testing
//		RationalNumber r1 = new RationalNumberImpl_Cardenas(1,4);
//		RationalNumber r2 = new RationalNumberImpl_Cardenas(2,8);
//		RationalNumber r3 = RationalNumberUtils_Cardenas.add(r1,r2);
//		RationalNumber r4 = RationalNumberUtils_Cardenas.subtract(r1,r2);
//		RationalNumber r5 = RationalNumberUtils_Cardenas.multiply(r1,r2);
//		RationalNumber r6 = RationalNumberUtils_Cardenas.divide(r1,r2);
//		RationalNumber r7 = RationalNumberUtils_Cardenas.negate(r1);
//		boolean r8 = RationalNumberUtils_Cardenas.equals(r1,r1);
//
//
//
//		
//		
//		
//
//
//		System.out.println(r8);
//
//
//	
//
//	}
	
	
	
}
