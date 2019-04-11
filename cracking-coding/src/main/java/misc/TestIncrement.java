package misc;

public class TestIncrement{

	public static void main(String args[]){
		int i = 2,j =4;
		System.out.println("Before: i=" +i + " j=" +j);
		swap(i,j);
		System.out.println("After: i=" +i + " j=" +j);
	}

	public static void swap(int i,int j){
		int temp;
		temp = i;
		i = j;
		j = temp;
		System.out.println("Inside swap: i="+i+" j="+j);
	}
}
