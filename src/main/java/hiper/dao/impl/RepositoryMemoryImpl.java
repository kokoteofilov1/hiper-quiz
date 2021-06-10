package hiper.dao.impl;

import hiper.dao.KeyGenerator;
import hiper.dao.Repository;
import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.EntityNotFoundException;
import hiper.exceptions.MissingKeyGeneratorException;
import hiper.models.Identifiable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RepositoryMemoryImpl<K, V extends Identifiable<K>> implements Repository<K, V> {
    private Map<K, V> entities = new ConcurrentHashMap<>();
    private KeyGenerator<K> keyGenerator;

    public RepositoryMemoryImpl() {
    }

    public RepositoryMemoryImpl(KeyGenerator<K> keyGenerator) {
        this.keyGenerator = keyGenerator;
    }

    @Override
    public List<V> findAll() {
        return new ArrayList<>(entities.values());
    }

    @Override
    public Optional<V> findById(K id) {
        return Optional.ofNullable(entities.get(id));
    }

    @Override
    public V create(V entity) throws EntityAlreadyExistsException, MissingKeyGeneratorException {
        if (entity.getId() == null) {
            if (keyGenerator != null) {
                entity.setId(keyGenerator.getNextId());
            } else {
                throw new MissingKeyGeneratorException(String.format("The repository has no KeyGenerator set!%n" +
                        "ID cannot be set for the entity!%n" +
                        "Either set the KeyGenerator for the repository or the entity."));
            }
        } else {
            if (entities.containsKey(entity.getId())) {
                throw new EntityAlreadyExistsException(String.format("Entity with ID=%s already exists!", entity.getId()));
            }
        }

        entities.put(entity.getId(), entity);

        return entity;
    }

    @Override
    public int createBatch(Collection<V> entityCollection) throws EntityAlreadyExistsException {
        int n = 0;
        for (V entity : entityCollection) {
            if (entities.putIfAbsent(entity.getId(), entity) != null) {
                throw new EntityAlreadyExistsException(String.format("Entity with ID=%s already exists!", entity.getId()));
            } else {
                n++;
            }
        }

        return n;
    }

    @Override
    public V update(V entity) throws EntityNotFoundException {
        Optional<V> oldValue = findById(entity.getId());
        if (oldValue.isEmpty()) {
            throw new EntityNotFoundException(String.format("Entity with ID=%s does not exist!", entity.getId()));
        }

        entities.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public V deleteById(K id) throws EntityNotFoundException {
        V oldValue = entities.remove(id);

        if (oldValue == null) {
            throw new EntityNotFoundException(String.format("Entity with ID=%s does not exist!", id));
        }

        return oldValue;
    }

    @Override
    public long count() {
        return entities.size();
    }
}
