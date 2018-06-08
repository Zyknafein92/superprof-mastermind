package fr.superprof.mastermind;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Board {
    private Mastermind mastermind;
    private Combination secret;
    private ArrayDeque<Combination> combinations;
    private Boolean isFound;

    public Board(Mastermind mastermind) {
        this.mastermind = mastermind;
        this.secret = new Combination();
        this.combinations = new ArrayDeque<>();
        this.isFound = Boolean.FALSE;
    }

    public Combination userInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Veuillez entrer votre combinaison de " + Mastermind.COMBINATION_LENGTH + " chiffres");
        String input = scan.nextLine();
        Integer[] inputInt = new Integer[Mastermind.COMBINATION_LENGTH];
        for (int i = 0; i < inputInt.length; i++) {
            inputInt[i] = Character.getNumericValue(input.charAt(i));
        }
        //TODO: ADD more check ex. letters, etc.
        return new Combination(inputInt);
    }

    public boolean addCombination(Mode mode) {
        Combination userCombinations = new Combination();
        if (mode.equals(Mode.CHALLENGER)) {
            userCombinations = this.userInput();
        }
        this.isFound = userCombinations.compare(secret);
        this.combinations.add(userCombinations);
        return this.isFound;
    }

    public void showLastCombination() {
        System.out.println(this.combinations.getLast() + " • " + this.combinations.size());
    }

    public Combination getSecret() {
        return secret;
    }

    public void setSecret(Combination secret) {
        this.secret = secret;
    }

    public ArrayDeque<Combination> getCombinations() {
        return combinations;
    }

    public void setCombinations(ArrayDeque<Combination> combinations) {
        this.combinations = combinations;
    }

    public Boolean getFound() {
        return isFound;
    }

    public void setFound(Boolean found) {
        isFound = found;
    }
}
