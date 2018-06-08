package fr.superprof.mastermind;

import java.util.Scanner;

public class Mastermind {

    private Board board;

    public static final int COMBINATION_LENGTH = 4;
    public static final int MIN_RANDOM = 0;
    public static final int MAX_RANDOM = 9;
    public static final int MAX_TRY = 10;

    public Mastermind() {
        this.board = new Board(this);
    }

    public void play(Mode mode) {
        boolean isFound = false;
        int attempt = 0;
        if (mode.equals(Mode.CHALLENGER)) {
            System.out.println("Secret: " + board.getSecret()); //todo remove
        }
        if (mode.equals(Mode.DEFENDER)) {
            this.board.setSecret(this.board.userInput());
        }
        while (!isFound && attempt < MAX_TRY) {
            isFound = board.addCombination(mode);
            board.showLastCombination();
            attempt = board.getCombinations().size();
        }
        showEndGame(isFound);
    }

    public void showEndGame(Boolean isFound) {
        if (isFound) {
            System.out.println("Bravo! You win in " + board.getCombinations().size() + " attempt(s)");
        } else {
            System.out.println("Noob");
        }
    }

    public Mode showMenu() {
        System.out.println("Veuillez choisir un mode de jeu :");
        System.out.println("(0) Challenger - Trouver la combinaison de l'ordinateur !");
        System.out.println("(1) Defenseur - L'ordinateur doit trouver votre combinaison !");
        System.out.println("(2) Duel - Affronter vous tour à tour pour qu'il n'en reste qu'un !");
        System.out.println("(*) Quitter le jeu");

        Scanner sc = new Scanner(System.in);
        Mode mode;
        try {
            mode = Mode.getModeByIndex(sc.nextInt());
            System.out.println("Vous avez choisis le mode " + mode.getName());
        } catch (Exception e) {
            mode = null;
        }
        return mode;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
