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
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                buyCoffee(scanner.nextInt());
                break;
            } case "fill": {
                fillMachine();
                break;
            } case "take": {
                takeMoney();
                break;
            } case "exit" :{
                break;
            }
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

        System.out.println("");

        startMode();
    }

    public static void buyCoffee (int type) {
        switch (type) {
            case 1: {
                totalAmtOfMoney += 4;
                totalAmtOfWater -= 250;
                totalAmtOfCoffeeBeans -= 16;
                totalAmtOfCups -= 1;

                checkAvailability(totalAmtOfWater, totalAmtOfMilk, totalAmtOfCoffeeBeans, totalAmtOfCups);

                System.out.println("");
                startMode();
                //remaining(totalAmtOfMoney, totalAmtOfWater, totalAmtOfMilk, totalAmtOfCoffeeBeans, totalAmtOfCups);
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

    public static void takeMoney () {
        System.out.println("I gave you $" + totalAmtOfMoney);
        remaining(0, totalAmtOfWater, totalAmtOfMilk, totalAmtOfCoffeeBeans, totalAmtOfCups);
    }

    public static void checkAvailability(int water, int milk, int beans, int cups){

        if (water == 0){
            System.out.println("Sorry, not enough water");
        }else if (milk == 0){
            System.out.println("Sorry, not enough milk");
        }else if (beans == 0){
            System.out.println("Sorry, not enough beans");
        }else if (cups == 0){
            System.out.println("Sorry, not enough cups");
        }else {
            System.out.println("I have enough resources, making you a cup of coffee!");
        }


//
//        if (water == 0){
//            System.out.println("Sorry, not enough water");
//        }else{
//            System.out.println("I have enough resources, making you a cup of coffee!");
//        }
//
//        if (milk == 0){
//            System.out.println("Sorry, not enough milk");
//        }else{
//            System.out.println("I have enough resources, making you a cup of coffee!");
//        }
//
//        if (beans == 0){
//            System.out.println("Sorry, not enough beans");
//        }else {
//            System.out.println("I have enough resources, making you a cup of coffee!");
//        }
//
//        if (cups ==0){
//            System.out.println("Sorry, not enough cups");
//        }else {
//            System.out.println("I have enough resources, making you a cup of coffee!");
//        }
    }

}
