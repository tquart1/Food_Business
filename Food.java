/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbusiness_program;

/**
 *
 * @author user
 */
public class Food {

    String typeDelicacy;
    String food;
    String numTracker;
    String fav;
    String description;
   String foodCompany;
    Food dool;
    double cost;
    Object Restu;
    String num;
    
    public Food(String td, String f, String nt, String fa, String des ) {
        typeDelicacy = td;
        food = f;
        numTracker = nt;
        fav = fa;
        description = des;
        
      
        
    }
    public String food(){
        return food;
    }
    public String numTracker(){
        return numTracker;
    }
    public String typeDelicacy(){
        return typeDelicacy;
    }
   
    public String getDescription(){
        return description;
    }

    void reserve(String cname, String cnum, String rperiodtype, String rtime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean isReserved() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
