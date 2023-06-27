import java.util.*; 

public class Test {
    public static void main(String[] args){
        int[] a = new int[]{1, 2}; 
        int[] b = Arrays.copyOf(a,2); 
        a[0] = 99; 
        System.out.println(Arrays.toString(a)); 
    }
}
