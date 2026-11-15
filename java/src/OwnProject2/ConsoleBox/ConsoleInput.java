package OwnProject2.ConsoleBox;

import OwnProject2.MessageToPlayer.InputMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.time.Duration;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsoleInput {

    private final BufferedReader reader;

    public ConsoleInput(BufferedReader reader) {
        this.reader = reader;
    }

    private String readRawLine() {
        try {
            String line = reader.readLine();

            if (line == null) {
                throw new IllegalStateException("Input stream closed.");
            }
            return line;

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String readString (String prompt) {
        System.out.print(prompt);
        return readRawLine();
    }

    public int readInt (String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(readRawLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(InputMessage.INVALID_MESSAGE);
            }
        }
    }

    public int readIntInRange (String prompt, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException(
                    "min > max");
        }

        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;

            } else {
                System.out.println(InputMessage.outOfRangeMessage(min, max));
            }
        }
    }

    public Optional<String> readLineWithin(Supplier<Duration> remaining, Consumer<Duration> onTick) {
        long lastShown = -1;
        try {
            while (reader.ready()) {
                reader.readLine();
            }
            while (true) {

                Duration left = remaining.get();
                if (left.isZero() || left.isNegative()) {
                    return Optional.empty();
                }

                long secondsNow = left.toSeconds();
                if (secondsNow != lastShown) {
                    onTick.accept(left);
                    lastShown = secondsNow;
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return Optional.empty();
                }

                if (reader.ready()) {
                    return Optional.of(readRawLine());
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
