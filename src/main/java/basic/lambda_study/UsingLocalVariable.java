package basic.lambda_study;

public class UsingLocalVariable {
    void method (final int  arg){  // arg는 final 특성을 가짐
        final int localVar = 40;

        MyFunctionalInteface2 fi2 = ()->{
            System.out.println("arg"+arg);
            System.out.println("lcalVar"+localVar);

        };
        fi2.method();
    }
}
