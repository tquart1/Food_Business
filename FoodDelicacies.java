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
public class FoodDelicacies {
    String foodCompany;
    String foodPaymentType;
    String oneTimePayment;
    String delicacyFavorite;
    
    public FoodDelicacies(String cFoodcomp, String cfoodPayment, String oneTime, String deliFav){
        foodCompany = cFoodcomp;
        foodPaymentType = cfoodPayment;
        oneTimePayment = oneTime;
        delicacyFavorite = deliFav;
    }
    public String getFoodcompany(){
        return foodCompany;
    }
    public String getFoodpaymentType(){
        return foodPaymentType;
    }
    public String getOneTimePayment(){
        return oneTimePayment;
    }
    public String delicacyFavorite(){
        return delicacyFavorite;
    }
    public String toString(){
        return foodCompany + foodPaymentType + delicacyFavorite;
    }
}
