package lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TransactionDara {




    public static void main(String[] args) {
        List<Transaction> transactions=new ArrayList<>();


        Trader raoul=new Trader("Raoul","R city");
        Trader jack=new Trader("Raoul","J city");
        Trader rose=new Trader("Raoul","R city");
        Trader tom=new Trader("Raoul","T city");
        Trader cake=new Trader("Raoul","C city");

        transactions.add(new Transaction(raoul,2017,200));
        transactions.add(new Transaction(jack,2018,600));
        transactions.add(new Transaction(rose,2012,800));
        transactions.add(new Transaction(tom,2019,2000));
        transactions.add(new Transaction(cake,2020,6000));
        List<Transaction> darta2017=transactions
                .stream()
                .filter(transaction -> transaction.getYear()==2017)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
                 darta2017.forEach(System.out::println);

//想查找T 城市 排序
        List<Trader> traders=transactions.stream()
                .map(transaction -> transaction.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        traders.forEach(System.out::println);



//        int sum=transactions.stream().reduce()
        //  求值的总和
        int values=transactions.stream().mapToInt(Transaction::getValue).sum();
        System.out.print(values);

        OptionalInt values1=transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();


        IntStream intStream=transactions.stream().mapToInt(Transaction::getValue);
        Stream<Integer> stream=intStream.boxed();

        //1到100的偶数

        intStream=IntStream.rangeClosed(1,100).filter(i->i%2==0);
///        System.out.println(intStream.count());
        intStream.forEach(System.out::println);

        Stream<Object> my=Stream.of(1,2,3,4,5,4,"a");

        Arrays.stream(new String[] {"1","2","2"});

        List<String> list=new ArrayList<>();
        Set<String> set=new HashSet<>();
        set.stream();

//        try{
//            Stream<String> lines = Files
//                    .lines(Paths.get( "f:\\a.txt"), Charset.defaultCharset());
//
//        }catch (IOException e){
//            System.out.println(e);
//        }
//        Stream.iterate( 0, integer -> integer+2). limit(10).forEach(System . out::println);

        Long count=transactions
                .stream()
                .filter(transaction -> transaction. getYear( ) == 2017)
                .count();
        System.out.println(count);

//        maxValue=transactions
//                .stream()
//                .collect(maxBy(Comparator.comparing(Transaction::getValue)));

//
//        Double average = transactions
//                . stream()
//                . collect(averagingLong(Transaction::getValue));
//        System. out . println(average);



    }

}
