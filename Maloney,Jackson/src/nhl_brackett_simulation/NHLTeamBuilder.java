package nhl_brackett_simulation;
import java.util.*;

public class NHLTeamBuilder {
    public static ArrayList<Team> fetchPlayoffTeams() {
        ArrayList<Team> teams = new ArrayList<>();
/* 
 * I inputed all of the stats and some of the team names/conference/divisions .
 * 
 * The Array list was made with Google Gemini assistance.
 */
        // Format: Name, Conf, Div, Pts, GAA, PP%, PK%, SV%        // EAST
        teams.add(new Team("Hurricanes", "Eastern", "Metropolitan", 113, 2.88, 24.9, 80.5, 0.912));
        teams.add(new Team("Penguins", "Eastern", "Metropolitan", 98, 3.15, 24.1, 81.4, 0.894));
        teams.add(new Team("Flyers", "Eastern", "Metropolitan", 98, 2.91, 15.7, 77.9, 0.906));
        teams.add(new Team("Sabres", "Eastern", "Atlantic", 109, 2.93, 19.5, 81.9, 0.910));
        teams.add(new Team("Lightning", "Eastern", "Atlantic", 106, 2.79, 20.7, 82.6, 0.912));
        teams.add(new Team("Canadiens", "Eastern", "Atlantic", 106, 3.06, 23.1, 78.2, 0.905));
        teams.add(new Team("Bruins", "Eastern", "Atlantic", 100, 3.01, 23.4, 80.7, 0.907));
        teams.add(new Team("Senators", "Eastern", "Atlantic", 99, 2.99, 24, 77.6, 0.901));
        
//This format will tell the program to add a team and add it to the Arraylist making a so called profile for the team and the needed stats for the team.
        
        // WEST
        Team avs = new Team("Avalanche", "Western", "Central", 121, 2.40, 17.1, 84.1, 0.921);
        avs.isPresidentsTrophy = true; // THE CURSE
        teams.add(avs);
        
        // The code above hooks in with the team arraylist but add a boolean saying that since they won the presidents trophy they have a curse making it harder to advance which will go away if they make it passed the second round.
        
        
        teams.add(new Team("Stars", "Western", "Central", 112, 2.71, 28.6, 80.3, 0.906));
        teams.add(new Team("Wild", "Western", "Central", 104, 2.87, 25.2, 79.7, 0.911));
        teams.add(new Team("Knights", "Western", "Pacific", 95, 2.95, 24.5, 81.4, 0.898));
        teams.add(new Team("Oilers", "Western", "Pacific", 93, 3.23, 30.6, 79.9, 0.899));
        teams.add(new Team("Ducks", "Western", "Pacific", 92, 3.51, 18.6, 75.8, 0.899));
        teams.add(new Team("Mammoth", "Western", "Central", 92, 2.93, 20, 77.1, 0.899));
        teams.add(new Team("Kings", "Western", "Pacific", 90, 2.90, 17, 76.4, 0.910));

        return teams;
    }
}