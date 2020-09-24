package lambda;

public class AppleWeightPredicate implements Lambda.ApplePredicate {

    public boolean test(Apple apple){
        return apple.getWeight() >= 150;
    }
}
