# Chess Game Design

### Talking about my design and implementation, My design follows the OOP principles, clean referring to clean code principles of Uncle Bob, “Effective Java” items, and the most important one it has to follow the SOLID  principles.

## My Approach

![logo](resources/chess_class_diagram.png)

## The Pieces

### The first and the most important component of the game is the pieces, where I tend to represent the pieces with a super type class called Piece, and as I mentioned before where each piece has its own rules of moving but at the same time the pieces have similar things in common, so for the approach of isolating the business logic and extracting the behavior of moving rules I used the Strategy Pattern.

## Pieces Strategy

### First, the design ensures that the system has a high Abstraction by breaking the design down into simplified classes with easy and straightforward usage.

### Also having a high Encapsulation where the logic and details are hidden from the client and given low profile methods to use, leads to minimizing the accessibility and accessorizing it like what effective java recommended.

### And using Inheritance and Polymorphism to create and consume various types of pieces

### Each piece has its own validation mechanism to handle the validation, using the Strategy Pattern, giving the ability to use several strategies in each type of piece.

### Making my design applied to the SOLID Principles where it’s very open for extension and closed for modification and following Liskov’s to ensure the inheritance is not misused and so on with other principles.

## The Board

### The board where the pieces in the game going to set and move, it’s contained 8x8 cells, making 64 places for the piece to play.

### To separate the concerns and make a cleaner code, I made the cell class that holds the piece on the board and give a cleaner and simpler representation.

### Where its single responsibility is holding the piece by creating a holder to access the piece and know his position on the board.

### Now the vision of the board getting clearer where it contains  64 cells, But in order to make sure that I can’t have more than one board for every game, I tend to design to be a Singleton Class.

## Singleton Board

### Each game should only have one board shared throw all the system, I designed a singleton class to strict the access and give it like a global variable.

### Giving it highly abstracted and encapsulated properties, with separated methods to manipulate the pieces in cells and minimizing the accessibility, as Joshua Bloch recommended in his book.

### Okay, we have the pieces and the board to play, we know the rules to play? Right? …as I mentioned, there are also more special rules applied to the game alongside the rules for each piece.
