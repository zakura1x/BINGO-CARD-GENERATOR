/*
 * @Title: BINGO TICKET GENERATOR
 * @Description: Develop a program that will generate a BINGO ticket 
 *               which is consists of four unique bingo cards. The program will display the 
 *               bingo cards with this given template format
 * @Author : Zeus A. Tenerife
 * @DateCreated: 11/15/2022
 */

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        
        do{
        //Header of the Program
        out.println("BINGO TICKET GENERATOR");
        out.println("----------------------");

        //Create an Arraylist for 4 Bingo Cards
        ArrayList<Integer> card1 = new ArrayList<Integer>();
        ArrayList<Integer> card2 = new ArrayList<Integer>();
        ArrayList<Integer> card3 = new ArrayList<Integer>();
        ArrayList<Integer> card4 = new ArrayList<Integer>();

        //Generate 4 Values for each Bingo Card
        generateRandomValuesOfCard(card1);
        generateRandomValuesOfCard(card2);
        generateRandomValuesOfCard(card3);
        generateRandomValuesOfCard(card4);

        //Union of 2 cards
        //To create a 2 tickets in one block
        ArrayList<Integer> union1 = unionOfTwoCards(card1, card2);
        ArrayList<Integer> union2 = unionOfTwoCards(card3, card4);


        //Display the Bingo Cards
        displayCard(union1);
        displayCard(union2);

        //check if the cards are unique
        //If cards are not unique, It will have a message
        out.print("Are the cards Unique?: ");
        if (!isUnique(card1, card2, card3, card4)){
            out.println("The 4 BINGO Cards are not unique");
        }else{
            out.println("The 4 BINGO Cards are unique");
        }

    }while(tryAgain()); //Loop the program if the user wants to try again

    out.println("--PROGRAM TERMINATED--");
}

    //Generate Random Values for each Bingo Card
    //Create an array of numbers
    public static void generateRandomValuesOfCard(ArrayList<Integer> card){
        Random rand = new Random();
        int num = 0;

        //Values for B
        //Generate 5 random numbers from 1 to 15
        for(int b = 0; b < 5; b++){
            num = rand.nextInt(15) + 1;
            if(!card.contains(num)){
                card.add(num);
            }else{
                b--;
            }
        }

        //Values for I
        //Generate 5 random numbers from 16 to 30
        for(int i = 0; i < 5; i++){
            num = rand.nextInt(15) + 16;
            if(!card.contains(num)){
                card.add(num);
            }else{
                i--;
            }
        }

        //Values for N
        //Generate 5 random numbers from 31 to 45
        for(int n = 0; n < 5; n++){
            num = rand.nextInt(15) + 31;
            if(!card.contains(num)){
                card.add(num);
            }else{
                n--;
            }
        }

        //Values for G
        //Generate 5 random numbers from 46 to 60
        for(int g = 0; g < 5; g++){
            num = rand.nextInt(15) + 46;
            if(!card.contains(num)){
                card.add(num);
            }else{
                g--;
            }
        }

        //Values for O
        //Generate 5 random numbers from 61 to 75
        for(int o = 0; o < 5; o++){
            num = rand.nextInt(15) + 61;
            if(!card.contains(num)){
                card.add(num);
            }else{
                o--;
            }
        }
        
        //Replace the 13th value with 0
        //This is the free space
        card.set(12, 0);
    }

    //Display Bingo Card
    public static void displayCard(ArrayList<Integer> union){
        out.println();
        out.println("+----+----+----+----+----+\t\t+----+----+----+----+----+");
        out.println("| B  | I  | N  | G  | O  |\t\t| B  | I  | N  | G  | O  |");
        out.println("+----+----+----+----+----+\t\t+----+----+----+----+----+");

        for(int i = 0; i < 5; i++){ //Rows
            for(int j = 0; j < 10; j++){ //Columns
                
                //If the Value of the Column is in 5
                //Create a border and tab for the second ticket
                if(j==5){
                    out.print("|\t\t");
                }
                
                //if the value is 0, print FR (Free Space)
                //The middle value of the card
                if(union.get(i + j * 5) == 0){
                    out.print("| FR ");
                }else{
                    //Print the values of the card
                    //Print the Border of the card
                    out.print("| ");
                    out.format("%02d",union.get(i + j * 5));
                    out.print(" "); 
                }   
            }
            //Print the Border of the card if the values are printed
            out.print("|\t\t");
            out.println();
            out.println("+----+----+----+----+----+\t\t+----+----+----+----+----+");
        }
        
    }

    //Check if the cards are equal
    public static boolean isEqual(ArrayList<Integer> card1, ArrayList<Integer> card2){
        return card1.equals(card2);
    }

    //check if the cards are unique
    public static boolean isUnique(ArrayList<Integer> card1, ArrayList<Integer> card2, ArrayList<Integer> card3, ArrayList<Integer> card4){
        return !isEqual(card1, card2) && !isEqual(card1, card3) && !isEqual(card1, card4) && !isEqual(card2, card3) && !isEqual(card2, card4) && !isEqual(card3, card4);
    }

    //Union of 2 cards
    public static ArrayList<Integer> unionOfTwoCards(ArrayList<Integer> card1, ArrayList<Integer> card2){
        ArrayList<Integer> unionOfTwoCards = new ArrayList<Integer>();
        //Add all the values of card1 to unionOfTwoCards
        for(int i = 0; i < card1.size(); i++){
            unionOfTwoCards.add(card1.get(i));
        }
        //Add all the values of card2 to unionOfTwoCards
        for(int i = 0; i < card2.size(); i++){
            unionOfTwoCards.add(card2.get(i));
        }

        return unionOfTwoCards;
    }

    //Asks the user if they wants to try again
    public static boolean tryAgain(){
        Scanner input = new Scanner(System.in);
        out.print("\nDo you want to Generate new BINGO Tickets? (Y/N): ");
        char answer = input.next().charAt(0);
        if(answer == 'Y' || answer == 'y'){
            out.println();
            return true;
        }else{
            out.println();
            return false;
        }
    }

}
