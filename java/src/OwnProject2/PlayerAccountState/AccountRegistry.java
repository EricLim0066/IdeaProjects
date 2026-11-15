package OwnProject2.PlayerAccountState;

import OwnProject2.CreateUid.UidGenerator;

import java.util.*;

public class AccountRegistry {

    private final UidGenerator generator;
    private final Set<String> usedUids = new HashSet<>();
    private final Map<String, Account> byUid = new HashMap<>();
    private final Map<String, String> byName = new HashMap<>();
    private static final int RETRY_LIMIT = 10;
    public static final int EXCEED_LENGTH = 15;
    private int registerCount = 0;

    public enum RegisterResult { EMPTY_NAME_INPUT, EMPTY_PASSWORD_INPUT, NAME_OCCUPIED, UID_GENERATE_ERROR, LONG_INPUT ,SUCCESS}
    public record RegisterOutcome(RegisterResult result, Account account) { }

    public AccountRegistry(UidGenerator generator) {
        this.generator = generator;
    }

    public String normalizeName(String name) {
        return name.trim().toLowerCase();
    }

    public RegisterResult check(String name, String password) {
        if (name == null || name.isBlank()) {
            return RegisterResult.EMPTY_NAME_INPUT;
        }

        if (password == null || password.isBlank()) {
            return RegisterResult.EMPTY_PASSWORD_INPUT;
        }

        String existingUid = byName.get(normalizeName(name));
        if (existingUid != null) {
            return RegisterResult.NAME_OCCUPIED;
        }

        if (name.length() > EXCEED_LENGTH || password.length() > EXCEED_LENGTH) {
            return RegisterResult.LONG_INPUT;
        }

        return RegisterResult.SUCCESS;
    }

    public RegisterOutcome register (String name, String password) {
        RegisterResult result = check(name, password);
        if (result != RegisterResult.SUCCESS) {
            return new RegisterOutcome(result, null);
        }

        String uid = null;
        boolean isUnique = false;
        int retries = 0;


        while (!isUnique && retries < RETRY_LIMIT) {
            uid = this.generator.next();
            if (usedUids.add(uid)) {
                isUnique = true;

            } else {
                retries++;

            }
        }

        if (!isUnique) {
            return new RegisterOutcome(RegisterResult.UID_GENERATE_ERROR, null);
        }

        registerCount++;
        String normalizedName = normalizeName(name);
        Account account = new Account(normalizedName, password, uid, registerCount);
        byUid.put(uid, account);
        byName.put(normalizedName, uid);
        return new RegisterOutcome(result, account);
    }

    public Account findByUid (String uid) {
        return byUid.get(uid);
    }

    public Account findByName (String name) {
        String uid = byName.get(normalizeName(name));
        if (uid == null) {
            return null;
        }

        return byUid.get(uid);
    }
}
