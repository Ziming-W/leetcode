class Solution {
    public static String gcdOfStrings(String str1, String str2) {
        String l, s; 
        if(str1.length() > str2.length()){
            l = str1;
            s = str2;
        }
        else{
            l = str2;
            s = str1;
        }
        int gcd = gcd(l.length(), s.length()); 
        if(gcd == 1 && !(s.length() == 1)){
            return ""; 
        }
        if(!l.substring(0, s.length()).equals(s)){
            return ""; 
        }
        String gcdSlice = l.substring(0, gcd); 
        for(int i = 0; i < l.length() / gcd; i++){
            if(!l.substring(i*gcd, i*gcd+gcd).equals(gcdSlice)){
                return ""; 
            }
        }
        return gcdSlice; 

    }

    public static int gcd(int large, int small){
        if(small == 0){
            return large; 
        }
        if(small == 1){
            return 1; 
        }
        return gcd(small, large % small); 
    }
}