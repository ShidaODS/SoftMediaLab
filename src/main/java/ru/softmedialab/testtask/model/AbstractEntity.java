package ru.softmedialab.testtask.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public class AbstractEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 6320257371728924950L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } 
        
        if (!(o instanceof AbstractEntity)) {
            return false;
        }
        
        if (this.getId() == null) {
            return false;
        }
        
        AbstractEntity that = (AbstractEntity) o;
        return getId().equals(that.getId());
    }
    
    @Override
    public int hashCode() {
        return getId() == null ? super.hashCode() : getId().hashCode();
    }
    
    @Override
    public String toString() {
        return getClass().getName() + ":" + getId();
    }
    
}
