package com.company;

public class RunSimulation {

    PlayerDataCard player1 = new PlayerDataCard();
    PlayerDataCard player2 = new PlayerDataCard();

    public RunSimulation() {
        player1.setAmountOfGold(3000);
        player2.setAmountOfGold(6000);
        player1.setName("Rymo");
        player2.setName("JokerD");
        player1.setGoldThreshold(0);
        player2.setGoldThreshold(0);
    }

    public void runSimulation() {

        int bid = bidAmount();
        int amountOfRolls = 0;
        int amountOfRounds = 0;

        do {

            if ( player1.setRoll(Roll(bid*10)) == 1 ) {
                System.out.println(player1.getName() + " rolls: " + player1.getRoll() + " (1-" + bid*10 + ") and lost!");
                amountOfRolls++;
            } else {
                System.out.println(player1.getName() + " rolls: " + player1.getRoll() + " (1-" + bid*10 + ")");
                amountOfRolls++;
            }


            while (player1.getRoll() != 1 && player2.getRoll() != 1) {

                if ( player2.setRoll(Roll(player1.getRoll())) == 1 ) {
                    System.out.println(player2.getName() + " rolls: " + player2.getRoll() + " (1-" + player1.getRoll() + ") and lost!");
                    amountOfRolls++;
                    break;
                } else {
                    System.out.println(player2.getName() + " rolls: " + player2.getRoll() + " (1-" + player1.getRoll() + ")");
                    amountOfRolls++;
                }

                if ( player1.setRoll(Roll(player2.getRoll())) == 1 ) {
                    System.out.println(player1.getName() + " rolls: " + player1.getRoll() + " (1-" + player2.getRoll() + ") and lost!");
                    amountOfRolls++;
                    break;
                } else {
                    System.out.println(player1.getName() + " rolls: " + player1.getRoll() + " (1-" + player2.getRoll() + ")");
                    amountOfRolls++;
                }

            }

            if(player1.getRoll() == 1) {
                player1.setAmountOfGold(player1.getAmountOfGold()-bidAmount());
                player2.setAmountOfGold(player2.getAmountOfGold()+bidAmount());
                player1.setRoll(0);
                player2.setRoll(0);
                amountOfRounds++;
            } else if(player2.getRoll() == 1) {
                player1.setAmountOfGold(player1.getAmountOfGold()+bidAmount());
                player2.setAmountOfGold(player2.getAmountOfGold()-bidAmount());
                player1.setRoll(0);
                player2.setRoll(0);
                amountOfRounds++;
            }

        } while (player1.getAmountOfGold() > player1.getGoldThreshold() && player2.getAmountOfGold() > player2.getGoldThreshold());

        System.out.println("Roll Duel ended and it took " + amountOfRolls + " rolls and " + amountOfRounds + " rounds");
        System.out.println("Final Gold " + player1.getName() + " " + player1.getAmountOfGold() + "g");
        System.out.println("Final Gold " + player2.getName() + " " + player2.getAmountOfGold() + "g");
    }

    private int bidAmount() {

        return 5;
    }

    private int Roll(int bid) {

        double x = (Math.random()*((bid-1)+1))+1;
        return (int)x;
    }
}
