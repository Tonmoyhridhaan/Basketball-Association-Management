package Basketball;

public class Record {
	private int game;
	private int position;
	private Team team;
	private int round;
	public Record(int game, int position, Team team, int round){
		this.game = game;
		this.position = position;
		this.team = team;
		this.round = round;
	}
	public Team getTeam() {
		return team;
	}
	public int getRound() {
		return round;
	}
}
