package ua.step.homework;

/**
 * Палиндром — это последовательность символов, которая слева-направо и
 * справа-налево пишется одинаково. Например «АБА» или «АББ ББА». Дана
 * последовательность символов. Метод makePalindrome() должен преобразовать
 * строку удалив минимальное количество символов из строки,
 * чтобы получить палиндром.
 * Длина последовательности не больше 20 символов, вводится с клавиатуры.
 * <p>
 * Алгоритм решения данной задачи <a href='https://ru.wikibooks.org/wiki/%D0%A0%D0%B5%D0%BA%D1%83%D1%80%D1%81%D0%B8%D1%8F#%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0_%C2%AB%D0%A1%D0%B4%D0%B5%D0%BB%D0%B0%D0%B9_%D0%BF%D0%B0%D0%BB%D0%B8%D0%BD%D0%B4%D1%80%D0%BE%D0%BC%C2%BB'>Задача «Сделай палиндром»</>
 */
public class Task03 {
    public static void main(String[] args) {
        //String word = "AADDAFD";
        String word = "AADDAFD";
        String result = makePalindrome(word);
        System.out.println("result = " + result);
    }

    /**
     * Рекурсивный метод превращающий входную строку в палиндром
     * @param word - входная строка - не палиндром
     * @return палиндром
     */
    public static String makePalindrome(String word) {
        //этот метод не подходит для рекупсивной функции, создадим свой
        //кстати говоря указаный алгоритм не полностью подходит к этой задаче
        int min = minNumberOfCharForPal(word);//круто конечно, но нашу задачу это не решает.

        return word;//заглушка
    }
    public static int minNumberOfCharForPal(String word){
        //Если строка имеет вид hst где h и t символы, а s  — подстрока, возможно пустая
        //вот тут я не понял, нам надо созвавать новые строки или индекс смещать?
        if (word.length() < 2){
            return 0;
        }
        String h = word.substring(0, 1);
        String t = word.substring(word.length() - 1);
        String s = word.substring(1, word.length() - 1);
        int min;
        if (h.equals(t)){
            min = minNumberOfCharForPal(s);
        }
        else {
            int a = minNumberOfCharForPal(s + t) + 1;
            int b = minNumberOfCharForPal(h + s) + 1;
            int c = minNumberOfCharForPal(s) + 2;
            min = Math.min(a, Math.min(b,c));
        }
        //вот последний абзац алгоритма вообще не понятен, откуда взялись i,j если мы говорили про строки?
        //от куда взялся двумерный массив если наша функция его не принимает и не возвращает?
        //как записывать результаты в массив если у нас нет i, j?
        return min;
    }
}
