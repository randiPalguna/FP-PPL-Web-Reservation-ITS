package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomModel {
    private String roomId;
    private String roomName;
    private String facultyId;
    private String departmentId;

    private static final List<RoomModel> rooms = new ArrayList<>();

    public RoomModel(String roomId, String roomName, String facultyId, String departmentId) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.facultyId = facultyId;
        this.departmentId = departmentId;
    }

    public String getRoomId() { return roomId; }
    public String getRoomName() { return roomName; }
    public String getFacultyId() { return facultyId; }
    public String getDepartmentId() { return departmentId; }

    public static void addRoom(RoomModel room) {
        rooms.add(room);
    }

    public static List<RoomModel> getAllRooms() {
        return new ArrayList<>(rooms);
    }

    public static List<RoomModel> getRoomsByFaculty(String facultyId) {
        return rooms.stream()
            .filter(r -> r.getFacultyId().equalsIgnoreCase(facultyId))
            .collect(Collectors.toList());
    }

    public static List<RoomModel> getRoomsByDepartment(String departmentId) {
        return rooms.stream()
            .filter(r -> r.getDepartmentId().equalsIgnoreCase(departmentId))
            .collect(Collectors.toList());
    }
}