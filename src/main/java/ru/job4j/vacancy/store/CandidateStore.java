package ru.job4j.vacancy.store;

import ru.job4j.vacancy.model.Candidate;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CandidateStore {

    private static final CandidateStore INST = new CandidateStore();

    private final Map<Integer, Candidate> posts = new ConcurrentHashMap<>();

    private CandidateStore() {
        posts.put(1, new Candidate(1, "Junior Java Job", "Collections, Stream API",
                "2022-04-10 10:30:00"));
        posts.put(2, new Candidate(2, "Middle Java Job","Spring, SQL",
                "2015-04-09 12:15:30"));
        posts.put(3, new Candidate(3, "Senior Java Job","Docker, Kafka",
                "2015-04-08 17:10:10"));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return posts.values();
    }
}
