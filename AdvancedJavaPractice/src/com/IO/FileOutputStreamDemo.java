package com.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
//        使用文件字节输出流将数据写入文件
//        1.创建文件字节输出流管道
//        try (OutputStream os = new FileOutputStream("D:\\java练习\\AdvancedJavaPractice\\src\\Study2.txt"))
        try (OutputStream os = new FileOutputStream("D:\\java练习\\AdvancedJavaPractice\\src\\Study2.txt", true)) // 追加数据
        {
//            2.写入数据
            os.write(97);
            os.write(98);
            os.write('a');
//            写入换行
            os.write("\r\n".getBytes());
//            os.write('徐');     会乱码
             byte[] bytes = {123, 124, 125, 126,41,32,54,75,98,99,100};
             os.write(bytes);
//             只写一部分字节数组
            os.write(bytes, 2, 3);
            os.flush();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
