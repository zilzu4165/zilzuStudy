package me.zilzustudy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {
    @Test
    void name() {
        ApplicationContextRunner runner = new ApplicationContextRunner();

        runner.run(c -> System.out.println(c.getDisplayName()));
    }

    @Test
    void ThreadTest() {
        Thread thread = new Thread(() -> System.out.println("Run!"));
        thread.run();
    }

    @Test
    void 람다테스트() {
        List<String> elements = new ArrayList<>();
        elements.add("holy-water"); // 10
        elements.add("bad-water!!"); // 11
        elements.add("good-water"); // 10
        elements.add("good-news"); // 9
        elements.add("goods-news"); // 9

        List<Integer> countElements = new ArrayList<>();
        for (String element : elements) {
            countElements.add(element.length());
        }
        System.out.println(countElements);

        String newsType = "holy";

        if (newsType.equals("good")) {
            notifyGoodNews(elements, "good");
        }else if(newsType.equals("bad")){
            notifyGoodNews(elements, "bad");
        }else {
            notifyGoodNews(elements, "holy");
        }

//        if (good) {
//            notifyGoodNews();
//        }
    }

    @Test
    void myLambdaTest() {

        List<String> cities = new ArrayList<>();
        cities.add("busan");
        cities.add("seoul");
        cities.add("ulsan");
        cities.add("newyork");
        cities.add("daegu");
        cities.add("chungju");

        List<Integer> countCities = new ArrayList<>();
        for (String city : cities) {
            countCities.add(city.length());
        }
        System.out.println(countCities);

        List<Integer> collect = cities.stream()
                .map(city -> city.length())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    private void notifyGoodNews(List<String> elements, String newsType) {
        List<Integer> collect = elements.stream()
                .filter((element) -> element.contains(newsType))
                .map(element -> element.length())
//                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    void name2() {
//        ZilzuInterface zilzu = new ZilzuInterface() {
//            @Override
//            public void zilzu() {
//                System.out.println("I am mr zilzu.");
//            }
//        };

        ZilzuInterface zilzu = () -> {
            System.out.println("I am mr zilzu.");
        };

        zilzu.zilzu();
    }
}


@FunctionalInterface
interface ZilzuInterface {
    void zilzu();
}

//
class HolyWaterZilzu implements ZilzuInterface {
    @Override
    public void zilzu() {
        System.out.println("Holy~Water~");
    }
}