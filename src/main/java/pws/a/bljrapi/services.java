/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.a.bljrapi;

/**
 *
 * @author ERDA WYNE
 */
public class services {
     public Double broto(Double price,Double quantity){
        return price*quantity;
    }
    
    public Double netto(Double price, Double quantity){
        return broto(price,quantity)-discount(price,quantity);
    }
    
    public Integer disc(Double broto){
    if (broto>15000){
        return 10;
    }
    else if(broto>1000){
        return 2;
    }
    else{
        return 0;
    }
  }
    public Double discount(Double price, Double quantity){
        return broto(price,quantity)*disc(price*quantity)/100;
    }
    public Double payment(Double price, Double quantity) {
        return broto(price,quantity)-(price*quantity);
    }
    
}
