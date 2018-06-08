package fr.superprof.mastermind;

import java.util.Arrays;

public enum Mode {
    
    CHALLENGER("Challengeur"),
    DEFENDER("Defender"),
    DUEL("Duel");

    private String mode;

    Mode(String mode) {
        this.mode = mode;
    }

    public static Mode getModeByIndex(int index) throws ArrayIndexOutOfBoundsException {
        return Arrays.asList(Mode.values()).get(index);
    }

    @Override
    public String toString() {
        return this.mode;
    }

    public String getName() {
        return mode;
    }

    public void setName(String mode) {
        this.mode = mode;
    }
}
