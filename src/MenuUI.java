import java.util.List;
import java.util.Scanner;

public class MenuUI {
    private final Scanner scanner;


    public MenuUI() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        System.out.println("Log in as admin [type 'admin'] or continue as guest? ");
        String userRights = scanner.nextLine();

        User user;
        if ("admin".equalsIgnoreCase(userRights)) {
            System.out.println("Type password for admin: ");
            String password = scanner.nextLine();
            if ("admin12345".equalsIgnoreCase(password)) {
                System.out.println("\nLogged in as admin");
                user = new Admin();
            } else {
                System.out.println("Wrong password, closing phonebook.");
            return; }
            } else {
                System.out.println("\nLogged in as guest");
                user = new Guest();
            }

            Phonebook phonebook = new Phonebook();

            while (true) {
                System.out.println("\nChoose your option");
                System.out.println("[1] - Add a contact");
                System.out.println("[2] - Delete a contact");
                System.out.println("[3] - Update a contact");
                System.out.println("[4] - Search for a contact");
                System.out.println("[5] - Print out phonebook");
                System.out.println("[6] - Quit the program");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        if (user.adminAdd()) {
                            System.out.println("firstname : ");
                            String firstname = scanner.nextLine();
                            System.out.println("Surname : ");
                            String surname = scanner.nextLine();
                            System.out.println("age : ");
                            int age = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("city: ");
                            String city = scanner.nextLine();
                            System.out.println("postcode: ");
                            String postcode = scanner.nextLine();
                            System.out.println("streetname: ");
                            String streetname = scanner.nextLine();
                            System.out.println("doornumber: ");
                            String doornumber = scanner.nextLine();

                            Adress adress = new Adress.Builder()
                                    .withCity(city)
                                    .withPostcode(postcode)
                                    .withStreetname(streetname)
                                    .withDoornumber(doornumber)
                                    .build();

                            System.out.println("private phonenumber: ");
                            String phonenumberOne = scanner.nextLine();
                            System.out.println("work phonenumber: ");
                            String phonenumberTwo = scanner.nextLine();

                            Contactinfo contact = new Contactinfo(firstname, surname, age, adress, phonenumberOne, phonenumberTwo);
                            phonebook.addContact(contact);
                        } else {
                            System.out.println("\nYou need to be logged in as admin to add a contact");
                        }
                        break;
                    case 2:
                        if (user.adminDelete()) {
                            System.out.println("Type the Surname of the contact you want to delete: ");
                            String deleteSurname = scanner.nextLine();
                            phonebook.deleteContact(deleteSurname);
                        } else {
                            System.out.println("\nYou need to be logged in as admin to remove a contact");
                        }
                        break;
                    case 3:
                        if (user.adminUpdate()) {
                            System.out.println("Type the surname of the contact you want to update: ");
                            String oldSurename = scanner.nextLine();

                            Contactinfo contactToUpdate = phonebook.findContactBySurname(oldSurename);
                            if (contactToUpdate == null) {
                                System.out.println("No match with that surname in the phonebook");
                                break;
                            }
                            System.out.println("Type what info you want to update " +
                                    "[firstname] [surname] [age] [phonenumber] [adress]");
                            String UpdateChoice = scanner.nextLine();

                            if ("firstname".equalsIgnoreCase(UpdateChoice)) {
                                System.out.println("Type the new firstname for the contact");
                                String newFirstname = scanner.nextLine();
                                phonebook.updateContactFirstname(contactToUpdate, newFirstname);
                            } else if
                            ("surname".equalsIgnoreCase(UpdateChoice)) {
                                System.out.println("Type the new surname for the contact");
                                String newSurname = scanner.nextLine();
                                phonebook.updateContactSurname(contactToUpdate, newSurname);
                            } else if
                            ("age".equalsIgnoreCase(UpdateChoice)) {
                                System.out.println("Type the new age for the contact");
                                int newAge = scanner.nextInt();
                                scanner.nextLine();
                                phonebook.updateContactAge(contactToUpdate, newAge);
                            } else if
                            ("phonenumber".equalsIgnoreCase(UpdateChoice)) {
                                System.out.println("Type the new phonenumber for the contact");
                                String newPhonenumber = scanner.nextLine();
                                phonebook.updateContactPhonenumber(contactToUpdate, newPhonenumber);
                            } else if
                            ("adress".equalsIgnoreCase(UpdateChoice)) {
                                System.out.println("Type the new adress [city, postcode, streetname, doornumber] for the contact");
                                System.out.println("city: ");
                                String city = scanner.nextLine();
                                System.out.println("postcode: ");
                                String postcode = scanner.nextLine();
                                System.out.println("streetname: ");
                                String streetname = scanner.nextLine();
                                System.out.println("doornumber: ");
                                String doornumber = scanner.nextLine();

                                Adress newAdress = new Adress.Builder()
                                        .withCity(city)
                                        .withPostcode(postcode)
                                        .withStreetname(streetname)
                                        .withDoornumber(doornumber)
                                        .build();
                                phonebook.updateContactAdress(contactToUpdate, newAdress);
                            }
                        }
                        else {
                            System.out.println("\nYou need to be logged in as admin to update a contact");
                        }
                        break;

                    case 4:
                        if (user.guestSearch()) {
                            System.out.println("Type the number of your choice of search" +
                                    "\n[1]-surname [2]-adress [3]-firstname [4]-free search ");
                            String searchChoice = scanner.nextLine();
                            System.out.println("Type what you want to search for");
                            String searchOption = scanner.nextLine();
                            List<Contactinfo> searchResults = phonebook.searchContacts(searchOption, searchChoice);
                            phonebook.printSearchResults(searchResults);
                        }
                        break;


                    case 5:
                        phonebook.printPhonebook();
                        break;


                    case 6:
                        System.out.println("Phonebook closed");
                        return;
                }
            }
        }
    }


