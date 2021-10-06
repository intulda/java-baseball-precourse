package baseball.core;

import baseball.model.Computer;
import baseball.ui.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseballCore {

    private final String NUMBER_CHECK_EXP = "[+-]?\\d*(\\.\\d+)?";
    private final String AGREE = "1";
    private final String DISAGREE = "2";
    private Computer computer;
    private int strike = 0;
    private int ball = 0;
    private boolean gameMode = true;

    public BaseballCore() {
        computer = new Computer();
        computer.setRandomNumber();
        this.isPlay();
    }

    /**
     * 게임 플레이 여부 함수
     */
    void isPlay() {
        while (this.gameMode) {
            this.gameStart();
        }
    }

    /**
     * 게임 시작 함수
     * 나눠놨던 기능들을 조립한다.
     */
    void gameStart() {
        if(computer.isRestart()) {
            computer.setRandomNumber();
        }
        String number = this.userInput();
        this.resetScore();
        this.numberCompareTo(number);
        if (this.strike == 3) {
            Message.getMessage(Message.SUCCESS);
            this.gameMode = isRunning();
        }
    }

    /**
     * 유저 입력 함수
     * @return
     */
    String userInput() {
        String inputNumber = null;
        Message.getMessage(Message.QUESTION);
        while (!IsUserInputValid(inputNumber)) {
            inputNumber = Message.inputMessage();
        }
        return inputNumber;
    }

    /**
     * 유저입력 유효성 검사
     * @param number
     * @return
     */
    boolean IsUserInputValid(String number) {
        if (number == null) {
            return false;
        }

        if (number.length() != 3) {
            Message.getMessage(Message.ERROR + Message.NUMBER_NOT_EQUALS);
            return false;
        }

        if (!stringNumberCheck(number)) {
            Message.getMessage(Message.ERROR + Message.NOT_A_NUMBER);
            return false;
        }

        return true;
    }

    /**
     * String Type 숫자인지 확인하는 함수
     * @param number
     * @return
     */
    boolean stringNumberCheck(String number) {
        return number.matches(this.NUMBER_CHECK_EXP);
    }

    /**
     * 스코어 리셋
     */
    void resetScore() {
        this.strike = 0;
        this.ball = 0;
    }

    /**
     * 유저의 값이랑 컴퓨터의 랜덤값이랑 비교를 시작하는 함수
     * @param number
     */
    void numberCompareTo(String number) {
        String[] userNumbers = number.split("");
        for (int i = 0; i < userNumbers.length; i++) {
            this.scoreCalculator(Integer.parseInt(userNumbers[i]), i);
        }

        if(this.strike == 3) {
            this.ball = 0;
        }

        Message.getScore(this.strike, this.ball);
    }

    /**
     * 스크라이크 및 볼 스코어 계산 함수
     * @param userNumber
     * @param index
     */
    void scoreCalculator(int userNumber, int index) {
        ArrayList<Integer> randomNumber = computer.getRandomNumber();
        this.strike += this.isStrike(randomNumber.get(index), userNumber);
        this.ball += this.isBall(randomNumber, userNumber, index);
    }

    /**
     * 스트라이크면 1 아니면 0을 리턴하는 함수
     * @param computerNumber
     * @param userNumber
     * @return
     */
    int isStrike(int computerNumber, int userNumber) {
        return computerNumber == userNumber ? 1 : 0;
    }

    /**
     * 볼이면 1 아니면 0을 리턴하는 함수
     * @param computerNumber
     * @param userNumber
     * @return
     */
    int isBall(ArrayList<Integer> computerNumber, int userNumber, int index) {
        int result = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            int currentIndex = computerNumber.indexOf(userNumber);
             result = currentIndex != -1 && currentIndex != index ? 1 : 0;
        }
        return result;
    }

    /**
     * 유저에게 게임을 진행할지 물어보는 함수
     * @return
     */
    boolean isRunning() {
        Message.getMessage(Message.GAME_RUNNING);
        String number = Message.inputMessage();
        isInputValid(number);
        computer.setRestart(this.AGREE.equals(number));
        return this.AGREE.equals(number);
    }

    /**
     * 시작과 종료 사이 사용자 입력이 올바른지 판단하는 함수
     * @param number
     */
    void isInputValid(String number) {
        if (!this.getAgreement().contains(number)) {
            Message.getMessage(Message.ERROR + Message.START_END_INPUT_ERROR);
            this.isPlay();
        }
    }

    /**
     * 유효성 검사를 위한 바뀌지 않는 상수 리스트
     * @return
     */
    List<String> getAgreement() {
        return Collections.unmodifiableList(Arrays.asList(this.AGREE, this.DISAGREE));
    }
}
