package Basketball;
import java.util.*;
public class Player {
	Scanner sc = new Scanner(System.in);
    private String name;
    private Double credit;
    private String level;
    private Integer age;
    private String team;
    private Integer No;
    public Player(String name, Double credit, String level, Integer age, Integer No, String team)
    {
        this.name = name;
        this.credit = credit;
        this.level = level;
        this.age = age;
        this.team = team;
        this.No = No;
    }
    public double getCredit() {
    	return credit;
    }
    public Integer getAge() {
    	return age;
    }
    public String getLevel(){
        return this.level;
    }
    public int getNumber() {
        return No;
    }
    public String getName() {
    	return name;
    }
    public String getTeam() {
    	return team;
    }
    public void updateInformation(String name, Double credit, String level, Integer age, Integer No) {
    	this.name = name;
        this.credit = credit;
        this.level = level;
        this.age = age;
        this.No = No;
    }

}
