package com.acem.demo.request;

import com.acem.demo.entity.enums.AttendanceStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class AttendanceRequest implements Serializable {

    private Long id;
    private AttendanceStatus status;
}
