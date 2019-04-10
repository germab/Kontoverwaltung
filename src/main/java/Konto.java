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
    
    public synchronized void withdraw(int amount)throws NotEnoughMoneyException{
        if(balance>=amount)
            balance-=amount;
        else
            throw new NotEnoughMoneyException();
    }
    
    public synchronized void deposit(int amount){
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
    
    
    
}
