import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("String 1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String 1을 ,로 split 했을 때 1만 포함하는 배열 반환 테스트")
    void splitOnlyOne() {
        assertThat("1".split(",")).contains("1");
    }

    @Test
    @DisplayName("String (1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\" 반환하는 테스트")
    void substring() {
        assertThat("(1,2)".substring(1, 4)).contains("1,2");
    }

    @ParameterizedTest
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 성공적으로 가져오는 테스트")
    @CsvSource(value= {"0,a", "1,b,","2,c"})
    void charAt(int idx, char chr) {
        assertThat("abc".charAt(idx)).isEqualTo(chr);
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 문자 위치값이 벗어났을 때 StringIndexOutOfBoundsException 발생하는지 테스트")
    void charAtException() {
        String data = "abc";

        assertThatThrownBy(() -> data.charAt(5))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> data.charAt(9)).withMessageMatching("String index out of range: 9");
    }
}