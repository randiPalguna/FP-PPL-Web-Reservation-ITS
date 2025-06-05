import controller.AuthController;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import model.UserModel;
import observer.AuthEventListener;
import observer.AuthEventManager;
import view.AuthView;
import view.ConsoleAuthView;

public class Main {
	public static void main(String[] args) {
		seedCivitasITSUsers();
		seedRoomData();
		registerAuthObservers();

		Scanner scanner = new Scanner(System.in);
		AuthView authView = new ConsoleAuthView(scanner);
		AuthController authController = new AuthController(authView);
		view.RoomListView roomListView = new view.RoomListView(scanner);
		controller.RoomController roomController = new controller.RoomController(roomListView);

		System.out.println("Welcome to Reservation Room ITS Web");

		boolean running = true;
		while (running) {
            System.out.println("\n--- Dashboard ---");
            System.out.println("/login		: Login");
            System.out.println("/register	: Register Non-Civitas ITS");
			System.out.println("/room\t\t: Lihat Daftar Ruangan");
			System.out.println("/logout		: Logout");
            System.out.print("Input Endpoint: ");

			String input = scanner.nextLine();

			switch (input) {
				case "/login" -> {
					authController.GETLogin();
					authController.POSTLogin();
				}
				case "/register" -> {
					authController.GETRegister();
					authController.POSTRegister();
				}
                case "/room" -> {
                    roomController.GETRoom();
                    roomController.GETRoomFilter();
                }
				case "/logout" -> {
					System.out.println("You have logged out.");
					running = false;
				}
			}
		}
		scanner.close();
	}

    public static void seedCivitasITSUsers() {
        UserModel.registerUser(
            "budi@its.ac.id",
            model.UserFactory.createUser("civitas", "civitas1", "Budi Santoso", "budi@its.ac.id", "budi123", "0512345678")
        );
        UserModel.registerUser(
            "sari@student.its.ac.id",
            model.UserFactory.createUser("civitas", "civitas2", "Sari Dewi", "sari@student.its.ac.id", "sari123", "5025231999")
        );
        UserModel.registerUser(
            "agus@student.its.ac.id",
            model.UserFactory.createUser("civitas", "civitas3", "Agus Wijaya", "agus@student.its.ac.id", "agus123", "502524020")
        );
    }

	public static void seedRoomData() {
	    model.FacultyModel.addFaculty(new model.FacultyModel("FTEIC", "Fakultas Teknologi Elektro dan Informatika Cerdas"));
	    model.FacultyModel.addFaculty(new model.FacultyModel("FTSPK", "Fakultas Teknik Sipil, Perencanaan, dan Kebumian"));

	    model.DepartmentModel.addDepartment(new model.DepartmentModel("IF", "Informatika", "FTEIC"));
	    model.DepartmentModel.addDepartment(new model.DepartmentModel("EL", "Teknik Elektro", "FTEIC"));
	    model.DepartmentModel.addDepartment(new model.DepartmentModel("TI", "Teknik Industri", "FTSPK"));

	    model.RoomModel.addRoom(new model.RoomModel("R101", "Ruang 101", "FTEIC", "IF"));
	    model.RoomModel.addRoom(new model.RoomModel("R102", "Ruang 102", "FTEIC", "EL"));
	    model.RoomModel.addRoom(new model.RoomModel("R201", "Ruang 201", "FTSPK", "TI"));
	}

	public static void registerAuthObservers() {
	    AuthEventManager.addListener(new AuthEventListener() {
	        @Override
	        public void onLogin(String email, boolean success) {
	            String msg = "[Observer] Login attempt for: " + email + " | Success: " + success;
	            System.out.println(msg);
	            logToFile(msg);
	        }

	        @Override
	        public void onRegister(String email, boolean success) {
	            String msg = "[Observer] Registration attempt for: " + email + " | Success: " + success;
	            System.out.println(msg);
	            logToFile(msg);
	        }
			
	        private void logToFile(String message) {
	            try (FileWriter fw = new FileWriter("log.txt", true)) {
	                fw.write(message + System.lineSeparator());
	            } catch (IOException e) {
	                System.err.println("Failed to write log: " + e.getMessage());
	            }
	        }
	    });
	}
}