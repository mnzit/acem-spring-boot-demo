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
        private String batchId;
        @Column(name="COURSE_ID", length=100, nullable = false, unique = false)
        private String courseId;
        @Column(name="DATA", length=100, nullable = false, unique = false)
        private String data;

    public Attendance(Long id, String name, String batchId, String courseId, String data) {
            this.id = id;
            this.name = name;
            this.batchId = batchId;
            this.courseId = courseId;
            this.data = data;
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
        public String getBatchId() { return batchId; }
        public void setBatchId(String batchId) { this.batchId = batchId; }
        public String getCourseId() { return courseId; }
        public void setCourseId(String batchId) { this.batchId = courseId; }
        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data = data;
        }
        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", batch id='" + batchId + '\'' +
                    ", course id='" + courseId + '\'' +
                    ", attendance='" + String.valueOf(this.getData()) + '\'' +
                    '}';
        }
}
