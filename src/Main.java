/*
 * @Title: UNION AND INTERSECTION OF SETS
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

        //Create 4 Bingo Cards
        ArrayList<Integer> card1 = new ArrayList<Integer>();
        ArrayList<Integer> card2 = new ArrayList<Integer>();
        ArrayList<Integer> card3 = new ArrayList<Integer>();
        ArrayList<Integer> card4 = new ArrayList<Integer>();

        //Generate 4 Bingo Cards
        generateRandomValuesOfCard(card1);
        generateRandomValuesOfCard(card2);
        generateRandomValuesOfCard(card3);
        generateRandomValuesOfCard(card4);

        //Union of 2 cards
        ArrayList<Integer> union1 = unionOfTwoCards(card1, card2);
        ArrayList<Integer> union2 = unionOfTwoCards(card3, card4);


        //Display the Bingo Cards
        displayCard(union1);
        displayCard(union2);

        //check if the cards are unique
        if (!isUnique(card1, card2, card3, card4)){
            out.println("The Cards are not unique");
        }
    }while(tryAgain());

    out.println("--PROGRAM TERMINATED--");

    }

    //Generate Bingo Card
    public static void generateRandomValuesOfCard(ArrayList<Integer> card){
        Random rand = new Random();
        int num = 0;

        //Values for B
        for(int b = 0; b < 5; b++){
            num = rand.nextInt(15) + 1;
            if(!card.contains(num)){
                card.add(num);
            }else{
                b--;
            }
        }

        //Values for I
        for(int i = 0; i < 5; i++){
            num = rand.nextInt(15) + 16;
            if(!card.contains(num)){
                card.add(num);
            }else{
                i--;
            }
        }

        //Values for N
        for(int n = 0; n < 5; n++){
            num = rand.nextInt(15) + 31;
            if(!card.contains(num)){
                card.add(num);
            }else{
                n--;
            }
        }

        //Values for G
        for(int g = 0; g < 5; g++){
            num = rand.nextInt(15) + 46;
            if(!card.contains(num)){
                card.add(num);
            }else{
                g--;
            }
        }

        //Values for O
        for(int o = 0; o < 5; o++){
            num = rand.nextInt(15) + 61;
            if(!card.contains(num)){
                card.add(num);
            }else{
                o--;
            }
        }
        
        //Replace the 13th value with 0
        card.set(12, 0);
    }

    //Display Bingo Card
    public static void displayCard(ArrayList<Integer> union){
        out.println();
        out.println("+----+----+----+----+----+\t\t+----+----+----+----+----+");
        out.println("| B  | I  | N  | G  | O  |\t\t| B  | I  | N  | G  | O  |");
        out.println("+----+----+----+----+----+\t\t+----+----+----+----+----+");

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 10; j++){
                //Replace 0 with FR
                if(j==5){
                    out.print("|\t\t");
                }
                if(union.get(i + j * 5) == 0){
                    out.print("| FR ");
                }else{
                out.print("| ");
                out.format("%02d",union.get(i + j * 5));
                out.print(" "); 
                }   
            }
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
