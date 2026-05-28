/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windows
 */
public class Match {
    private String matchId;
    private String matchDate;
    private String opponentTeam;
    private String matchType;

    public Match(String matchId, String matchDate, String opponentTeam, String matchType) {
        this.matchId = matchId;
        this.matchDate = matchDate;
        this.opponentTeam = opponentTeam;
        this.matchType = matchType;
    }

    public String getMatchId() {
        return matchId;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(String opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public void displayMatchInfo() {
        System.out.println("Match ID: " + matchId);
        System.out.println("Match Date: " + matchDate);
        System.out.println("Opponent Team: " + opponentTeam);
        System.out.println("Match Type: " + matchType);
    }
}