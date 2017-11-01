/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbusiness_program;

import java.util.*;

/**
 *
 * @author user
 */
public class FoodBusiness_Program {

    static Food[] foods = new Food[16];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int select; // Allow user to input a number to make a selection
        boolean finished = false;

        initFood();
        
        while (!finished) {
            System.out.println();

            System.out.println("Display Food Prices ---- Selection 1");
            System.out.println("Select Food Choices ---- Selection 2");
            System.out.println("Provide A Special Request ---- Selection 3");
            System.out.println("Display Prices ---- Selection 4");
            System.out.println("Checkout ---- Selection 5");
            System.out.println("End ---- Selection 6");

            select = console.nextInt();

            try {
                switch (select) {
                    case 1:
                        displayFoodPrices();
                        break;
                    case 2:
                        displayAvailFoodPrices(console);
                        break;
                    case 3:
                        makeReservation();
                        break;
                    case 4:
                        displayFoodCompanyReservation();
                        break;
                    case 5:
                        cancelFoodCompanyReservation();
                        break;
                    case 6:
                        finished = true;

                }

            } catch (Exception e) {

            }

        }
    }

    public static void initFood() {
        foods[0] = new Greek("Greek", "Gyros", "#53", "Favored","Tomatoes, Honey_Mustard, Guac");
        foods[1] = new Greek("Greek", "Kalamari", "#12", "Not","Extra_Parmesean, Extra Sauce");
        foods[2] = new Greek("Greek", "Greek Fries and Salad", "#32", "Not","Extra_Parmesean, Extra Sauce");
        foods[3] = new Greek("Greek", "Dolmades", "#42", "Not","Extra_Parmesean, Extra Sauce");
        foods[4] = new Greek("Greek", "Shrimp and Feta", "#62", "Not","Delectable Sauce");
        foods[5] = new Italian("Greek", "Rice Risotto", "#22", "Not","Extra Spice");
        foods[6] = new Italian("Italian", "Pizza Marinara", "#22", "Not","More cheese, maybe sausage");
        foods[7] = new Italian("Italian", "Pasta Garganelli", "#22", "Not","Extra_Parmesean, Extra Sauce");
        foods[8] = new Italian("Italian", "Baccalà", "#22", "Not","Regular");
        foods[9] = new Italian("Italian", "Braciolone", "#22", "Not","Time and Efficient");
        foods[10] = new Jamaican("Jamaican", "Curry goat with rice and peas", "#122", "Not","Extra_Parmesean, Extra Sauce");
        foods[11] = new Jamaican("Jamaican", "Ackee and saltfish", "#480", "Not","Extra_Parmesean, Extra Sauce");
        foods[12] = new Jamaican("Jamaican", "Jerk Chicken", "#390", "Not","Extra_Parmesean, Extra Sauce");
        foods[13] = new Jamaican("Jamaican", "Pasta", "#220", "Not","Extra_Parmesean, Extra Sauce");
        foods[14] = new Jamaican("Jamaican", "Pasta", "#100", "Not","Extra_Parmesean, Extra Sauce");
        foods[15] = new Jamaican("Jamaican", "Pasta", "#380", "Not","Extra_Parmesean, Extra Sauce");
      
        
        
    }
    private static void displayFoodPrices() {
        // TODO Auto-generated method stub
        System.out.println("Depending upon the combination of food, prices will vary, please ask your attendant for more information");
        System.out.println("      Specialities    General Foods    Discount Customers");
        System.out.println("Italian   $15.95       $6.95        $15.95");
        System.out.println("Jamaican   $19.95        $8.95        $20.95");
        System.out.println("Greek $21.95        $10.95        $25.95");
        System.out.println();
    }

    private static void makeReservation() throws Exception {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        String cname, cnum, rperiodtype, rtime, ans;
        rtime = " ";
        String Restu = input.nextLine();
        double cost = 0.0;
        System.out.println("Enter Resturant name to reserve: ");

        String Vin = input.nextLine();
        for (int i = 0; i < 21; i++) {
            if (foods[i].Restu.equals(Restu)) {
                //make reservation
                if (foods[i].dool != null) {
                    throw new Exception("Vehicle Already Reserved Exception");
                }
                System.out.println(foods[i].getDescription());
                System.out.println("Please enter the resturant's name: ");
                cname = input.nextLine();
                System.out.println("Enter Credit Card Number (10 digits): ");
                cnum = input.nextLine();
                if (cnum.length() != 10) {
                    throw new Exception("Invalid Credit Card Exception");
                }
                System.out.println("(1) Daily (2) Weekly (3) Monthly");
                rperiodtype = input.nextLine();
                if (rperiodtype.equals("1")) {
                    System.out.println("How many days?");
                    rtime = input.nextLine();
                } else if (rperiodtype.equals("2")) {
                    System.out.println("How many weeks?");
                    rtime = input.nextLine();
                } else if (rperiodtype.equals("3")) {
                    System.out.println("How many months?");
                    rtime = input.nextLine();
                }
                System.out.println("Do you want to add the optional reserved space for your specific resturant at $7.95 per day? (y/n)");
                ans = input.next();

                int rtime2 = Integer.parseInt(rtime); //casts rtime string to int
                double rtime3 = (double) rtime2;  //casts rtime int to double

                if (ans.equals("y"))//adds insurance to cost
                {
                    if (rperiodtype.equals("1")) {
                        foods[i].cost += 7.95 * rtime3;//days
                    } else if (rperiodtype.equals("2")) {
                        foods[i].cost += 7.95 * rtime3 * 7;//weeks
                    } else if (rperiodtype.equals("3")) {
                        foods[i].cost += 7.95 * rtime3 * 30;//months
                    }
                }

                if (foods[i] instanceof Food)//adds cost of car
                {

                    if (rperiodtype.equals("1")) {
                        foods[i].cost = rtime3 * 24.95;
                    }
                    if (rperiodtype.equals("2")) {
                        foods[i].cost = rtime3 * 149.95;
                    }
                    if (rperiodtype.equals("3")) {
                        foods[i].cost = rtime3 * 514.95;
                    }
                } else if (foods[i] instanceof Jamaican)//adds cost of SUV
                {
                    if (rperiodtype.equals("1")) {
                        foods[i].cost = rtime3 * 29.95;
                    }
                    if (rperiodtype.equals("2")) {
                        foods[i].cost = rtime3 * 189.95;
                    }
                    if (rperiodtype.equals("3")) {
                        foods[i].cost = rtime3 * 679.95;
                    }
                } else if (foods[i] instanceof Italian)//adds cost of Truck
                {
                    if (rperiodtype.equals("1")) {
                        foods[i].cost = rtime3 * 34.95;
                    }
                    if (rperiodtype.equals("2")) {
                        foods[i].cost = rtime3 * 224.95;
                    }
                    if (rperiodtype.equals("3")) {
                        foods[i].cost = rtime3 * 797.95;
                    }
                }
                foods[i].reserve(cname, cnum, rperiodtype, rtime);
                System.out.println("Reservation made for " + foods[i].getDescription() + " for $" + foods[i].cost);
                return;
            }

        }
        throw new Exception("VINNotFound");
    }

    private static void cancelFoodCompanyReservation() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter Resturant/Food Company: ");
        String cname = console.nextLine();
        String foodie[] = new String[16];
        int foodie_2[] = new int[16];
        int f = 0;
        for (int i = 0; i < 21; i++) {
            if (foods[i].dool != null) {
                if (cname.equals(foods[i].dool.foodCompany)) {
                    foodie[f] = foods[i].description;
                    foodie_2[f] = i;
                    f++;
                }
            }
        }
        for (int j = 0; j < 21; j++) {
            if (foodie[j] != null) {
                System.out.println((j + 1) + " " + foodie[j]);
            }
        }
        System.out.println("Enter the number of reservations you wish to cancel: ");
        int cancel = console.nextInt();

        System.out.println("reservation cancelled");

    }

    

  public static void displayAvailFoodPrices(Scanner console)
     {
    	 System.out.println("Enter Jamaican (1), Italian (2), or Greek (3)");
    	 int f = console.nextInt();
    	 int i = 0;
         
         while (foods[i] != null)
         {
             if (!foods[i].isReserved() && foods[i] instanceof Jamaican && f==1)
                System.out.println(foods[i].getDescription()+" "+foods[i].fav +" "+foods[i].num+" "+foods[i].Restu);
             if (!foods[i].isReserved() && foods[i] instanceof Italian && f==2)
            	 System.out.println(foods[i].getDescription()+" "+foods[i].fav +" "+foods[i].num+" "+foods[i].Restu);
             if (!foods[i].isReserved() && foods[i] instanceof Greek && f==3)
            	 System.out.println(foods[i].getDescription()+" "+ foods[i].fav +" "+foods[i].num+" "+foods[i].Restu);
 	                               
	     i = i + 1;
         }
     }
    private static void displayFoodCompanyReservation() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter the Resturant/Company: ");
        String cname = console.nextLine();
        String[] array = new String[16];
        for (int i = 0; i < 16; i++) {
            if (foods[i].dool != null) {
                if (cname.equals(foods[i].dool.foodCompany)) {
                    System.out.println(foods[i].description);
                }
            }
        }
    }

    private void checkout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
