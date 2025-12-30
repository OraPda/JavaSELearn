package HeiMaJava.Method1Reference;

import java.util.Arrays;
import java.util.Comparator;

public class Demo3 {
    public static void main() {
//        目标：特定类型的方法引用
//        需求：有一个字符串数组，里面又一些人的英文名字，请按照名字的首字母升序排序
        String[] names = {"Tony","Tom","Jerry","Mike","Marry","Dilei","Caocao","Angle","andy","Bobi","曹操"};
//        把这个数组进行排序
//        Arrays.sort( names);
//        System.out.println(Arrays.toString( names));
//        忽略大小写进行排序
        /*
             Arrays.sort(names, new Comparator<String>() {
                      @Override
         *             public int compare(String o1, String o2) {
         *                 return o1.compareToIgnoreCase(o2);    //java提供的字符串按照首字母忽略大小写比较方法发，compareToIgnoreCase;
         *             }
         *         });
         *         Arrays.sort(names, (String o1, String o2) -> o1.compareToIgnoreCase(o2) );
         */

//        如果Lambda表达式里只是调用一个特定类型的实例方法，并且前面参数列表中的第一个参数是作为方法的主调，后面的所有参数都是作为该实例方法的入参的，则可以进行方法引用
        Arrays.sort(names, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(names));

    }
}
