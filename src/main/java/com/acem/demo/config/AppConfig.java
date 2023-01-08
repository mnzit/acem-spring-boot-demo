package com.acem.demo.config;

import com.acem.demo.response.AttendanceResponse;
import com.acem.demo.response.IdResponse;
import com.acem.demo.service.AttendanceService;
import com.acem.demo.service.EmailSenderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import javax.crypto.spec.SecretKeySpec;
import java.time.LocalDate;
import java.util.List;

@Configuration
@EnableScheduling
public class AppConfig {
    private final EmailSenderService senderService;
    private final AttendanceService attendanceService;

    public AppConfig(EmailSenderService senderService, AttendanceService attendanceService) {
        this.senderService = senderService;
        this.attendanceService = attendanceService;
    }

    @Bean
    public SecretKeySpec secretKey(){
        return new SecretKeySpec("123456789123456789123456789asdfg".getBytes(), "HmacSHA256");
    }

    @Scheduled(cron = "0 * * ? * *") //every minute
//    @Scheduled(cron = "0 0 12 28 * ?") //Every month on the 28th, at noon
    public void scheduleHolidayEntityUpdate() {
        System.out.println("Scheduled Task (Every Month) : Holiday entity updated");
        List<IdResponse> idResponseList=  attendanceService.getAllStudents();
        try{
            for(IdResponse user: idResponseList){
                Long id = user.getId();
                senderService.sendSimpleEmail(user.getEmail(),
                        "Attendance: " + LocalDate.now().getMonth().toString(),
                        createMailBody(attendanceService.getAttendanceOfStudentOfCurrentMonth(id)));
            }
        }catch (MailException ex){
            System.out.println(ex.getMessage());
        }
    }

    String createMailBody(List<AttendanceResponse> attendanceResponseList){
        StringBuilder stringBuilder = new StringBuilder();
        if(attendanceResponseList.isEmpty()){
            return "Empty Attendance List";
        }
        for(AttendanceResponse attendanceResponse: attendanceResponseList) {
            stringBuilder.append(attendanceResponse.getCreatedDate());
            stringBuilder.append("\t");
            stringBuilder.append(attendanceResponse.getState());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
