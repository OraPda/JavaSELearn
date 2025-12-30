package ShangguiguJava.SelfdefiningException;

public class Person {
    private String name;
    private  int lifeValue;

    public Person() {

    }

    public Person(String name, int lifeValue) {
        this.name = name;
        setLifeValue(lifeValue);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public void setLifeValue(int lifeValue) {
        if(lifeValue <0){
            throw  new NoLifeValueException("生命不可为负数:" + lifeValue);
        }
        this.lifeValue = lifeValue;
    }



}
