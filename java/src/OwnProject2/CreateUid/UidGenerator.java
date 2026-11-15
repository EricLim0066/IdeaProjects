package OwnProject2.CreateUid;

import java.security.SecureRandom;

public final class UidGenerator {
    private final String format;
    private final SecureRandom random;

    public UidGenerator (String format, SecureRandom random) {
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("Format cannot be empty");
        }

        if (random == null) {
            throw new IllegalArgumentException("Random object is null");
        }

        for (int i = 0; i < format.length(); i++) {
            char ch = format.charAt(i);
            if (ch != 'A' && ch != '0') {
                throw new IllegalArgumentException("Illegal character format " + ch + " (Only accept 'A' or '0')");
            }
        }
        this.format = format;
        this.random = random;
    }

    private char pick(char formatChar) {
        if (formatChar == 'A') {
            return (char) ('A' + this.random.nextInt(26));
        }

        if (formatChar == '0') {
            return (char) ('0' + this.random.nextInt(10));
        }
        return formatChar;
    }

    public String next() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.format.length(); i++) {
            char formatChar = this.format.charAt(i);
            sb.append(pick(formatChar));
        }
        return sb.toString();
    }
}
