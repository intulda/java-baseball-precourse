package baseball.ui;

/**
 * UI를 담당할 Message 클래스
 */
public class Message {

    private final String GAME_START = "야구게임을 시작하시려면 1 아니면 2를 입력해주세요.";
    private final String GAME_RESTART = "게임을 재시작 하시겠습니까? 시작하시려면 1 아니면 2를 입력해주세요.";
    private final String QUESTION = "숫자를 3자리 입력해주세요.(1 ~ 9)";
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String MISSING = "미싱";

    /**
     * 메세지를 그대로 리턴 해주는 함수
     * @param message
     */
    public static void getMessage(String message) {
        System.out.println(message);
    }
}
