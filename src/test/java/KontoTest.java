/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Matthias
 */
public class KontoTest {
    private Konto konto;
    public KontoTest() {
    }

    /**
     * Test of withdraw method, of class Konto.
     */
    @org.junit.Test
    public void testWithdraw1() throws Exception {
        konto = new Konto(30);
        System.out.println("withdraw");
        int amount = 25;
        konto.withdraw(amount);
        assertEquals(5, konto.getBalance());
    }
    
    @Test
    public void testWithdraw2() throws Exception {
        konto = new Konto(30);
        System.out.println("Withdraw");
        int amount = 30;
        konto.withdraw(amount);
        assertEquals(0,konto.getBalance());
    }
    
    @Test(expected = NotEnoughMoneyException.class)
    public void testWithdraw3() throws Exception {
        konto = new Konto(30);
        System.out.println("Withdraw");
        int amount = 35;
        konto.withdraw(amount);
    }

    /**
     * Test of deposit method, of class Konto.
     */
    @org.junit.Test
    public void testDeposit() {
        konto = new Konto(30);
        System.out.println("deposit");
        int amount = 12;
        konto.deposit(amount);
        assertEquals(42, konto.getBalance());
    }

    /**
     * Test of getBalance method, of class Konto.
     */

}
