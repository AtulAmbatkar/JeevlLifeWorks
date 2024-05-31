## Description
This project is a simple library management system implemented in Java. It allows a librarian to add and remove books, and members to issue and return books. The system also handles error conditions gracefully.

## Project Stucture
com/
└── jeevLifeWorks/
    ├── book/
    │   └── Book.java
    ├── library/
    │   ├── Librarian.java
    │   ├── Library.java
    │   ├── LibraryOperation.java
    ├── members/
    │   ├── Member.java
    │   ├── StudentMember.java
    │   ├── TeacherMember.java
    └── Main.java
    
## Compile All Java File 
javac com/jeevLifeWorks/book/Book.java
javac com/jeevLifeWorks/library/Librarian.java
javac com/jeevLifeWorks/library/Library.java
javac com/jeevLifeWorks/library/LibraryOperation.java
javac com/jeevLifeWorks/members/Member.java
javac com/jeevLifeWorks/members/StudentMember.java
javac com/jeevLifeWorks/members/TeacherMember.java
javac com/jeevLifeWorks/Main.java

## Run the Application 
javac com/jeevLifeWorks/Main.java
Here the main method to start the execution.

## Sample Output
Book added to the Library: 
Book added in Library: Book [bookId=1, bookTitle=An Uncommon Love: The Early Life of Sudha and Narayana Murthy, bookAuthor=Chitra Banerjee Divakaruni, isIssued=false]
Book added in Library: Book [bookId=2, bookTitle=Pride and Prejudice, bookAuthor=Jane Austen, isIssued=false]
Book added in Library: Book [bookId=3, bookTitle=The Idiot, bookAuthor=Fyodor Dostoyevsky, isIssued=false]
This ID is already used: 3

Book Available in the library: 
An Uncommon Love: The Early Life of Sudha and Narayana Murthy
Pride and Prejudice
The Idiot

Issuing Books to Members:
Book issued to 'Sunita madam': An Uncommon Love: The Early Life of Sudha and Narayana Murthy
Book issued to 'Atul': Pride and Prejudice
Book issued to 'Matpati sir': The Idiot
Book Not found in Library: The Book Thief

Returning books from members: 
Book returned by 'Matpati sir' : The Idiot
'Communicating with Data' is not issued 
Book returned by 'Sunita madam' : An Uncommon Love: The Early Life of Sudha and Narayana Murthy

Book Available in the library: 
The Idiot
An Uncommon Love: The Early Life of Sudha and Narayana Murthy
Book removed from Library: The Idiot
Book Not found in Library: The Idiot



