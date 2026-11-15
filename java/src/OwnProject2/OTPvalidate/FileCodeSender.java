package OwnProject2.OTPvalidate;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public final class FileCodeSender implements CodeSender {
    private final Path inboxFile;

    public FileCodeSender(Path inboxFile) {
        this.inboxFile = inboxFile;
    }

    @Override public void send(String key, String code, Duration validFor) {
        try {
            Path parent = inboxFile.getParent();

            if (parent != null) {
                Files.createDirectories(parent);
            }

            Files.writeString(
                    inboxFile,
                    OtpSetText.fileBody(code, validFor),
                    StandardCharsets.UTF_8
            );

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

}
