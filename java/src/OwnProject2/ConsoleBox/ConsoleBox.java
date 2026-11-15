package OwnProject2.ConsoleBox;

import java.util.List;

public class ConsoleBox {

    private final int width = 85;
    private final int rightWidth = 30;

    private int calculatePadding(String text, int boxWidth) {
        int blank = boxWidth - text.length() - 1;
        return Math.max(0, blank - 1);
    }

    private String leftBoxLine() {
        int len = Math.max(0, this.width - this.rightWidth - 1);
        return("-".repeat(len));
    }

    private String rightBoxLine() {
        return("-".repeat(this.rightWidth));
    }

    private String boxContent(String text, int boxWidth) {
        return text + " ".repeat(calculatePadding(text, boxWidth));
    }

    public void show(String leftTitle, String rightTitle, List<String> left, List<String> right) {
        int maxLines = Math.max(left.size(), right.size());
        int leftLine = this.width - rightWidth;
        int rightLine = this.rightWidth + 1;

        System.out.println(
                "┌" + leftBoxLine() +
                        "┬" + rightBoxLine() + "┐"
        );

        System.out.println(
                ("|" + " " + boxContent(leftTitle, leftLine) + "|" +
                        " " + boxContent(rightTitle, rightLine) + "|")
        );

        System.out.println(
                "├" + leftBoxLine() + "┼" + rightBoxLine() + "┤"
        );

        for (int i = 0; i < maxLines; i++) {
            String leftContent =
                    i < left.size()
                    ? left.get(i)
                    : "";

            String rightContent =
                    i < right.size()
                    ? right.get(i)
                    : "";

            System.out.println("|" + " " + boxContent(leftContent, leftLine)
                    + "|" + " " + boxContent(rightContent, rightLine) + "|");
        }

        System.out.println(
                "└" + leftBoxLine() + "┴" + rightBoxLine() + "┘"
        );
    }
}