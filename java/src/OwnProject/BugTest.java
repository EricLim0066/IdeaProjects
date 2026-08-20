package OwnProject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BugTest {
    public List<String> playerList = new ArrayList<>();
    public List<String> inputList = new ArrayList<>();
    public Random random = new Random();
    //
    public int currentLine;
    public BufferedReader bufferedReader = null;
    public Reader reader = null;
    public String mode = "";
    //load file from file
    public void loadFile (String path) {
        playerList.clear();
        inputList.clear();
        currentLine = 0;
        try {
            reader = new FileReader(path);
            bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //Separate, then divert following #player and #input
                if (line.trim().equals("#Players")) {
                    mode = "Players";
                } else if (line.trim().equals("#Input")) {
                    mode = "Input";
                } else if (!line.trim().isEmpty() && mode.equals("Players")) {
                    playerList.add(line.trim());
                } else if (mode.equals("Input")) {
                    inputList.add(line);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String userFuzzInput() {
        //set input for thinking user will random enter
        String[][] userAllInput = {
                //Int fuzz input
                {"-12343", "0", "-1", "-999999",
                        "2147483647", "2147483648",
                        "3.14", "3.14.15.92", ".",
                        "123abc"},
                //String fuzz input
                {"TUYGVYGbjyuuy", "HFUYKfyuFYTUFy",
                        "中文字符", "\n", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"},
                //Symbol fuzz input
                {"%$^$$^:}:>>", "!@#$%^&*", ",,,,", "//////",
                        ">>><<<", "|||", "~~~"},
                //Space fuzz input
                {"", " ", "                      "}
        };
        String[] category = userAllInput[random.nextInt(userAllInput.length)];
        return category[random.nextInt(category.length)];
    }

    //set get random fuzz input
    public String systemRandomInput() {
        random = new Random();
        int length = random.nextInt(100);
        //
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < length; i++) {
            int charType = random.nextInt(2);
            switch (charType) {
                case 0:
                    //ASCII random
                    stringBuilder.append((char)random.nextInt(128));
                    break;
                case 1:
                    //Unicode random
                    stringBuilder.append((char)random.nextInt(65536));
                    break;
            }
        }
        return stringBuilder.toString();
    }
    public String getFuzzInput() {
        random = new Random();
        int category = random.nextInt(2);
        switch (category) {
            case 0:
                return userFuzzInput();
            case 1:
                return systemRandomInput();
        }
        return "";
    }
}