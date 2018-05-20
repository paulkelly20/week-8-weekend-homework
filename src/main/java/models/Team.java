package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    private int id;
    private String name;
    private Manager manager;
    private List<Player> players;
    private List<Match> matches;
    private List<Competition> competitions;

    public Team(String name) {
        this.name = name;
        this.matches = new ArrayList<Match>();
        this.players = new ArrayList<Player>();
        this.competitions = new ArrayList<Competition>();

    }

    public Team() {
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

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(mappedBy = "team" ,fetch = FetchType.LAZY)
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }


    @OneToMany(mappedBy = "team")
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


    @ManyToMany(mappedBy = "teams")
//    @JoinTable(name = "teams_in_match",
//            joinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "match_id", nullable = false, updatable = false)}
//    )
    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    @ManyToMany(mappedBy = "teams")
    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }

    public void newMatchForTeam(Match match){
        this.matches.add(match);
    }

    public void addPlayerToTeam(Player player, Calendar contractExpires, double newSalary){
        this.players.add(player);
        player.setContractEndDate(contractExpires);
        player.setSalary(newSalary);
    }

    public void hireManager(Manager manager, Calendar contractExpires, double newSalary){
        this.setManager(manager);
        manager.setContractEndDate(contractExpires);
        manager.setSalary(newSalary);

    }
}
