# Individualproject-Viswamithra

Name : Viswamithra Vallabhaneni.   
Student Id: 015570516.

# Problem Statement

Created a java application that contains the inventory information in which the user is allowed to purchase products from three categories i.e Essentials, Luxury, Misc. There is a limited cap of items on the purchase from each category. If the user request is satisfied, we generate the TXT file with the total amount to be paid and the card number is used for the payment.

# Steps to run the application


# Design Patterns

* Singleton
* Factory

   * Singleton:
        * It's a creational design pattern that lets you to assure that a class only has one instance while yet offering global access to that instance.
        * Used this pattern to store the data for the entire application. Class implemented using singleton pattern is StockRepository.java.
        * An instance of the StockRepository is created and the getter methods is called in the required classes by only one instance and it can be reused.

  *  Factory Pattern:
       * Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of            objects that will be created.
       * Used this pattern by creating an interface "InputReaderFactory.java" which is implemented by "InputFileReader.java" and "CardReader.java"
       * 


Class Diagram
![image](https://user-images.githubusercontent.com/88958925/144764419-120ad5c9-6ac6-4efe-b914-ffeaaaf61c36.png)

# Screenshots of Test Cases

### Test Case 1: 
### Test Case 2:
### Test Case 3:






