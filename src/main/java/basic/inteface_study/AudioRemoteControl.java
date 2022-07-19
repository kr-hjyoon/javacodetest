package basic.inteface_study;

public class AudioRemoteControl implements RemoteControl{
    private int volumn ;
    public void turnOn() {
        System.out.println("오디오를 켭니다.");
    }

    public void turnOff() {
        System.out.println("오디오를 껍니다.");
    }

    public void setVolumn(int volumn) {
        if( volumn > RemoteControl.MAX_VOLUMN){
            this.volumn =  RemoteControl.MAX_VOLUMN;
        }else if ( volumn < RemoteControl.MIN_VOLUMN){
            this.volumn = RemoteControl.MIN_VOLUMN;
        }else{
            this.volumn = volumn;
        }
        System.out.println("현재 볼륨 :" + volumn);
    }
}
