import java.util.ArrayList;

public class GeneratePrimes {
	private static int limit = (int) 1E3;
	private static ArrayList<Integer> primes = new ArrayList<Integer>();
	private static boolean[] isPrime = new boolean[limit];
	
	public static void main(String args[]){
		for(int i = 11; i < 1000; i += 60){
			System.out.println(i + ": " + useQuadratic3(i));
		}
	}
	
	public static void initialize(){
		for(int i = 0; i < limit ; i++){
			isPrime[i] = false;
		}
	}
	
	public static void eleminate(){
		int mod60 = 0;
		for(int i = 0; i < limit; i++){
			if(mod60 > 60){
				mod60 -= 60;
			}
			switch(mod60){
				case 1:
				case 13:
				case 17:
				case 29:
				case 37:
				case 41:
				case 49:
				case 53:
					isPrime[i] = useQuadratic1( i );
					break;
				case 7:
				case 19:
				case 31:
				case 43:
					isPrime[i] = useQuadratic2( i );
					break;
				case 11:
				case 23:
				case 47:
				case 59:
					isPrime[i] = useQuadratic3( i );
					break;
				default:
					break;
			}
		}
	}

	private static boolean useQuadratic1(int number) {
		int representations = 0;
		int square = 0;
		int fourSquare = 0;
		for(int i = 0; fourSquare < number; i++){
			
			square += 2*i + 1;
			fourSquare = 4*square;
			//System.out.println(i + " " + fourSquare);
			double temp = Math.sqrt(number - fourSquare);
			//System.out.println(temp);
			if(temp == Math.floor(temp) && temp%2 == 1){
				//System.out.println("represenation increase");
				representations++;
			}
		}
		return representations%2 == 1;
	}

	private static boolean useQuadratic2(int number) {
		int representations = 0;
		int square = 0;
		int threeSquare = 0;
		for(int i = 0; threeSquare < number; i+=2){
			square += 2*i + 1;
			threeSquare = 3*square;
			
			double temp = Math.sqrt(number - threeSquare);
			if(temp == Math.floor(temp) && temp%2 == 0){
				representations ++;
			}
		}
		return representations%2 == 1;
	}

	private static boolean useQuadratic3(int number) {
		int representations = 0;
		int square = 0;
		
		for(int i = 0; 3*square < number; i++){
			square += 2*i + 1;
			
			int temp1 = number + square;
			if(temp1%3 == 0){
				double temp = Math.sqrt(temp1);
				if(temp == Math.floor(temp) && ((i%2 == 0 && temp%2 == 1) || (i%2 == 1 && temp%2 == 0)) ){
					representations++;
				}
			}
			
		}
		return representations%2 == 1;
	}
	
	
	
}
