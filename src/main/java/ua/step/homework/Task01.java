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
		int[][] arr = new int[n][m];
		return arr;
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
		//допустим что матрици одного размера
		int[][] arr = new int [one.length][one[0].length];
		for (int i = 0; i < one.length; i++) {
			for (int j = 0; j < one[0].length; j++) {
				arr[i][j] = one[i][j] * two[j][i];
			}
		}

		return one;
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
			for (int j = 1; j < len; j++) {//строки минора (j = 1 пропуск 1 строки для минора)
				for (int k = 0; k < len; k++) {//колоны минора
					if (k == i){//пропуск i столбца для минора
						continue;
					}
					ans = ans + matrix[0][i] * determinant();//а все шло так хорошо
				}
			}
		}
		
		return 0;
	}

	/**
	 * Печатает матрицу в стандартный поток вывода
	 * @param matrix - матрица
	 */
	public static void printMatrix(int[][] matrix) {
		System.out.println(matrix);
	}
}
