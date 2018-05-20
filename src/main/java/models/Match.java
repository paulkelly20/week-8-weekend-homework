package models;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "matches")
public class Match {


    private int id;
    private Competition competition;
    private List<Team> teams;
    private boolean knockoutMatch;

    public Match() {
    }

    public Match(Competition competition,  boolean knockoutMatch) {
        this.competition = competition;
        this.knockoutMatch = knockoutMatch;
        this.teams = new ArrayList<Team>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "competition_id", nullable = false)
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }



    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "teams_in_match",
            inverseJoinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn(name = "match_id", nullable = false, updatable = false)}
    )
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Column(name = "knockout_match")
    public boolean isKnockoutMatch() {
        return knockoutMatch;
    }

    public void setKnockoutMatch(boolean knockoutMatch) {
        this.knockoutMatch = knockoutMatch;
    }

    public void addTeamToMatch(Team team){
        if (teams.size() < 2){
            this.teams.add(team);
        }
    }



    public void match(int homeScore, int awayScore){


    }


}
