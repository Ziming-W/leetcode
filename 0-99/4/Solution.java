//Time O(n)
//80% 80%
class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length; 
        int n = nums2.length;
        int index = (m + n) / 2;  
        int i, j, k; 
        i = j = k = 0; 
        int curr = 0; 
        int last = 0; 
        while(i < index + 1){
            //System.out.println(i + ":" + j + k); 
            if(k >= n || (j!=m && nums1[j] <= nums2[k])){
                last = curr; 
                curr = nums1[j]; 
                j++; 
            }
            else if(j >= m || (k!=n && nums1[j] > nums2[k])){
                last = curr; 
                curr = nums2[k]; 
                k++; 
            }
            i++; 
        }
        //System.out.println(last + curr); 
        return ((m + n) %2 == 0) ? (last + curr)/2.0 : curr; 
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1, 2}; 
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2)); 
    }
}