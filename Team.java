package Basketball;

import java.util.*;

public class Team {
    private String name;
    private ArrayList<Player> players;
    Scanner sc = new Scanner(System.in);
    
    public Team(String name, ArrayList<Player> players) {
        this.name = name;
        this.players = players;
    } 
 
    public double avgCredit() {
    	if(players==null) {
    		return 0;
    	}
    	double sum = 0.0;
    	for(Player p : this.players) {
    		sum += p.getCredit();
    	}
    	double avg = sum/this.players.size();
    	return avg;
    }
    public int getNumber() {
    	if(players==null) {
    		return 0;
    	}
    	return this.players.size();
    }
    public String getName() {
        return this.name;
    }
    public double avgAge() {
    	if(players==null) {
    		return 0.0;
    	}
    	double sum = 0.0;
    	for(Player p : this.players) {
    		sum += (double)p.getAge();
    	}
    	double avg = sum/this.players.size();
    	return avg;
    }
    
    public ArrayList<Player> getPlayers() {
        return this.players;
    }
    
    public void addPlayer(Player player) {
        this.players.add(player);
    }
    
    public void removePlayer(Player player) {
        this.players.remove(player);
    }
    
    public void displayAllPlayers() {
    	Utils.playerHeader();
        for (Player p : players) {
        	String result = String.format(Utils.PlayerFormat, p.getName(),p.getCredit(),p.getLevel(),p.getNumber(),p.getAge());
        	System.out.println(result);
        }
        Utils.playerTableEnd();
    }
    
    public void displayPlayersByLevel(String level) {
    	System.out.println(Utils.PlayerFormat);
        for (Player player : players) {
            if (player.getLevel() == level) {
                System.out.println(player.toString());
            }
        }
    }
    
    public void manageTeam() {
        while (true) {
            System.out.println("Welcome to the "+name+" 's Page! Please make a selection from the menu:");
            System.out.println("1. Display team's players.");
            System.out.println("2. Add a new player.");
            System.out.println("3. Update an existing player.");
            System.out.println("4. Delete an existing player.");
            System.out.println("R. Return to previous menu.");
            System.out.print("Enter a choice: ");
            //sc.nextLine();
            String choice = sc.nextLine();
            
            switch (choice) {
                case "1":
                    this.displayAllPlayers();
                    break;
                case "2":
                	System.out.print("Please enter the player's name: ");
                	String name = sc.nextLine();
                	System.out.print("Please enter the player's credit: ");
                	double credit = sc.nextDouble();
                	
                	String level="Edge";
                	if(credit>=1000.0) {level = "Common";}
                	if(credit>=1500.0) {level = "Core";}
                	if(credit>=2000.0) {level = "All Star";}
                	sc.nextLine();
                	System.out.print("Please enter the player's age: ");
                    Integer age = sc.nextInt();
                    System.out.print("Please enter the player's No: ");
                    Integer No = sc.nextInt();
                    
                    while(true) {
                    	boolean fg = true;
                    	for(Player p : this.players) {
                    		if(p.getNumber() == No) {
                    			fg=false;
                    			System.out.print("This No has been occupied by: "+p.getName());
                    			break;
                    		}
                    	}
                    	if(fg) {
                    		Player newPlayer = new Player(name,credit,level,age,No,this.name);
                            //Player newPlayer = Player.addPlayer();
                            this.addPlayer(newPlayer);
                            System.out.println("Player "+name+" added!");
                            break;
                    		
                    	}
                    	else {
                    		System.out.print(". Please re-enter the No: ");
                    		No = sc.nextInt();
                    	}
                    }
                    
                    sc.nextLine();
                    break;
                case "3":
                    System.out.print("Please enter the player's name: ");
                    String oldName = sc.nextLine();
                    //Player playerToRemove = null;
                    boolean fg=false;
                    for (Player player : this.players) {
                        if (player.getName().equals(oldName)) {
                            fg=true;
                            System.out.print("Please enter the name: ");
                            String newName = sc.nextLine();
                            
                        	System.out.print("Please enter the credit: ");
                        	double newcredit = sc.nextDouble();
                        	
                        	String newlevel="Edge";
                        	if(newcredit>=1000.0) {newlevel = "Common";}
                        	if(newcredit>=1500.0) {newlevel = "Core";}
                        	if(newcredit>=2000.0) {newlevel = "All Star";}
                        	sc.nextLine();
                        	System.out.print("Please enter the age: ");
                            Integer newage = sc.nextInt();
                            System.out.print("Please enter the No: ");
                            Integer newNo = sc.nextInt();
                            
                            while(true) {
                            	boolean fg2 = true;
                            	for(Player p : this.players) {
                            		if(p.getNumber() == newNo) {
                            			fg2=false;
                            			System.out.print("This No has been occupied by: "+p.getName());
                            			break;
                            		}
                            	}
                            	if(fg2) {
                            		player.updateInformation(newName, newcredit, newlevel, newage, newNo);
                                    System.out.println("Player information updated.");
                                    sc.nextLine();
                                    break;
                            		
                            	}
                            	else {
                            		System.out.print(". Please re-enter the No: ");
                            		newNo = sc.nextInt();
                            	}
                            }

                            break;
                        }
                    }
                    if(!fg) {
                    	System.out.println("Player does not exist!");
                    }
                    
                    break;
                case "4":
                	System.out.print("Please enter the player's name: ");
                    oldName = sc.nextLine();
                    //Player playerToRemove = null;
                    fg=false;
                    for (Player player : this.players) {
                        if (player.getName().equals(oldName)) {
                        	fg=true;
                            this.players.remove(player);
                            System.out.println("Player deleted.");
                            break;
                            //sc.nextLine();
                        }
                    }
                    if(!fg) {
                    	System.out.println("Player does not exist!");
                    }
                    break;
                case "R":
                    return;
                default:
                    //System.out.println("Invalid choice, please try again!");
                    break;
            }
        }
    }
}


