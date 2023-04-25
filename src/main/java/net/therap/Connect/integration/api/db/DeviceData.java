package net.therap.Connect.integration.api.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author duity
 * @since 4/19/23
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class DeviceData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "deviceDataSeq", sequenceName = "deviceDataSeq", allocationSize = 1)
    @GeneratedValue(generator = "deviceDataSeq")
    private long id;

    @ManyToOne
    private Device device;

    @ManyToOne
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updated;

    @Transient
    private long createdDateEpoch;

    public long getCreatedDateEpoch() {
        return created.getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof DeviceData)) {
            return false;
        }

        DeviceData deviceData = (DeviceData) o;

        return Objects.equals(getId(), deviceData.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
