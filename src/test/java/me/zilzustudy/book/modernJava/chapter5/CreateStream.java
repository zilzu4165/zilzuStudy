package me.zilzustudy.book.modernJava.chapter5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateStream {

    @Test
    @DisplayName("generate 스트림 만들기")
    void generateStream() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("iterate 스트림 만들기")
    void iterateStream() {
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("lotto 번호 만들기")
    void createLottoNumbers() {
        Collection<Integer> lottoNumbers =
                Stream.generate(() -> new Random().nextInt(45) + 1)
        //Stream.of(3,3,3,3,3,3)s
        .distinct()
                .limit(2)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("lottoNumbers = " + lottoNumbers);
    }
}
