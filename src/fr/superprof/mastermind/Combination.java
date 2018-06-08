package fr.superprof.mastermind;

import java.util.Arrays;
import java.util.Random;

public class Combination {

    private Integer[] values;
    private String result;

    private static final String[] RESULTS = {"+", "=", "-"};

    public Combination() {
        this.values = generateRandom();
        this.result = "";
    }

    public Combination(Integer ...values) {
        this.values = values;
        this.result = "";
    }

    public Combination(Combination combination) {
        this(combination.getValues());
    }

    public Boolean compare(Combination combination) {
        StringBuilder sb = new StringBuilder();
        boolean isFound = true;
        for (int i = 0; i < this.values.length; i++) {
            int index = this.values[i].compareTo(combination.getValues()[i]) + 1;
            if (index != 1) {
                isFound = false;
            }
            sb.append(RESULTS[index]);
        }
        this.result = sb.toString();
        return isFound;
    }

    public static Integer[] generateRandom() {
        Integer randoms[] = new Integer[Mastermind.COMBINATION_LENGTH];
        Random random = new Random();
        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = Mastermind.MIN_RANDOM + random.nextInt(Mastermind.MAX_RANDOM + 1);
        }
        return randoms;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.values) + " : " + this.result;
    }

    public Integer[] getValues() {
        return values;
    }

    public void setValues(Integer[] values) {
        this.values = values;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
