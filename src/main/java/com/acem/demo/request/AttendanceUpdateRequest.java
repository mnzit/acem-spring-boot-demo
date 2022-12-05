package com.acem.demo.request;

import com.acem.demo.entity.enums.AttendanceStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class AttendanceUpdateRequest implements Serializable {

    private Long id;
    private Date date;
    private AttendanceStatus status;
}
