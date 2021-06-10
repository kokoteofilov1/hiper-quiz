package hiper.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class AbstractEntity<K extends Comparable<K>, V extends Identifiable<K>>
        implements Comparable<V>, Identifiable<K>, Serializable {
    private K id;
    private Date created = new Date();
    private Date modified = new Date();

    public AbstractEntity() {
    }

    public AbstractEntity(K id) {
        this.id = id;
    }

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity<?, ?> that = (AbstractEntity<?, ?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(V other) {
        return getId().compareTo(other.getId());
    }
}
