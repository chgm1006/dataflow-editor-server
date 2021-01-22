package io.datadynamics.bigdata.dataflow.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Embeddable
public class UserId implements Serializable {

    @Column(name = "username", columnDefinition = "VARCHAR(100)")
    String username;

    @Column(name = "path", columnDefinition = "VARCHAR(255)")
    String path;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return Objects.equals(username, userId.username) && Objects.equals(path, userId.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, path);
    }
}
