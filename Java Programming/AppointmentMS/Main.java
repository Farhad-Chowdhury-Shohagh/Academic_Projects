package AppointmentManagerProject;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AppointmentManager manager = new AppointmentManager();

        manager.addAppointment("Farhad", "Haircut", LocalDateTime.of(2025, 5, 14, 10, 0), "Regular trim");
        manager.addAppointment("Hasib", "Massage", LocalDateTime.of(2025, 5, 14, 11, 0), "Back pain relief");
        manager.addAppointment("Nadir", "Facial", LocalDateTime.of(2025, 5, 14, 10, 0), "Anti-aging");

        manager.printUpcomingAppointments();

        manager.updateAppointment(2, "Noman", "Deep Tissue Massage", LocalDateTime.of(2025, 5, 14, 12, 0), "New time");

        manager.printUpcomingAppointments();

        manager.deleteAppointment(1);

        manager.printUpcomingAppointments();
    }
}

