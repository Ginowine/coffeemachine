import java.util.Scanner;

public class Machine {
    private static int totalAmtOfWater = 400;
    private static int totalAmtOfMilk = 540;
    private static int totalAmtOfCoffeeBeans = 120;
    private static int totalAmtOfCups = 9;
    private static int totalAmtOfMoney = 550;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        String inputBuy = "buy";
        String inputFill = "fill";
        String inputTake = "take";
        String inputRemaining = "remaining";
        String inputExit = "exit";
        String input;

        System.out.println("write action (buy, fill, take, remaining, exit): " );

        switch (scanner.next()){
            case "remaining": {
                remaining(totalAmtOfWater, totalAmtOfMilk, totalAmtOfCoffeeBeans, totalAmtOfCups, totalAmtOfMoney);
                break;
            } case "buy": {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                buyCoffee(scanner.nextInt());
            } case "fill": {
                fillMachine();
            }case
        }

    }

    public static void remaining(int money, int water, int milk, int beans, int cups){
        System.out.println("");

        System.out.println("The coffee machine has:");
        System.out.println(totalAmtOfWater + " of water");
        System.out.println(totalAmtOfMilk + " of milk");
        System.out.println(totalAmtOfCoffeeBeans + " of coffee beans");
        System.out.println(totalAmtOfCups + " of disposable cups");
        System.out.println(totalAmtOfMoney + " of money");
    }

    public static void buyCoffee (int type) {
        switch (type) {
            case 1: {
                totalAmtOfMoney += 4;
                totalAmtOfWater -= 250;
                totalAmtOfCoffeeBeans -= 16;
                totalAmtOfCups -= 1;
                remaining(totalAmtOfMoney, totalAmtOfWater, totalAmtOfMilk, totalAmtOfCoffeeBeans, totalAmtOfCups);
                break;
            }
            case 2: {
                totalAmtOfMoney += 7;
                totalAmtOfWater -= 350;
                totalAmtOfMilk -= 75;
                totalAmtOfCoffeeBeans -= 20;
                totalAmtOfCups -= 1;
                remaining(totalAmtOfMoney , totalAmtOfWater , totalAmtOfMilk , totalAmtOfCoffeeBeans , totalAmtOfCups );
                break;
            }
            case 3: {
                totalAmtOfMoney += 6;
                totalAmtOfWater -= 200;
                totalAmtOfMilk -= 100;
                totalAmtOfCoffeeBeans -= 12;
                totalAmtOfCups -= 1;
                remaining(totalAmtOfMoney , totalAmtOfWater , totalAmtOfMilk , totalAmtOfCoffeeBeans, totalAmtOfCups );
                break;
            }
            default: {
                System.out.println("Unknown type");
                break;
            }
        }
    }

    public static void fillMachine () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water do you want to add: ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int beans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int cups = scanner.nextInt();

        totalAmtOfWater += water;
        totalAmtOfMilk += milk;
        totalAmtOfCoffeeBeans += beans;
        totalAmtOfCups += cups;

        remaining(totalAmtOfMoney, totalAmtOfWater, totalAmtOfMilk, totalAmtOfCoffeeBeans, totalAmtOfCups);
    }

}
