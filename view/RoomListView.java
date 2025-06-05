package view;

import java.util.List;
import java.util.Scanner;
import model.RoomModel;

public class RoomListView {
    private Scanner scanner;

    public RoomListView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayRoomList(List<RoomModel> rooms) {
        System.out.println("\n--- Daftar Ruangan ---");
        if (rooms.isEmpty()) {
            System.out.println("Tidak ada ruangan ditemukan.");
        } else {
            for (RoomModel room : rooms) {
                System.out.println("ID: " + room.getRoomId() + " | Nama: " + room.getRoomName() +
                        " | Fakultas: " + room.getFacultyId() + " | Departemen: " + room.getDepartmentId());
            }
        }
    }

    public String askFacultyId() {
        System.out.print("Masukkan Faculty ID untuk filter (atau kosongkan): ");
        return scanner.nextLine();
    }

    public String askDepartmentId() {
        System.out.print("Masukkan Department ID untuk filter (atau kosongkan): ");
        return scanner.nextLine();
    }
}