package nhl_brackett_simulation;
import java.util.*;

/* I used half me half Ai reference in pretty much all parts of this file */
public class SeriesSimulator {
	//ME,AI
    public static SeriesResult simulateSeries(Team h, Team l, int round) {
        int hWins = 0, lWins = 0, game = 0;
        Random rand = new Random();
        
        h.gamesPlayedInSeries = 0; 
        l.gamesPlayedInSeries = 0;

        double hMotivationBonus = 0.0;
        double lMotivationBonus = 0.0;

        // NEW: Adds a blank line before mid-game events start logging
        System.out.println();

        while (hWins < 4 && lWins < 4) {
            game++;
            //                       AI helped with the logic below this on the next line
            // 1. BASE PROBABILITY
            double hChance = 0.50 + ((h.points - l.points) / 250.0);
            
            // The line above calculates the basic chance of winning a game.
            
            // ME,Ai Reference
            
            // 2. MOTIVATION EFFECTS
            hChance += hMotivationBonus;
            hChance -= lMotivationBonus;

            hMotivationBonus = 0.0;
            lMotivationBonus = 0.0;
            
            //ME, AI
            
            // 3. DESPERATION BOOST
            if (lWins == 3 && hWins < 3) hChance += 0.04; 
            if (hWins == 3 && lWins < 3) hChance -= 0.04; 
            
            // The line above states that if a team is one win away from moving on the other team gets a motivation boost increasing their odds of wining the next few games making it harder to get the last win.
            
            //ME
            
            // 4. INJURY PENALTIES
            hChance -= (h.injuryList.size() * 0.05);
            hChance += (l.injuryList.size() * 0.05);
            hChance -= (h.playingInjuredList.size() * 0.01);
            hChance += (l.playingInjuredList.size() * 0.01);
           

            //ME,AI
            
            // 5. CORE STATS & GOALIE FATIGUE
            hChance += (h.ppPct + h.pkPct - l.ppPct - l.pkPct) / 200.0 * 0.15;
            hChance += (h.svPct - l.svPct) * 2.0;
            if (h.gamesPlayedInSeries > 4) hChance -= (h.gamesPlayedInSeries * 0.005);
            if (l.gamesPlayedInSeries > 4) hChance += (l.gamesPlayedInSeries * 0.005);

            // 6. THE PLAYOFF OVERTIME SLOG
            boolean isOT = rand.nextDouble() < 0.25;
            if (isOT) {
                hChance += (h.svPct - l.svPct) * 2.0; 
                hChance -= (h.gamesPlayedInSeries - l.gamesPlayedInSeries) * 0.01;
                hChance += (rand.nextDouble() * 0.06) - 0.03; 
            }
            
            //The lines above make it so that it will check mto see which team has better special teams and save percentage it also checks to see what game the series is on to check for any pior goalie fatigue 
            
            //  The OT part of things just make sure that as OT goes on both teams are more and more fatiged and the save pct will give a hint of who will most likely win that game.
            
               //ME
            // 7. EQUIPMENT BREAKS & PRESIDENTS' CURSE
            if (rand.nextDouble() < 0.015) hChance -= 0.12; 
            if (rand.nextDouble() < 0.015) hChance += 0.12; 
            if (h.isPresidentsTrophy && round <= 2) hChance -= 0.05;
            if (l.isPresidentsTrophy && round <= 2) hChance += 0.05;

            //AI Reference 
            
            // 8. HOME ICE & PUCK LUCK
            if (game == 1 || game == 2 || game == 5 || game == 7) hChance += 0.03;
            hChance += (rand.nextDouble() * 0.10) - 0.05;
            
     //       why these spicific games were choosen is because the higher seed will get home ice and puck luck advantages on these games played at home any other game it will be flipped for the away side

            
            //AI Reference
            
            // --- RESOLVE GAME & MOTIVATION ---
            double outcomeRoll = rand.nextDouble();
            if (outcomeRoll < hChance) {
                hWins++;
                if (hChance - outcomeRoll > 0.25) {
                    if (rand.nextBoolean()) {
                        System.out.printf("  ↳ [GAME %d]  LOSS: %s Beat %s (Bounce-Back Ready)\n", game, h.name, l.name);
                        lMotivationBonus = 0.05;  
                        hMotivationBonus = -0.01; 
                    } else {
                        System.out.printf("  ↳ [GAME %d]  BLOWOUT: %s crushes %s (Demoralized Letdown)\n", game, h.name, l.name);
                        hMotivationBonus = 0.03;  
                        lMotivationBonus = -0.02; 
                    }
                }
            } else {
                lWins++;
                if (outcomeRoll - hChance > 0.25) {
                    if (rand.nextBoolean()) {
                        System.out.printf("  ↳ [GAME %d]  BLOWOUT: %s silences %s's crowd (Bounce-Back Ready)\n", game, l.name, h.name);
                        hMotivationBonus = 0.05;  
                        lMotivationBonus = -0.01; 
                    } else {
                        System.out.printf("  ↳ [GAME %d]  BLOWOUT: %s outclasses %s (Demoralized Letdown)\n", game, l.name, h.name);
                        lMotivationBonus = 0.03;  
                        hMotivationBonus = -0.02; 
                    }
                }
            }

            
            // Above is just the logic calculating Blowouts causing motivation shifts and it does the final game resolutions. Along with telling the user what is happening.
            
            // Mostly Me / some AI Reference
            
            // --- POST-GAME MEDICAL UPDATES ---
            handleReinjuryRisk(game, h, rand);
            handleReinjuryRisk(game, l, rand);

            if (rand.nextDouble() < 0.02) handleNewInjury(game, h, rand);
            if (rand.nextDouble() < 0.02) handleNewInjury(game, l, rand);

            h.gamesPlayedInSeries++; 
            l.gamesPlayedInSeries++;
            updateInjuryClocks(h); 
            updateInjuryClocks(l);
        }
        
        //this will update every teams medical status after each game.
        

        // NEW: Adds a blank line right after the last game log finishes
        System.out.println();
        
        return new SeriesResult((hWins == 4 ? h : l), game);
    }

      // Ai Helped a lot with this logic 
    
    private static void handleNewInjury(int game, Team team, Random rand) {
        int severity = calculateSeverity(rand);
        if (rand.nextDouble() < 0.70) {
            System.out.printf("  ↳ [GAME %d]  INJURY: %s player is hurt but skating through the pain.\n", game, team.name);
            team.playingInjuredList.add(severity);
        } else {
            System.out.printf("  ↳ [GAME %d]  INJURY: Severe break for %s. Sidelined to the press box.\n", game, team.name);
            team.injuryList.add(severity);
        }
    }

    private static void handleReinjuryRisk(int game, Team team, Random rand) {
        if (!team.playingInjuredList.isEmpty()) {
            ListIterator<Integer> iterator = team.playingInjuredList.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (rand.nextDouble() < 0.15) {
                    iterator.remove(); 
                    int catastrophicSeverity = rand.nextInt(12) + 10; 
                    team.injuryList.add(catastrophicSeverity);
                    System.out.printf("  ↳ [GAME %d]  DISASTER: Gutsy play backfires! %s player aggravated injury. Sidelined.\n", game, team.name);
                    break; 
                }
            }
        }
    }
    
    
    // The lines above calculate if a player that was ingured decides to play through and reingures himself even worse and will also notify the user.
    
    // Mostly Me , Very little AI Reference

    private static void updateInjuryClocks(Team t) {
        List<Integer> stillOut = new ArrayList<>();
        for (int d : t.injuryList) if (d - 1 > 0) stillOut.add(d - 1);
        t.injuryList = stillOut;

        List<Integer> stillPlayingHurt = new ArrayList<>();
        for (int d : t.playingInjuredList) if (d - 1 > 0) stillPlayingHurt.add(d - 1);
        t.playingInjuredList = stillPlayingHurt;
    }
//ME
    private static int calculateSeverity(Random rand) {
        int roll = rand.nextInt(100);
        if (roll < 50) return rand.nextInt(3) + 1;  //Small
        if (roll < 85) return rand.nextInt(5) + 4;  //Medium
        return rand.nextInt(12) + 9;    //Severe
    }
}

//The script above will roll a dice out of 100 to calculate the severity of the ingury it is very hard to get a severe one each level of ingury adds more and more games that the player will be out . it also keeps a clock on inguries 
