package edu.mum.cs.cs425.dprwakanda.servirce;

import edu.mum.cs.cs425.dprwakanda.model.Citizen;
import org.springframework.data.domain.Page;

import java.util.Map;


public interface CitizenService {
    public Page<Citizen> listOfAllCitizens(int pageNo);
    public Citizen saveNewCitizen(Citizen citizen);
    public Map<String, Double> NationalYearlyIncome();
}
