package edu.mum.cs.cs425.dprwakanda.servirce.implementation;

import edu.mum.cs.cs425.dprwakanda.model.State;
import edu.mum.cs.cs425.dprwakanda.repository.StateRepository;
import edu.mum.cs.cs425.dprwakanda.servirce.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImplementation implements StateService {
    @Autowired
    private StateRepository stateRepository;
    @Override
    public Iterable<State> getAllStates() {
        return stateRepository.findAll(Sort.by("stateCode"));
    }
}
