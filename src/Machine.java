import java.util.Scanner;

public class Machine {
    private static int totalAmtOfWater = 400;
    private static int totalAmtOfMilk = 540;
    private static int totalAmtOfCoffeeBeans = 120;
    private static int totalAmtOfCups = 9;
    private static int totalAmtOfMoney = 550;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        startMode();
    }

    public static void startMode(){
        System.out.println("write action (buy, fill, take, remaining, exit): " );
        switch (scanner.next()){
            case "remaining": {
                remaining(totalAmtOfWater, totalAmtOfMilk, totalAmtOfCoffeeBeans, totalAmtOfCups, totalAmtOfMoney);
                break;
            } case "buy": {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - back ");
                buyCoffee(scanner.nextInt());
                break;
            } case "fill": {
                fillMachine();
                break;
            } case "take": {
                takeMoney(totalAmtOfMoney);
                break;
            } case "exit" :{
                break;
            }
        }
    }

    public static void remaining(int water, int milk, int beans, int cups, int money){
        System.out.println("");

//        totalAmtOfMoney = money;
//        totalAmtOfWater = water;
//        totalAmtOfMilk = milk;
//        totalAmtOfCoffeeBeans = beans;
//        totalAmtOfCups = cups;

        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");

        System.out.println("");

        startMode();
    }

    public static void buyCoffee (int type) {
        switch (type) {
            case 1: {
                totalAmtOfWater -= 250;
                totalAmtOfCoffeeBeans -= 16;
                totalAmtOfCups -= 1;
                totalAmtOfMoney += 4;

                checkAvailability(totalAmtOfWater, totalAmtOfMilk, totalAmtOfCoffeeBeans, totalAmtOfCups);

                System.out.println("");
                startMode();
                //remaining(totalAmtOfMoney, totalAmtOfWater, totalAmtOfMilk, totalAmtOfCoffeeBeans, totalAmtOfCups);
                break;
            }
            case 2: {
                if (totalAmtOfWater <= 350){
                    //totalAmtOfWater = 50;
                    System.out.println("Sorry, not enough water!");
                }else {
                    System.out.println("I have enough resources, making you a cup of coffee!");
                    totalAmtOfWater -= 350;
                    totalAmtOfMilk -= 75;
                    totalAmtOfCoffeeBeans -= 20;
                    totalAmtOfCups -= 1;
                    totalAmtOfMoney += 7;
                }

                //checkAvailability(totalAmtOfWater, totalAmtOfMilk, totalAmtOfCoffeeBeans, totalAmtOfCups);
                System.out.println("");
                startMode();
                //remaining(totalAmtOfMoney , totalAmtOfWater , totalAmtOfMilk , totalAmtOfCoffeeBeans , totalAmtOfCups );
                break;
            }
            case 3: {
                totalAmtOfMoney += 6;
                totalAmtOfWater -= 200;
                totalAmtOfMilk -= 100;
                totalAmtOfCoffeeBeans -= 12;
                totalAmtOfCups -= 1;

                checkAvailability(totalAmtOfWater, totalAmtOfMilk, totalAmtOfCoffeeBeans, totalAmtOfCups);
                System.out.println("");

                //remaining(totalAmtOfMoney , totalAmtOfWater , totalAmtOfMilk , totalAmtOfCoffeeBeans, totalAmtOfCups );
                break;
            }
            case 4: {
                startMode();
            }
            default: {
                System.out.println("Unknown type");
                break;
            }
        }
    }

    public static void checkAvailability(int water, int milk, int beans, int cups){

        if (totalAmtOfWater < 350)

        if (water <= 0){
            System.out.println("Sorry, not enough water");
        }else if (milk <= 0){
            System.out.println("Sorry, not enough milk");
        }else if (beans <= 0){
            System.out.println("Sorry, not enough beans");
        }else if (cups <= 0){
            System.out.println("Sorry, not enough cups");
        }else {
            System.out.println("I have enough resources, making you a cup of coffee!");
        }

        //startMode();
    }

    public static void fillMachine () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water do you want to add: ");
        int water = scanner.nextInt();
        totalAmtOfWater += water;
        System.out.println("Write how many ml of milk do you want to add: ");
        int milk = scanner.nextInt();
        totalAmtOfMilk += milk;
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int beans = scanner.nextInt();
        totalAmtOfCoffeeBeans += beans;
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int cups = scanner.nextInt();
        totalAmtOfCups += cups;

        System.out.println("");
        startMode();
        //remaining(totalAmtOfMoney, totalAmtOfWater, totalAmtOfMilk, totalAmtOfCoffeeBeans, totalAmtOfCups);
    }

    public static void takeMoney (int amount) {
        System.out.println("I gave you $" + amount);
        //int zero = 0;
        totalAmtOfMoney = 0;
        startMode();
        //remaining(0, totalAmtOfWater, totalAmtOfMilk, totalAmtOfCoffeeBeans, totalAmtOfCups);
    }

}
