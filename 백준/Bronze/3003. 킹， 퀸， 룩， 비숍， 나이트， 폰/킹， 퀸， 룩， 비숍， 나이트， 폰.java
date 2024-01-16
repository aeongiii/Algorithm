import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int t = 1;
    	int result = 0;
    	
		String all = scanner.nextLine();
		
		String[] numarr = all.split(" ");
		
    	while(t < 7) {
    		for (int i=0; i<numarr.length; i++) {
    			int num = Integer.parseInt(numarr[i]); 
    		switch(t) {    		
	    		case(1):
	    			result = 1 - num;
	    			break;
	    		case(2):
	    			result = 1 - num;
    				break;
	    		case(3):
	    			result = 2 - num;
					break;
	    		case(4):
	    			result = 2 - num;
					break;
	    		case(5):
	    			result = 2 - num;
					break;
	    		case(6):
	    			result = 8 - num;
					break;
    		}
    		System.out.print(result + " ");
    		t ++;
    		
    	}
    }
}
}