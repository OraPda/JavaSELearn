package Ch10;
import java.util.*;
import java.math.*;

public class Test {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            String s1 = scanner.nextLine();
            String [] s2 = s1.split(" ");
            int [] num  = new int[s2.length];
            for (int i = 0;i< s2.length;i++){
                num[i] = Integer.parseInt(s2[i]);
            }
            if(num[0] +num[1] > num[2]){
                System.out.print("true");
            }else{
                System.out.println("false");
            }


        }
}
