package basic.lambda_study;

import java.util.function.Function;

import static java.lang.Integer.sum;

public class LambdaMain {
    public static void main(String[] args) {

        MyFunctionalInteface fi ;

        fi = ( x, y)-> x + y;
        System.out.println(fi.method(4, 5));

        fi = ( x, y)-> sum(x,y);
        System.out.println(fi.method(4, 5));

        // 표준 API Function

        //Function<Integer, Integer>  function = (x, y) -> x+y;


    }
}
