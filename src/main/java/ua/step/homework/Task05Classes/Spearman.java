package ua.step.homework.Task05Classes;

public class Spearman {
    int attack;
    int health;
    int maxHealth;
    //как бы MAX_HEALTH константой сделать? и где?

    public Spearman(){

    }

    public Spearman(int _attack, int _health){
        attack = _attack;
        health = _health;
        maxHealth = health;//ну вот вообще не уверен в том как это обявлять и где
    }
    public int getAttack(){
        return attack;
    }
    public int getHealth(){
        return health;
    }
    public int getMaxHeat(){
        return maxHealth;
    }
    public void takesDamage(int damage){
        if (damage <= health){
        health -= damage;
        }
        else{
            health = 0;
        }
    }
    public int takingDamageAndReturningRest(int damage){
        if (health < damage){
            int tmp = health;
            health = 0;
            return damage - tmp;}
        else{
            health -= damage;
            return 0;
        }
    }
}
