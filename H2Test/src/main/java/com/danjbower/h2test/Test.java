package com.danjbower.h2test;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Tests")
@XmlRootElement
public class Test implements Serializable
{
    @Id
    @Column(name = "Id", unique = true)
    @Basic(optional = false)
    @NotNull
    private Integer id = 0;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null)
        {
            return false;
        }

        if (getClass() != obj.getClass())
        {
            return false;
        }

        final Test other = (Test) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString()
    {
        return "Test (Id: " + id + ")";
    }
}
