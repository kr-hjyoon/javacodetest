package basic.generic_study;

public class GenericMain {
    public static void main(String[] args) {
        EmployInfo ei = new EmployInfo(1);
        Integer rank = Integer.valueOf(10);

        // 타입추론으로 생략 가능
        // Person<EmployInfo, Integer> person1 = new Person<EmployInfo, Integer>( ei, rank);
        Person person1 = new Person( ei, rank);

        // 타입 추론으로 생략 가능
        // person1.<EmployInfo>printInfo(ei);
        person1.printInfo(ei);
    }
}
