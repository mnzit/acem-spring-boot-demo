package com.acem.demo.model;

import javax.persistence.*;


@Entity
@Table(name = "ATTENDANCE")
public class Attendance {

        @Id
        @Column(name="ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name="NAME", length=100, nullable = false, unique = true)
        private String name;
        @Column(name="BATCH_ID", length=100, nullable = false, unique = false)
        private int batchId;
        @Column(name="COURSE_ID", length=100, nullable = false, unique = false)
        private int courseId;
        @Column(name="DATA", length=100, nullable = false, unique = false)
        private Boolean attendance;



    public Attendance(Long id, String name, int batchId, int courseId, Boolean attendance) {
            this.id = id;
            this.name = name;
            this.batchId = batchId;
            this.courseId = courseId;
            this.attendance = attendance;
        }

    public Attendance() {
    }

    public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
        this.name = name;
    }

        public int getBatchId() { return batchId; }
        public void setBatchId(int batchId) { this.batchId = batchId; }

        public int getCourseId() { return courseId; }
        public void setCourseId(int batchId) { this.batchId = courseId; }
        public Boolean getAttendance() {
            return attendance;
        }
        public void setAttendance(Boolean attendance) {
            this.attendance = attendance;
        }


        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", batch id='" + batchId + '\'' +
                    ", course id='" + courseId + '\'' +
                    ", attendance='" + String.valueOf(this.getAttendance()) + '\'' +
                    '}';
        }
}
