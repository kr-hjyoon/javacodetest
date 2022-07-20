package basic.inteface_study;

public class AudioRemoteControl implements RemoteControl{
    private int volumn ;
    @Override
    public void turnOn() {
        System.out.println("오디오를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("오디오를 껍니다.");
    }

    @Override
    public void setVolumn(int volumn) {
        if( volumn > RemoteControl.MAX_VOLUMN){
            this.volumn =  RemoteControl.MAX_VOLUMN;
        }else if ( volumn < RemoteControl.MIN_VOLUMN){
            this.volumn = RemoteControl.MIN_VOLUMN;
        }else{
            this.volumn = volumn;
        }
        System.out.println("Audio 볼륨 :" + volumn);
    }
}
