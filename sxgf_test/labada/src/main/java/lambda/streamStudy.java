package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class streamStudy {
    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<Apple>();
        apples.add(new Apple("red", 120));
        apples.add(new Apple("green", 150));
        apples.add(new Apple("blue", 160));
        //filter 接收一个返回boolean的函数 apple->"green".equals(apple.getColor()) 这个地方是判断是否为true 如果为true则返回
        List<Apple> appleList = apples.stream().filter(apple->"green".equals(apple.getColor())).collect(Collectors.toList());
        //foreach循环等同下面这个循环
        appleList.forEach(System.out::println);
        for (Object aa:appleList) {
            System.out.println(aa);
        }

        List<Integer> integers=Arrays.asList(1,2,4,3,4,5,7);

        List<Integer> integerList=integers.stream().filter(integer -> integer%2==0).distinct().collect(Collectors.toList());
        integerList.forEach(System.out::println);


        System.out.println("-----------------------------------");
        //limit()的作用是只输出integers中的钱两位数字
        List<Integer> integerList1=integers.stream().limit(3).collect(Collectors.toList());
        integerList1.forEach(System.out::println);
        System.out.println("-----------------------------------");
        //skip: 作用是跳过前三个
        List<Integer> integerList2=integers.stream().skip(3).collect(Collectors.toList());
        integerList2.forEach(System.out::println);
        System.out.println("-----------------------------------");
        List<String> integerList3=apples.stream().map(Apple::getColor).collect(Collectors.toList());
        integerList3.forEach(System.out::println);
        System.out.println("-----------------------------------");

        boolean flag=apples.stream().anyMatch(apple -> apple.getWeight()>120);
        System.out.print("anyMatch:"+flag);
        System.out.println("-----------------------------------");
        boolean flag1=apples.stream().allMatch(apple -> apple.getWeight()>120);
        System.out.println("anyMatch:"+flag1);

        boolean flag3=apples.stream().noneMatch(apple -> apple.getWeight()>120);
        System.out.println("anyMatch:"+flag3);


        Optional<Apple> singin=apples.stream().filter(apple -> apple.getWeight()>100).findAny();
        singin.ifPresent(apple -> System. out . println(apple.getColor()));

        System.out.println("findany:"+singin.isPresent());

        Optional<Apple> singin1=apples.stream().filter(apple -> apple.getWeight()>100).findFirst();
        singin1.ifPresent(apple -> System. out . println(apple.getColor()));

        System.out.println("findany:"+singin1.isPresent());

        int sum = 0;
        for(Apple apple:apples){
            sum = sum + apple.getWeight();
        }
        System. out .println("-------------------------apple sum ="+ sum);
        sum = apples. stream().map(Apple::getWeight). reduce(0 ,Integer::sum);
        System. out . print("--------------------------reduce sum =" + sum);



    }
}
