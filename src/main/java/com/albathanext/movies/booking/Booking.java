package com.albathanext.movies.booking;

import com.albathanext.movies.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private Status status=Status.active;

    @NotNull
    private LocalDate dateTime;

    @NotNull
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Movie movie;

    @NotNull
    private String venu;

    @NotNull
    private Integer numberofPerson;

}
