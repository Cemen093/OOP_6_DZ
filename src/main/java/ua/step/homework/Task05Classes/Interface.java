package ua.step.homework.Task05Classes;

import java.util.Scanner;

public class Interface {
    public static int Input(String s, int min, int max){
        int c = 0;
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
                    "Введите целое число от %d до %d\n",min, max);
        } while (false);
        return c;
    }
    public static int Input(String s, int min){
        int c = 0;
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
                    "Введите целое число от %d до %d\n",min, 2147483647);
        } while (true);
        return c;
    }
    public static int Input(String s){
        int c = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(s);
            if(scanner.hasNextInt()) {
                scanner.nextLine();
                break;
            }
            c = scanner.nextInt();
            System.out.printf("Не корректный ввод\n" +
                    "Введите целое число от %d до %d\n",-2147483647, 2147483647);
        } while (true);
        return c;
    }
    public static void OutputDragonAttacks(int damage, int live, int liveWoundedSpearman){
        //Дракон атакует – осталось 15 копейщиков, один из которых ранен (осталось 5 жизней)
        if (liveWoundedSpearman == 0) {
            System.out.printf("Дракон атакует (урон %d) – осталось %d копейщиков\n",damage, live);
        }
        else{
            System.out.printf("Дракон атакует – осталось %d копейщиков, один из которых ранен " +
                    "(осталось %d жизней\n", live, liveWoundedSpearman);
        }
    }
    public static void OutputSpearmanAttack(int damage, int live) {
        //Копейщики атакуют (урон 200) – у дракона осталось 300 жизней
        System.out.printf("Копейщики атакуют (урон %d) – у дракона осталось %d жизней\n", damage, live);
    }
    public static void OutputVictoryDragon(){
        //Дракон атакует и побеждает
        System.out.print("Дракон атакует и побеждает\n");
    }
    public static void OutputVictorySpearman(){
        System.out.print("Копейщики атакуют и побеждают\n");
    }
    public static void Iteration(int it){
        System.out.printf("Итерация %d\n", it);
    }
}
