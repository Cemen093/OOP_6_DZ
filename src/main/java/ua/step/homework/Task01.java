package ua.step.homework;

/**
 * Написать и методы работы с квадратными матрицами (матрицы
 * представить в виде двухмерных массивов). 
 * Должны присутствовать методы:
 * • создания единичной (диагональной) матрицы (метод createOne)
 * • создания нулевой матрицы (метод createNull)
 * • сложение матриц (метод sumMatrix)
 * • умножения матриц (метод productMatrix)
 * • умножение матрицы на скаляр (метод productMatrix)
 * • определение детерминанта матрицы (метод determinant)
 * • вывод матрицы на консоль (метод printMatrix)
 */
public class Task01 {

	public static void main(String[] args) {
		// TODO: Проверяйте методы здесь
	}

	/**
	 * Создает единичную матрицу
	 * @param n - количество строк
	 * @param m - количество колонок
	 * @return единичную (диагональную) матрицу
	 */
	public static int[][] createOne (int n, int m) {
		int[][] arr = new int [n][m];
		for (int i = 0; i < n ; i++) {
			arr[i][i] = 1;
		}
		return arr;
	}

	/**
	 * Создает нулевую матрицу
	 * @param n - количество строк
	 * @param m - количество колонок
	 * @return нулевую матрицу
	 */
	public static int[][] createNull (int n, int m) {
		return new int[n][m]; // можно упростить
	}

	/**
	 * Вычисляет сумму двух матриц
	 * @param one - первая матрица
	 * @param two - вторая матрица
	 * @return сумму двух матриц
	 */
	public static int[][] sumMatrix(int[][] one, int[][] two) {
		//предположим матрици одинаковые
		int[][] arr = new int[one.length][one[0].length];
		for (int i = 0; i < one.length; i++) {
			for (int j = 0; j < one[0].length; j++) {
				arr[i][j] = one[i][j] + two[i][j];
			}
		}
		return arr;
	}

	/**
	 * Вычисляет произведение двух матриц
	 * @param one - первая матрица
	 * @param two - вторая матрица
	 * @return произведение матриц
	 */
	public static int[][] productMatrix(int[][] one, int[][] two) {
		int[][] arr = new int[one.length][two[0].length];
		for (int i = 0; i < one.length ; i++) {//результирующая матрица [x][]
			for (int j = 0; j < two[0].length; j++) {//результирующая матрица [][x]
				for (int k = 0; k < two.length; k++) {//смещение по двум исходным матрицам
					arr[i][j] += one[i][k] * two[k][j];
				}
			}
		}

		return arr;
	}

	/**
	 * Вычисляет произведение матрицы на скаляр
	 * @param matrix - матрица
	 * @param num - скаляр
	 * @return произведение матрицы на скаляр
	 */
	public static int[][] productMatrix(int[][] matrix, int num) {
		int[][] arr = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length ; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				arr[i][j] = matrix[i][j] * num;
			}
		}
		return arr;
	}

	/**
	 * Вычисляет детерминант матрицы
	 * @param matrix - матрица
	 * @return детерминант матрицы
	 */
	public static int determinant(int[][] matrix) {
		int len = matrix.length;
		if (len == 1) {
			return matrix[0][0];//решение для матрици 1х1 и выход из рекурсии
		}
		int ans = 0;
		for (int i = 0; i < len; i++) {//доп минор по одному
			int[][] arr = new int[len - 1][len - 1];
			for (int j = 1, j1 = 0; j < len; j++, j1++) {//строки минора (j = 1 пропуск 1 строки для минора)
				for (int k = 0, k1 = 0; k < len ; k++) {//колоны минора
					if (k == i){//пропуск i столбца для минора
						continue;
					}
					arr[j1][k1] = matrix[j][k];//вот самому стыдно столько памяти выедать, но руки кривые
					//я так понял по хорошему тут надо на Arrey.List переделать? Чтоб избавится от костыля.
					k1++;//три раза выражение переставлял, пока правильное место не нашел
				}
			}
			ans = ans + matrix[0][i] * determinant(arr) * ((i % 2 == 1)? -1: 1);
		}

		return ans;
	}

	/**
	 * Печатает матрицу в стандартный поток вывода
	 * @param matrix - матрица
	 */
	public static void printMatrix(int[][] matrix) {
		// Не верное решение. Что мы увидим в консоли?
		System.out.println(matrix);
	}
}
