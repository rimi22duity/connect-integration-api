package net.therap.Connect.integration.api.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import net.therap.Connect.integration.api.enums.UserRoleType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_id", columnNames = {"user_id"}),
        @UniqueConstraint(name = "uk_email", columnNames = {"email"})
}
)
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "userSeq", allocationSize = 1)
    @GeneratedValue(generator = "userSeq")
    private long id;

    @Column(name = "user_id")
    private String userId;

    @NotNull
    @Size(min = 8, message = "Username's size cannot be less than 8 characters.")
    private String userName;

    @NotNull
    private String fullName;

    private String password;

    @NotNull
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRoleType role;

    private String phone;

    private String address;

    @OneToMany(mappedBy = "assignedUser")
    @JsonIgnore
    private List<Device> assignedDeviceList;

    @OneToMany(mappedBy = "createdByUser")
    @JsonIgnore
    private List<Device> createdDeviceList;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<DeviceData> deviceDataList;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedDate;

    @Transient
    private String confirmPassword;

    @Transient
    private String adminSecretKey;

    public User() {
        assignedDeviceList = new ArrayList<>();
        createdDeviceList = new ArrayList<>();
        deviceDataList = new ArrayList<>();
    }

    public boolean isAdmin() {
        return this.role.getRoleString().equals("Admin");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
