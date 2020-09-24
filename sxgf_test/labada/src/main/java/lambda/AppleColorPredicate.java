package lambda;

public class AppleColorPredicate implements Lambda.ApplePredicate {

    public boolean test(Apple apple){
        return "green".equals(apple.getColor());
    }
}
