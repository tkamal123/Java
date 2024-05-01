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
