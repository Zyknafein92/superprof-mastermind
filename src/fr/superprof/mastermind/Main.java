package fr.superprof.mastermind;

public class Main {
    public static void main(String[] args) {
        Mode mode;
        do {
            Mastermind mastermind = new Mastermind();
            System.out.println("------------------------");
            System.out.println("------ MASTERMIND ------");
            System.out.println("------------------------");
            mode = mastermind.showMenu();
            if (mode != null) {
                mastermind.play(mode);
            }
        } while (mode != null);
    }
}
