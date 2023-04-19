package Basketball;

import java.util.ArrayList;
import java.util.*;
public class Teams {
    private ArrayList<Team> teams = new ArrayList<Team>();

    public Teams()
    {
    	ArrayList<Player> players = new ArrayList<Player>();
    	Player p = new Player("Devin Booker", 2500.00, "All Star", 26, 1, "Suns");
    	players.add(p);
    	p = new Player("Chris Paul", 1500.00, "Core", 37, 3, "Suns");
    	players.add(p);
    	p = new Player("Deandre Ayton", 2000.00, "All Star", 24, 22, "Suns");
    	players.add(p);
    	p = new Player("Kevin Durant", 3000.00, "All Star", 34, 35, "Suns");
    	players.add(p);
    	p = new Player("Terrence Ross", 1000.00, "Common", 32, 8, "Suns");
    	players.add(p);
    	Team team = new Team("Suns",players);
    	teams.add(team);
    	
    	players = new ArrayList<Player>();
    	p = new Player("Andre Drummond", 1500.00, "Core", 29, 3, "Bulls");
    	players.add(p);
    	p = new Player("Zach LaVine", 3000.00, "All Star", 28, 8, "Bulls");
    	players.add(p);
    	p = new Player("Dalen Terry", 900.00, "Edge", 20, 25, "Bulls");
    	players.add(p);
    	p = new Player("Terry Taylor", 1000.00, "Common", 23, 32, "Bulls");
    	players.add(p);
    	p = new Player("Carlik Jones", 800.00, "Edge", 25, 22, "Bulls");
    	players.add(p);
    	team = new Team("Bulls",players);
    	teams.add(team);
    	
    	players = new ArrayList<Player>();
    	p = new Player("Trae Young", 2200.00, "All Star", 24, 11, "Hawks");
    	players.add(p);
    	p = new Player("John Collins", 2000.00, "All Star", 25, 20, "Hawks");
    	players.add(p);
    	p = new Player("Aaron Holiday", 800.00, "Edge", 26, 3, "Hawks");
    	players.add(p);
    	p = new Player("Jalen Johnson", 1000.00, "Common", 21, 1, "Hawks");
    	players.add(p);
    	p = new Player("Trent Forrest", 1200.00, "Common", 24, 2, "Hawks");
    	players.add(p);
    	team = new Team("Hawks",players);
    	teams.add(team);

    	players = new ArrayList<Player>();
    	p = new Player("Mikal Bridges", 2400.00, "All Star", 26, 1, "Nets");
    	players.add(p);
    	p = new Player("Ben Simmons", 2000.00, "All Star", 26, 10, "Nets");
    	players.add(p);
    	p = new Player("Patty Mills", 900.00, "Edge", 34, 8, "Nets");
    	players.add(p);
    	p = new Player("Joe Harris", 1200.00, "Common", 31, 12, "Nets");
    	players.add(p);
    	p = new Player("Seth Curry", 1900.00, "Core", 32, 30, "Nets");
    	players.add(p);
    	//players.add(p);
    	team = new Team("Nets",players);
    	teams.add(team);
    	
    }
    public ArrayList<Team> getAllTeams() {
    	return teams;
    }

    public void use(){
        Scanner sc = new Scanner(System.in);
        //System.out.println("init");
        while(true){
            System.out.println("Welcome to the Teams Page! Please make a selection from the menu:");
            System.out.println("1. Display all teams.");
            System.out.println("2. Display all players.");
            System.out.println("3. Add a new team.");
            System.out.println("4. Manage an existing team.");
            System.out.println("5. Delete an existing team.");
            System.out.println("6. Display all players by an level.");
            System.out.println("R. Return to previous menu.");
            System.out.print("Enter a choice: ");
            String choice = sc.next();
            if(choice.equals("R")){
                return;
            }
            else if(choice.equals("1")) {
            	
            	Utils.teamsHeader();
            	for (Team team: this.teams) {
            		String result = String.format(Utils.teamsFormat, team.getName(),team.getNumber(),team.avgCredit(),team.avgAge());
            		System.out.println(result);
            	}
            	Utils.teamTableEnd();
            	
            }
            else if(choice.equals("2")) {
            	
            	//Utils.teamsHeader();
            	Utils.DisplayPlayerFromAllTeamsHeader();
            	for (Team team: this.teams) {
            		
            		ArrayList<Player> players = team.getPlayers();
            		for(Player p: players) {
            			
                		String result = String.format(Utils.DisplayPlayerFromAllTeamsFormat, p.getName(),p.getCredit(),p.getLevel(),p.getAge(),p.getNumber(),p.getTeam());
                		System.out.println(result);
            		}
            		Utils.DisplayPlayerFromAllTeamsEnd();
            		
            	}
            	
            	
            }
            else if(choice.equals("3")) {
            	System.out.print("Please enter the name of the team: ");
            	sc.nextLine();
            	String name = sc.nextLine();
            	
            	while(true) {
            		boolean fg = true;
            		for (Team team: this.teams) {
                		if(team.getName().equals(name)) {
                			fg=false;
                			break;
                		}
                	}
            		if(!fg) {
            			System.out.print("Team "+name+" already exist! Please enter a new name: ");
            			name = sc.nextLine();
            		}
            		else {
            			Team team = new Team(name,null);
            			this.teams.add(team);
            			System.out.println("Team "+name+" added!");
            			break;
            		}
            	}
            }
            else if(choice.equals("4")) {
            	System.out.print("Please enter the team's name that you want to manage: ");
            	sc.nextLine();
            	String name = sc.nextLine();
            	boolean fg=false;
        		for (Team team: this.teams) {
            		if(team.getName().equals(name)) {
            			fg=true;
            			team.manageTeam();
            			break;
            		}
            	}
        		if(!fg) {
        			System.out.println("Team does not exist!");
        		}

            }
            else if(choice.equals("5")) {
            	System.out.print("Please enter the team's name that you want to delete: ");
            	sc.nextLine(); 
            	String name = sc.nextLine();
            	boolean fg=false;
        		for (Team team: this.teams) {
            		if(team.getName().equals(name)) {
            			fg=true;
            			this.teams.remove(team);
            			System.out.println("The team "+name+" has been deleted.");
            			break;
            		}
            	}
        		if(!fg) {
        			System.out.println("The team you want to delete does not exist!");
        		}

            }
            else if(choice.equals("6")) {
            	//boolean fg = true;
            	System.out.print("Please enter the player's level that you want to view: ");
            	sc.nextLine(); 
            	String level = sc.nextLine();
            	while(true) {
            	
	            	
	            	//boolean fg=false;
	            	ArrayList<Player> levelplayers = new ArrayList<Player>();
	        		for (Team team: this.teams) {
	        			
	        			ArrayList<Player> players = team.getPlayers();
	        			
	        			for(Player p: players) {
	        				if(p.getLevel().equals(level)) {
	        					levelplayers.add(p);
	                		}
	        				
	        			}
	        			
	            		
	            	}
	        		if(levelplayers.size()>0) {
	        			Utils.DisplayPlayerFromAllTeamsHeader();
	        			for(Player p: levelplayers) {
	        				String result = String.format(Utils.DisplayPlayerFromAllTeamsFormat, p.getName(),p.getCredit(),p.getLevel(),p.getAge(),p.getNumber(),p.getTeam());
	                		System.out.println(result);
	        			}
	        			Utils.DisplayPlayerFromAllTeamsEnd();
	        			break;
	        		}
	        		else {
	        			System.out.print("No such level! Please re-enter the level: ");
	        			level = sc.nextLine();
	        		}
            	}
        		

            }

        }
        //System.out.println("working");
        
    }

}
