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
    void ddd() {
        List<String> elements = new ArrayList<>();
        elements.add("holy-water"); // 10
        elements.add("bad-water"); // 9
        elements.add("good-water"); // 10
        elements.add("good-news"); // 9
        elements.add("good-news"); // 9

        List<Integer> countElements = new ArrayList<>();
        for (String element : elements) {
            countElements.add(element.length());
        }
        System.out.println(countElements);

        List<Integer> collect = elements.stream()
                .filter((element) -> element.contains("good"))
                .map(element -> element.length())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(collect);

//        if (good) {
//            notifyGoodNews();
//        }
    }

    private void notifyGoodNews() {

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