package net.therap.Connect.integration.api.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import net.therap.Connect.integration.api.enums.DeviceModel;
import net.therap.Connect.integration.api.enums.DeviceType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author duity
 * @since 4/19/23
 */

@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"deviceMacAddress"}))
@Entity
public class Device implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "deviceSeq", sequenceName = "deviceSeq", allocationSize = 1)
    @GeneratedValue(generator = "deviceSeq")
    private long id;

    @Column(unique = true)
    @NotNull
    @Pattern(regexp = "^(?:[0-9A-Za-z]{2}[:-]){5}(?:[0-9A-Za-z]{2})$", message = "Pattern doesn't match")
    private String deviceMacAddress;

    private String deviceName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DeviceModel deviceModel;

    private String firmwareVersion;

    private String deviceId;

    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

    @ManyToOne
    private User assignedUser;

    @ManyToOne
    private User createdByUser;

    @OneToMany(mappedBy = "device")
    @JsonIgnore
    private List<DeviceData> dataList;

    private String dataSendingTopicName;

    private String authInfoTopicName;

    @Transient
    private String adminSecretKey;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updated;

    public Device() {
        dataList = new ArrayList<>();
    }

    public void clearAssignedUser() {
        this.assignedUser = null;
    }

    public void clearDeviceName() {
        this.assignedUser = null;
    }

    public void clearDataSendingTopic() {
        this.dataSendingTopicName = null;
    }

    public void clearAuthInfoTopic() {
        this.authInfoTopicName = null;
    }

    public void clearFirmwareVersion() {
        this.firmwareVersion = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Device)) {
            return false;
        }

        Device that = (Device) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
