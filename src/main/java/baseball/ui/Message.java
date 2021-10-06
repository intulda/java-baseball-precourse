package baseball.ui;

import nextstep.utils.Console;

/**
 * UI를 담당할 Message 전역 클래스
 */
public class Message {

    public static final String GAME_RUNNING = "게임을 새로 시작하려면 1 종료하려면 2를 입력해주세요.";
    public static final String QUESTION = "숫자를 3자리 입력해주세요.";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";
    public static final String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 끝!";

    public static final String ERROR = "[ERROR]";
    public static final String START_END_INPUT_ERROR = "옳바른 입력 값이 아닙니다. 다시 입력해주세요.";
    public static final String NUMBER_NOT_EQUALS = "옳바른 입력 값이 아닙니다. 다시 입력해주세요.";
    public static final String NOT_A_NUMBER = "숫자가 아닙니다. 다시 입력해주세요.";

    /**
     * 메세지를 그대로 리턴 해주는 함수
     * @param message
     */
    public static void getMessage(String message) {
        System.out.println(message);
    }

    /**
     * 유저의 값을 입력할 수 있는 환경 제공
     * @return
     */
    public static String inputMessage() {
        return Console.readLine();
    }

    /**
     * 현재 스코어 표기
     * @param strike
     * @param ball
     * @return
     */
    public static void getScore(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            getMessage(Message.NOTHING);
            return;
        }

        if (strike == 3) {
            getMessage(strike + STRIKE);
            return;
        }

        getMessage(strike + STRIKE + " " + ball + BALL);
    }
}
