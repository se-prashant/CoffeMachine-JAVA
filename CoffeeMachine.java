package machine;
import java.util.Scanner;
public class CoffeeMachine {

    private static Scanner sc;

    enum AVAILABLE {
        buy, fill, take, remaining, exit;
    }
    static class Update {
        private int water;
        private int milk;
        private int beans;
        private int cup;
        private int money;

        public int getWater() {
            return water;
        }
        public int getMilk() {
            return milk;
        }
        public int getBeans() {
            return beans;
        }
        public int getCup() {
            return  cup;
        }
        public int getMoney() {
            return money;
        }
        public void setWater(int water){
            this.water = water;
        }
        public void setMilk(int milk){
            this.milk = milk;
        }
        public void setBeans(int beans){
            this.beans = beans;
        }
        public void setCup(int cup){
            this.cup = cup;
        }
        public void setMoney(int money){
            this.money = money;
        }
    }
    public static Update update = new Update();

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        update.setWater(400);
        update.setMilk(540);
        update.setBeans(120);
        update.setCup(9);
        update.setMoney(550);
        boolean flag = true;
        while (flag){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = sc.next();
            AVAILABLE available = AVAILABLE.valueOf(action);
            switch (available) {
                case buy:
                    buy();
                    break;
                case fill:
                    fill();
                    break;
                case take:
                    take();
                    break;
                case remaining:
                    System.out.println("\nThe coffee machine has:\n" +
                            +update.getWater()+ " of water\n" +
                            +update.getMilk()+ " of milk\n" +
                            +update.getBeans()+ " of coffee beans\n" +
                            +update.getCup()+" of disposable cups\n" +
                            "$"+update.getMoney()+" of money\n");
                    break;
                case exit:
                    flag = false;
                    break;
            }

        }
    }

    private static void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String type = sc.next();
        switch (type) {
            case "1":
                if(update.getWater()>=250 && update.getBeans()>=16 && update.getCup()>=1){
                    update.setMoney(update.getMoney()+4);
                    update.setWater(update.getWater()-250);
                    update.setBeans(update.getBeans()-16);
                    update.setCup(update.getCup()-1);
                    System.out.println("I have enough resources, making you a coffee!\n");
                }else
                    System.out.println("Sorry, not enough water!\n");
                break;
            case "2":

                if(update.getWater()>=350 && update.getBeans()>=20 && update.getCup()>=1 && update.getMilk()>=70){
                    update.setMoney(update.getMoney()+7);
                    update.setWater(update.getWater()-350);
                    update.setBeans(update.getBeans()-20);
                    update.setCup(update.getCup()-1);
                    update.setMilk(update.getMilk()-75);
                    System.out.println("I have enough resources, making you a coffee!\n");
                }else
                    System.out.println("Sorry, not enough water!\n");
                break;
            case "3":
                if(update.getWater()>=200 && update.getBeans()>=12 && update.getCup()>=1 && update.getMilk()>=100){
                    update.setMoney(update.getMoney()+6);
                    update.setWater(update.getWater()-200);
                    update.setBeans(update.getBeans()-12);
                    update.setCup(update.getCup()-1);
                    update.setMilk(update.getMilk()-100);

                    System.out.println("I have enough resources, making you a coffee!\n");
                }else
                    System.out.println("Sorry, not enough water!\n");
            case "4":
                break;
        }
    }

    private static void  fill() {
        System.out.println("\nWrite how many ml of water do you want to add:");
        int water = sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int beans = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups = sc.nextInt();
        update.setWater(water+update.getWater());
        update.setMilk(update.getMilk()+milk);
        update.setBeans(update.getBeans()+beans);
        update.setCup(update.getCup()+cups);
        System.out.println();
    }
    private static void  take() {
        System.out.println("I gave you $"+update.getMoney()+"\n");
        update.setMoney(0);
    }
}
