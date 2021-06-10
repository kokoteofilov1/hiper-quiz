package hiper.dao.impl;

import hiper.dao.KeyGenerator;
import hiper.dao.QuestionRepository;
import hiper.models.Question;

public class QuestionRepositoryMemoryImpl extends RepositoryMemoryImpl<Long, Question> implements QuestionRepository {
    public QuestionRepositoryMemoryImpl() {
    }

    public QuestionRepositoryMemoryImpl(KeyGenerator<Long> keyGenerator) {
        super(keyGenerator);
    }


}
