package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<Apple>();
        apples.add(new Apple("red", 120));
        apples.add(new Apple("green", 150));
        apples.add(new Apple("blue", 160));
        
        List<Apple> data = new ArrayList<Apple>();
        data = filterGreenApples(apples);
        data.forEach(System.out::println);

        data = filter(apples,(Apple apple)->"green".equals(apple.getColor()));

        ApplePredicate appleColorPredicate = new AppleColorPredicate();
        data = filterApples(apples,appleColorPredicate);

        IntPredicate intPredicate = (int i)->i%2==0;
        System.out.println( intPredicate.test( 1900));

        Predicate<Integer> predicate =(Integer i)-> i%2==0;
        System. out . println(predicate.test(  1000));

        Apple a = new Apple( "",1);
        Supplier<Apple> supplier =()->new Apple( "",  3);




    }

    public static List<Apple> filterGreenApples(List<Apple> list) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : list) {
            if (apple.getColor().equals("green")) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterColorApples(List<Apple> list, String color) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : list) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterWeightApples(List<Apple> list, Integer weight) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : list) {
            if (apple.getWeight() >= weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> list, String color, Integer weight, boolean flag) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : list) {
            if ((flag && color.equals(apple.getColor())) || (!flag && apple.getWeight() >= weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> list,ApplePredicate predicate){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : list) {
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    interface ApplePredicate{
        boolean test(Apple apple);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for(T t:list){
            if(predicate.test(t)){
                result.add(t);
            }
        }
        return result;
    }



}
