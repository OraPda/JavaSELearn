package HeiMaJava.demo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JD implements  Switch{
    private String name;
//    状态:开关
    private boolean status;


    @Override
    public void press() {
//        控制当前设备的开关
        status=!status;
    }
}
