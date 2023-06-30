package Main;

import controller.DiaryController;
import dtos.request.DiaryRequest;

import javax.swing.*;
import java.time.LocalDate;

public class DiaryMain {
    private static final DiaryController controller = new DiaryController();

    public static void main(String[] args) {

        displayMenu();

    }
            private static void displayMenu(){
                String menu = """
                        Welcome to diary
                        1 -> Add Entry
                        2 -> Edit Entry
                        3 -> Delete Entry
                        4 -> View Entry
                        5 -> View All Entries
                        6 -> delete All Entries
                        7 -> Exit
                        """;
                String userInput = collectStringInput(menu);
                switch (userInput.charAt(0)){
                    case '1' -> createEntry();
                    case '2' -> editEntry();
                    case '3' -> deleteEntry();
                    case '4' -> viewEntry();
                    case '5' -> viewAllEntries();
                    case '6' -> deleteAllEntries();
                    case '7' -> System.exit(0);
                    default -> {
                        display("Invalid input");
                        displayMenu();
                    }
                }

            }
            private static void createEntry(){
                DiaryRequest request = new DiaryRequest();
                String title = collectStringInput("Enter your entry title");
                request.setTitle(title);
                String content = collectStringInput("Enter entry content");
                request.setContent(content);
                 LocalDate.now();
                controller.saveEntry(request);
                display("Title : " + title + "\nContent : " + content + "\nDate : " + LocalDate.now() + "\nEntry created successfully");
                displayMenu();
            }
            private static void editEntry(){
                DiaryRequest request = new DiaryRequest();
                int id =  Integer.parseInt(collectStringInput("Enter the id of the entry you wish to edit"));
                request.setId(id);
                String title = collectStringInput("Enter your entry title");
                request.setTitle(title);
                String content = collectStringInput("Enter entry content");
                request.setContent(content);

                controller.updateEntry(request);
                display("Title : " + title + "\nContent : " + content + "\nDate : " + LocalDate.now() + "\nEntry successfully updated");
                displayMenu();
            }
            private static void deleteEntry(){
                int id = Integer.parseInt(collectStringInput("Enter the id of Enter you wish to delete"));
                controller.deleteById(id);
                display("Entry at  id " + id +" successfully deleted");
                displayMenu();
            }
            private static void viewEntry(){
                int id = Integer.parseInt(collectStringInput("Enter the id of entry you wish to view"));
                controller.viewDiaryEntry(id);
                display("This is the entry at id " + id);
                displayMenu();
            }
            private static void viewAllEntries(){
                controller.listDiaryEntries();
                display("Your entries list " + LocalDate.now());
                displayMenu();
            }
            private static void deleteAllEntries(){
                String response = collectStringInput("Are you sure you want to delete all your entries ?\nYes           No");
                if (response.equalsIgnoreCase("yes")){
                    controller.deleteAllDiaryEntries();
                    display("All entries deleted");
                }else {
                    displayMenu();
                }
                displayMenu();
            }
            private static String collectStringInput(String prompt){
                return JOptionPane.showInputDialog(prompt);
            }
            private static void display(String message){
                JOptionPane.showMessageDialog(null, message);
            }
        }

