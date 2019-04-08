
import java.util.ArrayList;

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

    private ArrayList<Konto> konten = new ArrayList();
    private String name;

    public KontoBenutzer(String name) {
        this.name = name;
    }
    
    public void addKonto(Konto k){
        konten.add(k);
    }
    
    @Override
    public void run() {
        
    }
    
}
