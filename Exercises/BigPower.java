
import java.math.*;

public class BigPower {

    public static int countPower = 0;
    public static int countPower2 = 0;

    public static void main (String[] argv)
    {
        BigInteger X = new BigInteger ("3");
        BigInteger Y = new BigInteger ("2");
        BigInteger Z = power (X, Y);
	System.out.println("power count: " + countPower);
	BigInteger Z2 = power2 (X, Y);
	System.out.println("power2 count: " + countPower2);
        System.out.println (X + "^" + Y + " = " + Z + " Z2=" + Z2);

        X = new BigInteger ("2");
        Y = new BigInteger ("8");
        Z = power (X, Y);
	System.out.println("power count: " + countPower);
	Z2 = power2 (X, Y);
	System.out.println("power2 count: " + countPower2);
        System.out.println (X + "^" + Y + " = " + Z + " Z2=" + Z2);


        X = new BigInteger ("2");
        Y = new BigInteger ("1000");
	Z = power (X, Y);
	System.out.println("power count: " + countPower);
	Z2 = power2 (X, Y);
	System.out.println("power2 count: " + countPower2);
        System.out.println (X + "^" + Y + " = " + Z + " Z2=" + Z2);
    }


    static BigInteger zero = new BigInteger ("0");
    static BigInteger one = new BigInteger ("1");
    static BigInteger two = new BigInteger ("2");

    static BigInteger power (BigInteger A, BigInteger B)
    {
        if ( B.equals(zero) ) 
	{
            return new BigInteger ("1");
        }

        BigInteger BMinus1 = B.subtract (one);
	countPower++;
        BigInteger temp = power (A, BMinus1);
	//count++;
	BigInteger P = A.multiply (temp);
        countPower++;
	return P;
    }

    static BigInteger power2 (BigInteger A, BigInteger B)
    {
	if(B.equals(zero))
	{
		return one;
	}
	
	else if(B.mod(two).equals(zero))
	{
		countPower2++;
		BigInteger base = A.multiply(A);
		countPower2++;
		BigInteger P = power2(base, B.divide(two));
		countPower2++;
		return P;	
	}

	else if(!B.mod(two).equals(zero))
	{
		countPower2++;
		BigInteger base = A.multiply(A);
		countPower2++;
		BigInteger P = power2(base, (B.subtract(one)).divide(two));
		countPower2 = countPower2 + 3;
		return P.multiply(A);
	}
	
	return zero;
    }
}
