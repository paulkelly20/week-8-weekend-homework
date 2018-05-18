package models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "employees")
public abstract class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private Calendar contractEndDate;
    private Team team;


    public Employee() {
    }

    public Employee(String name, int age, double salary, Calendar contractEndDate, Team team) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.contractEndDate = contractEndDate;
        this.team = team;
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

    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "contract_end_date")
    public Calendar getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Calendar contractEndDate) {
        this.contractEndDate = contractEndDate;
    }


    public Team getTeam() {
        return team;
    }


    public void setTeam(Team team) {
        this.team = team;
    }
}
