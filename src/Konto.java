/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthias
 */
public class Konto{

    private int balance;

    public Konto(int balance) {
        this.balance = balance;
    }
    
    public synchronized int withdraw(int amount)throws Exception{
        if(balance-amount>=0){
            balance-=amount;
            return balance;
        }
        else
            throw new Exception("Nicht genug Geld auf dem Konto!");
    }
    
    public synchronized int deposit(int amount){
        balance += amount;
        return balance;
    }
    
}
