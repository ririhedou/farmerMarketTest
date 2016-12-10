/*
 * Created by Zhen Guo on 2016.11.03  * 
 * Copyright © 2016 Zhen Guo. All rights reserved. * 
 */
package market.mymarket.managers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Zhen
 */
// The SessionScoped annotation preserves the values of the
// instance variables accessed by some facelets pages.
@SessionScoped
@Named(value = "priceManager")

public class PriceManager implements Serializable {

    /*
    ===============================
    Instance Variables (Properties)
    ===============================
     */
    private final Map<String, Map<String, String>> pizzaPrices = new HashMap<>();

    private String pizzaSize;
    private String pizzaCrustType;
    private String pizzaCrustPrice;
    private double totalCost;
    private final double salesTax = 0.053;
    private String toppings;

    private Map<String, String> pizzaSizes;
    private Map<String, String> pizzaCrusts;
    private Map<String, String> smallPizzaPrices;
    private Map<String, String> mediumPizzaPrices;
    private Map<String, String> largePizzaPrices;

    private Map<String, String> selectedPizzaPrices;

    // Meat Toppings
    private boolean bacon;
    private boolean beef;
    private boolean chicken;
    private boolean ham;
    private boolean meatball;
    private boolean pepperoni;
    private boolean pork;
    private boolean salami;
    private boolean sausage;

    // Veggie Toppings
    private boolean bananaPeppers;
    private boolean blackOlives;
    private boolean cherryPeppers;
    private boolean greenBellPeppers;
    private boolean jalapenoPeppers;
    private boolean mushrooms;
    private boolean pineapple;
    private boolean redOnions;
    private boolean spinach;
    private boolean tomatoes;

    /*
    The PostConstruct annotation designates the init() method to be executed after
    dependency injection is done to perform any initialization. Think about it as a
    class constructor that dresses up the PriceManager class object in this init()
    method right after it is instantiated.
     */
    @PostConstruct
    public void init() {

        pizzaSizes = new HashMap<>();
        pizzaSizes.put("Small", "Small");
        pizzaSizes.put("Medium", "Medium");
        pizzaSizes.put("Large", "Large");

        pizzaCrusts = new HashMap<>();
        pizzaCrusts.put("Thin Crust", "Thin Crust");
        pizzaCrusts.put("Regular Crust", "Regular Crust");
        pizzaCrusts.put("Stuffed Crust", "Stuffed Crust");

        smallPizzaPrices = new HashMap<>();
        smallPizzaPrices.put("Thin Crust", "2.99");
        smallPizzaPrices.put("Regular Crust", "3.99");
        smallPizzaPrices.put("Stuffed Crust", "4.99");

        smallPizzaPrices.put("Bacon", "0.25");
        smallPizzaPrices.put("Beef", "0.30");
        smallPizzaPrices.put("Chicken", "0.35");
        smallPizzaPrices.put("Ham", "0.20");
        smallPizzaPrices.put("Meatball", "0.30");
        smallPizzaPrices.put("Pepperoni", "0.40");
        smallPizzaPrices.put("Pork", "0.35");
        smallPizzaPrices.put("Salami", "0.40");
        smallPizzaPrices.put("Sausage", "0.30");

        smallPizzaPrices.put("Banana Peppers", "0.35");
        smallPizzaPrices.put("Black Olives", "0.20");
        smallPizzaPrices.put("Cherry Peppers", "0.25");
        smallPizzaPrices.put("Green Bell Peppers", "0.20");
        smallPizzaPrices.put("Jalapeno Peppers", "0.30");
        smallPizzaPrices.put("Mushrooms", "0.30");
        smallPizzaPrices.put("Pineapple", "0.45");
        smallPizzaPrices.put("Red Onions", "0.30");
        smallPizzaPrices.put("Spinach", "0.20");
        smallPizzaPrices.put("Tomatoes", "0.40");

        mediumPizzaPrices = new HashMap<>();
        mediumPizzaPrices.put("Thin Crust", "3.99");
        mediumPizzaPrices.put("Regular Crust", "4.99");
        mediumPizzaPrices.put("Stuffed Crust", "5.99");

        mediumPizzaPrices.put("Bacon", "0.30");
        mediumPizzaPrices.put("Beef", "0.40");
        mediumPizzaPrices.put("Chicken", "0.40");
        mediumPizzaPrices.put("Ham", "0.25");
        mediumPizzaPrices.put("Meatball", "0.40");
        mediumPizzaPrices.put("Pepperoni", "0.50");
        mediumPizzaPrices.put("Pork", "0.40");
        mediumPizzaPrices.put("Salami", "0.45");
        mediumPizzaPrices.put("Sausage", "0.40");

        mediumPizzaPrices.put("Banana Peppers", "0.40");
        mediumPizzaPrices.put("Black Olives", "0.25");
        mediumPizzaPrices.put("Cherry Peppers", "0.30");
        mediumPizzaPrices.put("Green Bell Peppers", "0.30");
        mediumPizzaPrices.put("Jalapeno Peppers", "0.40");
        mediumPizzaPrices.put("Mushrooms", "0.35");
        mediumPizzaPrices.put("Pineapple", "0.55");
        mediumPizzaPrices.put("Red Onions", "0.35");
        mediumPizzaPrices.put("Spinach", "0.30");
        mediumPizzaPrices.put("Tomatoes", "0.50");

        largePizzaPrices = new HashMap<>();
        largePizzaPrices.put("Thin Crust", "4.99");
        largePizzaPrices.put("Regular Crust", "5.99");
        largePizzaPrices.put("Stuffed Crust", "6.99");

        largePizzaPrices.put("Bacon", "0.35");
        largePizzaPrices.put("Beef", "0.50");
        largePizzaPrices.put("Chicken", "0.45");
        largePizzaPrices.put("Ham", "0.30");
        largePizzaPrices.put("Meatball", "0.50");
        largePizzaPrices.put("Pepperoni", "0.60");
        largePizzaPrices.put("Pork", "0.45");
        largePizzaPrices.put("Salami", "0.50");
        largePizzaPrices.put("Sausage", "0.50");

        largePizzaPrices.put("Banana Peppers", "0.50");
        largePizzaPrices.put("Black Olives", "0.30");
        largePizzaPrices.put("Cherry Peppers", "0.40");
        largePizzaPrices.put("Green Bell Peppers", "0.40");
        largePizzaPrices.put("Jalapeno Peppers", "0.60");
        largePizzaPrices.put("Mushrooms", "0.40");
        largePizzaPrices.put("Pineapple", "0.65");
        largePizzaPrices.put("Red Onions", "0.40");
        largePizzaPrices.put("Spinach", "0.40");
        largePizzaPrices.put("Tomatoes", "0.60");

        pizzaPrices.put("Small", smallPizzaPrices);
        pizzaPrices.put("Medium", mediumPizzaPrices);
        pizzaPrices.put("Large", largePizzaPrices);

        setDefaultValues();
    }

    // Set some instance variables to their default values
    private void setDefaultValues() {

        toppings = "";
        selectedPizzaPrices = smallPizzaPrices;

        pizzaSize = pizzaSizes.get("Small");
        pizzaCrustType = pizzaCrusts.get("Thin Crust");
        pizzaCrustPrice = pizzaPrices.get(pizzaSize).get(pizzaCrustType);
        totalCost = Double.parseDouble(pizzaCrustPrice);
    }

    // Provide the sales tax to ConfirmOrder.xhtml
    public Double getSalesTax() {
        return salesTax;
    }

    /*
    =====================================
    Getter Methods for the Topping Prices
    =====================================
     */
    public String priceOfBacon() {
        return selectedPizzaPrices.get("Bacon");
    }

    public String priceOfBeef() {
        return selectedPizzaPrices.get("Beef");
    }

    public String priceOfChicken() {
        return selectedPizzaPrices.get("Chicken");
    }

    public String priceOfHam() {
        return selectedPizzaPrices.get("Ham");
    }

    public String priceOfMeatball() {
        return selectedPizzaPrices.get("Meatball");
    }

    public String priceOfPepperoni() {
        return selectedPizzaPrices.get("Pepperoni");
    }

    public String priceOfPork() {
        return selectedPizzaPrices.get("Pork");
    }

    public String priceOfSalami() {
        return selectedPizzaPrices.get("Salami");
    }

    public String priceOfSausage() {
        return selectedPizzaPrices.get("Sausage");
    }

    public String priceOfBananaPeppers() {
        return selectedPizzaPrices.get("Banana Peppers");
    }

    public String priceOfBlackOlives() {
        return selectedPizzaPrices.get("Black Olives");
    }

    public String priceOfCherryPeppers() {
        return selectedPizzaPrices.get("Cherry Peppers");
    }

    public String priceOfGreenBellPeppers() {
        return selectedPizzaPrices.get("Green Bell Peppers");
    }

    public String priceOfJalapenoPeppers() {
        return selectedPizzaPrices.get("Jalapeno Peppers");
    }

    public String priceOfMushrooms() {
        return selectedPizzaPrices.get("Mushrooms");
    }

    public String priceOfPineapple() {
        return selectedPizzaPrices.get("Pineapple");
    }

    public String priceOfRedOnions() {
        return selectedPizzaPrices.get("Red Onions");
    }

    public String priceOfSpinach() {
        return selectedPizzaPrices.get("Spinach");
    }

    public String priceOfTomatoes() {
        return selectedPizzaPrices.get("Tomatoes");
    }

    /*
    =================================================================
    Getter and Setter Methods for the Properties (Instance Variables)
    =================================================================
     */
    public Map<String, Map<String, String>> getPizzaPrices() {
        return pizzaPrices;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getPizzaCrustType() {
        return pizzaCrustType;
    }

    public void setPizzaCrustType(String pizzaCrustType) {
        this.pizzaCrustType = pizzaCrustType;
    }

    public String getPizzaCrustPrice() {
        return pizzaCrustPrice;
    }

    public void setPizzaCrustPrice(String pizzaCrustPrice) {
        this.pizzaCrustPrice = pizzaCrustPrice;
    }

    public Map<String, String> getPizzaSizes() {
        return pizzaSizes;
    }

    public void setPizzaSizes(Map<String, String> pizzaSizes) {
        this.pizzaSizes = pizzaSizes;
    }

    public Map<String, String> getPizzaCrusts() {
        return pizzaCrusts;
    }

    public void setPizzaCrusts(Map<String, String> pizzaCrusts) {
        this.pizzaCrusts = pizzaCrusts;
    }

    public Map<String, String> getSmallPizzaPrices() {
        return smallPizzaPrices;
    }

    public void setSmallPizzaPrices(Map<String, String> smallPizzaPrices) {
        this.smallPizzaPrices = smallPizzaPrices;
    }

    public Map<String, String> getMediumPizzaPrices() {
        return mediumPizzaPrices;
    }

    public void setMediumPizzaPrices(Map<String, String> mediumPizzaPrices) {
        this.mediumPizzaPrices = mediumPizzaPrices;
    }

    public Map<String, String> getLargePizzaPrices() {
        return largePizzaPrices;
    }

    public void setLargePizzaPrices(Map<String, String> largePizzaPrices) {
        this.largePizzaPrices = largePizzaPrices;
    }

    public Map<String, String> getSelectedPizzaPrices() {
        return selectedPizzaPrices;
    }

    public void setSelectedPizzaPrices(Map<String, String> selectedPizzaPrices) {
        this.selectedPizzaPrices = selectedPizzaPrices;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    // Reset all selected values upon clicking Clear Order
    public void clearOrder() {
        setDefaultValues();
        onSizeChange();
    }

    /*
    Upon selection of a pizza size, reset all topping check boxes to unselected
    and obtain the new values for totalCost and selectedPizzaPrices
     */
    public void onSizeChange() {

        // Unselect all Meat Toppings
        bacon = false;
        beef = false;
        chicken = false;
        ham = false;
        meatball = false;
        pepperoni = false;
        pork = false;
        salami = false;
        sausage = false;

        // Unselect all Veggie Toppings
        bananaPeppers = false;
        blackOlives = false;
        cherryPeppers = false;
        greenBellPeppers = false;
        jalapenoPeppers = false;
        mushrooms = false;
        pineapple = false;
        redOnions = false;
        spinach = false;
        tomatoes = false;

        totalCost = Double.parseDouble(pizzaCrustPrice);

        if (pizzaSize != null && !pizzaSize.equals("")) {
            selectedPizzaPrices = pizzaPrices.get(pizzaSize);
        } else {
            selectedPizzaPrices = new HashMap<>();
        }
    }

    // Upon selection of a pizza crust type, set pizzaCrustPrice
    public void onCrustChange() {

        if (pizzaCrustType != null && !pizzaCrustType.equals("")) {
            pizzaCrustPrice = pizzaPrices.get(pizzaSize).get(pizzaCrustType);
        }
    }

    /*
    ==========================================================================
    Getter and Setter Methods for the PrimeFaces Select Boolean Checkbox Items
    ==========================================================================
     */
    public boolean isBacon() {
        return bacon;
    }

    public void setBacon(boolean bacon) {
        this.bacon = bacon;
    }

    public boolean isBeef() {
        return beef;
    }

    public void setBeef(boolean beef) {
        this.beef = beef;
    }

    public boolean isChicken() {
        return chicken;
    }

    public void setChicken(boolean chicken) {
        this.chicken = chicken;
    }

    public boolean isHam() {
        return ham;
    }

    public void setHam(boolean ham) {
        this.ham = ham;
    }

    public boolean isMeatball() {
        return meatball;
    }

    public void setMeatball(boolean meatball) {
        this.meatball = meatball;
    }

    public boolean isPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
    }

    public boolean isPork() {
        return pork;
    }

    public void setPork(boolean pork) {
        this.pork = pork;
    }

    public boolean isSalami() {
        return salami;
    }

    public void setSalami(boolean salami) {
        this.salami = salami;
    }

    public boolean isSausage() {
        return sausage;
    }

    public void setSausage(boolean sausage) {
        this.sausage = sausage;
    }

    public boolean isBananaPeppers() {
        return bananaPeppers;
    }

    public void setBananaPeppers(boolean bananaPeppers) {
        this.bananaPeppers = bananaPeppers;
    }

    public boolean isBlackOlives() {
        return blackOlives;
    }

    public void setBlackOlives(boolean blackOlives) {
        this.blackOlives = blackOlives;
    }

    public boolean isCherryPeppers() {
        return cherryPeppers;
    }

    public void setCherryPeppers(boolean cherryPeppers) {
        this.cherryPeppers = cherryPeppers;
    }

    public boolean isGreenBellPeppers() {
        return greenBellPeppers;
    }

    public void setGreenBellPeppers(boolean greenBellPeppers) {
        this.greenBellPeppers = greenBellPeppers;
    }

    public boolean isJalapenoPeppers() {
        return jalapenoPeppers;
    }

    public void setJalapenoPeppers(boolean jalapenoPeppers) {
        this.jalapenoPeppers = jalapenoPeppers;
    }

    public boolean isMushrooms() {
        return mushrooms;
    }

    public void setMushrooms(boolean mushrooms) {
        this.mushrooms = mushrooms;
    }

    public boolean isPineapple() {
        return pineapple;
    }

    public void setPineapple(boolean pineapple) {
        this.pineapple = pineapple;
    }

    public boolean isRedOnions() {
        return redOnions;
    }

    public void setRedOnions(boolean redOnions) {
        this.redOnions = redOnions;
    }

    public boolean isSpinach() {
        return spinach;
    }

    public void setSpinach(boolean spinach) {
        this.spinach = spinach;
    }

    public boolean isTomatoes() {
        return tomatoes;
    }

    public void setTomatoes(boolean tomatoes) {
        this.tomatoes = tomatoes;
    }

    /*
    Update instance variable totalCost's value every time the user selects a
    topping name by clicking its check box.
     */
    public void onUserSelection() {
        totalCost = 0;

        if (pizzaCrustType.equals("Thin Crust")) {
            String crustPriceString = pizzaPrices.get(pizzaSize).get("Thin Crust");
            double crustPriceDouble = Double.parseDouble(crustPriceString);
            totalCost += crustPriceDouble;
        }

        if (pizzaCrustType.equals("Regular Crust")) {
            String crustPriceString = pizzaPrices.get(pizzaSize).get("Regular Crust");
            double crustPriceDouble = Double.parseDouble(crustPriceString);
            totalCost += crustPriceDouble;
        }
        if (pizzaCrustType.equals("Stuffed Crust")) {
            String crustPriceString = pizzaPrices.get(pizzaSize).get("Stuffed Crust");
            double crustPriceDouble = Double.parseDouble(crustPriceString);
            totalCost += crustPriceDouble;
        }

        if (bacon) {
            double toppingCost = Double.parseDouble(priceOfBacon());
            totalCost += toppingCost;
        }
        if (beef) {
            double toppingCost = Double.parseDouble(priceOfBeef());
            totalCost += toppingCost;
        }
        if (chicken) {
            double toppingCost = Double.parseDouble(priceOfChicken());
            totalCost += toppingCost;
        }
        if (ham) {
            double toppingCost = Double.parseDouble(priceOfHam());
            totalCost += toppingCost;
        }
        if (meatball) {
            double toppingCost = Double.parseDouble(priceOfMeatball());
            totalCost += toppingCost;
        }
        if (pepperoni) {
            double toppingCost = Double.parseDouble(priceOfPepperoni());
            totalCost += toppingCost;
        }
        if (pork) {
            double toppingCost = Double.parseDouble(priceOfPork());
            totalCost += toppingCost;
        }
        if (salami) {
            double toppingCost = Double.parseDouble(priceOfSalami());
            totalCost += toppingCost;
        }
        if (sausage) {
            double toppingCost = Double.parseDouble(priceOfSausage());
            totalCost += toppingCost;
        }
        if (bananaPeppers) {
            double toppingCost = Double.parseDouble(priceOfBananaPeppers());
            totalCost += toppingCost;
        }
        if (blackOlives) {
            double toppingCost = Double.parseDouble(priceOfBlackOlives());
            totalCost += toppingCost;
        }
        if (cherryPeppers) {
            double toppingCost = Double.parseDouble(priceOfCherryPeppers());
            totalCost += toppingCost;
        }
        if (greenBellPeppers) {
            double toppingCost = Double.parseDouble(priceOfGreenBellPeppers());
            totalCost += toppingCost;
        }
        if (jalapenoPeppers) {
            double toppingCost = Double.parseDouble(priceOfJalapenoPeppers());
            totalCost += toppingCost;
        }
        if (mushrooms) {
            double toppingCost = Double.parseDouble(priceOfMushrooms());
            totalCost += toppingCost;
        }
        if (pineapple) {
            double toppingCost = Double.parseDouble(priceOfPineapple());
            totalCost += toppingCost;
        }
        if (redOnions) {
            double toppingCost = Double.parseDouble(priceOfRedOnions());
            totalCost += toppingCost;
        }
        if (spinach) {
            double toppingCost = Double.parseDouble(priceOfSpinach());
            totalCost += toppingCost;
        }
        if (tomatoes) {
            double toppingCost = Double.parseDouble(priceOfTomatoes());
            totalCost += toppingCost;
        }

        // Convert totalCost to have only 2 decimal points by rounding
        // e.g., totalCost = 12.768956 --> x100 --> 1276.8956 --> Math.round --> 1277
        // totalCostRounded = 1277 --> 1277 / 100 = 12.77 = totalCost 
        double totalCostRounded = Math.round(totalCost * 100);
        totalCost = totalCostRounded / 100;
    }

    // Create a comma separated list of selected topping names
    private void createToppingsList() {
        // Empty the toppings list first
        toppings = "";
        /**
         * Meat Toppings
         */
        if (bacon) {
            toppings += "Bacon, ";
        }
        if (beef) {
            toppings += "Beef, ";
        }
        if (chicken) {
            toppings += "Chicken, ";
        }
        if (ham) {
            toppings += "Ham, ";
        }
        if (meatball) {
            toppings += "Meatball, ";
        }
        if (pepperoni) {
            toppings += "Pepperoni, ";
        }
        if (pork) {
            toppings += "Pork, ";
        }
        if (salami) {
            toppings += "Salami, ";
        }
        if (sausage) {
            toppings += "Sausage, ";
        }

        /**
         * Vegetable Toppings
         */
        if (bananaPeppers) {
            toppings += "Banana Peppers, ";
        }
        if (blackOlives) {
            toppings += "Black Olives, ";
        }
        if (cherryPeppers) {
            toppings += "Cherry Peppers, ";
        }
        if (greenBellPeppers) {
            toppings += "Green Bell Peppers, ";
        }
        if (jalapenoPeppers) {
            toppings += "Jalapeno Peppers, ";
        }
        if (mushrooms) {
            toppings += "Mushrooms, ";
        }
        if (pineapple) {
            toppings += "Pineapple, ";
        }
        if (redOnions) {
            toppings += "Red Onions, ";
        }
        if (spinach) {
            toppings += "Spinach, ";
        }
        if (tomatoes) {
            toppings += "Tomatoes, ";
        }

        // Do not include the last comma and space
        toppings = toppings.substring(0, toppings.length() - 2);
    }

    // Process the submitted pizza order
    public String orderSubmitted() {

        // Create a comma separated list of selected topping names
        createToppingsList();

        // Add sales tax to totalCost
        totalCost = totalCost + totalCost * salesTax;

        // Convert totalCost to have only 2 decimal points by rounding
        double totalCostRounded = Math.round(totalCost * 100);
        totalCost = totalCostRounded / 100;

        // Redirect to show the ConfirmOrder page
        return "ConfirmOrder?faces-redirect=true";
    }
}
