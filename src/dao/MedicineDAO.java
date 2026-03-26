package dao;

import util.DBConnection;
import java.sql.*;

public class MedicineDAO {

    public void addMedicine(String name, double price, int qty) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO medicines(name, price, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, qty);
            ps.executeUpdate();

            System.out.println("Medicine Added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewMedicines() {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM medicines";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\nID | Name | Price | Quantity");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDouble("price") + " | " +
                        rs.getInt("quantity")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sellMedicine(int id, int qty) {
        try (Connection con = DBConnection.getConnection()) {

            String check = "SELECT quantity FROM medicines WHERE id=?";
            PreparedStatement ps = con.prepareStatement(check);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int available = rs.getInt("quantity");

                if (available >= qty) {
                    String update = "UPDATE medicines SET quantity = quantity - ? WHERE id=?";
                    PreparedStatement ps2 = con.prepareStatement(update);
                    ps2.setInt(1, qty);
                    ps2.setInt(2, id);
                    ps2.executeUpdate();

                    System.out.println("Medicine Sold!");
                } else {
                    System.out.println("Not enough stock!");
                }

            } else {
                System.out.println("Medicine not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMedicine(int id) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "DELETE FROM medicines WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Medicine Deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}