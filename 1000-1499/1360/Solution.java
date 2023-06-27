import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        //parse
        String[] d1 = date1.split("-"); 
        String[] d2 = date2.split("-"); 
        int[] dd1 = new int[3]; 
        int[] dd2 = new int[3]; 
        for(int i = 0; i < 3 ; i++){
            dd1[i] = Integer.parseInt(d1[i]); 
            dd2[i] = Integer.parseInt(d2[i]); 
        }
        //acc year diff
        int smallerYear = Math.min(dd1[0], dd2[0]);
        int days1 = 0; 
        int days2 = 0; 
        int yearDays = 0; 
        for(int i = smallerYear; i < Math.max(dd1[0], dd2[0]); i++){
           yearDays += (isLeap(i) ? 366 : 365); 
        }
        if(dd1[0] > dd2[0]){
            days1 += yearDays; 
        }
        else{
            days2 += yearDays; 
        }
        //acc month & day diff
        days1 += accMonth(dd1[1], dd1[0]) + dd1[2]; 
        days2 += accMonth(dd2[1], dd2[0]) + dd2[2]; 
        //System.out.println(days1 + " " + days2); 
        return Math.abs(days1 - days2); 
    }

    private  int accMonth(int month, int currYear){
        int[] add_31 = new int[]{1, 3, 5, 7, 8, 10, 12};
        int count = 0; 
        for(int i = 1; i < month; i++){
            if(i == 2){
                count += (isLeap(currYear) ? 29 : 28); 
            }
            else if(Arrays.stream(add_31).boxed().collect(Collectors.toList()).contains(i)){
                count += 31; 
            }
            else{
                count += 30; 
            }
        }
        return count; 
    }

    private boolean isLeap(int year){
        boolean isLeap = true; 
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    isLeap = true; 
                }
                else{
                    isLeap = false; 
                }
            }
            else{
                isLeap = true; 
            }
        }
        else{
            isLeap = false; 
        }
        return isLeap; 
    }
}
