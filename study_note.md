# Exception 다시 복습 

## Excption 종류
  * RuntimeException
    * 실행타임에서 발생
    * 주요 Exception
      * NullPointException
      * ArrayIndexOutOfBoundsException
      * NumberFormatException
      * ClassCastException
        * 타입변환이 가능한지 instanceof 검사 ( 변수 instanceof 타입 )
  * Exception 
    * 컴파일 단계에서 발생

## 예외처리코드 구조 
  ```java
    try{

    }catch(NullPointExcption | NumberFormatException e ){
        // 예외처리1
    }catch(Exception e){
        // 예외처리2
    }finally{
        // 항상처리
    }
    
  ```
  * 상위 예외 클래스가 하위 예외 클래스보다 아래 위치
  * 7버젼에서 try-with-resource 추가
    * java.lang.AutoCloseable 인터페이스를 구현하고 있어야 함 
  ```java
  try(FileInputStream fis = new FileInputStream("file.txt")){
    // 예외   
  }catch((IOException e){
    // 예외
  }
  ```
## throws 
  * declare exceptions that can occur during the execution of a program
  * (예외처리를 메서드내에 직접하지 않고 ) 메서드를호출한 곳으로 예외를 던지기
  * 메소드 선언부 끝에 작성.  메소드에서 처리하지 않은 예외를 호출한 곳으로 떠넘김 
  ``` java  
  public void methodName() throws ClassNotFoundException{
  }
  ```
## 사용자 정의 예외 
  * java 표준 api에서 제공하는 예외 클래스로 표현이 어려울때 직접 예외클래스를 선언하여 사용
  * 관례적으로 기본생성자와 message를 인자로 갖는 생성자 생성 
  ```java
  public class MyCustomeException extends Exception{
    public MyCustomeException(){}
    public MyCustomeException(String message){ super(message)}
}
  ```
## throw ( 예외발생 )
  ```java
  throw new Exception();
  throw new XXXException("메세지");
  ```
## 주요 메서드
  * getMessage()
  * printStackTrace()


# Interface 복습
  * 모든 메서드는 기본적으로 public 이고 더 낮은 접근 제한으로 작성 X
  * 인터페이스 변수 = 구현객체 ();
    * 구현객체 > 인터페이스 타입으로 자동타입변환(Promotion)이 일어남 
  * 구성
    * 추상메서드 ( Abstract Method)
      * abstract 를 생략해도 컴파일과정에서 붙게됨  
      * 반드시 implement @Override
        * @Override 생략 가능 
    * 상수필드 (Constant Field)
      * 인터페이스명.상수필드 접근 가능 
    * 정적 메서드 ( static method ) (1.8부터 지원)
      * 인터페이스명.정적메서드() 직접호출 가능
      * [public] static 리턴타입 메서드명(매게변수,...){...}
    * 디폴트 메서드 Default Method (1.8부터 지원)
      * [public] default 리턴타입 메서드명(매게변수,...){...}
      * 기존인터페이스를 확장해서 새로운 기능을 추가 
        * 이때 구현체 모두에게 구현을 강제하지 않아도 됨 
          * 기존 abstract의 경우 모두 구현하지 않으면 컴파일 오류 
      * 모든 구현객체가 가지고 있는 기본 메소드 
        * 인터페이스 메서드를 그대로 사용해도 되고
        * 재정의(Override) 해서사용해도 됨
      * 디폴트 메서드의 송속
        * 디폴트 메서드를 단순히 상속 
        * 디폴트 메서드를 재정의(Override)
        * 디폴트 메서드를 추상메소드로 재선언

  * 람다식을 이용한 익명 구현체 사용가능
    ```java
    /*
    인터페이스 변수 = new 인터페이스(){
        // 추상메서드 내용 
    };
    */
    
    RemoteControl rc = new RemoteControl(){
        public void turnOn{ /* 실행문 구현 */};
    };
    ```
  * 구현객체는 인터페이스를 다중상속 가능
    ```code
    public class MyClass implenent MyinterfaceA, MyinterfaceB{
        // Myinterfaca A 메소드 선언
        // Myinterfaca B 메소드 선언
    }
    ```
  * 인터페이스는 인터페이스를 다중 상속 가능 
    ```code
    public interface 하위인터페이스 extends 상위 인터페이스1, 상위인터페이스2{
        // ...
    }
    ```  
    
  * 강제 타입 변환시 instanceof로 검사  
    * ClassCastException이 발생할수 있음
    ```java
    if(vehicle instanceof Bus){
        Bus bus = (bus) vechine;
    }
    ```

## 제네릭 
  * 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법
  * 표기형식: 클래스 or 인터페이스 명 뒤에 < 타임 >
      ```java
      class Person<T>{
        public T info; 
      }
      Person<String> p1 = new Person<String>();
      Person<StringBuilder> p2 = new Person<StringBuilder>();
      ```
  * 왜 jeneric을 사용하는가?
    * type safety 
      * 잘못된 타입이 사용될수 있는 문제를 컴파일 과정에서 제거 
      * 참조형 데이터만 올수 있다. (기본형은 X )
        * int > Integer, double > Double, long > Long
    * 매개변수를 통해 타입 추론이 가능시에는 생략 가능 
      ```java
      
      class EmployeeInfo{
        public int rank;
        Employinfo( int rank ){
            this.rank  = rank;
      }
      
      class Person<T,S >
        public T info;
        public S id;
      ``
  * extends 를 이용한 타입 제한 가능
    * <T extends 상위타입>
      * 구체상위타입이나 그 하위 타입만 올수 있다. 
    * <T super 하위타입>
      * 구체하위타입이나 그 상위 타입이 올수 잇다. 
  * 와일드 카드 ?
    * 아래와 같이 클래스 상속 구조를 가질때  
      * Person - Student- HighStudent 
      * Person - Worker 
    * Course<?>
      * 수강생(?) 의 타입은 모든 타입이 될수 있다 
        * Person, Worker, Student, HighStudent
    * Course<? extends Student >
      * 수강생(?) 의 타입은 Student와 그 하위타입이 될수 있다. 
          * Student, HighStudent
    * Course<? super  Worker >
      * 수강생(?) 의 타입은 Worker와 그 하위타입이 될수 있다.
          * Worker, Person 

# 람다 복습 
## 람다식 
  * JDK 1.8 부터 지원
  * 익명함수를 생성하기 위한 식으로 functional programming 을 지원 하기 위한 기법 
  * 람다식 > 매개변수를 가진 코드 block > 익명 구현 객체
  * 형식: (매개변수,...)->{실행문;...}
  ```java
    Runable runable = new Runable(){
            public void run (){
                /*실행코드*/
        }
    }
    // 위 코드를 람다식으로 표현시 
    Runable runable = () -> { /*실행코드*/ }; 
        
  ```
  * 기본문법
  ```java
    // (타입 매개변수,...)->{실행문;...}
    
    (int a)->{System.out.println(a)};
    (a)->{System.out.println(a);}   // 런타임시 대입되는 값에 따라 자동 인식하기에, 일반적으로 타입을 지정X
    a->{System.out.println(a)}      // 단일 매개변수인경우 괄호 생략
            
    (x,y)->{ return x+y; }         // 리턴 가능
    (x,y)->x+y                     // {}안에 return문만 존재시 {}  return 생략 가능
  ```
  * 함수적 인터페이스 
    * @FunctionalInterface (생략 가능 )
      * Functional Interface는 일반적으로 '구현해야 할 추상 메소드가 하나만 정의된 인터페이스'
  * 클래스의 멤버 사용
    * inner class의 경우 : this.멤버명
      * this는 익명 구현 객체를 가르킴
    * outter class의 경우 : 클래스명.this.멤버명 사용 
      * 객체명.this는 바깥 객체를 가르킴  

  * 람다식에서 참조하고 있는 local 변수는 final여야 한다. 
    * final 지정은 안해도 됨 
    
  * 표준 API 
    * Consumer : 매개값 O, 리턴값 X 
      * accept() 메소드 
    * Supplier : 매개값 X, 리턴값 O
      * getXXX() 메소드를 가짐 
        * get()
        * getAsInt()
        * getAsBoolean()
        * getAsDouble()
        * getAsLong()
    * Function :  매개값 O, 리턴값 O
      * 매개값 -> 리턴값 매핑 (타입변경 가능)
      * applyXXX 메소드를 가짐 
        * 중략 
    * Operator :  매개값 O, 리턴값 O
      * 매개값 -> 리턴값 연산 (동일타입)
      * applyXXX 메소드를 가짐 
          * 중략
    * Predicate : : 매개값 O, 리턴값 boolean
      * testXXX 메소드를 가짐
        * 중략
      * 디폴트 메서드: and() or() negate()   
      * 정적 메서드:  isEqual()
    

## 스트림 복습 
