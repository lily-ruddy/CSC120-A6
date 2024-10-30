/* Resources */
// https://docs.oracle.com/javase/8/docs/api/index.html?java/util/Hashtable.html

import java.util.Hashtable;

public class Library extends Building{

  // Attribute:
  private Hashtable<String, Boolean> collection;
  
  // Costructor:
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
  
  public static void main(String[] args) {
    Library neilson = new Library("Neilson Library", "7 Neilson Drive", 5);
    System.out.println(neilson);

    /* Collections */
    neilson.addTitle("Green Eggs and Ham by Dr. Seuss"); // adding book
    System.out.println(neilson.collection);
    neilson.removeTitle("Green Eggs and Ham by Dr. Seuss"); // removing book
    System.out.println(neilson.collection);
    neilson.removeTitle("Green Eggs and Ham by Dr. Seuss"); // RuntimeException
    
    
  }
  
}