package OwnProject;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class ReadFile extends BugTest {
    //Read #Input in file
    public Scanner getInputScanner(DoneChecker doneChecker) throws Exception{
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(pis);
        PrintWriter printWriter = new PrintWriter(pos, true);
        new Thread(() -> {
            //system input
            for (String line : inputList) {
                System.out.println("System input : [" + line + "]");
                printWriter.println(line);
                try {
                    Thread.sleep (500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //manual input after system input finished
            System.out.println("[Test input exhausted, switching to manual input...]");
            Scanner manual = new Scanner(System.in);
            //set !false to true for always true, until the last mian set to true, and !true to false and out
            while (!doneChecker.isDone() && manual.hasNextLine()) {
                printWriter.println(manual.nextLine());
            }
            System.out.println("[Test input finished, closing...]");
            printWriter.close();
        }).start();
        return new Scanner(pis);
    }
    public interface DoneChecker {
        boolean isDone();
    }
    //System random input
    public Scanner systemFuzzInput(int inputCount) throws IOException {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(pis);
        PrintWriter printWriter = new PrintWriter(pos,true);
        new Thread (() -> {
            for (int i = 0; i < inputCount; i++) {
                String fuzz = getFuzzInput();
                System.out.println("Fuzz input " + i + ": [" + fuzz + "]");
                printWriter.println(fuzz);
                int second = 1000;
                try {
                    Thread.sleep(second);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("[Test input finished, closing...]");
            printWriter.close();
        }).start();
        return new Scanner(pis);
    }

    public Scanner infiniteFuzzInput() throws IOException {
        //input end (data receiver)
        PipedInputStream pis = new PipedInputStream();
        //output end (data sender, connected to pis)
        PipedOutputStream pos = new PipedOutputStream(pis);
        PrintWriter printWriter = new PrintWriter(pos,true);

        //start infinity input
        new Thread(() -> {
            while (true) {
                String fuzz = getFuzzInput();
                System.out.println("Fuzz: [" + fuzz + "]");
                printWriter.println(fuzz);
                try {
                    //set input 1 per 1000ms
                    int basesleep = 1000;
                    Thread.sleep(basesleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return new Scanner(pis);
    }
}
