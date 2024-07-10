class Solution {
    public String countAndSay(int n) {
        String base = "1"; 
        for(int i = 1; i < n; i++){
            base = helper(base); 
            System.out.println(base);
        }
        return base; 
    }

    public String helper(String str){
        StringBuilder sb = new StringBuilder(); 
        char keep = 'a'; 
        int counter = 0; 
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == keep){
                counter ++;  
            }
            else{
                if(counter > 0){
                    sb.append(counter);
                    sb.append(keep); 
                }
                counter = 1; 
                keep = str.charAt(i); 
            }
        }  

        if(counter > 0){
            sb.append(counter);
            sb.append(keep); 
        }
        return sb.toString(); 
    }
}