package Helpers;

public class ArrayHelper {
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public void reverse(int[] A, int start, int end) {
        while(start < end) swap(A, start++, end--);
    }
    
}
