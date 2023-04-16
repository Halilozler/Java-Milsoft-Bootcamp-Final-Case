package homeworks.sports;

import java.util.ArrayList;

public class Test {
    /*
    HW 1A:
    com.godoro.sports
	Team teamId teamName
	Player playerId playerName averageScore
	Test
		901 Godoro Spor
			301 "Neşet Ertaş"  45.2
			302 "Mahsuni Şerif" 36.5
			303 "Erkan Ocaklı" 71.3
     */
    public static void main(String[] args) {
        Team team1 = new Team(901, "Godoro Spor");
        Player player1 = new Player(301, "Neşet Ertaş", 45.2);
        Player player2 = new Player(302, "Mahsuni Şerif", 36.5);
        Player player3 = new Player(303, "Erkan Ocaklı", 71.3);

        team1.setPlayerList(new ArrayList<Player>());

        team1.getPlayerList().add(player1);
        team1.getPlayerList().add(player2);
        team1.getPlayerList().add(player3);

        player1.setTeam(team1);
        player2.setTeam(team1);
        player3.setTeam(team1);

        System.out.println(team1.getTeamId() + " " + team1.getTeamName());
        for(Player player : team1.getPlayerList()){
            System.out.println("\t" + player.getPlayerId() + " " + player.getPlayerName() + " " + player.getAverageScore());
        }
    }
}
