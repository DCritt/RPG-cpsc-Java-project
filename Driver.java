import java.util.HashMap;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Driver
{
    public static void main(String[] args)
    {
        //initialize scanner
        Scanner scnr = new Scanner(System.in);

        //current room variables
        String door = "";
        String item = "";
        String input1 = "goto";
        String input2 = "";
        String location = "Shore";
        String newLocation = "Shore";
        String fileName = "Title_Screen";
        FileOutputStream fileStream = null;
        try {
            fileStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e){

        }
        PrintWriter outFS = new PrintWriter(fileStream);

        //create adMap and room objects
        AdventureMap adMap = new AdventureMap();
        Room room;

        //creates shore location, its descriptions, and exits
        room = new Room("Shore", "You wake up on the shore of a river confused. Then you remember that you spent the night at Big Ev's house last night. He must have thrown you into the river and left you for dead:(. ITS TIME FOR REVENGE!!!", "The shore is calm and peaceful... now go up the hill and beat Big Ev!");
        room.addExit("Hill");
        adMap.addRoom(room);

        //creates Hill location, its descriptions and exits
        room = new Room("Hill", "You make the long walk up the hill from the shore. Ahead you see two paths, one leads to an unknown house, the other leads to Big Ev's house.", "The hill gives you two paths... I only give you one! go get Big Ev!!!");
        room.addExit("Unknown_Path");
        room.addExit("Ev's_Path");
        room.addExit("Shore");
        adMap.addRoom(room);

        //creates Unknown_Path location, its descriptions and exits. It also creates a book object and stores its writing.
        room = new Room("Unknown_Path", "You take the path in search of supplies to take down Big EV. There is a book on the side of the path labeled BEJouranl... for Big Ev!", "This path is beautiful and sunny! Unlike Big Ev's future when you have your revenge!!!");
        room.addExit("Hill");
        room.addExit("Big_Brady's");
        Book BEJournal = new Book("BEJournal", "Log 69420: Today I have a guest staying over, i'm going to lure him into a false since of security and while he is sleeping throw him in the\nriver!!! In case he survives im going to hide the only other key to my house in Big Brady's house down the Unkown_Path so that Big Brady can use it to check on me.\n -Big Ev\nI told you Big Ev threw you in the river!!!");
        room.addBook(BEJournal);
        adMap.addRoom(room);
        
        //creates Big_Brady's house location, its descriptions and exits
        room = new Room("Big_Brady's", "You make the long walk down the Unknown_Path to find the house of... Big... Brady!!! Will he be and ally or a foe!!!", "This is Big Brady's house, now go beat BIG EV!!!");
        room.addExit("Unknown_Path");
        adMap.addRoom(room);

        //creates Entrance location, its descriptions and exits
        room = new Room("Entrance", "You enter Big Brady's house... which is somehow unlocked... its quiet... too quiet...", "This is the entrance to Big Brady's house... now leave and beat up Big Ev!!!");
        room.addExit("Kitchen");
        room.addExit("Big_Brady's");
        adMap.addRoom(room);

        //creates Kitchen location, its descriptions and exits
        room = new Room("Kitchen", "You enter Big Brady's kitchen, it looks very well kept. You hear talking from what sounds like a tv in the living room... you should check it out.", "This is Big Brady's kitchen... now go beat up Big Ev!!!");
        room.addExit("Living_Room");
        room.addExit("Entrance");
        adMap.addRoom(room);

        //creates Living_Room location, its descriptions and exits. Also creates a bat object and stores its name
        room = new Room("Living_Room", "You walk into the living room to find Big Brady sitting down with a bat watching tv. He tells you he has been expecting you, he says that Big Ev always steals his glory and he wants you to take him down! He offers you the bat and tells you to go down the stairwell and get the keys to Big Ev's.", "This is the living room where Big Brady is sitting, he says hurry up and go beat Big Ev!!!");
        room.addExit("Stairwell");
        room.addExit("Kitchen");
        Bat bigBradysBat = new Bat("BigBrady'sBat");
        room.addBat(bigBradysBat);
        adMap.addRoom(room);

        //creates Stairwell location, its descriptions and exits
        room = new Room("Stairwell", "You carefully walk down the stairwell leading down to the basement which Big Brady said the key was in. The floor boards whine and creak as you slowly\nmake your way down.", "This is Big Brady's stairwell leading to his basement... maybe you should throw Big Ev down these stairs when you knock him out!!!");
        room.addExit("Living_Room");
        room.addExit("Basement");
        adMap.addRoom(room);

        //creates Basement location, its descriptions and exits. Also creates a key object and stores its name.
        room = new Room("Basement", "You finally make your way into the basement... its dark and muggy. You hear the sound of buzzing fluorescent lights. You think to yourself, all I have to do is find this key and get out of this weird Big Brady dungeon. You spot the key sitting on an open storage shelf", "This is Big Brady's basement... I wonder if he traps people down here? Now go get Big Ev!!!");
        room.addExit("Stairwell");
        Key BigEvsKey = new Key("BigEv'sKey");
        room.addKey(BigEvsKey);
        adMap.addRoom(room);

        //creates Ev's_Path location, its descriptions and exits
        room = new Room("Ev's_Path", "You make your way down Ev's Path in search of vengence for all that Big Ev has done to you!!! Show him what you are made of!!!", "This is the path leads to Big Ev's place... the place where Big Ev will pay!!!");
        room.addExit("Hill");
        room.addExit("Big_Ev's");
        adMap.addRoom(room);

        //creates Big_Ev's house location, its descriptions and exits
        room = new Room("Big_Ev's", "You arrive in front of Big Ev's house ready to have your revenge!!! You walk up to the door and jiggle the handle... its locked. You will need to use a key.", "This is the front of Big Ev's house!!! Use a key to open the door and finally beat Big Ev!!!");
        room.addExit("Ev's_Path");
        adMap.addRoom(room);

        //creates Inside Big Ev's house location, its descriptions and exits
        room = new Room("Inside", "You have finally done it! you are inside of Big Ev's house... And there he is... staring at you... ready... to... fight. He yells, I thought you were dead!!! You yell back explaining that you washed up and are ready for revenge!!!", "");
        adMap.addRoom(room);

        //prints short description of game in other file
        outFS.println("Revenge RPG Project");
        outFS.print("\nIn this RPG you will navigate a premade map which contains different items and people to interact with. The goal of the game is to get revenge on Big Ev.");
        outFS.close();

        //prints introduction
        System.out.println("\nWelcome to Revenge, in this game you wash up on the shore and need to find a way to get your revenge on Big Ev.\n");
        /*
         * Guest Room: A room filled with numerous torture devices. Who said anything about welcome guests? :: Kitchen
         * Library: Better version of the study. It has all of the different books that one may want. Make sure that you stay quiet or the mean librarian will slap you! :: Holodeck, Trophy Room, Study
         * Kitchen: This amazing culinary art studio has it all: cheese cellar, wine racks, and a 16 stove burner. With its pizza oven, it makes for the perfect Italian getaway. :: Study, Guest Room
         * Study: Do you love being disturbed while working? This room has it all. It is the central hub to the whole house. It has a giant wall of computers and amazing lighting, but doors that exit out into numerous different rooms. :: Kitchen, Library, Bedroom
         * Holodeck: A room that can disguise itself in a variety of ways. Experience a lush, humid rainforest, a speakeasy of the 1920’s, or the dungeons of Cooper Library. :: Library
         * Trophy Room: Spacious room with oak wood as far as the eye can see, shelves filled to the brim with trophies and obscure collections, it really makes you wonder who they belong to. :: Bedroom, Library
         * Bedroom: A lavished bed adorns the center of this room, with long curtains, beautiful rugs, and gilded furniture acting as little details to truly make this a great bedroom. :: Study, Trophy Room
         */
        
        //while loop that repeats until the user types exit or is inside of big ev's house
        while (!(location.equalsIgnoreCase("exit")) && !(location.equalsIgnoreCase("Inside"))) {

            //only prints if user has entered a new room
            if (input1.equalsIgnoreCase("goTo")){
            //prints out current room and decription
            System.out.println(adMap.getRoom(location).toString());
            }

            //prints out all of the possible exits
            System.out.print(adMap.getRoom(location).listExits());

            //prints all possible items the user can pick up
            System.out.println(adMap.getRoom(location).listItems());
            
            //prints all possible items the user can drop
            adMap.listDrops();

            //prints all possible items the user can read
            adMap.listRead();

            //lists all possible doors the user can open
            adMap.listOpen(location);

            //prompts user to pick an input command and place or object to use the command on
            System.out.println("Please choose an input");
            input1 = scnr.next();
            input2 = scnr.next();
            
            //if the users input is valid continue the program
            if (input1.equalsIgnoreCase("goTo") || input1.equalsIgnoreCase("pickup") || input1.equalsIgnoreCase("read") || input1.equalsIgnoreCase("drop") || input1.equalsIgnoreCase("open")) {
                
            }

            //if the users input is invalid continue to ask until it is valid
            else {
                while (!(input1.equalsIgnoreCase("goTo")) && !(input1.equalsIgnoreCase("pickup")) && !(input1.equalsIgnoreCase("read")) && !(input1.equalsIgnoreCase("drop")) && !(input1.equalsIgnoreCase("open"))) {
                    scnr.nextLine();
                    System.out.println("\nInvalid input.");
                    System.out.println("Please choose a valid input");
                    input1 = scnr.next();
                    input2 = scnr.next();
                }

            }


            //if the user input goto command
            if (input1.equalsIgnoreCase("goTo")) {
                newLocation = input2;
                //while loop that checks for an invalid goto command location
            while (!(adMap.getRoom(location).testCurr(newLocation))) {
                System.out.println("\nInvalid goTo.");
                System.out.println("Please choose a valid goTo");

                newLocation = scnr.next();
            }
            //sets the users location to their inputed location
            location = newLocation;
            }

            //if the user uses the pickup command
            else if (input1.equalsIgnoreCase("pickup")) {
                item = input2;
                
                //while the users pickup command is invalid ask for a valid input
                while (!(item.equalsIgnoreCase("book")) && !(item.equalsIgnoreCase("bat")) && !(item.equalsIgnoreCase("key"))) {
                    System.out.println("\nInvalid item");
                    System.out.println("Please choose a valid item");
                    item = scnr.next();
                }

                //if input is book try to pick up a book in the room
                if (item.equalsIgnoreCase("book")) {
                    adMap.getBook(location);
                    System.out.println("");
                }

                //if input is bat try to pick up a bat in the room
                else if(item.equalsIgnoreCase("bat")) {
                    adMap.getBat(location);
                    System.out.println("");
                }

                //if input is key try to pick up a key in the room
                else if(item.equalsIgnoreCase("key")) {
                    adMap.getKey(location);
                    System.out.println("");
                }
            }

            //if users command is read
            else if (input1.equalsIgnoreCase("read")) {
                item = input2;

                //while the user inputs an invalid item for the read command ask for another input
                while (!(item.equalsIgnoreCase("book"))) {
                    System.out.println("\nInvalid item");
                    System.out.println("Please choose a valid item");
                    item = scnr.next();
                }
                System.out.println("");

                //reads the contents of the book
                adMap.readBook();
                System.out.println("");
            }

            //if the users input is the drop command
            else if (input1.equalsIgnoreCase("drop")) {
                item = input2;

                //while the users input is invalid ask for a new input
                while (!(item.equalsIgnoreCase("book")) && !(item.equalsIgnoreCase("bat")) && !(item.equalsIgnoreCase("key"))) {
                    System.out.println("\nInvalid item");
                    System.out.println("Please choose a valid item");
                    item = scnr.next();
                }

                //if the input is book attempt to drop a book
                if (item.equalsIgnoreCase("book")) {
                    adMap.dropBook(location);
                    System.out.println("");
                }

                //if the input is bat attempt to drop a bat
                else if(item.equalsIgnoreCase("bat")) {
                    adMap.dropBat(location);
                    System.out.println("");
                }

                //if the input is key attempt to drop a key
                else if(item.equalsIgnoreCase("key")) {
                    adMap.dropKey(location);
                    System.out.println("");
                }
            }

            //if the users command is open
            else if (input1.equalsIgnoreCase("open")) {
                door = input2;

                //while the users input isnt door ask for a valid input
                while (!(door.equalsIgnoreCase("door"))) {
                    System.out.println("\nInvalid input");
                    System.out.println("Please choose a valid input");
                    door = scnr.next();
                }
                //attempts to open a rooms door
                adMap.openDoor(location);
            }

            //if the user is inside of Ev's house print the description
            if (location.equalsIgnoreCase("Inside")) {
                System.out.println(adMap.getRoom(location).toString());
            }
        }
        
        //if the user has the bat print the user win ending
        if (adMap.hasBat()) {
            System.out.println("\nYou and Big Ev begin your final battle!!! Big Ev starts the fight by punching you in the face!!! He sends you flying back through his door and onto the grass!!! Then you remember the baseball bat that Big Brady gave you... you quickly pull it out of your bag and smack Big Ev right in the jaw!!! He's knocked out cold... you pick up Big Ev and carry him back to the shore, and you throw him downstream!!! But... He... Will... Be... Back!!!\nTHE END");
        }
        //else print the Big Ev win ending
        else {
            System.out.println("\nYou and Big Ev begin your final battle!!! Big Ev starts the fight by punching you in the face!!! He sends you flying back through his door and onto the grass!!! Then you remember the baseball bat that Big Brady wanted to give you... but why didn't you take it!!! Regret floods your mind as you realize... Big Ev is too powerful!!! With one final hit he knocks you out cold!!! He then Picks you up and throws you back into the river... where you belong\nTHE END");
        }


        
        
    }

}

