package TestNGIntro;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleTest {

    // count the number of names starting with 'A' in list
    @Test
    public void regular() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("Furkan");
        names.add("Abdullah");
        names.add("Haluk");
        names.add("Ahmet");

        int count = 0;

        for (String name : names) {
            if (name.startsWith("A")) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("Furkan");
        names.add("Abdullah");
        names.add("Haluk");
        names.add("Ahmet");

        long count = names.stream().filter(name -> name.startsWith("A")).count();
        System.out.println(count);

        long c = Stream.of("Ali","Furkan","Abdullah", "Haluk", "Ahmet").filter(n -> n.startsWith("A")).count();
        System.out.println(c);

        names.stream().filter(name -> name.length() > 4).forEach(name -> System.out.println(name));
        System.out.println("------");
        names.stream().filter(name -> name.length() > 4).limit(2).forEach(name -> System.out.println(name));
    }

    @Test
    public void streamMap() {
        // print names which have last letter as "k" with uppercase
        ArrayList<String> names1 = new ArrayList<>();
        names1.add("Melik");
        names1.add("Furkan");
        names1.add("Abdullah");
        names1.add("Haluk");
        names1.add("Faruk");

        names1.stream().filter(name -> name.endsWith("k")).map(name -> name.toUpperCase()).
                forEach(name -> System.out.println(name));

        // print names which starts "F" with uppercase and sorted
        System.out.println("-------------");
        List<String> names2 = Arrays.asList("Elif","Furkan","Zeynep", "Melis", "Faruk");
        names2.stream().filter(name -> name.startsWith("F")).sorted().
                forEach(name -> System.out.println(name.toUpperCase()));

        //Merging to list
        System.out.println("--------");
        Stream<String> newStream = Stream.concat(names1.stream(),names2.stream());
        //newStream.sorted().forEach(n -> System.out.println(n));

        // Check "Zeynep" is in the list or not
        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Zeynep"));
        Assert.assertTrue(flag);
    }
    @Test
    public void streamCollect() {
        List<String> names = Stream.of("Faruk","Furkan","Abdullah", "Haluk", "Ahmet").
                filter(n -> n.endsWith("k")).map(n -> n.toUpperCase()).collect(Collectors.toList());
        System.out.println(names.get(1));

        List<Integer> values = Arrays.asList(3,5,7,2,9,7,2,1);
        // print distinct numbers from this array
        values.stream().distinct().forEach(v -> System.out.print(v + " "));
        System.out.println();

        // sort the array and print 3rd -> 1 2 3 5 7 9
        List<Integer> sl = values.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(sl.get(2));

    }
}
