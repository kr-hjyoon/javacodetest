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