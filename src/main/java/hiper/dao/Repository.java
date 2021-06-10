package hiper.dao;

import hiper.exceptions.EntityAlreadyExistsException;
import hiper.exceptions.EntityNotFoundException;
import hiper.exceptions.MissingKeyGeneratorException;
import hiper.models.Identifiable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Repository<K, V extends Identifiable<K>> {
    List<V> findAll();
    Optional<V> findById(K id);
    V create(V entity) throws EntityAlreadyExistsException, MissingKeyGeneratorException;
    int createBatch(Collection<V> entities) throws EntityAlreadyExistsException;
    V update(V entity) throws EntityNotFoundException;
    V deleteById(K id) throws EntityNotFoundException;
    long count();
}
