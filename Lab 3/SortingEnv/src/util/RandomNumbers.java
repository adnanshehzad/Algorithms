package util;




import java.math.BigInteger;
import java.util.*;

/**
 *  This class keeps hold of an instance of Random and guarantees
 *  that the same instance will be used over and over (so the cost
 *  of re-seeding the random number generator is avoided).
 *  Each time the getRandomInt() method is called, the next integer
 *  from this Random instance is returned. 
 */
public class RandomNumbers {
    
    static Random random;
    
    private RandomNumbers() {
        random = new Random();
    }
	/** returns a random BigInteger in the range 0..2^bits -1 */
    public static BigInteger getRandomBigInteger(int  bits){
		if(random == null) new RandomNumbers();
		return new BigInteger(bits,random);
    }
    /** 
     *  Use this method to get a random integer, with a call like this:
     *     int myInt = RandomNumbers.getRandomInt();
     */
    public static int getRandomInt() {
        if(random == null) new RandomNumbers();
        return random.nextInt();
    }
    /**
     * Returns a random integer x satisfying
     * lower <= x <= upper. If lower > upper, returns 0.
     * @param lower
     * @param upper
     * @return
     */
    public static int getRandomInt(int lower, int upper) {
        if(lower > upper) return 0;
        if(lower == upper) return lower;
        int difference = upper - lower;
        int start = getRandomInt();
        
        //nonneg int in the range 0..difference - 1
        start = Math.abs(start) % (difference+1);
        
        start += lower;
        return start;
    }
	/**
	 * Chooses between 0 and 1. Picks 1 with probability p;
	 * picks 0 with probability 1-p. Modifies 0,1 to
	 * lower,upper.
	 */
	public static int getBernoulliInt(int lower, int upper, double probSuccess){
		int[] temp = new int[10000];
		int num = (int)(probSuccess*10000);  //this is the number of 1's in the array
		for(int i = 0; i < num; ++i){
			temp[i]=1;
		}
		int select = temp[getRandomInt(0,9999)];
		return ((select==0) ? lower : upper);
	}
	   /** 
     *  Use this method to get a random integer, with a call like this:
     *     int myInt = RandomNumbers.getRandomInt();
     */
    public static long getRandomLong() {
        if(random == null) new RandomNumbers();
        return random.nextLong();
    }
    /**
     * Returns a random integer x satisfying
     * lower <= x <= upper. If lower > upper, returns 0.
     * @param lower
     * @param upper
     * @return
     */
    public static long getRandomLong(long lower, long upper) {
        if(lower > upper) return 0;
        if(lower == upper) return lower;
        long difference = upper - lower;
        long start = getRandomLong();
        
        //nonneg int in the range 0..difference - 1
        start = Math.abs(start) % (difference+1);
        
        start += lower;
        return start;
    }	
	public static void main(String[] args){
		for(int i = 0; i < 30; ++i){
			System.out.println(getBernoulliInt(3,7, 0.6667));
		}
		/*
		int big = 1048000;
		int small = 1000;
		Random r = new Random();
		BigInteger b = null;
		int max = 0;
		int min = 0;
		int above = 0;
		int below = 0;
		System.out.println(Math.pow(2,20));
		
		for(int i = 0; i < 1000; ++i){
			b = new BigInteger(20,r);
			
			if(b.intValue() >big) {
				System.out.println(b.intValue());
				++above;
			}
			if(b.intValue()==(int)(Math.pow(2,20)-1)) ++max;
			if(b.intValue() < small) {
				System.out.println(b.intValue());
				++ below;
			}
			if(b.intValue() == 0) ++min;
		}
		System.out.println("max: "+max+" min: "+min+" above "+big+":"+above+" below "+small+":"+below);

		/*
		System.out.println(r.nextInt()+" "+r.nextInt()+" "+r.nextInt()+" "+r.nextInt());
		r = new Random();
		System.out.println(r.nextInt()+" "+r.nextInt()+" "+r.nextInt()+" "+r.nextInt());
		r = new Random();
		System.out.println(r.nextInt()+" "+r.nextInt()+" "+r.nextInt()+" "+r.nextInt());
		r = new Random();
		System.out.println(r.nextInt()+" "+r.nextInt()+" "+r.nextInt()+" "+r.nextInt());
		String s = "hello";
		char c = s.charAt(0);
		char d = s.charAt(1);
		System.out.println(c+" "+d+" "+(char)(c+d));
		*/
	}
        
        
}