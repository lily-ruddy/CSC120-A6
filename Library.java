/* Resources */
// https://docs.oracle.com/javase/8/docs/api/index.html?java/util/Hashtable.html

import java.util.Hashtable;

public class Library extends Building{

  // Attribute:
  private Hashtable<String, Boolean> collection;
  
  // Costructor:
  /**
   * Constructor for Library class.
   * @param name; Name of the library.
   * @param address; Address of the library.
   * @param nFloors; Number of floors of the library. Must be greater than equal to 1.
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors); // extends Building
    System.out.println("You have built a library: 📖");
    this.collection = new Hashtable<String, Boolean>();
  }

  // Methods:
  /**
   * Adds the book into the library.
   * @param title; Name of the added book
   */
  public void addTitle(String title){
    this.collection.put(title, true);
    System.out.println(title + " is now in the " + this.name);
  }

  /**
   * Removes the book from the library. 
   * @param title; Name of the book
   * @return title; Name of the removed book
   */
  public String removeTitle(String title){
    /* Check if the title is in the collection */
    if(this.collection.containsKey(title)){
      System.out.println(title + "is no longer in the " + this.name);
      this.collection.remove(title);
      return title;

    } else{
      throw new RuntimeException(title + " isn't in the " + this.name + ". Please give another title.");
    }
  }

  /**
   * Checks out the book from the library. Changes its availability to false.
   * @param title; Name of the checked out book
   */
  public void checkOut(String title){
    /* Check if the title is in the collection */
      if(this.collection.containsKey(title)== false){
        throw new RuntimeException(title + " isn't in the " + this.name + ". Please give another title."); // not in the library
        
        /* Checks to see if the title is already checked out */
      } else{
        if (this.collection.get(title) == false ) {
          throw new RuntimeException("Sorry " + title + " is already checked out."); // already checked out
          
        } else { 
          this.collection.replace(title, true, false);
          System.out.println(title + " is now checked out of the " + this.name);
        }
      }
    }

    /**
     * Returns the title to the library. Changes its availabilty to true. 
     * @param title; Name of the book that is being returned. 
     */
    public void returnBook(String title){
      /* Check if the title is in the collection */
        if(this.collection.containsKey(title)== false){
          throw new RuntimeException(title + " isn't in the " + this.name + ". Please give another title."); // not in the library
          
          /* Checks to see if the title is already checked out */
        } else{
          if (this.collection.get(title) == true ) {
            throw new RuntimeException(title + " is already in " + this.name + "This title isn't the property of " +this.name); // not from library
            
          } else { 
            this.collection.replace(title, false, true);
            System.out.println(title + " is now checked back in to the " + this.name);
          }
        }
      }
    
  
  public static void main(String[] args) {
    /* Creating Library */
    System.out.println("-----------------------------------------------------");
    Library neilson = new Library("Neilson Library", "7 Neilson Drive", 5);
    System.out.println(neilson);

    /* Adding & Removing */
    System.out.println("-----------------------------------------------------");
    neilson.addTitle("Green Eggs and Ham by Dr. Seuss"); // adding book
    System.out.println(neilson.collection);
    neilson.removeTitle("Green Eggs and Ham by Dr. Seuss"); // removing book

    /* Check In & Out */
    System.out.println("-----------------------------------------------------");
    neilson.addTitle("Goodnight Moon by Margaret Wise Brown"); // adding book
    neilson.checkOut("Goodnight Moon by Margaret Wise Brown"); // checking out book
    neilson.returnBook("Goodnight Moon by Margaret Wise Brown"); // returning book

    
  }
}
