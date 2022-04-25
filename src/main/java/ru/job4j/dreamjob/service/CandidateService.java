package ru.job4j.dreamjob.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.store.CandidateDbStore;

import java.util.Collection;

@Service
@ThreadSafe
public class CandidateService {

    private final CandidateDbStore candidateDbStores;

    /**
    public CandidateService() {
        this.store = CandidateStore.instOf();
    }
     */
    public CandidateService(CandidateDbStore candidateStores) {
        this.candidateDbStores = candidateStores;
    }

    public Collection<Candidate> findAll() {
        return candidateDbStores.findAll();
    }

    public void add(Candidate candidate) {
        candidateDbStores.add(candidate);
    }

    public void update(Candidate candidate) {
        candidateDbStores.update(candidate);
    }

    public Candidate findById(int id) {
        return candidateDbStores.findById(id);
    }
}
