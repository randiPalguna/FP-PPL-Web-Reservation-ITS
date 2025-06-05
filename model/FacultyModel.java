package model;

import java.util.ArrayList;
import java.util.List;

public class FacultyModel {
    private String facultyId;
    private String facultyName;

    private static final List<FacultyModel> faculties = new ArrayList<>();

    public FacultyModel(String facultyId, String facultyName) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
    }

    public String getFacultyId() { return facultyId; }
    public String getFacultyName() { return facultyName; }

    public static void addFaculty(FacultyModel faculty) {
        faculties.add(faculty);
    }

    public static List<FacultyModel> getAllFaculties() {
        return new ArrayList<>(faculties);
    }
}