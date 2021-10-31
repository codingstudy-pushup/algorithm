package topInterview;
import java.util.*;

public class BasicCalculator2 {

	public static void main(String[] args) {
		String s = "3+2*2";
		solve(s);
	}
	
	public int solve(String s) {
		if(s==null) return 0;
		
		int leng = s.length();
		if(leng==0) return 0;
		
		Stack<Integer> stack = new Stack<>();
		int num =0;
		char sign ='+';
		
		 for(int i=0;i<leng;i++){
		        if(Character.isDigit(s.charAt(i))){
		            num = num*10+s.charAt(i)-'0';
		        }
		        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
		            if(sign=='-'){
		                stack.push(-num);
		            }
		            if(sign=='+'){
		                stack.push(num);
		            }
		            if(sign=='*'){
		                stack.push(stack.pop()*num);
		            }
		            if(sign=='/'){
		                stack.push(stack.pop()/num);
		            }
		            sign = s.charAt(i);
		            num = 0;
		        }
		    }

		    int res = 0;
		    for(int i:stack){
		        res += i;
		    }
		    return res;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
