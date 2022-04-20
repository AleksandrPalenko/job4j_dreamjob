package ru.job4j.dreamjob.controller;

import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.store.CandidateStore;

import java.util.Collection;

@Service
public class CandidateService {

    private final CandidateStore candidateStores;

    /**
    public CandidateService() {
        this.store = CandidateStore.instOf();
    }
     */
    public CandidateService(CandidateStore candidateStores) {
        this.candidateStores = candidateStores;
    }

    public Collection<Candidate> findAll() {
        return candidateStores.findAll();
    }

    public void add(Candidate candidate) {
        candidateStores.add(candidate);
    }

    public void update(Candidate candidate) {
        candidateStores.update(candidate);
    }

    public Candidate findById(int id) {
        return candidateStores.findById(id);
    }
}
