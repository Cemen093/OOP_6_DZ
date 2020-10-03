package ua.step.homework;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Эту задачу можно встретить и под названием «Золотая гора» — нужно спуститься с горы
 * и собрать как можно больше золота.
 *
 * Ниже показан пример треугольника из чисел.
 * <pre>
 *       7
 *      3 8
 *     8 1 0
 *    2 7 4 4
 *   4 5 2 6 5
 * </pre>
 *
 * Написать программу, которая позволит:
 * - выводить значения треугольника на консоль в таком виде как на рисунке;
 * - вычислять наибольшую сумму чисел, через которые проходит путь, начинающийся на вершине и
 * заканчивающийся где-то на основании.
 *
 * 1. Каждый шаг может идти диагонально вниз-направо или диагонально вниз-налево.
 * 2. Количество строк в треугольнике >1, но <100.
 * 3. Числа в треугольнике все целые от 0 до 99 включительно (генерируются случайным образом).
 *
 * В примере, описанном выше, это путь 7, 3, 8, 7, 5, дающий максимальную сумму 30.
 *
 * Программа должна выводить на экран треугольник и путь, который даст максимальный результат. Для текущего
 * примера он будет такой – влево, влево, вправо, влево.
 *
 * Алгоритм решения данной задачи: <a href='https://ru.wikibooks.org/wiki/%D0%A0%D0%B5%D0%BA%D1%83%D1%80%D1%81%D0%B8%D1%8F#%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0_%D0%BE_%D0%B7%D0%BE%D0%BB%D0%BE%D1%82%D0%BE%D0%B9_%D0%B3%D0%BE%D1%80%D0%B5'>Задача о золотой горе</a>
 */
public class Task04 {

	public static final int MAX = 100;
	public static final int ROW = 7;

	public static void main(String[] args) {
		final int[][] triangle = new int[ROW][];
		final Random rnd = new Random();

		for (int i = 0; i < triangle.length; i++) {
			triangle[i] = new int[i+1];
			for (int j = 0; j < triangle[i].length; j++) {
				triangle[i][j] = rnd.nextInt(MAX);
			}
		}

		printTriangle(triangle);//пример был для чисел до 9, но у нас до 100, адаптировать под двухзначные?
		//System.out.println(solve2(triangle, 0, 0));//первый алгоритм намного проще
		System.out.print("\nПуть с золотой горы : ");
		for (int number : solve(triangle))
		{
			System.out.printf("%d ", number);
		}
		System.out.println();
	}

	/**
	 * Метод распечатывает треугольник на консоль
	 * @param triangle - двумерный массив
	 */
	static void printTriangle(int[][] triangle) {
		//адапритую под двухзначные числа
		//строка
		for (int i = 0; i < triangle.length; i++) {
			//Отступ
			for (int j = 0; j < triangle.length - 1 - i; j++) {
				System.out.print("  ");
			}
			//Числа
			for (int j = 0; j < triangle[i].length; j++) {
				if (triangle[i][j] < 10){//надо нет?
					System.out.print(" ");
				}
				System.out.printf("%d  ", triangle[i][j]);
			}
			//переход на новую строку
			System.out.print("\n");
		}
	}

	/**
	 * Метод решающий задачу поиска пути
	 * @param triangle - двумерный массив
	 * @return - путь от вершины до основания в котором сумма числе наибольшая
	 */
	static int[] solve(int[][] triangle) {
		//насколько я понял суть алгоритма, мы идем снизу вверх и переписываем значение элемента на
		//максимальную сумму элементов

		//массив для пути
		int[] theWay = new int[triangle.length];
		//массив для записи вычислений
		//я сдаюсь, за час так и не смог скопировать какой то массив методами.
		int[][] arr = new int[triangle.length][];
		for (int i = 0; i < triangle.length - 1; i++) {
			arr[i] = new int[i+1];
		}
		arr [triangle.length - 1] = Arrays.copyOf(triangle[triangle.length - 1], triangle[triangle.length - 1].length);
		for (int i = arr.length - 2; i > -1; i--) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i + 1][j] > arr[i + 1][j + 1]){
					arr[i][j] += arr[i + 1][j];
					theWay[i + 1] = triangle[i + 1][j];
				}
				else{//если равно тоже идем в право
					arr[i][j] += arr[i + 1][j+ 1];
					theWay[i + 1] = triangle[i + 1][j + 1];
				}
			}
		}
		theWay[0] = triangle[0][0];
		return theWay;
	}
	/*static int solve2(int[][] triangle, int i, int j){
		if (triangle.length - 1 > i) {
			return triangle[i][j] + Math.max(solve2(triangle, (i + 1), j), solve2(triangle, (i + 1), (j + 1)));
		}
		else{
			return triangle[i][j];
		}
	}*/
}
