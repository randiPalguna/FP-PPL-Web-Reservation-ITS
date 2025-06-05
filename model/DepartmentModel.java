package model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentModel {
    private String departmentId;
    private String departmentName;
    private String facultyId;

    private static final List<DepartmentModel> departments = new ArrayList<>();

    public DepartmentModel(String departmentId, String departmentName, String facultyId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.facultyId = facultyId;
    }

    public String getDepartmentId() { return departmentId; }
    public String getDepartmentName() { return departmentName; }
    public String getFacultyId() { return facultyId; }

    public static void addDepartment(DepartmentModel department) {
        departments.add(department);
    }

    public static List<DepartmentModel> getAllDepartments() {
        return new ArrayList<>(departments);
    }
}