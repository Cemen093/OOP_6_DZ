package ua.step.homework.Task05Classes;

public class Spearman {
    int attack;
    int health;
    final int MAX_HEALTH = health;//ну вот вообще не уверен в том как это обявлять и где

    public Spearman(){

    }

    public Spearman(int _attack, int _health){
        attack = _attack;
        health = _health;
    }
    public int getAttack(){
        return attack;
    }
    public int getHealth(){
        return health;
    }
    public void takesDamage(int damage){
        health -= damage;
    }
    public int getMaxHeat(){
        return MAX_HEALTH;
    }
}
