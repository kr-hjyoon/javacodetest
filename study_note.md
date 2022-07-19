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




