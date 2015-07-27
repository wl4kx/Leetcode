package wenxin.test;

public class Test {
	public static void main(String[] args) {

		int[] arr = {3, 7, 1, 11, 5};
		int i=0, j = 4;
		while(i<=j){
			i++;
			if(i==j){
				System.out.println(arr[i]);
			}
			j--;
		}
		System.out.println(arr[i]);
	}
}