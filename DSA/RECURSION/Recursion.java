public class Recursion {
	
	

	public static void main(String[] args) {
		System.out.println( sum(3));
		System.out.println(multiply(-3, 2));
		System.out.println(Fibonacci(17));

	}

	public static int sum(int n) {
		if (n<=0) {
			return 0;
		}
		else {
			return sum(n-1) + n;
		}
	}

	// Part 1 complete
	public static int multiply(int m, int n) {
		if (m==0 || n==0) {
			return 0;
		}
		else if (m>0 && n>0){
			return  multiply(m, n-1) + m;
		}
		else if (m<0 && n<0) {
			return multiply(-m, -n+1) + m;
			
		}
		else {
			 if (m<0 ) {
				 return m + multiply(m, n-1) ;
			 }
			 else {
				return -m + multiply(m, n+1)   ;
			 }
		}
		

	}
//
//	// Part 1: complete
//	public static int Fibonacci(int n) {
//		
//	}
//	public class Recursion {
//
//		public static int sum(int n) {
//			// Base step: checking if n is negative then returning 0
//			if (n <= 0) {
//				return 0;
//
//			} else
//				// Step case: Sum of n and the sum of numbers up to n-1
//				return n + sum(n - 1);
//		}
//
//		// Part 1 complete
//		public static int multiply(int m, int n) {
//			// Base case: checks if n == 0 or m ==0 then returns 0;
//			if (n == 0 || m == 0) {
//				return 0;
//
//				// Step case: else if checks if n is positive and m is positive
//			} else if (n > 0 && m > 0) {
//				// then returns m adds to the method multiply(m,n-1)
//				return m + multiply(m, n - 1);
//				// Step case: else if checks if n is negative and m is negative
//			} else if (n < 0 && m < 0) {
//				// then returns negative of m and adds multiply(m,n+1)
//				return -m + multiply(m, n + 1);
//			}
//
//			else {
//				// Step case:if n is positive
//				if (n < 0) {
//					// returns negative of m and adds multiply(m,n+1)
//					return -m + multiply(m, n + 1);
//				} else {
//					// else returns m adds to the method multiply(m,n-1)
//					return m + multiply(m, n - 1);
//				}
//
//			}
//
//		}
//
//		// Part 1: complete
		public static int Fibonacci(int n) {
			// if n == 0 returns 0 else if n == 1 then returns 1
			if (n == 0) {
				return 0;

			} else if (n == 1) {
				return 1;
				// else we return the Fibonacci sequence which is Fn-1 + fn-2
			} else {
				return Fibonacci((n - 1)) + Fibonacci((n - 2));
			}
		}

	
}