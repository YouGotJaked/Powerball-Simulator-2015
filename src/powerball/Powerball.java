package powerball;

import java.util.ArrayList;

public class Powerball {

    private ArrayList<Integer> uniqueNumbers = new ArrayList<>(5), winningNumbers = new ArrayList<>(5);
    private int powerNumber = 0, winningPowerNumber = 0;
    private long moneySpent = 0, gamesPlayed = 0, weeksPlayed = 0;

    public void generateUniqueNumbers() {
        for (int i = 0; i < 5; i++) {
            while (true) {
                int r = (int) (Math.random() * 59 + 1);
                if (!uniqueNumbers.contains(r)) {
                    if (uniqueNumbers.size() == 5) {
                        uniqueNumbers.set(i, r);
                        break;
                    }
                    uniqueNumbers.add(r);
                    break;
                }
            }
        }
    }

    public void addUniqueNumbers(int num) {
        if (num >= 1 && num <= 59 && !uniqueNumbers.contains(num)) {
            uniqueNumbers.add(num);
        }
    }
    
    public void clearTicket() {
        uniqueNumbers.clear();
    }

    public ArrayList<Integer> getUniqueNumbers() {
        return uniqueNumbers;
    }

    public void generatePowerNumber() {
        powerNumber = (int) (Math.random() * 35 + 1);
    }

    public void choosePowerNumber(int num) {
        if (num >= 1 && num <= 35) {
            powerNumber = num;
        }
    }

    public int getPowerNumber() {
        return powerNumber;
    }
    
    public boolean validTicket() {
        return !(uniqueNumbers.size() != 5 || powerNumber == 0);
    }

    public void generateWinningNumbers() {
        for (int i = 0; i < 5; i++) {
            while (true) {
                int r = (int) (Math.random() * 59 + 1);
                if (!winningNumbers.contains(r)) {
                    if (winningNumbers.size() == 5) {
                        winningNumbers.set(i, r);
                        break;
                    }
                    winningNumbers.add(r);
                    break;
                }
            }
        }
    }

    public ArrayList<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void generateWinningPowerNumber() {
        winningPowerNumber = (int) (Math.random() * 35 + 1);
    }

    public int getWinningPowerNumber() {
        return winningPowerNumber;
    }

    public boolean isWinner() {
        gamesPlayed++;
        moneySpent += 2;
        return uniqueNumbers.containsAll(winningNumbers) && powerNumber == winningPowerNumber;
    }

    public long getMoneySpent() {
        return moneySpent;
    }

    public long getWeeksPlayed() {
        if (gamesPlayed % 2 == 0) {
            return gamesPlayed / 2;
        }
        return (gamesPlayed / 2) + 1;
    }

    public void simulate() {
        while (true) {
            generateWinningNumbers();
            generateWinningPowerNumber();
            if (isWinner() == true) {
                break;
            }
        }
    }
}
