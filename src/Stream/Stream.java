package Stream;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.stream.*;

public class Stream {
    public static void main(String[] args ){
        ArrayList<String> list = new ArrayList<>();
        list.add("lisi");
        list.add("zhangsan");
        list.add("wangwu");
        list.stream().forEach(item ->{
            System.out.println(item);
        });
    }

}
