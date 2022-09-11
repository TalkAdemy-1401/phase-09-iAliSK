package com.alisk.chatroom.service;

import com.alisk.chatroom.model.report.GeneralReport;
import com.alisk.chatroom.model.report.Report;
import com.alisk.chatroom.model.report.RoomReport;
import com.alisk.chatroom.model.report.UserReport;
import com.alisk.chatroom.repository.MessageRepository;
import com.alisk.chatroom.repository.RoomRepository;
import com.alisk.chatroom.repository.UserRepository;
import com.alisk.chatroom.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {

    private final UserRepository userRepo;
    private final RoomRepository roomRepo;
    private final MessageRepository messageRepo;

    @Value("${report.location}")
    private String reportLoc;

    // This method might be better moved to an Invoker Class
    @Override
    @Scheduled(cron = "0 0 1 * * MON")
    public void generateReport() {
        Report report = Report.builder()
                .reportId(System.currentTimeMillis())
                .createdAt(LocalDateTime.now())
                .generalReport(getGeneralReport())
                .roomsReport(getRoomsReport())
                .usersReport(getUsersReport())
                .build();

        String json = Mapper.mapToJson(report);
        File file = new File(reportLoc.replace("{reportId}", report.getReportId().toString()));

        PrintWriter out = null;
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();

            out = new PrintWriter(new FileWriter(file));
            out.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) out.close();
        }
    }

    @Override
    public Set<RoomReport> getRoomsReport() {

        Set<RoomReport> roomReports = new HashSet<>();

        roomRepo.findAll().forEach(room -> {
            roomReports.add(RoomReport.builder()
                    .roomId(room.getId())
                    .members(room.getMembers().size())
                    .messages(messageRepo.countByRoomId(room.getId()))
                    .build());
        });

        return roomReports;
    }

    @Override
    public Set<UserReport> getUsersReport() {

        Set<UserReport> userReports = new HashSet<>();

        userRepo.findAll().forEach(user -> {
            userReports.add(UserReport.builder()
                    .userId(user.getId())
                    .messages(messageRepo.countBySenderId(user.getId()))
                    .build());
        });

        return userReports;
    }

    @Override
    public GeneralReport getGeneralReport() {
        return GeneralReport.builder()
                .totalUsers((int) userRepo.count())
                .totalRooms((int) roomRepo.count())
                .totalMessages((int) messageRepo.count())
                .build();
    }

}
