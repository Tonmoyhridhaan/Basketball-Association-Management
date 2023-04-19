package Basketball;

import java.util.*;
public class Association
{
    private static ArrayList<Team> teams;
    private Season season;
    public Association()
    {
        /*teams = new Teams();
        ArrayList<Player> players;
        Player p1 = new Player("Devin Booker",2500.00, "All Star",26,1,"Suns");
        players.add(p1);
        Team t1 = new ("Suns",players);
        teams.add(t1);*/
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Association asc = new Association();
        Teams t = new Teams();
        while(true){
            System.out.println("Welcome to the Association! Please make a selection from the menu:");
            System.out.println("1. Explore the teams.");
            System.out.println("2. Arrange a new season.");
            System.out.println("X. Exit the system.");
            System.out.print("Enter a choice: ");
            String choice = sc.next();
            if(choice.equals("X")){
                System.out.print("Done");
                break;
            }
            else if(choice.equals("1")){
                while(true){
                    
                    t.use();
                    
                    break;
                }
            }
            else if(choice.equals("2")){
                while(true){
                    Season s = new Season(t.getAllTeams());
                    s.use();
                    break;
                }
            }

        }
    }
}


