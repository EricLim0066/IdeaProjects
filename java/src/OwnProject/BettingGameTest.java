package OwnProject;

import java.io.IOException;
import java.util.Scanner;

public class BettingGameTest extends ReadFile{
    //analysis data to player
    //set fake input data
    public void loadTestFile() {
        loadFile("C:\\Users\\jingx\\work\\test.txt");
        //Read #Player in file
        for (String line : playerList) {
            String[] parts = line.split(",");
            //public Player(String name, int moneyBalance) in class player
            Player player = new Player(parts[0], (int)(Double.parseDouble(parts[1]) * 100));
            player.setChips(Integer.parseInt(parts[2]));
            player.setWin(Integer.parseInt(parts[3]));
            player.setLose(Integer.parseInt(parts[4]));
            player.setWinRate(Double.parseDouble(parts[5].replace("%", "")));
            //send info to BettingGame which get form test.txt
            BettingGame.players.add(player);
        }
    }
    public Scanner setupInput() throws Exception {
        return getInputScanner(() -> BettingGame.testDoneFlag);
    }
}
