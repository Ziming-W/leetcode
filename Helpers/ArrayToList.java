package Helpers;

public class ArrayToList {
    private void test(){
        int[] add_31 = new int[]{1, 3, 5, 7, 8, 10, 12};
        List<Integer> list = Arrays.stream(add_31).boxed().collect(Collectors.toList());
        System.out.println(list.contains(1));
    }
    
    
}
