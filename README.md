# OOP Workshop - Cosmetics Shop 2

## Preface

Before you start coding, read this document from top to bottom. It has some valuable information that will make your work easier.

## Description

You are given a software system for managing a cosmetics shop. There are several models - two types of products (`Shampoo` and `Toothpaste`), as well as a `Category` and a `Shopping cart`. Your task is to design an object-oriented class hierarchy to model the cosmetics shop, using the best practices for object-oriented design (OOD) and object-oriented programming (OOP). Encapsulate all fields correctly and use validation whenever needed.

## Architecture

The system already has a working `Engine` which executes a sequence of commands read from the console. It uses the classes and interfaces in your project (see the `CosmeticsEngine` class). You do not have to touch anything in it or the `main()` method, but you could try to understand how they work. 

## Models

> Note: All validation intervals are inclusive (closed).

### **ShampooImpl**

- Implements `Shampoo`.
- Each `shampoo` in the system has a `name, brand, price, gender, milliliters, and usage type`.
- `name` - the name's length should be between `3` and `10` symbols.
- Exception message: `Name should be between 3 and 10 symbols.`
- `brand` - the brand name's length should be between `2` and `10` symbols.
- Exception message: `Brand should be between 2 and 10 symbols.`
- `price` - the price cannot be negative.
- Exception message: `Price should be non negative.`
- `Gender type` can be one of `[Men, Women or Unisex]`.
- `milliliters` cannot be negative.
- Exception message: `Milliliters should be non negative.`
- `Usage type` can be `[Every_Day or Medical]`.
- Should be convertible to **String** in the format:

```none
#{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 #Milliliters: {milliliters}
 #Usage: {usageType}
 ===
```

### **ToothpasteImpl**

- Implements `Toothpaste`.
- Each `toothpaste` in the system has `name, brand, price, gender, and ingredients`.
- `name` - the name's length should be between `3` and `10` symbols.
- Exception message: `Name should be between 3 and 10 symbols.`
- `brand` - the brand name's length should be between `2` and `10` symbols.
- Exception message: `Brand should be between 2 and 10 symbols.`
- `price` - cannot be negative.
- Exception message: `Price should be non negative.`
- `Gender type` can be `[Men, Women or Unisex]`.
- Should be convertible to **String** in the format:

```none
#{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 #Ingredients: [VALUE, VALUE]
 ===
```

### **CategoryImpl**
- Has a `name` and a `list of products`.
- `name` - the name's length should be between `2` and `15` symbols.
- Exception message: `Name should be between 2 and 15 symbols.`
- Should be convertible to **String** in the format:

```none
#Category: Shampoos
#{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 #Milliliters: {milliliters}
 #Usage: {usageType}
 ===
#{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 #Milliliters: {milliliters}
 #Usage: {usageType}
 ===
#{name} {brand}
 #Price: {price}
 #Gender: {genderType}
 #Milliliters: {milliliters}
 #Usage: {usageType}
 ===
```

```none
#Category: Shampoos
 #No product in this category
```

### **ShoppingCartImpl**

- Has a `list of products`.

## CosmeticsRepositoryImpl

The `CosmeticsRepositoryImpl` class stores all the application's data. It also handles creating new objects and is used to find existing ones. Your task is implementing all methods that throw `UnsupportedOperationException()`. 

## Interfaces

- All the needed interfaces are already there. **You must use them all** to achieve the best OOP design.
- When doing the advanced task you need to **create** and use interfaces.

## Constraints

- Have a look at the example below to get a better understanding of the printing format.
- Format all floating-point values with **two digits** after the decimal point.
- All methods in the above interfaces are **mandatory** (cannot return null or empty).

## Additional notes

- Put your classes in **cosmetics.models** package.
- If you decide to create and use new classes and/or interfaces, you can do so.
- When you implement an unfinished method (one that throws `UnsupportedOperationException()`), delete the `throws new...` line.

## Unit Tests

- You are given unit tests to keep track of your progress.
- Run them by right-clicking the **tests** package and selecting **Run 'All Tests'**.
- If you get stuck, check out the tests' names to guide you on what to do.

> *Hint*: Run the unit tests whenever you finish a task.
> Note: Be careful not to change anything in the **tests** folder.

## Step by step guide

> *Note*: The project won't compile initially. First, you need to build to correct interface hierarchy.
> *Important*: See the methods in `ParsingHelpers` and `ValidationHelpers` classes and use them whenever possible!

1. Implement the classes for `Shampoo` and `Toothpaste`.

   - Implement the necessary interfaces.
   - Look at the **models.contracts** package and think about how to build a correct hierarchy.
   - Create the necessary fields and initialize them in the constructor.
   - Validate all the fields according to the constraints above.
   - Implement all necessary methods. Leave the `print()` method for later.
   - Did you notice the repeating code in the `ShampooImpl` and `ToothpasteImpl` classes (the common fields/methods)? What could you do to avoid the repetition?

2. Implement the unfinished methods in `CosmeticsRepositoryImpl`.

   - This is where the creation of the object should be.
   - Add the newly created object to the list.

3. Implement `CreateShampooCommand` and `CreateToothpasteCommand`.

   - In the `execute()` method, validate that the input parameters' count matches the expected count. Next, they should be extracted and parsed, then used to create the `Shampoo`/`Toothpaste`.

    > *Hint*: Look at `CreateCategoryCommand` if you get stuck.

4. Implement methods in `CommandFactoryImpl`.

   - This is where we connect the incoming command from the console with the class that implements that command.

5. Implement the `print()` methods.

**6. ADVANCED TASK**

- Implement the new product `Cream` and its creation in the `Engine` class.
	- Each `cream` in the system has a `name, brand, price, gender, and scent`.
	- `name` - the name's length should be between `3` and `15` symbols.
	- Exception message: `Name should be between 3 and 15 symbols.`
	- `brand` - the brand name's length should be between `3` and `15` symbols.
	- Exception message: `Brand should be between 3 and 15 symbols.`
	- `price` - is greater than zero.
	- Exception message: `Price should be non negative.`
	- `Gender type` can be `[Men, Women or Unisex]`.
	- `Scent type` can be `[Rose, Lavender or Vanilla]`.
	- Should be convertible to **String** in the format:

	```none
	#{name} {brand}
	 #Price: {price}
	 #Gender: {genderType}
	 #Scent: {scentType}
	 ===
	```
- Implement product creation in the `Factory` and the `Repository`.
  - Just look at the other products.
- Test it if it works correctly.

### Sample Input

```none
CreateShampoo MyMan Nivea 10.99 Men 1000 Every_Day
CreateToothpaste White Colgate 10.99 Men calcium,fluoride
CreateCategory Shampoos
CreateCategory Toothpastes
AddToCategory Shampoos MyMan
AddToCategory Toothpastes White
AddToShoppingCart MyMan
AddToShoppingCart White
ShowCategory Shampoos
ShowCategory Toothpastes
TotalPrice
RemoveFromCategory Shampoos MyMan
ShowCategory Shampoos
RemoveFromShoppingCart MyMan
TotalPrice
Exit
```

### Sample Output

```none
Shampoo with name MyMan was created!
Toothpaste with name White was created!
Category with name Shampoos was created!
Category with name Toothpastes was created!
Product MyMan added to category Shampoos!
Product White added to category Toothpastes!
Product MyMan was added to the shopping cart!
Product White was added to the shopping cart!
#Category: Shampoos
#MyMan Nivea
 #Price: $10.99
 #Gender: Men
 #Milliliters: 1000
 #Usage: EveryDay
 ===
#Category: Toothpastes
#White Colgate
 #Price: $10.99
 #Gender: Men
 #Ingredients: [calcium, fluoride]
 ===
$21.98 total price currently in the shopping cart.
Product MyMan removed from category Shampoos!
#Category: Shampoos
 #No product in this category
Product MyMan was removed from the shopping cart!
$10.99 total price currently in the shopping cart.
```
