package models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private Calendar contractEndDate;



    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;


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


}
