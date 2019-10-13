package edu.mum.cs.cs425.dprwakanda.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.LinkedList;
import java.util.List;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stateId;
//    @Digits(integer = 9, fraction = 2, message = "* Balance must be a numeric/monetary amount in decimal (money) format such as 'x,xxx.xx'")
//    @NumberFormat(pattern = "#,###.##")

    private String stateCode;
    private String stateName;
    @OneToMany(targetEntity = Citizen.class, mappedBy = "state", cascade = CascadeType.ALL)
    private List<Citizen> citizenList;

    public State() {
        citizenList = new LinkedList<>();
    }

    public State(String stateCode, String stateName) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        citizenList = new LinkedList<>();
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<Citizen> getCitizenList() {
        return citizenList;
    }

    public void setCitizenList(List<Citizen> citizenList) {
        this.citizenList = citizenList;
    }

    @Override
    public String toString() {
        return stateCode + " - " + stateName;
    }

}
