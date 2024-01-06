



public class Application {
    public static void main(String[] args) {
        int i = 0;                                                   // Первое задание
        while (i != 10) {
            System.out.print("JAVA ");
            i++;
        }
        System.out.println("\n");

        for(int j =0; j < 10; j++){                                 // Второе задание
            System.out.print("JAVA ");
        }
        System.out.println("\n");

        int c = 0;                                                   // Третье задание
        while (c != 10) {
            System.out.println("JAVA");
            c++;
        }
        System.out.println("\n");
        int year = 1980;                                            // Четвертое задание
        while(year<=2020){
            System.out.println("Олимпиада "+year+" года");
            year += 4;
        }
        System.out.println("\n");
        for(int years = 1980; years <=2020; years += 4 ){               // Пятое задание
            System.out.printf("Олимпиада %d года \n", years);
        }
        System.out.println("\n");                                       // Шестое задание
        int k = 7;
        for(int y=1;y<10;y++)
            System.out.printf("%d*%d=%d\n", y, k, y*k);
    }
}



       /*. Задачи:

1. Вывести на экран слово “JAVA”, в строку, чтобы оно повторилось 10 раз, используя цикл while.
Вывод в консоль должен быть таким:
JAVA JAVA JAVA JAVA JAVA JAVA JAVA JAVA JAVA JAVA

2. Повторить задание 1, но используя цикл for.

3. Вывести на экран слово “JAVA”, в столбик, чтобы оно повторилось 10 раз, используя цикл на ваше усмотрение (for или while).
Вывод в консоль должен быть таким:
JAVA
JAVA
JAVA
JAVA
JAVA
JAVA
JAVA
JAVA
JAVA
JAVA

4. Используя цикл while, выведите в столбик строки вида “Олимпиада year года”, где year - это число, которое принимает значения, начиная от 1980 до 2020, с шагом увеличения равным 4.
То есть на первой итерации цикла, year равен 1980, а на каждой следующей итерации, значение year увеличивается на 4. Строки такого вида выводятся до тех пор, пока значение year не станет больше 2020.


Пример:
year = 1980, вывод должен быть таким:
Олимпиада 1980 года
Олимпиада 1984 года
Олимпиада 1988 года
Олимпиада 1992 года
……
Олимпиада 2016 года
Олимпиада 2020 года

5. Повторить задание 4, но используя цикл for.

6. Объявите переменную типа int, имя переменной - k. Присвойте этой переменной какую-нибудь цифру от 1 до 9. Используя цикл на ваше усмотрение (for или while), выведите в консоль таблицу умножения для этой цифры в следующем формате:
1 x k = …
2 x k = …
3 x k = …
……
9 x k = …


Пример:
k = 3

Вывод в консоль:
1 x 3 = 3
2 x 3 = 6
3 x 3 = 9
……
9 x 3 = 27 */