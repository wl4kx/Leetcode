package wenxin.leetcode;

/*
 * Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers?
 */
public class AdditiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdditiveNumber instance = new AdditiveNumber();
		String num = "198019823962";
		System.out.println(instance.isAdditiveNumber(num));
	}

    public boolean isAdditiveNumber(String num) {
        
    	if(num.length()<3){
        	return false;
        }
        
        for (int i = 1; i < num.length()-1; i++) {
			for (int j = i + 1; j < num.length(); j++) {
				long i1 = Long.parseLong(num.substring(0, i));
				long i2 = Long.parseLong(num.substring(i, j ));
				String copy = num;
				while(copy!=""){
					long sum = i1+i2;
					String sumStr = i1+i2+"";
					if(copy.substring((i1+"").length()+(i2+"").length()).startsWith(sumStr)){
						if(copy.substring((i1+"").length()+(i2+"").length()).equals(sumStr)){
							return true;
						}
						copy = copy.substring((i1+"").length());
						i1 = i2;
						i2 = sum;
					}else{
						break;
					}
				}
			}
		}
        return false;
    }
    
}
