package ru.job4j.dreamjob.store;

import org.testng.annotations.Test;
import ru.job4j.dreamjob.MainBoot;
import ru.job4j.dreamjob.model.Candidate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CandidateDbStoreTest {

    @Test
    public void whenCreateCandidate() {
        CandidateDbStore store = new CandidateDbStore(new MainBoot().loadPool());
        Candidate candidate = new Candidate(1, "Pavel");
        store.add(candidate);
        Candidate findCandidate = store.findById(candidate.getId());
        assertThat(findCandidate.getName(), is(candidate.getName()));
    }

    @Test
    public void whenFindAllCandidate() {
        CandidateDbStore store = new CandidateDbStore(new MainBoot().loadPool());
        store.deleteFrom();
        Candidate candidate = new Candidate(1, "Pavel");
        Candidate candidate1 = new Candidate(2, "Alex");
        Candidate candidate2 = new Candidate(3, "Petr");
        store.add(candidate);
        store.add(candidate1);
        store.add(candidate2);
        List<Candidate> posts = List.of(
                new Candidate(1, "Pavel"),
                new Candidate(2, "Alex"),
                new Candidate(3, "Petr")
        );
        List<Candidate> postFindAll = store.findAll();
        assertThat(postFindAll, equalTo(posts));
        assertThat(3, is(postFindAll.size()));
    }

    @Test
    public void whenReplaceCandidate() {
        CandidateDbStore store = new CandidateDbStore(new MainBoot().loadPool());
        store.deleteFrom();
        Candidate candidate = new Candidate(1, "Pavel");
        store.add(candidate);
        candidate.setName("Igor");
        store.update(candidate);
        Candidate findCandidate = store.findById(candidate.getId());
        assertThat(findCandidate.getName(), equalTo(candidate.getName()));
    }
}
