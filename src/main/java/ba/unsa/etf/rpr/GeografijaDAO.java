package ba.unsa.etf.rpr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {
    private static GeografijaDAO ref;
    private String url= "jdbc:sqlite:resources/data.db";
    private Connection conn;
    private Statement stmt;

    private GeografijaDAO() throws SQLException {
        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM grad;");
            stmt.executeUpdate("DELETE FROM drzava;");
            stmt.executeUpdate("INSERT INTO grad VALUES (1,'Sarajevo',275524,1),(2,'Zenica',146603,1),(3,'Berlin',3645000,2);");
            stmt.executeUpdate("INSERT INTO drzava VALUES (1,'Bosna i Hercegovina',1),(2,'Njemacka',3);");
        }
        catch(SQLException e){
            generisiBazu();
            stmt.executeUpdate("DELETE FROM grad;");
            stmt.executeUpdate("DELETE FROM drzava;");
            stmt.executeUpdate("INSERT INTO grad VALUES (1,'Sarajevo',275524,1),(2,'Zenica',146603,1),(3,'Berlin',3645000,2);");
            stmt.executeUpdate("INSERT INTO drzava VALUES (1,'Bosna i Hercegovina',1),(2,'Njemacka',3);");
        }
    }

    private void generisiBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("resources/data.db..sql"));
            String sqlUpit = "";
            Statement stmt = conn.createStatement();
            while (ulaz.hasNext()) {
                sqlUpit += ulaz.nextLine();
                if ( sqlUpit.length() > 1 && sqlUpit.charAt( sqlUpit.length()-1 ) == ';') {
                    try {
                        stmt.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } ulaz.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ne postoji SQL datoteka... nastavljam sa praznom bazom");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static GeografijaDAO getInstance() throws SQLException {
        if(ref==null) ref = new GeografijaDAO();
        return ref;
    }

    public static void removeInstance() throws SQLException { ref.conn.close(); ref = null; }

    ArrayList<Grad> gradovi() throws SQLException {
        ArrayList<Grad> list=new ArrayList<>();
        ResultSet res=stmt.executeQuery("SELECT g.naziv, g.broj_stanovnika, d.naziv FROM grad g, drzava d WHERE g.drzava==d.id ORDER BY g.broj_stanovnika DESC;");
        while(res.next()) {
            list.add(new Grad(res.getString(1),res.getInt(2),res.getString(3)));
        };
        return list;
    }

    Grad glavniGrad(String drzava) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT g.naziv,g.broj_stanovnika FROM grad g, drzava d WHERE d.naziv=? AND d.glavni_grad=g.id");
        try{
            ps.setString(1,drzava);
            ResultSet result = ps.executeQuery();
            return new Grad(result.getString(1),result.getInt(2),drzava);
        }
        catch (SQLException e){
            System.out.println("Nepostojeca drzava!");
            return null;
        }
    }

    void obrisiDrzavu(String drzava) throws SQLException {
        try{
            PreparedStatement ps1 = conn.prepareStatement("SELECT id FROM drzava WHERE naziv=?");
            ps1.setString(1,drzava);
            ResultSet idQuery= ps1.executeQuery();
            int id=idQuery.getInt(1);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM drzava WHERE naziv=?");
            ps.setString(1,drzava);
            ps.executeUpdate();
            stmt.executeUpdate("DELETE FROM grad WHERE drzava="+id);
        }
        catch (SQLException e){
            System.out.println("Nepostojeca drzava!");
        }
    }

    void dodajGrad(Grad grad) throws SQLException {
        ResultSet idQuery=stmt.executeQuery("SELECT id FROM grad ORDER BY id DESC");
        int id= idQuery.getInt(1);
        int id_drz;
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT id FROM drzava WHERE naziv=?");
            ps.setString(1,grad.getDrzava());
            id_drz=ps.executeQuery().getInt(1);
        }
        catch (SQLException e){
            ResultSet id_drzQuery=stmt.executeQuery("SELECT id FROM drzava ORDER BY id DESC");
            id_drz= id_drzQuery.getInt(1)+1;
            PreparedStatement ps = conn.prepareStatement("INSERT INTO drzava VALUES (?,?,?)");
            ps.setInt(1,id_drz);
            ps.setString(2,grad.getDrzava());
            ps.setInt(3,id+1);
            ps.executeUpdate();
        }
        PreparedStatement ps = conn.prepareStatement("INSERT INTO grad VALUES (?,?,?,?)");
        ps.setInt(1,id+1);
        ps.setString(2,grad.getNaziv());
        ps.setInt(3,grad.getPopulacija());
        ps.setInt(4,id_drz);
        ps.executeUpdate();
    }

    void dodajDrzavu(Drzava drzava) throws SQLException {
        ResultSet idQuery=stmt.executeQuery("SELECT id FROM drzava ORDER BY id DESC");
        int id= idQuery.getInt(1);
        int id_grad;
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT id FROM grad WHERE naziv=?");
            ps.setString(1,drzava.getGlavni_grad());
            id_grad=ps.executeQuery().getInt(1);
        }
        catch (SQLException e){
            ResultSet id_gradQuery=stmt.executeQuery("SELECT id FROM grad ORDER BY id DESC");
            id_grad= id_gradQuery.getInt(1)+1;
            PreparedStatement ps = conn.prepareStatement("INSERT INTO grad VALUES (?,?,?,?)");
            ps.setInt(1,id_grad);
            ps.setString(2, drzava.getGlavni_grad());
            ps.setInt(3,0);
            ps.setInt(4,id+1);
            ps.executeUpdate();
        }
        PreparedStatement ps = conn.prepareStatement("INSERT INTO drzava VALUES (?,?,?)");
        ps.setInt(1,id+1);
        ps.setString(2,drzava.getNaziv());
        ps.setInt(3,id_grad);
        ps.executeUpdate();
    }

    void izmijeniGrad(Grad grad) throws SQLException {
        int id,id_drz;
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT id FROM grad WHERE naziv=?");
            ps.setString(1,grad.getNaziv());
            id=ps.executeQuery().getInt(1);
            PreparedStatement ps1 = conn.prepareStatement("SELECT id FROM drzava WHERE naziv=?");
            ps1.setString(1,grad.getDrzava());
            id_drz=ps1.executeQuery().getInt(1);
        } catch (SQLException e) {
            System.out.println("Nepostojeci grad");
            return;
        }
        stmt.executeUpdate("UPDATE grad SET naziv='"+grad.getNaziv()+"', broj_stanovnika="+grad.getPopulacija()+", drzava="+id_drz+" WHERE id="+id);
    }

    Drzava nadjiDrzavu(String drzava){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT d.naziv, g.naziv FROM drzava d, grad g WHERE d.naziv=? AND d.glavni_grad=g.id");
            ps.setString(1,drzava);
            ResultSet rez=ps.executeQuery();
            return new Drzava(rez.getString(1), rez.getString(2));
        }
        catch (SQLException e) {
            System.out.println("Nepostojeca drzava!");
        }
        return null;
    }
}
