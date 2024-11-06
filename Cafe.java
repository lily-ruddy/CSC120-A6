public class Cafe extends Building{

    // Attributes:
    private int nCoffeeOunces; 
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups; 

    // Constructor:
    /**
     * Creates Cafe class. 
     * @param name; Name of the cafe   
     * @param address; Address of the cafe
     * @param nFloors; Number of floors of the cafe
     * @param nCoffeeOunces; Number of ounces of coffee remaining in inventory
     * @param nSugarPackets; Number of sugar packets remaining in inventory
     * @param nCreams; Number of "splashes" of cream remaining in inventory
     * @param nCups; Number of cups remaining in inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    // Getters: 
    /**
     * Getter for the ounces of coffee at the cafe.
     * @return int nCoffeeOunces; Number of ounces left in the inventory
     */
    public int getNCoffeeOunces(){
        return this.nCoffeeOunces;
    }

    /**
     * Getter for the number of sugar packets at the cafe.
     * @return int nSugarPackets; Number of sugar packets in inventory
     */
    public int getNSugarPackets(){
        return this.nSugarPackets;
    }

    /**
     * Getter for the number of creams at the cafe.
     * @return int nCreams; Number of creams in the inventory
     */
    public int getNCreams(){
        return this.nCreams;
    }

    /**
     * Getter for the number of cups at the cafe. 
     * @return nCups; Number of cups in the inventory
     */
    public int getNCups(){
        return this.nCups;
    }

    // Methods:
    /**
     * Sells a coffee at the cafe. Subtracts the items from the inventory. 
     * @param int size; Number of ounces the coffee is
     * @param int nSugarPackets; Number of sugar packets in the coffee
     * @param int nCreams; Number of splashes of creams in the coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        /* Checks to see if there are enough cups */
        if(nCups>0 & size <= this.nCoffeeOunces & nSugarPackets <= this.nSugarPackets & nCreams <= this.nCreams){
            System.out.println("** Making coffee **");
            this.nCups = this.nCups -1; // subtracts one cup
            this.nCoffeeOunces = this.nCoffeeOunces - size; // subtracts the coffee ounces
            this.nSugarPackets = this.nSugarPackets - nSugarPackets; // subtracts the sugar packets
            this.nCreams = this.nCreams - nCreams; // subtracts the creams 

        } else{
            throw new RuntimeException("There isn't enough inventory at "+ this.name +" to make the coffee. Please restock.");
        }
    }


    
    public static void main(String[] args) {
        /* Creating cafe */
        System.out.println("-----------------------------------------------------");
        Cafe campusCafe = new Cafe("Campus Center Cafe", "Smith College Campus Center 100 Elm St",3, 100, 45 , 45, 15);
        System.out.println(campusCafe);

        /* Selling coffee */
        System.out.println("-----------------------------------------------------");
        campusCafe.sellCoffee(10, 3, 2);
        
    }
    
}
