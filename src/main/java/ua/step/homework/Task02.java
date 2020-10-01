package ua.step.homework;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * В массиве хранится n явно заданных текстовых строк.
 * <p>
 * Создать методы:
 * • Возвращает содержимое массива в виде строки через пробел (join)
 * • Возвращает содержимое массива в виде строки через заданный разделитель (перегруженный join)
 * • Сортирующий массив обратном порядке (без учёта регистра) от z до a (sortDesc);
 * • Сортирующий массив по количеству слов в строке (слова разделены пробелами) (sortByWordCount).
 *
 * Примечание: Не использовать методы строк и стандартную сортировку
 */
public class Task02 {
    public static void main(String[] args) {
        // TODO: Проверяйте методы здесь
    }

    /**
     * Соединяет массив строк в одну строку разделенную пробелом
     *
     * @param strings - массив строк
     * @return строка состоящая из элементов массив
     */
    public static String join(String[] strings) {
        String s = new String();
        for (int i = 0; i < strings.length - 1; i++) {
            s += strings[i] + " ";
        }
        s += strings[strings.length - 1];
        return s;
    }

    /**
     * Соединяет массив строк в одну строку разделенную соединителем glue
     *
     * @param strings - массив строк
     * @param glue    - соединитель
     * @return строка состоящая из элементов массива
     */
    public static String join(String[] strings, String glue) {
        String s = new String();
        for (int i = 0; i < strings.length - 1; i++) {
            s += strings[i] + glue;
        }
        s += strings[strings.length - 1];
        return s;
    }

    /**
     * Сортирует массив строк в порядке обратном алфавитному
     *
     * @param strings - массив строк для сортировки
     */
    public static void sortDesc(String[] strings) {
        Arrays.sort(strings, Collections.reverseOrder());
    }

    /**
     * Сортирует массив строк по количеству слов в строке
     *
     * @param strings - массив строк для сортировки
     */
    public static void sortByWordCount(String[] strings) {
        Comparator<String> stringLengthComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length()) {
                    return 1;
                } else {
                    if (s1.length() < s2.length()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }

        };//;)
        Arrays.sort(strings, stringLengthComparator);
        for (String str : strings) {
            System.out.println(str);
        }

    }
}