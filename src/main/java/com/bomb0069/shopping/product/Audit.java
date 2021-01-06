package com.bomb0069.shopping.product;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Audit<T> {
    @CreatedBy
    protected T created_By;

    @LastModifiedBy
    protected T modified_By;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date created;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date modified;

    public T getCreated_By() {
        return created_By;
    }

    public void setCreated_By(T created_By) {
        this.created_By = created_By;
    }

    public T getModified_By() {
        return modified_By;
    }

    public void setModified_By(T modified_By) {
        this.modified_By = modified_By;
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
}
