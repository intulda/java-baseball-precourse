package baseball.model;

import baseball.ui.Message;
import nextstep.utils.Randoms;

import java.util.*;

public class Computer {
    private LinkedHashSet<Integer> numbers;
    private boolean restart = false;

    public Computer() {
        numbers = new LinkedHashSet<>();
    }

    /**
     * 랜덤 넘버 생성함수
     */
    public void setRandomNumber() {
        if (this.restart) {
            this.clearNumbers();
            this.setRestart(false);
        }

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numbers.add(randomNumber);
        }
    }

    public void clearNumbers() {
        numbers.clear();
    }

    public boolean isRestart() {
        return restart;
    }

    public void setRestart(boolean restart) {
        this.restart = restart;
    }

    /**
     * 불변성을 위한 리스트 카피
     * @return
     */
    public ArrayList<Integer> getRandomNumber() {
        ArrayList<Integer> copyList = new ArrayList<>();
        copyList.addAll(numbers);
        return copyList;
    }
}
