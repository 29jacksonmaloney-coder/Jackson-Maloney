package nhl_brackett_simulation;

// Me

public class SeriesResult {
    public Team winner;
    public int totalGames;

    public SeriesResult(Team winner, int totalGames) {
        this.winner = winner;
        this.totalGames = totalGames;
    }
}

//This is just like Team.java but it is for the special code names for the logic behind the series. 