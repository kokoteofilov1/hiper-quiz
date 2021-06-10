package hiper.dao.impl;

import hiper.dao.AnswerRepository;
import hiper.dao.KeyGenerator;
import hiper.models.Answer;

public class AnswerRepositoryMemoryImpl extends RepositoryMemoryImpl<Long, Answer> implements AnswerRepository {
    public AnswerRepositoryMemoryImpl() {
    }

    public AnswerRepositoryMemoryImpl(KeyGenerator<Long> keyGenerator) {
        super(keyGenerator);
    }
}
