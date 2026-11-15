package OwnProject2.ConsoleBox;

import java.util.List;

public class ConsoleLogin {
    private final int width = 50;

    private int calculatePadding (String text) {
        int blank = (this.width - text.length()) / 2;
        return Math.max(0, blank);
    }

    private String boxLine() {
        return ("-".repeat(this.width));
    }

    private String middleTitle (String title) {
        String space = " ".repeat(calculatePadding(title)) + title + " ".repeat(calculatePadding(title));
        if (title.length() % 2 == 0) {
            return space;
        } else {
            return space + " ";
        }
    }

    public void show (String title, List<String> hint) {

        System.out.println(
                "┌" + boxLine() + "┐"
        );

        System.out.println(
                "|" + middleTitle(title) + "|"
        );

        System.out.println(
                "├" + boxLine() + "┤"
        );

        for (String word : hint) {
            System.out.println(
                    "|" + middleTitle(word) + "|"
            );
        }

        System.out.println(
                "└" + boxLine() + "┘"
        );

    }
}
