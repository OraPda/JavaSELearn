package Ch11;

import java.util.Scanner;

public class PowerMeter {
    public int lastRecord;
    public int currentRecord;
    public double price = 1.2;
    public double fee;
    public void setRecord(){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        lastRecord = scanner.nextInt();
        currentRecord = scanner1.nextInt();
    }
    public void showRecord(){
        System.out.println("上月电表读数为：" + lastRecord +",本月电表读数：" + currentRecord);
    }
    public int calcUsedAmount(){
        int amount =currentRecord - lastRecord  ;
        return amount;
    }
    public void showUsedAmount(){
        System.out.println("本月用电度数：" + calcUsedAmount());
    }
    public void calcUsedFee(){
        fee = price * calcUsedAmount();
    }
    public void showFee(){
        System.out.println("本月费用：" + fee);
    }
}
