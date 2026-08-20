package OwnProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import static OwnProject.BettingGame.players;

public class GameUI {
    static int[] playerArrays = {0};
    static int totalGames = 0;
    static JFrame frame;
    static JButton currentEggButton = null;
    static Logger logger = LogManager.getLogger(GameUI.class);

    static JPanel createStartGamePanel(CardLayout cardLayout, JPanel mainPanel) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Welcome to Betting Game");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton button = new JButton("Start Game");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> {
            mainPanel.add(createUserLoginPanel(cardLayout,mainPanel),"login");
            cardLayout.show(mainPanel, "login");
        });

        panel.add(Box.createVerticalGlue());
        panel.add(label);
        panel.add(Box.createVerticalStrut(20));
        panel.add(button);
        panel.add(Box.createVerticalGlue());

        EasterEggPanel(mainPanel);
        return panel;
    }
    static JPanel createUserLoginPanel (CardLayout cardLayout, JPanel mainPanel) {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel,BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Enter Page");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel playerLabel = new JLabel("How many players want to join?");
        playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] options = new String[]{"1","2","3","4","5","6","7","8"};
        JComboBox <String> playerNumber = new JComboBox<>(options);
        playerNumber.setMaximumSize(new Dimension(300,30));
        playerNumber.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton button = new JButton("Play");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> {
            int choice = Integer.parseInt(playerNumber.getSelectedItem().toString());
            mainPanel.add(createUserNamePanel(choice,cardLayout,mainPanel),"Username");
            cardLayout.show(mainPanel,"Username");
        });

        loginPanel.add(Box.createVerticalGlue());
        loginPanel.add(label);
        loginPanel.add(Box.createVerticalStrut(5));
        loginPanel.add(playerLabel);
        loginPanel.add(Box.createVerticalStrut(10));
        loginPanel.add(playerNumber);
        loginPanel.add(Box.createVerticalStrut(5));
        loginPanel.add(button);
        loginPanel.add(Box.createVerticalGlue());

        EasterEggPanel(mainPanel);
        return loginPanel;
    }
    static JPanel createUserNamePanel(int choice, CardLayout cardLayout, JPanel mainPanel) {
        JPanel userNamePanel = new JPanel();
        userNamePanel.setLayout(new BoxLayout(userNamePanel,BoxLayout.Y_AXIS));

        JLabel userNameLabel = new JLabel("Welcome Player");
        userNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout((new BoxLayout(inputPanel,BoxLayout.Y_AXIS)));

        ArrayList <JTextField> getTextFieldName = new ArrayList<>();
        for (int i = 1; i <= choice; i++) {
            JTextField textField =  new JTextField();
            textField.setMaximumSize(new Dimension(200,30));
            textField.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel playerLabel = new JLabel("Player " + i + ":");
            playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JPanel rowPanel = new JPanel();
            rowPanel.setLayout((new BoxLayout(rowPanel,BoxLayout.X_AXIS)));
            rowPanel.add(playerLabel);
            rowPanel.add(textField);

            inputPanel.add(rowPanel);
            inputPanel.add(Box.createVerticalStrut(5));

            getTextFieldName.add(textField);
        }

        JButton returnLastPageButton = new JButton("Return To Last Page");
        returnLastPageButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnLastPageButton.addActionListener(e -> {
            cardLayout.show(mainPanel,"login");
        });

        JButton startGameButton = new JButton("Start Game");
        startGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startGameButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Ready to start game?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                //Binding UI name with BettingGame name
                String name = null;
                boolean allField = true;
                for (JTextField tf : getTextFieldName) {
                    if (tf.getText().trim().isEmpty()) {
                        allField = false;
                        break;
                    }
                    name = tf.getText();
                    Player player = new Player (name, 0);
                    players.add(player);
                }
                if (!allField) {
                    JOptionPane.showMessageDialog(null,"Sorry The Text Blank Still Empty :(");
                } else {
                    mainPanel.add(createUserEnterBalancePanel(cardLayout,mainPanel),"Enter Balance");
                    cardLayout.show(mainPanel,"Enter Balance");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setMaximumSize(new Dimension(400,20));
        buttonPanel.add(returnLastPageButton);
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(startGameButton);

        userNamePanel.add(Box.createVerticalGlue());
        userNamePanel.add(userNameLabel);
        userNamePanel.add(Box.createVerticalStrut(5));
        userNamePanel.add(inputPanel);
        userNamePanel.add(Box.createVerticalStrut(10));
        userNamePanel.add(buttonPanel);
        userNamePanel.add(Box.createVerticalGlue());

        EasterEggPanel(mainPanel);
        return userNamePanel;
    }
    static JPanel createUserEnterBalancePanel(CardLayout cardLayout, JPanel mainPanel) {
        JPanel userBalancePagePanel = new JPanel();
        userBalancePagePanel.setLayout(new BoxLayout(userBalancePagePanel,BoxLayout.Y_AXIS));

        JPanel userEnterBalancePanel = new JPanel();
        userEnterBalancePanel.setLayout(new BoxLayout(userEnterBalancePanel,BoxLayout.Y_AXIS));

        JLabel userEnterBalanceLabel1 = new JLabel("~~Welcome Player " + players.get(playerArrays[0]).getName() + "~~");
        userEnterBalanceLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel userEnterBalanceLabel2 = new JLabel("~~Please Enter Your Current Balance~~");
        userEnterBalanceLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField balanceTextField = new JTextField();
        balanceTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        balanceTextField.setMaximumSize(new Dimension(200,30));

        JButton buttonBalance = new JButton(players.size() == 1? "Go to Place Bet" : "Go To Next Person");
        buttonBalance.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonBalance.addActionListener(e -> {
            if (!balanceTextField.getText().isEmpty()) {
                try {
                    int balance = Integer.parseInt(balanceTextField.getText().trim());
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Did u sure want to go to next person?",
                            "Confirm",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (confirm == JOptionPane.YES_OPTION) {
                        //change dollar to cents
                        players.get(playerArrays[0]).setMoneyBalance(balance * 100);
                        playerArrays[0]++;
                        if (playerArrays[0] < players.size()) {
                            userEnterBalanceLabel1.setText("~~Welcome Player " + players.get(playerArrays[0]).getName() + "~~");
                            balanceTextField.setText("");
                            if (playerArrays[0] == players.size()-1 ) {
                                buttonBalance.setText("Go to Place Bet");
                            }
                        } else {
                            playerArrays[0] = 0;
                            mainPanel.add(createExchangeChipsPanel(cardLayout,mainPanel),"Exchange chips");
                            cardLayout.show(mainPanel, "Exchange chips");
                        }
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Sorry Please Integer Number :(");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Sorry The Blank Cannot Be Empty :(");
            }
        });
        userEnterBalancePanel.add(Box.createVerticalGlue());
        userEnterBalancePanel.add(userEnterBalanceLabel1);
        userEnterBalancePanel.add(Box.createVerticalStrut(5));
        userEnterBalancePanel.add(userEnterBalanceLabel2);
        userEnterBalancePanel.add(Box.createVerticalStrut(5));
        userEnterBalancePanel.add(balanceTextField);
        userEnterBalancePanel.add(Box.createVerticalStrut(10));
        userEnterBalancePanel.add(buttonBalance);
        userEnterBalancePanel.add(Box.createVerticalGlue());
        userBalancePagePanel.add(userEnterBalancePanel);

        EasterEggPanel(mainPanel);
        return userBalancePagePanel;
    }
    static JPanel createExchangeChipsPanel(CardLayout cardLayout, JPanel mainPanel) {
        JPanel chipsPanel = new JPanel();
        chipsPanel.setLayout(new BoxLayout(chipsPanel,BoxLayout.Y_AXIS));

        JPanel chipLabelPanel = new JPanel();
        chipLabelPanel.setLayout(new BoxLayout(chipLabelPanel, BoxLayout.Y_AXIS));

        JLabel chipsLabel = new JLabel("Player: " + players.get(playerArrays[0]).getName() + ";Balance: " + players.get(playerArrays[0]).getMoneyBalance()/100.00);
        chipsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel chipsLabel2 = new JLabel("Please enter how much chips you want to bet");
        chipsLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel chipsLabel3 = new JLabel("Tips: 1 dollar per 10 chips");
        chipsLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField chipText = new JTextField();
        chipText.setAlignmentX(Component.CENTER_ALIGNMENT);
        chipText.setMaximumSize(new Dimension(200,30));

        JButton button = new JButton("GO BET");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> {
            if (!(chipText.getText().trim().isEmpty())) {
                try {
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Are you sure want to go to place your exchange",
                            "Place Bet Chosen",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (confirm == JOptionPane.YES_OPTION) {
                        int inputChips = 0;
                        inputChips = Integer.parseInt(chipText.getText().trim());
                        //1 dollar per 10 chips, so 10 cents per 1 chips
                        int centPerChips = inputChips * 10;
                        if (inputChips <= 0 || centPerChips > players.get(playerArrays[0]).getMoneyBalance()) {
                            JOptionPane.showMessageDialog(null, "Sorry invalid amount, please retry :(");

                        } else {
                            players.get(playerArrays[0]).setChips(players.get(playerArrays[0]).getChips() + inputChips);
                            players.get(playerArrays[0]).setMoneyBalance(players.get(playerArrays[0]).getMoneyBalance() - (inputChips * 10));

                            JOptionPane.showMessageDialog(null,
                                    "Exchange Successful, you have current " + players.get(playerArrays[0]).getChips() + " chips right now~" +
                                            "\nRemaining Amount: " + players.get(playerArrays[0]).getMoneyBalance()/100.00);

                            replacePanel(mainPanel,createPlaceBetPanel(cardLayout,mainPanel),"Place Bet");
                            cardLayout.show(mainPanel,"Place Bet");
                        }
                    }
                } catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Sorry please enter number :(");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Sorry text blank cannot be empty :(");
            }

        });
        chipLabelPanel.add(chipsLabel);
        chipLabelPanel.add(chipsLabel2);
        chipLabelPanel.add(chipsLabel3);

        chipsPanel.add(Box.createVerticalGlue());
        chipsPanel.add(chipLabelPanel);
        chipsPanel.add(Box.createVerticalStrut(5));
        chipsPanel.add(chipText);
        chipsPanel.add(Box.createVerticalStrut(5));
        chipsPanel.add(button);
        chipsPanel.add(Box.createVerticalGlue());

        EasterEggPanel(mainPanel);
        return chipsPanel;
    }
    static JPanel createPlaceBetPanel(CardLayout cardLayout, JPanel mainPanel) {
        JPanel betPanel = new JPanel();
        betPanel.setLayout(new BoxLayout(betPanel, BoxLayout.Y_AXIS));

        JLabel betLabel1 = new JLabel("Current Chips: " + players.get(playerArrays[0]).getChips());
        betLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel betLabel2 = new JLabel("~Please enter how many chips you wanna bet~");
        betLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField betTextField = new JTextField();
        betTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        betTextField.setMaximumSize(new Dimension(200,30));

        JPanel betLabelPanel = new JPanel();
        betLabelPanel.setLayout(new BoxLayout(betLabelPanel,BoxLayout.Y_AXIS));
        betLabelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton betButton = new JButton("LET'S PLAY");
        betButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        betButton.addActionListener(e -> {
            if (!betTextField.getText().trim().isEmpty()) {
                try {
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Are you sure want to go to play ?",
                            "Confirm",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (confirm == JOptionPane.YES_OPTION) {
                        int currentBet = 0;
                        currentBet = Integer.parseInt(betTextField.getText().trim());
                        if (currentBet <= 0 || currentBet > players.get(playerArrays[0]).getChips()) {
                            JOptionPane.showMessageDialog(null,"Sorry invalid of bets, please retry :(");
                        } else {
                            replacePanel(mainPanel,createPlaygroundPanel(cardLayout,mainPanel,currentBet), "Playground");
                            cardLayout.show(mainPanel,"Playground");
                        }
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Sorry only can enter integer, please retry :(");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Sorry text blank cannot be empty :(");
            }

        });

        betLabelPanel.add(betLabel1);
        betLabelPanel.add(Box.createVerticalStrut(5));
        betLabelPanel.add(betLabel2);

        betPanel.add(Box.createVerticalGlue());
        betPanel.add(betLabelPanel);
        betPanel.add(Box.createVerticalStrut(10));
        betPanel.add(betTextField);
        betPanel.add(Box.createVerticalStrut(10));
        betPanel.add(betButton);
        betPanel.add(Box.createVerticalGlue());

        EasterEggPanel(mainPanel);
        return betPanel;
    }

    static JPanel createPlaygroundPanel(CardLayout cardLayout, JPanel mainPanel, int currentBet) {
        JPanel playgroundPanel = new JPanel();
        playgroundPanel.setLayout(new BoxLayout(playgroundPanel, BoxLayout.Y_AXIS));

        JLabel playgroundLabel = new JLabel("Your Bet: " + currentBet + "\nYour Chips: " + players.get(playerArrays[0]).getChips() +
                "\nYour Current Balance: " + players.get(playerArrays[0]).getMoneyBalance()/100.0);

        playgroundLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPlaygroundPanel = new JPanel();
        buttonPlaygroundPanel.setLayout(new GridLayout(2,5,5,5));
        buttonPlaygroundPanel.setMaximumSize(new Dimension(250, 70));

        for (int i = 0; i <= 9; i++) {
            JButton buttonPlayground = new JButton(String.valueOf(i));
            buttonPlayground.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonPlayground.addActionListener(e -> {
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure this chosen?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    Random rand = new Random();
                    int randNum = rand.nextInt(10);
                    int buttonNum = Integer.parseInt(buttonPlayground.getText().trim());
                    if (buttonNum == randNum) {
                        players.get(playerArrays[0]).setChips(players.get(playerArrays[0]).getChips() + currentBet * 2);
                        players.get(playerArrays[0]).setWin(players.get(playerArrays[0]).getWin() + 1);
                        totalGames++;
                        JOptionPane.showMessageDialog(null, "System result: " + randNum + "\nYour result: " + buttonNum +
                                "\nSuper lucky! Chip + " + currentBet * 2 + "; Current: " + players.get(playerArrays[0]).getChips());

                    } else if ((buttonNum > 4 && randNum > 4) || (buttonNum < 5 && randNum < 5) ) {
                        players.get(playerArrays[0]).setChips(players.get(playerArrays[0]).getChips() + currentBet);
                        players.get(playerArrays[0]).setWin(players.get(playerArrays[0]).getWin() + 1);
                        totalGames++;
                        JOptionPane.showMessageDialog(null, "System result: " + randNum + "\nYour result: " + buttonNum +
                                "\nYou Won! Chip + " + currentBet + "; Current: " + players.get(playerArrays[0]).getChips());
                    } else {
                        players.get(playerArrays[0]).setChips(players.get(playerArrays[0]).getChips() - currentBet);
                        players.get(playerArrays[0]).setLose(players.get(playerArrays[0]).getLose() + 1);
                        totalGames++;
                        JOptionPane.showMessageDialog(null, "System result: " + randNum + "\nYour result: " + buttonNum +
                                "\nOh no you lose ! Chip - " + currentBet + "; Current: " + players.get(playerArrays[0]).getChips());
                    }

                    if (players.get(playerArrays[0]).getChips() <= 0 && players.get(playerArrays[0]).getMoneyBalance() == 0 ) {
                        if (!(playerArrays[0] == players.size() - 1)) {
                            playerArrays[0]++;
                            replacePanel(mainPanel,createExchangeChipsPanel(cardLayout,mainPanel),"Exchange chips");
                            cardLayout.show(mainPanel,"Exchange chips");
                        } else {
                            mainPanel.add(createResultPanel(cardLayout,mainPanel),"Result");
                            cardLayout.show(mainPanel,"Result");
                        }

                    } else if (players.get(playerArrays[0]).getChips() <= 0 && players.get(playerArrays[0]).getMoneyBalance() > 0){
                        replacePanel(mainPanel,createRechargeChipsPanel(cardLayout, mainPanel),"Recharge");
                        cardLayout.show(mainPanel,"Recharge");
                    } else {
                        replacePanel(mainPanel,createPlaceBetPanel(cardLayout, mainPanel), "Place Bet");
                        cardLayout.show(mainPanel, "Place Bet");
                    }
                }
            });
            buttonPlaygroundPanel.add(buttonPlayground);
        }

        JPanel buttonExitPanel = new JPanel();
        buttonExitPanel.setLayout(new BoxLayout(buttonExitPanel,BoxLayout.Y_AXIS));

        JButton buttonExit = new JButton(playerArrays[0] == players.size() - 1? "Exit Game" : "Go to Next Person");
        buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonExit.setMaximumSize(new Dimension(200,30));
        buttonExit.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure want to exit the game and go to the next person ?",
                    "Exit Confirm",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                if (playerArrays[0] == players.size() - 1) {
                    mainPanel.add(createResultPanel(cardLayout,mainPanel),"Result");
                    cardLayout.show(mainPanel,"Result");
                } else {
                    playerArrays[0]++;
                    replacePanel(mainPanel,createExchangeChipsPanel(cardLayout, mainPanel),"Exchange chips");
                    cardLayout.show(mainPanel,"Exchange chips");
                }
            }
        });

        playgroundPanel.add(Box.createVerticalGlue());
        playgroundPanel.add(playgroundLabel);
        playgroundPanel.add(Box.createVerticalStrut(15));
        playgroundPanel.add(buttonPlaygroundPanel);
        playgroundPanel.add(Box.createVerticalStrut(5));
        playgroundPanel.add(buttonExit);
        playgroundPanel.add(Box.createVerticalGlue());

        EasterEggPanel(mainPanel);
        return playgroundPanel;
    }
    public static JPanel createRechargeChipsPanel(CardLayout cardLayout, JPanel mainPanel) {
        JPanel rechargeChipsPanel = new JPanel();
        rechargeChipsPanel.setLayout(new BoxLayout(rechargeChipsPanel, BoxLayout.Y_AXIS));

        JLabel rechargeLabel = new JLabel("Your Current Balance" + players.get(playerArrays[0]).getMoneyBalance()/100.0);
        rechargeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel rechargeLabel2 = new JLabel("How much chips you want to recharge ?");
        rechargeLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel rechargeLabel3 = new JLabel("Tips: 1 dollar per 10 chips");
        rechargeLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField rechargeTextField = new JTextField();
        rechargeTextField.setMaximumSize(new Dimension(200,30));
        rechargeTextField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton rechargeButton = new JButton("Recharge");
        rechargeButton.setMaximumSize(new Dimension(200,30));
        rechargeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rechargeButton.addActionListener(e -> {
            try {
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure want to go to place bet ?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    int inputChips = 0;
                    inputChips = Integer.parseInt(rechargeTextField.getText());
                    int chipsCent = inputChips * 10;

                    if (!(inputChips <= 0 || chipsCent > players.get(playerArrays[0]).getMoneyBalance())) {

                        players.get(playerArrays[0]).setChips(players.get(playerArrays[0]).getChips() + inputChips);
                        players.get(playerArrays[0]).setMoneyBalance(players.get(playerArrays[0]).getMoneyBalance() - inputChips * 10);

                        JOptionPane.showMessageDialog(null,
                                "Recharge Successful! Your current chips:" + players.get(playerArrays[0]).getChips() +
                                "\nYour Current Balance:" + players.get(playerArrays[0]).getMoneyBalance()/100);

                        replacePanel(mainPanel,createPlaceBetPanel(cardLayout,mainPanel),"Place Bet");
                        cardLayout.show(mainPanel,"Place Bet");
                    } else {
                        JOptionPane.showMessageDialog(null,"Sorry Invalid Bet, please try again :(");
                    }
                }
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Sorry only can enter number :(");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        JButton buttonExit = new JButton(playerArrays[0] == players.size() - 1? "Exit Game" : "Go To Next Person" );
        buttonExit.setMaximumSize(new Dimension(200,30));
        buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonExit.addActionListener(e -> {
            try {
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure want to go to the next person ?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    if (!(playerArrays[0] == players.size() - 1)) {
                        playerArrays[0]++;
                        replacePanel(mainPanel,createExchangeChipsPanel(cardLayout,mainPanel),"Exchange chips");
                        cardLayout.show(mainPanel,"Exchange chips");
                    } else {
                        mainPanel.add(createResultPanel(cardLayout,mainPanel),"Result");
                        cardLayout.show(mainPanel,"Result");
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        JPanel rechargePanel = new JPanel();
        rechargePanel.setLayout(new BoxLayout(rechargePanel, BoxLayout.Y_AXIS));

        rechargePanel.add(rechargeLabel);
        rechargePanel.add(rechargeLabel2);
        rechargePanel.add(rechargeLabel3);
        rechargePanel.add(Box.createVerticalStrut(5));
        rechargePanel.add(rechargeTextField);
        rechargePanel.add(Box.createVerticalStrut(5));
        rechargePanel.add(rechargeButton);
        rechargePanel.add(buttonExit);

        rechargeChipsPanel.add(Box.createVerticalGlue());
        rechargeChipsPanel.add(rechargePanel);
        rechargeChipsPanel.add(Box.createVerticalGlue());

        EasterEggPanel(mainPanel);
        return rechargeChipsPanel;
    }

    public static JPanel createResultPanel(CardLayout cardLayout, JPanel mainPanel) {
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel,BoxLayout.Y_AXIS));

        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));

        JLabel resultLabel = new JLabel("Result");
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (int i = 0 ; i < players.size() ; i++) {
            if (totalGames > 0) {
                players.get(i).setWinRate(
                        (double) players.get(i).getWin() / totalGames * 100
                );
            }
            JLabel messageLabel = new JLabel(
                    i + ". " +
                            "Player name: " + players.get(i).getName() + " ; " +
                            "Player balance: " + players.get(i).getMoneyBalance() + " ; " +
                            "Player chips: " + players.get(i).getChips() + " ; " +
                            "Player win: " + players.get(i).getWin() + " ; " +
                            "Player lose: " + players.get(i).getLose() + " ; " +
                            "Player win rate: "+ players.get(i).getWinRate()
            );
            messagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            messagePanel.add(messageLabel);
        }

        resultPanel.add(Box.createVerticalGlue());
        resultPanel.add(resultLabel);
        resultPanel.add(Box.createVerticalStrut(5));
        resultPanel.add(messagePanel);
        resultPanel.add(Box.createVerticalGlue());

        EasterEggPanel(mainPanel);
        return resultPanel;
    }

    static void replacePanel(JPanel mainPanel, JPanel newPanel, String key) {
        mainPanel.add(newPanel, key);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    static void EasterEggPanel(JPanel mainPanel) {
        if (currentEggButton != null) {
            frame.getLayeredPane().remove(currentEggButton);
            frame.getLayeredPane().revalidate();
            frame.getLayeredPane().repaint();
            currentEggButton = null;
        }
        Random rand = new Random();
        int num = rand.nextInt(100)+1;
        int corner = rand.nextInt(4);
        if (num <= 100) {
            JButton eggButton = new JButton();
            eggButton.addActionListener(e -> {
                Donut donut = new Donut();
                JFrame donutFrame = new JFrame("???");
                donutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                donutFrame.add(donut);
                donutFrame.pack();
                donutFrame.setLocationRelativeTo(null);
                donutFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                       donut.stopAudio();
                    }
                });
                donutFrame.setVisible(true);
            });
            switch (corner) {
                case 0:
                    eggButton.setBounds(0, 0, 15, 15);
                    break;
                case 1:
                    eggButton.setBounds(frame.getWidth() - 15, 0, 15, 15);
                    break;
                case 2:
                    eggButton.setBounds(0, frame.getHeight() - 15, 15, 15);
                    break;
                case 3:
                    eggButton.setBounds(frame.getWidth() - 15, frame.getHeight() - 15, 15, 15);
                    break;
            }
            frame.getLayeredPane().add(eggButton, JLayeredPane.POPUP_LAYER);
            currentEggButton = eggButton;
            mainPanel.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    switch (corner) {
                        case 0:
                            eggButton.setBounds(0, 0, 15, 15);
                            break;
                        case 1:
                            eggButton.setBounds(frame.getWidth() - 15, 0, 15, 15);
                            break;
                        case 2:
                            eggButton.setBounds(0, frame.getHeight() - 15, 15, 15);
                            break;
                        case 3:
                            eggButton.setBounds(frame.getWidth() - 15, frame.getHeight() - 15, 15, 15);
                            break;
                    }
                }
            });
        }

    }

    public static void main(String[] args) {
        //set frame title, size,and how to close frame
        logger.info("Test working");
        frame = new JFrame("Betting Game");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        mainPanel.add(createStartGamePanel(cardLayout,mainPanel),"start");

        frame.add(mainPanel);
        //set frame location, and set it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}