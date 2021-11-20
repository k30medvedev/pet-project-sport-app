package by.kirill.sportsman.app.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Builder
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "runs")
@EntityListeners({AuditingEntityListener.class})
public class Run extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_run")
    private OffsetDateTime startRun;

    @Column(name = "finish_run")
    private OffsetDateTime finishRun;

    @Column(name = "distance")
    private Double distance;

    @Column(name = "sportsman_id")
    private Long sportsmanId;

    @Column(name = "average")
    private Double average;
}