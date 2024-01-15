import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

                Scanner scan = new Scanner(System.in);
                String[] name = {"employee1","employee2", "employee3", "employee4"};
                int[] speed = {10, 5, 30, 3};
                String[] tasks = new String[4];
                boolean exit=false;

                while(!exit) {
                    String str = scan.next();
                    switch (str) {
                        case "1" -> {
                            int maxspeed = speed[0]; // создаем переменную maxspeed, чтобы сравнивать значения скорости в массиве между собой
                            int maxIndex = 0; // создаем переменную maxIndex, чтобы использовать ее при выводе имени самого быстрого сотрудника

                            for (int j = 0; j < speed.length; j++) {
                                if (speed[j] > maxspeed && tasks[j] == null) {
                                    maxspeed = speed[j];// сохраняем максимальное значение в переменной maxspeed
                                    maxIndex = j;
                                }


                            }
                            System.out.println(name[maxIndex]);
                        }
                        case "2" -> {
                            int str2 = 0;
                            String name1 = scan.next();
                            String str1 = scan.next();
                            for (int k = 0; k < name.length; k++) {
                                if (name[k].equals(name1)) {
                                    tasks[k] = str1;
                                    str2 = k;
                                }

                            }
                            if (!name[str2].equals(name1)) {
                                System.out.println("Сотрудник не найден");
                            }
                        }
                        case "3" -> {
                            for (int d = 0; d < tasks.length; d++) {
                                if(tasks[d] != null) {
                                    System.out.print(name[d] + " - " + tasks[d]);

                                    if (d < tasks.length - 1) {
                                        System.out.print(", ");
                                    }
                                }
                            }
                        }
                        case "4" -> {
                            exit=true;
                        }

                    }
                }
            }
        }












