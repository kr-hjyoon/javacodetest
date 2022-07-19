package basic.inteface_study;

public interface RemoteControl {

    // 상수 는 가질수 있다.
    public int MAX_VOLUMN = 10;
    public int MIN_VOLUMN = 0;

    // 추상 메소드
    public void turnOn();
    public void turnOff();
    public void setVolumn(int volumn);


    // default 메소드
    default void setMute(boolean mute){
        if (mute) {
            System.out.println("무음처리합니다.");
        }else{
            System.out.println("무음해제합니다.");
        }
    }

    // 정적 메소드 선언
    static void changeBattery(){
        System.out.println("건전지를 교환합니다.");
    }

}
