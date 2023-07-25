import java.util.*; 

class Solution {
    public int[][] merge(int[][] intervals) {
        //sort
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int m = intervals.length; 
        List<List<Integer>> output = new ArrayList<>(); 
        int start = intervals[0][0]; 
        int end = intervals[0][1]; 
        for(int i = 1; i < m; i++){
            if(start <= intervals[i][0] && intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]); 
            }
            else{
                output.add(new ArrayList<>(Arrays.asList(start, end))); 
                start = intervals[i][0]; 
                end = intervals[i][1]; 
            }

        }
        output.add(new ArrayList<>(Arrays.asList(start, end)));
        int[][] outputArray= new int[output.size()][2]; 
        for(int i=0; i < output.size(); i++){
            outputArray[i][0] = output.get(i).get(0); 
            outputArray[i][1] = output.get(i).get(1); 
        }
        return outputArray; 
    }

}