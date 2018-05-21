package models;

import db.DBCompetition;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Competition {
    private int id;
    private String name;
    private int prizeMoney;
    private List<Match> matches;
    private List<Team> teams;

    public Competition() {
    }

    public Competition(String name, int prizeMoney) {
        this.name = name;
        this.prizeMoney = prizeMoney;
        this.matches = new ArrayList<Match>();
        this.teams = new ArrayList<Team>();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "prize_money")
    public int getPrizeMoney() {
        return prizeMoney;
    }

    public void setPrizeMoney(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    @OneToMany(mappedBy = "competition")
    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public abstract void addMatchToCompetition(Match match);

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "teams_in_competition",
            joinColumns = {@JoinColumn(name = "competition_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)}
    )
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void addTeamToComp(Team team){
        if(!this.teams.contains(team)){
            this.teams.add(team);
        }
    }


}

