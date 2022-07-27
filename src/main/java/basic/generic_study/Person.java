package basic.generic_study;

public class Person<T,S>{
    public T info;
    public S id;
    public Person(T info, S id) {
        this.info = info;
        this.id = id;
    }
    public <U> void printInfo(U info){
        System.out.println(info);
    }
}
