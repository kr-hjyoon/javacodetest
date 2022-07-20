import basic.inteface_study.AudioRemoteControl;
import basic.inteface_study.RemoteControl;
import basic.inteface_study.TVRemoteControl;

public class CodeTestMain {

    public static void main(String[] args) {

        TVRemoteControl rc1 = new TVRemoteControl();
        AudioRemoteControl rc2 = new AudioRemoteControl();
        rc1.setVolumn(5);
        rc2.setVolumn(5);

        System.out.println("hello world");
    }
}
