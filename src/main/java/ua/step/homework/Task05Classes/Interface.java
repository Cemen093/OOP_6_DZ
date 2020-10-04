package ua.step.homework.Task05Classes;

import java.util.Scanner;

public class Interface {
    public static int Input(String s, int min, int max){
        int c;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(s);
            if(scanner.hasNextInt()) {
                c = scanner.nextInt();
                if (c <= max || c >= min) {
                    break;
                }
            }
            scanner.nextLine();
            System.out.printf("Не корректный ввод\n" +
                    "Введите целое число от %d до %d\n", min, max);
        } while (true);
        return c;
    }
    public static int Input(String s, int min){
        int c;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(s);
            if(scanner.hasNextInt()) {
                c = scanner.nextInt();
                if (c >= min){
                    break;
                }
            }
            scanner.nextLine();
            System.out.printf("Не корректный ввод\n" +
                    "Введите целое число от %d до %d\n", min, 2147483647);
        } while (true);
        return c;
    }
    public static int Input(String s){
        int c;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(s);
            if(scanner.hasNextInt()) {
                c = scanner.nextInt();
                break;
            }
            scanner.nextLine();
            System.out.printf("Не корректный ввод\n" +
                    "Введите целое число от %d до %d\n", -2147483647, 2147483647);
        } while (true);
        return c;
    }
    public static void outputDragonAttacks(int damage, int live, int liveWoundedSpearmanOrZeroIfNot){
        //Дракон атакует – осталось 15 копейщиков, один из которых ранен (осталось 5 жизней)
        if (liveWoundedSpearmanOrZeroIfNot == 0) {
            System.out.printf("Дракон атакует (урон %d) – осталось %d копейщиков\n",damage, live);
        }
        else{
            System.out.printf("Дракон атакует – осталось %d копейщиков, один из которых ранен " +
                    "(осталось %d жизней)\n", live, liveWoundedSpearmanOrZeroIfNot);
        }
    }
    public static void outputSpearmanAttack(int damage, int live) {
        //Копейщики атакуют (урон 200) – у дракона осталось 300 жизней
        System.out.printf("Копейщики атакуют (урон %d) – у дракона осталось %d жизней\n", damage, live);
    }
    public static void outputVictoryDragon(){
        //Дракон атакует и побеждает
        System.out.print("Дракон атакует и побеждает\n");
    }
    public static void outputVictorySpearman(){
        System.out.print("Копейщики атакуют и побеждают\n");
    }
    public static void iteration(int it){
        System.out.printf("\nИтерация %d\n", it);
    }
}
