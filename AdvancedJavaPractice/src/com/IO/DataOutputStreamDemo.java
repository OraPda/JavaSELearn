package com.IO;

import lombok.Data;

import java.io.*;

public class DataOutputStreamDemo {
    public static void main(String[] args) {
        try(
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("AdvancedJavaPractice\\src\\Study.txt"));
                DataInputStream dis = new DataInputStream(new FileInputStream("AdvancedJavaPractice\\src\\Study.txt"));
                ){
            dos.writeInt(100);
            dos.writeBoolean(true);
            dos.writeChar('a');
            dos.writeDouble(3.14);
            dos.writeUTF("hello world");

            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readChar());
            System.out.println(dis.readDouble());
            System.out.println(dis.readUTF());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
