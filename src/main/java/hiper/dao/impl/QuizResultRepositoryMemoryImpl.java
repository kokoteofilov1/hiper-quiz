package hiper.dao.impl;

import hiper.dao.KeyGenerator;
import hiper.dao.QuizResultRepository;
import hiper.models.QuizResult;

public class QuizResultRepositoryMemoryImpl extends RepositoryMemoryImpl<Long, QuizResult> implements QuizResultRepository {
    public QuizResultRepositoryMemoryImpl() {
    }

    public QuizResultRepositoryMemoryImpl(KeyGenerator<Long> keyGenerator) {
        super(keyGenerator);
    }
}
