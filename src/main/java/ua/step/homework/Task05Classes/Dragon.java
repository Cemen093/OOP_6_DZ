package ua.step.homework.Task05Classes;

public class Dragon {
    int attack;
    int health;

    public Dragon(){

    }
    public Dragon(int _attack, int _health){
        attack = _attack;
        health = _health;
    }
    public int getAttask(){
        return attack;
    }
    public int getHealth(){
        return health;
    }
    public void takesDamage(int damage){
        if (health > damage) {
            health -= damage;
        }
        else{
            health = 0;
        }
    }
    public boolean returnTrueIfLive(){
        if (health > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
