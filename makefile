default: Driver.java AdventureMap.java Room.java Book.java Bat.java Key.java
	javac Driver.java AdventureMap.java Room.java Book.java Bat.java Key.java

run: Driver.class AdventureMap.class Room.class Book.java Bat.java Key.java
	java Driver

clean:
	rm -f *.class