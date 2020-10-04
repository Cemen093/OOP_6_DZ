package ua.step.homework.Task05Classes;

import java.util.Arrays;

public class Detachment {
    int numbers;//зря я тут number так использую, надо было тольео при иниицилизации, а потом брать из массива
    Spearman[] spearmen;

    public Detachment(){

    }

    public Detachment(int _oneSpearmanAttack, int _oneSpearmanHealth, int _numbers){
        numbers = _numbers;
        spearmen = new Spearman[numbers];
        for (int i = 0; i < numbers; i++) {
            spearmen[i] = new Spearman(_oneSpearmanAttack, _oneSpearmanHealth);
        }
    }
    public int getNumbers(){
        return numbers;
    }
    public int getAttack(){
        return (spearmen[0].getAttack() * numbers);
    }
    public int getHealthLastOrZeroIfNot(){
        if (numbers > 0){
            if (spearmen[numbers - 1].getHealth() != spearmen[0].maxHealth) {//Клятая ; как она тут вообще оказалась?
                return spearmen[numbers - 1].getHealth();
            }
            else{return 0;}
        }
        else{
            return 0;
        }
    }
    public void takesDamage(int damage){
        do {
            damage = spearmen[numbers - 1].takingDamageAndReturningRest(damage);
            if (spearmen[numbers - 1].getHealth() == 0){removingSpearman(1);}
        }while(!(damage == 0 || numbers == 0));
    }
    /*
    public void takesDamage(int damage){
        if (this.getTruthIfWounded()) {
            //отнимаем здоровье у раненого
            if (this.getHealthWounded() <= damage) {
                //первый раненый
                damage -= spearmen[numbers - 1].getHealth();
                removingSpearman(1);
                numbers--;
            } else {
                spearmen[numbers - 1].takesDamage(damage);
                return;
            }
        }
        //ранения целиком
        int col = damage / spearmen[0].getMaxHeat();
        if (col <= numbers) {
            removingSpearman(col);
            damage %= spearmen[0].getMaxHeat();
            numbers -= col;
        }
        else {
            removingSpearman(numbers);
            numbers = 0;
            return;
        }

        //последний раненый
        spearmen[numbers - 1].takesDamage(damage);
    }
    */
    public void removingSpearman(int _numbers){
        if (_numbers < numbers) {
            spearmen = Arrays.copyOf(spearmen, numbers - _numbers);
            //А можно сразу переопределить ссылку без темп?
            //что произойдет при выделении памяти под массив длиной в 0 элементов?
            numbers -= _numbers;
        }
        else {
            numbers = 0;//Функции не работают при numbers 0; как это провильно оформить?
            spearmen = Arrays.copyOf(spearmen, 1);
        }
    }
    public boolean returnTrueIfLive(){
        if (numbers > 0){//Warning:(87, 9) 'if' statement can be simplified как его упростить??
            return true;
        }
        else {
            return false;
        }
    }
}
