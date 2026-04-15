public class Main {
    public static void main(String[] args) {

        UserRepository repo = new UserRepository();

        // User valid
        try {
            User user1 = new User("testuser", 25);
            repo.addUser(user1);
            System.out.println("User adăugat cu succes!");
        } catch (InvalidUserDataException e) {
            System.out.println("Eroare: " + e.getMessage());
        }

        // Admin valid
        try {
            AdminUser admin = new AdminUser("admin", 30, "full_access");
            repo.addUser(admin);
            System.out.println("Admin adăugat cu succes!");
        } catch (InvalidUserDataException e) {
            System.out.println("Eroare: " + e.getMessage());
        }

        // Username prea scurt
        try {
            User user2 = new User("ab", 22);
            repo.addUser(user2);
        } catch (InvalidUserDataException e) {
            System.out.println("Eroare: " + e.getMessage());
        }

        // Age negativ
        try {
            User user3 = new User("baduser", -5);
            repo.addUser(user3);
        } catch (InvalidUserDataException e) {
            System.out.println("Eroare: " + e.getMessage());
        }

        // Afișare utilizatori validați
        System.out.println("\nLista utilizatorilor validați:");
        for (User user : repo.getUsers()) {
            System.out.println(user);
        }
    }
}