package powerball;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIWindow extends JFrame {

    private Powerball p = new Powerball();

    private JLabel powerballLabel = new JLabel("Powerball Simulator 2015");
    private JLabel ticketLabel = new JLabel(" Enter 5 unique numbers from 1-59:");
    private JLabel powerNumLabel = new JLabel(" Enter a power number from 1-35:");
    private JLabel buttonLabel = new JLabel(" Click to randomly generate a ticket >>>");
    private JLabel ticketOutputLabel = new JLabel(" Your ticket: ");
    private JLabel winningTicketLabel = new JLabel(" Winning ticket: ");
    private JLabel weeksPlayedLabel = new JLabel(" Weeks played: ");
    private JLabel moneySpentLabel = new JLabel(" Money spent: ");
    private JTextField ticketField = new JTextField(2);
    private JTextField ticketField2 = new JTextField(2);
    private JTextField ticketField3 = new JTextField(2);
    private JTextField ticketField4 = new JTextField(2);
    private JTextField ticketField5 = new JTextField(2);
    private JTextField powerNumField = new JTextField(2);
    private JTextField yourTicketField = new JTextField(20);
    private JTextField winningTicketField = new JTextField(20);
    private JTextField weeksPlayedField = new JTextField(20);
    private JTextField moneySpentField = new JTextField(20);
    private JButton generateButton = new JButton("Generate");
    private JButton playButton = new JButton("Play");
    private JButton ticketButton = new JButton("Add Ticket");

    GridBagConstraints gbc = new GridBagConstraints();

    public GUIWindow() {
        setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 10;
        add(powerballLabel, gbc);
        powerballLabel.setFont(new Font("SansSerif", Font.BOLD, 48));

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(ticketLabel, gbc);

        gbc.gridy++;
        add(powerNumLabel, gbc);

        gbc.gridy++;
        add(buttonLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(playButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(ticketField, gbc);
        gbc.gridx++;
        add(ticketField2, gbc);
        gbc.gridx++;
        add(ticketField3, gbc);
        gbc.gridx++;
        add(ticketField4, gbc);
        gbc.gridx++;
        add(ticketField5, gbc);
        gbc.gridx++;
        add(ticketOutputLabel, gbc);
        gbc.gridx++;
        add(yourTicketField, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        add(powerNumField, gbc);
        gbc.gridx++;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(ticketButton, gbc);

        gbc.gridx = 6;
        gbc.gridwidth = 1;
        add(winningTicketLabel, gbc);
        gbc.gridx++;
        add(winningTicketField, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(generateButton, gbc);

        gbc.gridx = 6;
        gbc.gridy = 3;
        add(weeksPlayedLabel, gbc);
        gbc.gridx++;
        add(weeksPlayedField, gbc);

        gbc.gridx = 6;
        gbc.gridy++;
        add(moneySpentLabel, gbc);
        gbc.gridx++;
        add(moneySpentField, gbc);

        generateButton.addActionListener(new generateListener());
        playButton.addActionListener(new playListener());
        ticketButton.addActionListener(new ticketListener());
    }

    private class ticketListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                String input1 = ticketField.getText();
                String input2 = ticketField2.getText();
                String input3 = ticketField3.getText();
                String input4 = ticketField4.getText();
                String input5 = ticketField5.getText();
                String input6 = powerNumField.getText();
                int n1 = Integer.parseInt(input1);
                int n2 = Integer.parseInt(input2);
                int n3 = Integer.parseInt(input3);
                int n4 = Integer.parseInt(input4);
                int n5 = Integer.parseInt(input5);
                int n6 = Integer.parseInt(input6);
                p.clearTicket();
                p.addUniqueNumbers(n1);
                p.addUniqueNumbers(n2);
                p.addUniqueNumbers(n3);
                p.addUniqueNumbers(n4);
                p.addUniqueNumbers(n5);
                p.choosePowerNumber(n6);
                yourTicketField.setText("" + p.getUniqueNumbers() + ", power number: " + p.getPowerNumber());

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(GUIWindow.this, "Invalid Ticket Error", "Powerball Simulator 2015", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class generateListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                p.generateUniqueNumbers();
                p.generatePowerNumber();
                yourTicketField.setText("" + p.getUniqueNumbers() + ", power number: " + p.getPowerNumber());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(GUIWindow.this, "I'm impressed if you get this error.", "Powerball Simulator 2015", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class playListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (p.validTicket() == true) {
                p.simulate();
                winningTicketField.setText("" + p.getWinningNumbers() + ", power number: " + p.getWinningPowerNumber());
                weeksPlayedField.setText("" + p.getWeeksPlayed());
                moneySpentField.setText("$" + p.getMoneySpent());
                JOptionPane.showMessageDialog(GUIWindow.this, "Congrats! You've won!", "Powerball Simulator 2015", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(GUIWindow.this, "You must have a valid ticket to play.", "Powerball Simulator 2015", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
