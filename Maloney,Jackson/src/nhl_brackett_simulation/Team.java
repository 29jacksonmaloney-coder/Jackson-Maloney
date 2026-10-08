package nhl_brackett_simulation;
import java.util.*;

//The following was done with Google Gemini as a Reference.

public class Team {
	
	//AI
	
	// This initalizes the stats from NHLTeamBiulder.java and sorts them into their different types like string and integer  
	
    public String name, conference, division;
    public int points;
    public double gaAvg, ppPct, pkPct, svPct;

    //ME
    
    
    
    public List<Integer> injuryList = new ArrayList<>(); 
    public List<Integer> playingInjuredList = new ArrayList<>();
    
    public int gamesPlayedInSeries = 0; 
    public boolean isPresidentsTrophy = false; 

    //ME, Ai
    
    // .this gives a already classified name an Abreviation or a code name its like at at a mexican resturant and they label you burrito to go with a S or a C. S being Steak and C being Chicken.
    
    public Team(String name, String conf, String div, int pts, double ga, double pp, double pk, double sv) {
        this.name = name; 
        this.conference = conf; 
        this.division = div;
        this.points = pts; 
        this.gaAvg = ga; 
        this.ppPct = pp;
        this.pkPct = pk; 
        this.svPct = sv;
    }
}