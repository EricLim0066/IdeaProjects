package OwnProject;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BettingGame {
    //Method of betting balls share with all code
    static Scanner input = new Scanner(System.in);
    static ArrayList <Player> players = new ArrayList<>();
    static Random random = new Random();
    static boolean testDoneFlag =  false;
    //
    static void exchangeChips(Player player) {
        boolean exchangeFlag = true;
        double balance= 0.0;
        while (exchangeFlag) {
            System.out.println("Please enter your current balance: ");
            try {
                balance = Double.parseDouble(input.nextLine().trim());
                if (balance <= 0) {
                    System.out.println("Sorry must enter money to start the game, please retry :(");
                    continue;
                } else if (balance > 1000000) {
                    System.out.println("Sorry maximum 1000000 dollars :(");
                    continue;
                }
                exchangeFlag = false;
            } catch (NumberFormatException e) {
                System.out.println("Sorry Invalid balance, please enter the number :(");
            }
        }
        //balance change to cent form dollar, so *100
        player.setMoneyBalance((int) (balance * 100));
        rechargeChips(player);
    }

    static int placeBet(Player player) {
        //Enter betting chips
        System.out.println("=============================================");
        int bet = 0;
        boolean betFlag = true;
        while (betFlag) {
            System.out.println("Your current chips:" + player.getChips());
            //choose want to exit or continue play
            System.out.println("Did you want to continue playing ? Press 1 == Continue; Press 0 == Exit Game ");
            int choice = -1;
            //set line to clear residue space
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Sorry cannot be empty, please retry :(");
                continue;
            }
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Sorry only can enter 1 or 0, please retry :(");
                continue;
            }
            switch (choice) {
                case 0 :
                    System.out.println("Cashing out...");
                    System.out.println(String.format("OwnProject.Player: %s \nCurrent Balance: %.2f \nCurrent chips: %d" , player.getName() ,player.getMoneyBalance()/100.00,player.getChips()));
                    System.out.println("Thanks for playing, have a good luck next time :)");
                    System.out.println("Quiting game...");
                    return -1;
                case 1 :
                    System.out.println("Please Enter how much chips you want to bet: ");
                    try {
                        bet = Integer.parseInt(input.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Sorry please enter the number, retry :(");
                        continue;
                    }
                    if (bet <= 0 || player.getChips() < bet) {
                        System.out.println("Sorry Invalid bet, please try again :(");
                        continue;
                    }
                    betFlag = false;
                    break;
                default :
                    System.out.println("Sorry only can enter 1 or 0, please retry :(");
                    break;
            }
        }
        return bet;
    }

    static void playground(Player player, int bet) {
        System.out.println("=============================================");
        int result = random.nextInt(10);
        System.out.println("Please guess a number between 0 ~ 9");
        //0,1,2,3,4 SMALL , 5,6,7,8,9 BIG
        int playerGuessBall = -1;
        try {
            playerGuessBall = Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Sorry please enter the number, retry :(");
            return;
        }
        if (playerGuessBall < 0 || playerGuessBall > 9) {
            System.out.println("Sorry only can enter 0 ~ 9, retry :(");
            return;
        }
        //
        System.out.println("OwnProject.Player result: " + playerGuessBall);
        System.out.println("System result: " + result);
        //
        if (playerGuessBall == result) {
            player.setChips(player.getChips() + bet * 2);
            player.setWin(player.getWin() + 1);
            System.out.println("Super lucky !!! Chips + " + (bet * 2) + ", current: " + player.getChips());
        } else if ((playerGuessBall < 5 && result < 5) || (playerGuessBall > 4 && result > 4)) {
            player.setChips(player.getChips() + bet);
            player.setWin(player.getWin() + 1);
            System.out.println("You Won ! Chips + " + bet + ", current: " + player.getChips());
        } else {
            player.setChips(player.getChips() - bet);
            player.setLose(player.getLose() + 1);
            System.out.println("You Lose ! Chips - " + bet + ", current: " + player.getChips());
        }
    }

    static void rechargeChips(Player player) {
        boolean rechargeFlag = true;
        while (rechargeFlag) {
            System.out.println("Please enter how much chips you want exchange: ");
            System.out.println(String.format("Remaining amount: %.2f dollars", player.getMoneyBalance() / 100.00));
            System.out.println("1 dollar per 10 chips~");
            //check scanner chips first, then add to player.chips if no problem
            int inputChips;
            try {
                inputChips = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e){
                System.out.println("Sorry please enter number, retry :(");
                continue;
            }
            //1 chip per 10 cents
            int centPerChip = inputChips*10;
            if (inputChips <= 0 || centPerChip > player.getMoneyBalance()) {
                System.out.println("invalid amount, please retry again :(");
                continue;
            }
            //inputchips is for current add, player chips is total add, must separate
            //inputchips/10 be the money, and then *100 become cent
            player.setChips(player.getChips() + inputChips);
            player.setMoneyBalance(player.getMoneyBalance() - (inputChips*10));
            System.out.println("Exchange successful ! You get " + player.getChips() + " chips right now");
            System.out.println(String.format("Remaining amount: %.2f dollars",player.getMoneyBalance()/100.00));
            rechargeFlag = false;
        }
    }

    static boolean recharge(Player player) {
        System.out.println(String.format("Sorry out of chips! Your current balance: %.2f", player.getMoneyBalance()/100.00));
        boolean rechargeChoice = true;
        while (rechargeChoice) {
            System.out.println("Continue recharge? Press 1 == YES // 2 == NO");
            int end = -1;
            try {
                end = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Sorry only can be enter 1 or 0, please retry :(");
            }
            switch (end) {
                case 1:
                    rechargeChips(player);
                    return true;
                case 2:
                    System.out.println("GAME OVER ! Have a good luck next time :)");
                    System.out.println("Exiting game...");
                    return false;
                default :
                    //return back to rechargeChoice to choose again
                    System.out.println("Sorry only can be enter 1 or 0, please retry :(");
                    break;
            }
        }
        return true;
    }
    static void showResults() {
        System.out.println("==================================");
        System.out.println("Final results leaderboard:");
        players.sort((a,b)-> Integer.compare(b.getChips(), a.getChips()));
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            int totalGames = player.getWin() + player.getLose();
            if (totalGames > 0) {
                player.setWinRate((double) player.getWin()/ totalGames * 100);
            }
            System.out.println(String.format("Rank%d: %s; Chips: %d; Balance: %.2f; Total Win: %d; Total Lose: %d; winRate: %.1f%%"
                    ,(i + 1),player.getName(), player.getChips(), player.getMoneyBalance()/100.00, player.getWin(), player.getLose(), player.getWinRate()));
        }
    }
    static void saveResult() {
        BufferedWriter bufferedWriter = null;
        FileWriter writer = null;
        int i = 0;
        //
        try {
            writer = new FileWriter("C:\\Users\\jingx\\work\\读\\result.txt");
            bufferedWriter = new BufferedWriter(writer);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Player player : players) {
            try {
                bufferedWriter.write(String.format("%s,%.2f,%d,%d,%d,%.1f%%\n",
                        player.getName(),player.getMoneyBalance()/100.00 ,player.getChips(),player.getWin(),player.getLose(),player.getWinRate()));
                i++;
                System.out.println("OwnProject.Player " + i + " data saved");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            if (bufferedWriter != null) bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        testDoneFlag = true;
    }
    //
    static void readResult() {
        BufferedReader bufferedReader = null;
        FileReader reader = null;
        String line;
        //
        try {
            reader = new FileReader("C:\\Users\\jingx\\work\\读\\result.txt");
            bufferedReader = new BufferedReader(reader);
            System.out.println("Show last result: ");
            while ((line = bufferedReader.readLine()) != null) {

                // using split when reading text, the text is segmented and stored in an array, with commas as the delimiters
                String[] parts = line.split(",");
                System.out.println(String.format("OwnProject.Player name: %s | OwnProject.Player balance: %.2f | OwnProject.Player chips: %s | Total win: %s | Total lose: %s | WinRate: %s",
                        parts[0], Double.parseDouble(parts[1]), parts[2], parts[3], parts[4], parts[5]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry file not found :(");;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //check if still have message haven't finish reading
            if (bufferedReader != null) bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void startGame() {
        for (Player player: players) {
            boolean playing = true;
            System.out.println("============================================");
            System.out.println("OwnProject.Player now: " + player.getName());
            System.out.println(String.format("The current balance: %.2f ", player.getMoneyBalance()/100.00));
            System.out.println("The current chips: " + player.getChips());
            //
            while ((player.getMoneyBalance() > 0 || player.getChips() > 0) && playing) {
                int bet = placeBet(player);
                //Start game
                if (bet == -1) break;         //jump out from code and not continue, if player want to exit game
                playground(player,bet);
                //game over if no money
                if (player.getChips() <= 0) {
                    if (player.getMoneyBalance() <= 0) {
                        System.out.println("Sorry out of money and chips ! GAME OVER ! Have a good luck next time :)");
                        System.out.println("Exiting game...");
                        playing = false;               //exit from while
                    } else {
                        playing = recharge(player);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        //test with using fake data
        BettingGameTest test = new BettingGameTest();
        ReadFile readFile = new ReadFile();
        //fine file address and read #player
        //test.loadTestFile();
        //read #scanner
        //scanner = test.setupInput();
        //50 blanks for random scanner
        //scanner = readFile.systemFuzzInput(50);
        //infinity scanner
        //scanner = readFile.infiniteFuzzInput();
//        if (!players.isEmpty()) {
//            startGame();
//            showResults();
//            saveResult();
//            return;
//        }
        readResult();
        System.out.println("Welcome to Betting Game~");
        System.out.println("How many players wants to join the game (Only can maximum 8 players):");
        int playerCount = 0;
        boolean playerCountFlag = true;
        while (playerCountFlag) {
            try {
                playerCount = Integer.parseInt(input.nextLine().trim());
                if (playerCount <= 0) {
                    System.out.println("Sorry the game must have player to join, please retry :(");
                } else if (playerCount > 8) {
                    System.out.println("Sorry the game only maximum 8 players, please retry :(");
                } else {
                    playerCountFlag = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Sorry please enter number, restarting... :(");
            }
        }
        //Multiplayer games
        for (int i = 0; i < playerCount; i++) {
            //index problem, +1 for calibrate with value and index
            System.out.println("Hello player " + (i+1) + ",please enter your name:");
            String name = null;
            boolean nameFlag = true;
            while (nameFlag) {
                name = input.nextLine().trim();
                if (name.length() > 25) {
                    System.out.println("Sorry only maximum 25 characters, please retry :(");
                } else if (!name.isEmpty()) {
                    nameFlag = false;
                } else {
                    System.out.println("Sorry player name cannot be empty, please retry :(");
                }
            }
            Player player = new Player(name,0);
            players.add(player);
            System.out.println("Welcome back " + player.getName() + "~");
            //one line for one part of code, scanner player class to method
            exchangeChips(player);
        }
        //continue play if still have money
        startGame();
        //show last result and ranking
        showResults();
        saveResult();
    }
}
