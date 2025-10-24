import java.sql.ResultSet;
import java.util.Scanner;

import java.sql.ResultSet;
import java.util.Scanner;

class SchemeService {

    static void addScheme() {
        Scanner sc = new Scanner(System.in);

        try {

            ResultSet rs = DatabaseConnection.resultSet("SELECT * FROM schemes");
            System.out.print("Enter scheme name: ");
            String scheme_name = sc.nextLine();

            boolean flag = false;
            while (rs.next()) {
                if (scheme_name.equalsIgnoreCase(rs.getString("scheme_name"))) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println(" Scheme already exists with this name.");
                return;
            }

            System.out.print("Enter eligible crop: ");
            String eligible_crop = sc.nextLine();

            System.out.print("Enter minimum land area: ");
            double min_land_area = Double.parseDouble(sc.nextLine());

            System.out.print("Enter maximum land area: ");
            double max_land_area = Double.parseDouble(sc.nextLine());

            System.out.print("Enter subsidy amount: ");
            double subsidy_amount = Double.parseDouble(sc.nextLine());

            System.out.print("Enter start date (YYYY-MM-DD): ");
            String start_date = sc.nextLine();

            System.out.print("Enter end date (YYYY-MM-DD): ");
            String end_date = sc.nextLine();

            String query = "INSERT INTO schemes (scheme_name, eligible_crop, min_land_area, max_land_area, subsidy_amount, start_date, end_date) "
                    +
                    "VALUES ('" + scheme_name + "','" + eligible_crop + "'," + min_land_area + "," + max_land_area + ","
                    + subsidy_amount + ",'" + start_date + "','" + end_date + "')";
            int res = DatabaseConnection.updateData(query);

            if (res > 0) {
                System.out.println("  Scheme added successfully");
            } else {
                System.out.println(" failed to add scheme.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   static void updateScheme() {
    Scanner sc = new Scanner(System.in);

    try {
        System.out.print("Enter scheme name to update: ");
        String scheme_name = sc.nextLine();
        ResultSet rs=DatabaseConnection.resultSet("select * from schemes");
        boolean exist=false;
        while(rs.next()){
            if(scheme_name.equalsIgnoreCase(rs.getString("scheme_name"))){
                exist=true;
            }
        }
        if(!exist){
            return;
        }

        System.out.print("Enter eligible crop: ");
        String eligible_crop = sc.nextLine();

        System.out.print("Enter minimum land area: ");
        double min_land_area = Double.parseDouble(sc.nextLine());

        System.out.print("Enter maximum land area: ");
        double max_land_area = Double.parseDouble(sc.nextLine());

        System.out.print("Enter subsidy amount: ");
        double subsidy_amount = Double.parseDouble(sc.nextLine());

        
        String query = "UPDATE schemes " +"SET eligible_crop = '" + eligible_crop + "', " +
                    "min_land_area = " + min_land_area + ", " +
                    "max_land_area = " + max_land_area + ", " +
                       "subsidy_amount = " + subsidy_amount + " " +
                       "WHERE scheme_name = '" + scheme_name + "'";

        int res = DatabaseConnection.updateData(query);

        if (res > 0) {
            System.out.println(" Scheme updated successfully!");
        } else {
            System.out.println(" Failed to update scheme. Check scheme name.");
        }

    } catch (Exception e) {
        System.out.println(  e.getMessage());
    }
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Scheme Management ===");
            System.out.println("1. Add New Scheme");
            System.out.println("2. Update Existing Scheme");

            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addScheme();
                    break;
                case 2:
                    updateScheme();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 0);
    }
}
