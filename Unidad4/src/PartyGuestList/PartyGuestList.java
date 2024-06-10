package PartyGuestList;

import java.util.HashSet;
import java.util.Set;

public class PartyGuestList {

    Set<String> guestList;

    public PartyGuestList() {
        this.guestList = new HashSet<>();
    }

    public void addGuest(String guest) {
        this.guestList.add(guest);
    }

    public void removeGuest(String guest) {
        this.guestList.remove(guest);
    }

    public void isGuestInList(String guest) {
        String checked = this.guestList.contains(guest) ? "Si" : "No";
        System.out.println("El invidato " + guest + " se encuentra en la lista? : " + checked);

    }

    public void getTotalGuests() {
        System.out.println("La lista de invitados contiene: " + this.guestList.size() + " personas");
    }

    public void printGuestsList() {
        this.guestList.forEach(System.out::println);

    }
}
