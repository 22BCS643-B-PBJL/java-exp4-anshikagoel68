import java.util.ArrayList;
import java.util.List;

public class WrapperClass {
    public static void main(String[] args) {
        String[] numbers = {"10", "20", "30", "40", "50", "1810", "1110"};
        List<Integer> integerList = new ArrayList<>();
        
        for (String str : numbers) {
            integerList.add(parseStringToInteger(str));
        }
        
        System.out.println("The numbers are: " + integerList);
        
        int sum = calculateSum(integerList);
        
        System.out.println("The sum of the numbers is: " + sum);
    }

    public static Integer parseStringToInteger(String str) {
        return Integer.parseInt(str);
    }

    public static int calculateSum(List<Integer> integerList) {
        int sum = 0;
        for (Integer num : integerList) {
            sum += num;
        }
        return sum;
    }
}
