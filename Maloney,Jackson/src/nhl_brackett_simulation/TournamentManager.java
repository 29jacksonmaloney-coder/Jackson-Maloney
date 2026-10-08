package nhl_brackett_simulation;

import java.util.*;
import java.util.stream.Collectors;

public class TournamentManager {
    public static void main(String[] args) {
    	//Ai
        ArrayList<Team> all = NHLTeamBuilder.fetchPlayoffTeams();
        
        // This fetches the Team Arraylist for use from the NHLTeamBiulder.java
        
        // Auto-assign Presidents' Trophy
        Team pres = all.stream().max(Comparator.comparingInt(t -> t.points)).orElse(null);
        if (pres != null) pres.isPresidentsTrophy = true;
        
    //    This just preps the presidents trophy curse.
//ME
        List<Team> east = buildConferenceBracket(all, "Eastern");
        List<Team> west = buildConferenceBracket(all, "Western");
        
        
//Me , WIth some AI Reference
      
        System.out.println("\n===========================================================");
        System.out.println("             NHL 2026 STANLEY CUP Playoff Simulator         ");
        System.out.println("                     (By: Jackson Maloney)                  ");
        System.out.println("===========================================================\n");
        
        System.out.println(">>> EASTERN CONFERENCE PATH <<<");
        Team eastChamp = runConference(east, "EAST");

        System.out.println("\n>>> WESTERN CONFERENCE PATH <<<");
        Team westChamp = runConference(west, "WEST");

        System.out.println("\n===========================================================");
        System.out.println("                THE STANLEY CUP FINALS                     ");
        System.out.println("===========================================================");
        
        //ME
        
        // Final recovery before the big series
        applyOffseasonRest(eastChamp, 4); 
        applyOffseasonRest(westChamp, 4);

        SeriesResult cupResult = SeriesSimulator.simulateSeries(eastChamp, westChamp, 4);
        
        //Me with AI Reference
        
        System.out.printf("\n CHAMPION: %s\n", cupResult.winner.name.toUpperCase());
        System.out.printf("Finals Result: %s in %d games\n", cupResult.winner.name, cupResult.totalGames);
        System.out.println("===========================================================\n");
    }
    
    // This just formats every thing and all the logic from the SeriesSimulator.java so its not an eyesore and it looks nice.

    //Me, With Ai Reference
    
    private static Team runConference(List<Team> b, String confName) {
        // ROUND 1
        System.out.println("\n[" + confName + " ROUND 1]");
        SeriesResult r1m1 = SeriesSimulator.simulateSeries(b.get(0), b.get(1), 1);
        printRes("R1-M1", b.get(0), b.get(1), r1m1);
        
        SeriesResult r1m2 = SeriesSimulator.simulateSeries(b.get(2), b.get(3), 1);
        printRes("R1-M2", b.get(2), b.get(3), r1m2);

        SeriesResult r1m3 = SeriesSimulator.simulateSeries(b.get(4), b.get(5), 1);
        printRes("R1-M3", b.get(4), b.get(5), r1m3);

        SeriesResult r1m4 = SeriesSimulator.simulateSeries(b.get(6), b.get(7), 1);
        printRes("R1-M4", b.get(6), b.get(7), r1m4);

        // RECOVERY PHASE (Teams heal based on how fast they won)
        applyRest(r1m1); applyRest(r1m2); applyRest(r1m3); applyRest(r1m4);

        // ROUND 2
        System.out.println("\n[" + confName + " ROUND 2]");
        SeriesResult s1 = SeriesSimulator.simulateSeries(r1m1.winner, r1m2.winner, 2);
        printRes("SEMIS", r1m1.winner, r1m2.winner, s1);

        SeriesResult s2 = SeriesSimulator.simulateSeries(r1m3.winner, r1m4.winner, 2);
        printRes("SEMIS", r1m3.winner, r1m4.winner, s2);

        applyRest(s1); applyRest(s2);

        // ROUND 3
        System.out.println("\n[" + confName + " FINALS]");
        SeriesResult f = SeriesSimulator.simulateSeries(s1.winner, s2.winner, 3);
        printRes("C-FIN", s1.winner, s2.winner, f);
        
        return f.winner;
    }
    
    // Above just sets up what the veiwer will see for both conferences and the format for prior final rounds.
    
    
    //Me with some Minor AI Reference

 // THE RECOVERY LOGIC: Rest heals both bench injuries AND playing-hurt statuses
    private static void applyRest(SeriesResult res) {
        Team winner = res.winner;
        int daysOfRest = 8 - res.totalGames; // Sweeping in 4 gives 4 extra days of rest.
        
        // Heal benched injuries
        List<Integer> healedOut = new ArrayList<>();
        for (int d : winner.injuryList) if (d - daysOfRest > 0) healedOut.add(d - daysOfRest);
        winner.injuryList = healedOut;

        // Heal playing-injured players
        List<Integer> healedHurt = new ArrayList<>();
        for (int d : winner.playingInjuredList) if (d - daysOfRest > 0) healedHurt.add(d - daysOfRest);
        winner.playingInjuredList = healedHurt;

        winner.gamesPlayedInSeries = 0; // Goalie fatigue resets entirely
    }
    
    // This code resets the whole team including injuries and goalie fatigue motivation resets after every series.
    

    //ME , AI
    
    private static void applyOffseasonRest(Team t, int days) {
        List<Integer> healedOut = new ArrayList<>();
        for (int d : t.injuryList) if (d - days > 0) healedOut.add(d - days);
        t.injuryList = healedOut;

        List<Integer> healedHurt = new ArrayList<>();
        for (int d : t.playingInjuredList) if (d - days > 0) healedHurt.add(d - days);
        t.playingInjuredList = healedHurt;

        t.gamesPlayedInSeries = 0;
    }

    //This just makes sure that AFTER THE PLAYOFFS ARE SIMULATED every effect including inguries and goalie fatige are allways cleared and ready for the next simulation.
    
    
    //AI Mainly helped here
    
    private static void printRes(String round, Team t1, Team t2, SeriesResult r) {
        // Build clear status tags for the print window
        String t1Out = t1.injuryList.isEmpty() ? "" : "[Inj x" + t1.injuryList.size() + "]";
        String t1Hurt = t1.playingInjuredList.isEmpty() ? "" : "[Hurt x" + t1.playingInjuredList.size() + "]";
        String t1Status = (t1Out + t1Hurt).trim();

        String t2Out = t2.injuryList.isEmpty() ? "" : "[Inj x" + t2.injuryList.size() + "]";
        String t2Hurt = t2.playingInjuredList.isEmpty() ? "" : "[Hurt x" + t2.playingInjuredList.size() + "]";
        String t2Status = (t2Out + t2Hurt).trim();
        
        System.out.printf("%-8s %-12s %-12s vs  %-12s %-12s ->  %-12s in %d\n", 
            "[" + round + "]", t1.name, t1Status, t2.name, t2Status, r.winner.name, r.totalGames);
    }

    private static List<Team> buildConferenceBracket(List<Team> all, String confName) {
        List<Team> conf = all.stream()
                .filter(t -> t.conference.equalsIgnoreCase(confName))
                .sorted((a, b) -> b.points - a.points)
                .collect(Collectors.toList());
        
        
        //This shows the ingury list size when you simulate so you see how many players are out per team and it formats each series showing for example [Boston vs Ottowa -> Ottowa 7 games ].
        
//Me with some Minor AI Reference
        
        List<Team> d1 = new ArrayList<>(), d2 = new ArrayList<>(), wc = new ArrayList<>();
        String d1Name = confName.equalsIgnoreCase("Eastern") ? "Metropolitan" : "Central";
        String d2Name = confName.equalsIgnoreCase("Eastern") ? "Atlantic" : "Pacific";

        for (Team t : conf) {
            if (t.division.equals(d1Name) && d1.size() < 3) d1.add(t);
            else if (t.division.equals(d2Name) && d2.size() < 3) d2.add(t);
            else if (wc.size() < 2) wc.add(t);
        }

        List<Team> b = new ArrayList<>();
        if (d1.size() >= 3 && d2.size() >= 3 && wc.size() >= 2) {
            b.add(d1.get(0)); b.add(wc.get(1)); // 1vWC2
            b.add(d1.get(1)); b.add(d1.get(2)); // 2v3
            b.add(d2.get(0)); b.add(wc.get(0)); // 1vWC1
            b.add(d2.get(1)); b.add(d2.get(2)); // 2v3
        }
        return b;
    }
}

// This automaticaly seed everyone based off of regular season points.
