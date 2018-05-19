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

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "competition_id", nullable = true)
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }


    @ManyToMany(mappedBy = "matches", cascade = CascadeType.PERSIST)
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

//    public void match(){
//        Team team1 = this.teams.get(0);
//        Team team2 = this.teams.get(1);
//
//    }


}
