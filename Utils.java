package Basketball;

public class Utils{
    public static final String teamsFormat = "| %-20s | %-19d | %-21.2f | %-12.2f |%n";
    public static final String PlayerFormat = "| %-20s | %-14.2f | %-12s | %-5d | %-5d |%n";
    public static final String DisplayPlayerFromAllTeamsFormat = "| %-20s | %-14.2f | %-12s | %-5d | %-5d | %-9s |%n";
    public static final String GamesFormat="| %-17s | %-4s | %-17s |%n";
    public static final String RecordFormat="| %-5d | %-4d | %-12s | %-12s |%n";

    public static void RecordHeader(){
        System.out.format("+-------+------+--------------+--------------+%n");
        System.out.format("| Round | Game | Winning Team | Losing team  |%n");
        System.out.format("+-------+------+--------------+--------------+%n");
    }
    public static void RecordEnd()
    {
        System.out.format("+-------+------+--------------+--------------+%n");
    }
    public static void GameHeader(){
        System.out.format("+-------------------+------+-------------------+%n");
        System.out.format("| First Team        |      | Second Team       |%n");
        System.out.format("+-------------------+------+-------------------+%n");
    }
    public static void GameEnd()
    {
        System.out.format("+-------------------+------+-------------------+%n");
    }
    public static void teamsHeader( ){
        System.out.format("+----------------------+---------------------+-----------------------+--------------+%n");
        System.out.format("| Team Name            | Number of Players   | Average Player Credit | Average Age  |%n");
        System.out.format("+----------------------+---------------------+-----------------------+--------------+%n");
    }
    public static void teamTableEnd(){

        System.out.format("+----------------------+---------------------+-----------------------+--------------+%n");
    }
    public static void playerHeader( ){
        System.out.format("+----------------------+----------------+--------------+-------+-------+%n");
        System.out.format("| Player Name          | Credit         | Level        | No    | Age   |%n");
        System.out.format("+----------------------+----------------+--------------+-------+-------+%n");
    }
    public static void playerTableEnd(){

        System.out.format("+----------------------+----------------+--------------+-------+-------+%n");
    }
    public static void DisplayPlayerFromAllTeamsHeader()
    {
        System.out.format("+----------------------+----------------+--------------+-------+-------+-----------+%n");
        System.out.format("| Player Name          | Credit         | Level        | Age   | No    | Team      |%n");
        System.out.format("+----------------------+----------------+--------------+-------+-------+-----------+%n");
    }

    public static void DisplayPlayerFromAllTeamsEnd()
    {

        System.out.format("+----------------------+----------------+--------------+-------+-------+-----------+%n");
    }
}



