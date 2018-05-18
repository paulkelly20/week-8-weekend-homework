package models;

import javax.persistence.*;
import java.util.List;

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

    public Match(Competition competition, List<Team> teams, boolean knockoutMatch) {
        this.competition = competition;
        this.teams = teams;
        this.knockoutMatch = knockoutMatch;
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
    @JoinColumn(name = "competition_id")
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }


    @ManyToMany(mappedBy = "matches")
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
}
