package HeiMaJava.Method1Reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Demo4 {
    static void main() {
/*
        目标：理解构造器引用
        创建接口的匿名内部类对象
        CarFactory carFactory = new CarFactory() {
            @Override
            public Car getCar(String name) {
                return new Car(name);
            }
        };
        CarFactory carFactory = (name) -> new Car(name);
*/
        CarFactory carFactory = Car::new;
        Car car = carFactory.getCar("法拉利");
        System.out.println(car);
    }
}
interface CarFactory {
    Car getCar(String name);
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Car{
    private String name;
}