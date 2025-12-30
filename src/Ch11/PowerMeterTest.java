package Ch11;

public class PowerMeterTest {
    public static void main(String[] args) {
        PowerMeter powerMeter = new PowerMeter();
        powerMeter.setRecord();
        powerMeter.showRecord();
        powerMeter.showUsedAmount();
        powerMeter.calcUsedFee();
        powerMeter.showFee();


    }
}
