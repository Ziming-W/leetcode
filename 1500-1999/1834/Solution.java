import java.util.*; 

class Solution {
    class StartComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a1, int[] a2){
            return a1[0] - a2[0]; 
        }
    }

    class DuringComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a1, int[] a2){
            if((a1[1] - a2[1]) == 0){
                return a1[2] - a2[2]; 
            }
            return a1[1] - a2[1]; 
        }
    }

    public int[] getOrder(int[][] tasks) {
        int currTime = 1; 
        List<Integer> returnOrder = new ArrayList<>(); 
        Comparator<int[]> startComparator = new StartComparator();
        Comparator<int[]> duringComparator = new DuringComparator();
        //convert to arrayList with indexing
        List<int[]> taskList = new ArrayList<>(); 
        for(int i = 0; i < tasks.length; i++){
            int[] noIndexTask = tasks[i];  
            int[] withIndexTask = new int[3]; 
            withIndexTask[0] = noIndexTask[0]; 
            withIndexTask[1] = noIndexTask[1]; 
            withIndexTask[2] = i; 
            taskList.add(withIndexTask); 
        }
        //sort array with start time ordered
        Collections.sort(taskList, startComparator); 
        Queue<int[]> pq = new PriorityQueue<>(duringComparator); 
        while(!pq.isEmpty() || !taskList.isEmpty()){
            //if tasks in queue, run 
            if(!pq.isEmpty()){
                int[] popped = pq.poll();
                currTime += popped[1]; 
                returnOrder.add(popped[2]); 
            }
            //enqueue all the available tasks,
            while(taskList.size() > 0 && taskList.get(0)[0] <= currTime){
                pq.add(taskList.remove(0)); 
            }
            //jump to next available time directly
            if(pq.isEmpty() && taskList.size() > 0 && taskList.get(0)[0] > currTime){
                currTime = taskList.get(0)[0]; 
            }
        }
        //convert back from arrayList to array
        int[] returnArray = new int[returnOrder.size()]; 
        for(int i = 0; i < returnOrder.size(); i++){
            returnArray[i] = returnOrder.get(i); 
        }
        return returnArray;
}
}
