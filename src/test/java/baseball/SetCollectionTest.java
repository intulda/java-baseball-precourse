package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("요구사항1: size체크")
    @Test
    void setSizeTest() {
        int size = this.numbers.size();
        assertThat(size).isEqualTo(this.numbers.size());
    }

    @DisplayName("요구사항2: contains 확인 parameterizedTest로 중복제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int value) {
        assertThat(this.numbers.contains(value)).isTrue();
    }

    @DisplayName("요구사항3: contains의 true/false 값둘다 체크한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,true",
            "2,true",
            "3,true",
            "4,false",
            "5,false"
    }, delimiter = ',')
    void containsElseTest(int value, boolean flag) {
        assertThat(this.numbers.contains(value)).isEqualTo(flag);
    }
}
