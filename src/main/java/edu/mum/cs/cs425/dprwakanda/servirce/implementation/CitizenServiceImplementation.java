package edu.mum.cs.cs425.dprwakanda.servirce.implementation;

import edu.mum.cs.cs425.dprwakanda.model.Citizen;
import edu.mum.cs.cs425.dprwakanda.repository.CitizenRepository;
import edu.mum.cs.cs425.dprwakanda.servirce.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CitizenServiceImplementation implements CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public Page<Citizen> listOfAllCitizens(int pageNo) {
        return citizenRepository.findAll(PageRequest.of(pageNo, 3, Sort.by("lastName")));
    }

    @Override
    public Citizen saveNewCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    @Override
    public Map<String , Double> NationalYearlyIncome() {
        List<Citizen> citizens = citizenRepository.findAll();
        double totalYearlyIncome = 0;
        for(Citizen citizen : citizens){
            totalYearlyIncome += citizen.getYearlyIncome();
        }
        Map<String, Double> summary = new LinkedHashMap<>();
        summary.put("National Total Yearly Income", totalYearlyIncome);
        return summary;
    }
}
