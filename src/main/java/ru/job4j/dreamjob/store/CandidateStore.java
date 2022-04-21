package ru.job4j.dreamjob.store;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Candidate;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@ThreadSafe
public class CandidateStore {

    /**
    private static final CandidateStore INST = new CandidateStore();
     */
    private final AtomicInteger id = new AtomicInteger(4);
    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Junior Java Job", "Collections, Stream API",
                LocalDateTime.now(), null));
        candidates.put(2, new Candidate(2, "Middle Java Job","Spring, SQL",
                LocalDateTime.now(), null));
        candidates.put(3, new Candidate(3, "Senior Java Job","Docker, Kafka",
                LocalDateTime.now(), null));
    }

    /**
    public static CandidateStore instOf() {
        return INST;
    }
     */

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public void add(Candidate candidate) {
        candidate.setId(id.incrementAndGet());
        candidates.put(id.get(), candidate);
    }

    public void update(Candidate candidate) {
        candidates.replace(candidate.getId(), candidate);
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }
}
