import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        RobotService robotService = new RobotService();
        Robot robot1 = new Robot();
        robot1.model = "Mixi";

        Robot robot2 = new Robot();
        robot2.model = "Xiaomi";

        Robot robot3 = new Robot();
        robot3.model = "Braun";

        Robot robot4 = new Robot();
        robot4.model = "Philips";

        Robot[] arrayRobot = {robot1, robot2, robot3, robot4};
        int i=0;
        while(i!=5) {
            System.out.println("""
            1. Вывести всех роботов
            2. Начать уборку
            3. Поставить на зарядку
            4. Пополнить бак
            5. Выход                
            """);
            i = scan.nextInt();
            switch (i) {
                case 1:
                    for (Robot robot : arrayRobot) {
                        robot.printInfo();

                    }
                    break;
                case 2:
                    System.out.println("Введите модель робота");
                    String str = scan.next();
                    Robot foundRobot = RobotService.findRobot(arrayRobot, str);
                    System.out.println("Включить ли режим сухой уборки (true/false):");
                     boolean dryCleaning = scan.nextBoolean();
                    System.out.println("Включить ли режим влажной уборки (true/false):");
                     boolean wetCleaning = scan.nextBoolean();
                     System.out.println("Включить ли режим увлажнения воздуха (true/false):");
                     boolean airWetness = scan.nextBoolean();

                    foundRobot.startCleaning(dryCleaning,  wetCleaning,  airWetness);
                    break;

                case 3:
                    System.out.println("Введите модель робота.");
                    String model = scan.next();
                    foundRobot = RobotService.findRobot(arrayRobot, model);

                    foundRobot.startCharging();

                    break;
                case 4:
                    System.out.println("Введите модель робота.");
                    String model1 = scan.next();
                    Robot foundWater = RobotService.findRobot(arrayRobot, model1);
                    System.out.println("Введите объем воды, который нужно добавить в бак");
                    int water = scan.nextInt();
                    foundWater.addWater( water);

                    break;
                case 5:
                    System.out.println("Exit");
                    break;
            }
        }
    }
}
class RobotService{


    public static Robot findRobot(Robot[] robots, String robotName){

        for (int k = 0; k < robots.length; k++) {
            if (robots[k].getModel().equals(robotName)) {
               return robots[k];

            }
        }
        return null;
    }
}
class Robot {

    String model;

    int waterVolume = 500;

    int consumptionForCleaning = 300;

    int consumptionForAiring = 100;


    int battery = 100;

    void startCleaning(boolean dryCleaning, boolean wetCleaning, boolean airWetness) {
        int i = 0;

        if (dryCleaning && wetCleaning && dryCleaning && airWetness) {
            System.out.println("Робот не может делать одновременно сухую и влажную уборку");
            return;
        }
        if (dryCleaning) {
            i += 30;
        }
        if (wetCleaning) {
            i += 30;

        }
        if (airWetness) {
            i += 30;

        }
        if (battery < i) {
            System.out.println("Для работы робота требуется " + i + " заряда");
        } else {
            battery -= i;
        }
        if (wetCleaning && waterVolume < consumptionForCleaning) {
            System.out.println("Предупреждение: выбрана влажная уборка, но она не может быть выполнена. Не хватает воды в баке");
        } else {
            waterVolume -= consumptionForCleaning;
        }
        if (airWetness && waterVolume < consumptionForAiring) {
            System.out.println("Предупреждение: выбрана опция увлажнения воздуха, но она не может быть выполнена. Не хватает воды в баке");
        } else {
            waterVolume -= consumptionForAiring;
        }
    }
    void printInfo() {
        System.out.printf("Робот %s, Кол-во воды в баке: %d, расход воды на влажную уборку %d, расход на увлажнение: %d, заряд: %d\n",
                model, waterVolume, consumptionForCleaning, consumptionForAiring, battery);

    }

    void startCharging() {
        battery = 100;
        boolean dryCleaning = false;
        boolean wetCleaning = false;
        boolean airWetness = false;
    }


    public String getModel () {
        return model;
    }
    void addWater(int water){
        waterVolume += water;
    }

}









