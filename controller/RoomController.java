package controller;

import java.util.List;
import view.RoomListView;
import model.RoomModel;

public class RoomController {
    private RoomListView roomListView;

    public RoomController(RoomListView roomListView) {
        this.roomListView = roomListView;
    }

    public void GETRoom() {
        List<RoomModel> rooms = RoomModel.getAllRooms();
        roomListView.displayRoomList(rooms);
    }

    public void GETRoomFilter() {
        String facultyId = roomListView.askFacultyId();
        String departmentId = roomListView.askDepartmentId();

        List<RoomModel> filteredRooms;
        if (!departmentId.isEmpty()) {
            filteredRooms = RoomModel.getRoomsByDepartment(departmentId);
        } else if (!facultyId.isEmpty()) {
            filteredRooms = RoomModel.getRoomsByFaculty(facultyId);
        } else {
            filteredRooms = RoomModel.getAllRooms();
        }
        roomListView.displayRoomList(filteredRooms);
    }
}