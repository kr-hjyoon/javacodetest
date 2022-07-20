package basic.inteface_study;

public class TVRemoteControl implements RemoteControl{
    private int volumn ;
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 껍니다.");
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
        System.out.println("TV 볼륨 :" + volumn);
    }
}
