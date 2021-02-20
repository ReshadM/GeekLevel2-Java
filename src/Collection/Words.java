package Collection;


import java.util.*;

public class Words {


    public static void main(String[] args) {

        List<String> words = Arrays.asList("Hello", "My", "Name", "Is", "Mercedes", "Lamborghini",
               "Ferrari", "Bugatti", "Tesla", "Hello", "BMW", "Audi", "Pagani", "Niva","Hello");



        Set<String> setArray = new HashSet<>(words);
        System.out.println(setArray); //Печать уникальных слов
        for (String s : setArray) {                                             //Печатает количество
            System.out.println(s + ": " + Collections.frequency(words, s)); //повторяющихся слов
        }
    }
}


