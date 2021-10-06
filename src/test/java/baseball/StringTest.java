package baseball;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("요구사항1: split 테스트")
    @Test
    public void splitTest() {
        String testStr = "1,2";
        String[] splitStr = testStr.split(",");
        assertThat(splitStr).contains("1", "2");
        assertThat(splitStr).containsExactly("1", "2");
    }

    @DisplayName("요구사항2: substring() 테스트")
    @Test
    public void substringTest() {
        String testStr = "(1,2)";
        String subStr = testStr.substring(1,4);
        assertThat(subStr).isEqualTo("1,2");
    }

    @DisplayName("요구사항3: charAt 문자 가져오기 테스트")
    @Test
    public void charAtStrTest() {
        String testStr = "abc";
        int size = testStr.length();
        assertThatThrownBy(() -> testStr.charAt(size))
                .isInstanceOf(IndexOutOfBoundsException.class);

    }
}
