package Basketball;

import java.util.ArrayList;
import java.util.Scanner;
public class Season {
    private ArrayList<Game> schedule;
    private ArrayList<Team> currentTeamList;
    private Integer round;
    private ArrayList<Record>  records;
    int game;
    int position;
    public Season(ArrayList<Team> teams)
    {
    	game=1;
    	position=1;
    	currentTeamList = teams;
    	records = new ArrayList<Record>();
    	round = 1;
    	schedule = new ArrayList<Game>();

    }
    public void use() {
    	Scanner sc = new Scanner(System.in);
    	while(true){
            System.out.println("Welcome to the season page! Please make a selection from the menu:");
            System.out.println("1. Add a team to the round.");
            System.out.println("2. Display the current round.");
            System.out.println("3. Play games.");
            System.out.println("4. Display the game result records.");
            System.out.println("R. Return to previous menu.");
            System.out.print("Enter a choice: ");
            String choice = sc.next();
            if(choice.equals("R")) {
            	return;
            }
            else if(choice.equals("1")) {
            	sc.nextLine();
            	while(currentTeamList.size()>0) {
            		
            		if(position==3) {
            			game++;
            			position=1;
            		}
            		System.out.println("The existing teams are as follows: ");
                	for(Team t: currentTeamList) {
                		System.out.print(t.getName()+" ");
                	}
                	System.out.println();
                	System.out.println("Please enter the team's name that you want to schedule: ");
                	String teamName = sc.nextLine();
                	boolean fg = false;
                	for(Team t: currentTeamList) {
                		if(t.getName().equals(teamName)) {
                			fg=true;
                			Record r = new Record(game,position,t,round);
                			records.add(r);
                			currentTeamList.remove(t);
                			
                			System.out.println("Team "+teamName+" has been added at the Game "+game+" position "+position);
                			position++;
                			break;
                		}
                	}
                	if(fg==false) {
                		System.out.println("No such team! Please try again");
                	}
            		
            	}
            	
            }
            else if(choice.equals("2")) {
            	int g=1;
            	Utils.GameHeader();
            	Team t1 = null;
            	Team t2 = null;
            	for(Record r : records) {
            		if(r.getRound()!=round) {
            			continue;
            		}
            		if(g%2==1) {
            			t1 = r.getTeam();
            			g++;
            		}
            		else {
            			t2 = r.getTeam();
            			String result = String.format(Utils.GamesFormat, t1.getName(),"vs", t2.getName());
                    	System.out.println(result);
                    	g++;
            		}
            		
            	}
            	Utils.GameEnd();
            }
            else if(choice.equals("3")) {
            	int g=1;
            	//Utils.GameHeader();
            	Team t1 = null;
            	Team t2 = null;
            	int i=1;
            	for(Record r : records) {
            		if(r.getRound()!=round) {
            			continue;
            		}
            		if(g%2==1) {
            			t1 = r.getTeam();
            			g++;
            		}
            		else {
            			t2 = r.getTeam();
            			if(t2.avgCredit()>t1.avgCredit()) {
            				Game gm = new Game(round, i, t2, t1);
            				currentTeamList.add(t2);
            				schedule.add(gm);
            			}
            			else {
            				Game gm = new Game(round, i, t1, t2);
            				schedule.add(gm);
            				currentTeamList.add(t1);
            			}
            			
                    	i++;
                    	g++;
            		}
            		
            	}
            	System.out.println("All games finished! You can use 4 to check the results.");
            	
            	round++;
            	
            }
            else if(choice.equals("4")) {
            	Utils.RecordHeader();
            	
            	for(Game g : schedule) {
            		String result = String.format(Utils.RecordFormat, g.getRound(), g.getGame(),g.getWin().getName(), g.getLose().getName());
                	System.out.println(result);
            	}
            	
            	Utils.RecordEnd();
            }
            
            
    	}
    }


}
