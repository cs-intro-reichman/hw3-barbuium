// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int result = x1;
		while (x2 != 0) {
			if (x2 > 0) {
				result++;
				x2--;
			} else {
				result--;
				x2++;
			}
		}
			return result;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int result = x1;
		while (x2 != 0) {
			if (x2 > 0) {
				result--;
				x2--;
			} else {
				result++;
				x2++;
			}
		}
		return result;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
        int result = 0;
		if (x1 == 0 || x2 == 0)
			return result;
		if (x2 == 1)
			return x1;
		if (x1 == 1)
			return x2;
		if (x1 > 0 && x2 > 0) {
			for (int i = 0; i < x2; i++)
				result = plus(result, x1);
			return result;			
		}	
		if (x1 < 0 && x2 < 0) {
			int newx1 = Math.abs(x1);
			for (int i = 0; i < Math.abs(x2); i++) ;
				result = plus(result,newx1);
				return result;
		}	
		if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
			int newX1 = Math.abs(x1);
			int newX2 = Math.abs(x2);
			for (int i = 0; i < newX2; i++)
				result = plus(result, newX1);
				int total = minus(0, result);
				return total;
		}
		return result;
    }

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
			if (n == 0)
				return 1;
			if (n < 0)
				return 0;
			if (n == 1)
				return x;	
			int result = 1;
			if (n > 0) {
				for (int i = 0; i < n; i++)
					result = times(result, x);
					return result;
			}
			return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int result = 0;
		int abs1 = x1 < 0 ? minus(0, x1) : x1;
		int abs2 = x2 < 0 ? minus(0, x2) : x2;
	
		while (abs1 >= abs2) {
			abs1 = minus(abs1, abs2);
			result++;
		}
	
		if ((x1 < 0 && x2 >= 0) || (x1 >= 0 && x2 < 0)) {
			result = minus(0, result);
        }
        return result;
    }

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int abs1 = x1 < 0 ? minus(0, x1) : x1;
		int abs2 = x2 < 0 ? minus(0, x2) : x2;

		while (abs1 >= abs2) {
			abs1 = minus(abs1, abs2);
		}

		if (x1 < 0) {
			abs1 = minus(0,abs1);
		}
        return abs1;
    }

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int result = 0;
		int odd = 1;
		while (x >= odd) {
				x = minus(x, odd);
				odd = plus(odd, 2);
				result++;
			}
			return result;
		}
}
