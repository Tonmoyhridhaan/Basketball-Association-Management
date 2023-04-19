package Basketball;

import java.util.ArrayList;
public class Game
{
    private ArrayList<Team> teams;
    private ArrayList<Team> results;
    public Integer term;
    private int round;
    private int game;
    Team win;
    Team lose;
    public Game(int round, int game, Team win, Team lose )
    {
    	this.round = round;
    	this.game = game;
    	this.win = win;
    	this.lose = lose;
    }
    public int getRound() {
    	return round;
    }
    public int getGame() {
    	return game;
    }
    public Team getWin() {
    	return win;
    }
    public Team getLose() {
    	return lose;
    }

}

