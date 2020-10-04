package ua.step.homework;


import ua.step.homework.Task05Classes.Detachment;
import ua.step.homework.Task05Classes.Dragon;
import ua.step.homework.Task05Classes.Interface;
import ua.step.homework.Task05Classes.Spearman;

import static ua.step.homework.Task05Classes.Interface.*;

/**
 * В этом задании нет заготовленных методов.
 * Продумайте их самостоятельно.
 *
 * Королю нужно убить дракона, но в его казне мало средств
 * для покупки армии. Нужно создать программу, используя
 * методы, которая поможет рассчитать минимальное ко-
 * личество копейщиков, которое необходимо, чтобы убить
 * дракона. C клавиатуры вводятся данные:
 * - здоровья дракона;
 * - атаки дракона;
 * - здоровье одного копейщика;
 * - атака одного копейщика.
 * Защита, меткость и т. п. не учитывать. Копейщики наносят
 * удар первыми (общий нанесенный урон – это сумма атак
 * всех живых копейщиков). Если атака дракона превышает
 * значение жизни копейщика (например, у копейщика жиз-
 * ни – 10, а атака – 15), то умирает несколько копейщиков, а
 * оставшийся урон идет одному из копейщиков.
 *
 * Например, жизнь дракона – 500, атака – 55, жизнь одно-
 * го копейщика – 10, атака –10, а количество копейщиков при
 * данных условиях – 20.
 * Лог боя для данного примера должен выглядеть так:
 *
 * Итерация 15
 * Копейщики атакуют (урон 200) – у дракона осталось 300 жизней
 * Дракон атакует – осталось 15 копейщиков, один из которых ранен
 * (осталось 5 жизней)
 * Копейщики атакуют – у дракона осталось 150 жизней
 * Дракон атакует – осталось 9 копейщиков
 * Копейщики атакуют – у дракона осталось 60 жизней
 * Дракон атакует – осталось 4 копейщика, один из которых ранен
 * (осталось 5 жизней)
 * Копейщики атакуют – у дракона осталось 20 жизней
 * Дракон атакует и побеждает
 *
 *
 */
public class Task05 {
	public static void main(String[] args) {
		//Вы обещали коментарии!!!

		//ввод данных
		int dragonHealth = Input("Здоровье дракона >> ", 1);
		int dragonAttacks = Input("Атака дракона >> ", 1);
		int oneSpearmanHealth = Input("Здоровье одного копейщика >> ", 1);
		int oneSpearmanAttack = Input("Атака одного копейщика >> ", 1);

		//цикл нахождения мин копейшиков для победы
		int i = 1;
		int win = 0;//-1 победа дракона, 1 победа копейщиков
		do {
			boolean attackingSide = true;//true атакуют копейщики
			//Итерация X
			Interface.iteration(i);
			//создадим объекты
			Dragon dragon = new Dragon(dragonAttacks, dragonHealth);
			Detachment detachment = new Detachment(oneSpearmanAttack, oneSpearmanHealth, i);

			//цикл боя
			do {

				//симуляция боя
				//выбор атакующей стороны
				if (attackingSide){
					//атака копейщиков
					dragon.takesDamage(detachment.getAttack());
					//проверка на выживание
					if (!dragon.returnTrueIfLive()){
						win = 1;
						break;
					}
					//вывод сообщения
					Interface.outputSpearmanAttack(detachment.getAttack(), dragon.getHealth());
					//передача хода
					attackingSide = false;
				}
				else{
					//атака дракона
					detachment.takesDamage(dragon.getAttask());
					//проверка на выживание
					if (!detachment.returnTrueIfLive()){
						win = -1;
						break;
					}
					//вывод сообщения
					Interface.outputDragonAttacks(dragon.getAttask(), detachment.getNumbers(), detachment.getHealthLastOrZeroIfNot());
					//передача хода
					attackingSide = true;
				}
			} while (win == 0);//Warning:(101, 13) Condition 'win == 0' is always 'true' ?? всм?
			//сообщение о победе
			if (win == 1){Interface.outputVictorySpearman();}
			else{Interface.outputVictoryDragon();}

			if (win == 1){break;}//победа копейщиков
			attackingSide = true;//Warning:(107, 4) The value true assigned to 'attackingSide' is never used, ну тут как бы цикл нет?
			win = 0;//востанавливаем значение
			i++;//итерация и кол копейщиков + 1
		} while (win != 1);//Warning:(110, 12) Condition 'win != 1' is always 'true' чего он злой такой? как это надо было написать?
	}
}
