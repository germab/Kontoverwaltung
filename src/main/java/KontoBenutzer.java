
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthias
 */
public class KontoBenutzer implements Runnable{

    private String name;
    private KontoGUI gui;
    private Konto konto;

    public KontoBenutzer(String name, KontoGUI gui) {
        this.name = name;
        this.gui = gui;
    }

    @Override
    public void run() {
        
        konto = gui.getCurrent();
        Random randy = new Random();
        int amount;
        synchronized(konto){
            for(int i=0;i<10;i++){
            
                if(i%2==0){
                    amount = randy.nextInt(50-10+1)+10;
                    if(konto.getBalance()>amount){
                        try {
                            konto.withdraw(amount);
                            gui.setBalance(konto.getBalance());
                            gui.addLog(name+" has withdrawn "+amount);
                            gui.repaint();
                            konto.notifyAll();
                        } catch (NotEnoughMoneyException ex) {
                            try {
                                konto.wait();
                            } catch (InterruptedException ex1) {
                                Logger.getLogger(KontoBenutzer.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                            
                        }
                        
                    }
                    
                }
                else{
                    amount = randy.nextInt(50-10+1)+10;
                    konto.deposit(amount);
                    gui.setBalance(konto.getBalance());
                    gui.addLog(name+" has deposited "+amount);
                    gui.repaint();
                    konto.notifyAll();
                }
                int waitTime = randy.nextInt(1000-1+1)+1;
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException ex) {
                    Logger.getLogger(KontoBenutzer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            gui.addLog(name+" has finished");
        }
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
