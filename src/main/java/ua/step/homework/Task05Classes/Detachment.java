package ua.step.homework.Task05Classes;

import java.util.Arrays;

public class Detachment {
    int numbers;//зря я тут number так использую, надо было тольео при иниицилизации, а потом брать из массива
    Spearman[] spearmen;

    public Detachment(){

    }

    public Detachment(int _numbers){
        numbers = _numbers;
        spearmen = new Spearman[numbers];
    }
    public int getNumbers(){
        return numbers;
    }
    public int getAttack(){
        return spearmen[0].getAttack() * numbers;
    }
    public boolean getTruthIfWounded(){
        if (spearmen[numbers - 1].getHealth() != spearmen[0].getMaxHeat()){
            return true;
        }
        else{
            return false;
        }
    }
    public int getHealthWounded(){
        return spearmen[numbers - 1].getHealth();
    }
    public void takesDamage(int damage){
        if (this.getTruthIfWounded()){
            //отнимаем здоровье у раненого
            if (this.getHealthWounded() <= damage){
                //первый раненый
                damage -= spearmen[numbers - 1].getHealth();
                removingSpearman(1);
                numbers--;
            }
            else{
                spearmen[numbers - 1].takesDamage(damage);
                return;
            }
            //ранения целиком
            int col = damage / spearmen[0].getMaxHeat();
            if (col > numbers) {
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
            return;
        }

    }
    public void removingSpearman(int _numbers){
        if (_numbers <= numbers) {
            spearmen = Arrays.copyOf(spearmen, numbers - _numbers);
            //А можно сразу переопределить ссылку без темп?
            //что произойдет при выделении помяти под массив длиной в 0 элементов?
            numbers -= _numbers;
        }
        else {
            removingSpearman(numbers);
        }
    }
    public boolean returnTrueIfLive(){
        if (numbers > 0){
            return true;
        }
        else {
            return false;
        }
    }
}
