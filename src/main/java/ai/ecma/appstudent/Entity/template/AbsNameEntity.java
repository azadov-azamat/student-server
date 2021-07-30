package ai.ecma.appstudent.Entity.template;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class AbsNameEntity extends AbsEntity {
    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "text")
    private String description;
}
