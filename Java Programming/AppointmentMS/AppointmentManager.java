package AppointmentManagerProject;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

class AppointmentManager {
    private final List<Appointment> appointments = new ArrayList<>();

    public boolean addAppointment(String clientName, String serviceType, LocalDateTime dateTime, String notes) {
        if (hasConflict(dateTime)) {
            System.out.println("Conflict detected! Appointment not added.");
            return false;
        }
        appointments.add(new Appointment(clientName, serviceType, dateTime, notes));
        return true;
    }

    public List<Appointment> getAllAppointments() {
        return appointments.stream()
                .sorted(Comparator.comparing(Appointment::getDateTime))
                .collect(Collectors.toList());
    }

    public boolean updateAppointment(int id, String clientName, String serviceType, LocalDateTime dateTime, String notes) {
        Appointment appt = findById(id);
        if (appt == null)
            return false;

        if (!appt.getDateTime().equals(dateTime) && hasConflict(dateTime)) {
            System.out.println("⚠️ Conflict detected! Update canceled.");
            return false;
        }

        appt.setClientName(clientName);
        appt.setServiceType(serviceType);
        appt.setDateTime(dateTime);
        appt.setNotes(notes);
        return true;
    }

    public boolean deleteAppointment(int id) {
        return appointments.removeIf(appt -> appt.getId() == id);
    }

    private boolean hasConflict(LocalDateTime dateTime) {
        for (Appointment appt : appointments) {
            if (appt.getDateTime().equals(dateTime)) {
                return true;
            }
        }
        return false;
    }

    private Appointment findById(int id) {
        return appointments.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public void printUpcomingAppointments() {
        List<Appointment> upcoming = getAllAppointments();
        System.out.println("Upcoming Appointments:   ");
        for (Appointment a : upcoming) {
            System.out.println(a);
        }
    }
}
