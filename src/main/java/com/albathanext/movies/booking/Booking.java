package com.albathanext.movies.booking;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private Status status;
    @NotNull
    private LocalDateTime time;

    public void setStatus(Status cancel) {
        this.status = cancel;
    }
}
