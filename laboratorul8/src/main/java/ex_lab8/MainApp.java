package ex_lab8;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class MainApp {

    public static void AfisarePersoane(Connection connection) {
        String sql = "select * from persoane";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next())
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ", varsta="
                        + rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AfisareExcursii(Connection connection) {
        String sql = "select * from excursii";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next())
                System.out.println("id=" + rs.getInt(2) + ", destinatia=" + rs.getString(3) + ", anul=" + rs.getObject(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void StergereExcursie(Connection connection,int id){
        String sql="delete from excursii where id_excursie=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int nr_randuri=ps.executeUpdate();
            if(nr_randuri>0){
                System.out.println("\nRANDURI AFECTATE="+nr_randuri);
            }
            else
                System.out.println("\nNU EXISTA ACEASTA EXCURSIE");

        }
        catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void StergerePersoana(Connection connection,int id){
        String sql="delete from persoane where id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int nr_randuri=ps.executeUpdate();
            if(nr_randuri>0){
                System.out.println("\nRANDURI AFECTATE"+nr_randuri);
            }
            else
                System.out.println("\nNU EXISTA ACEASTA PERSOANA");

        }
        catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void AdaugarePersoana(Connection connection, String nume, int varsta) {
        String sql="insert into persoane(nume,varsta) values (?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setString(1, nume);
            ps.setInt(2, varsta);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void AdaugareExcursie(Connection connection,int id, String destinatia, int anul) throws SQLException {
        String sql = "select COUNT(*) from persoane where id=?";
        String sql2="insert into excursii(id_persoana,destinatia,anul) values (?,?,?)";
        ResultSet rs;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            if (rs.getInt(1)==1)
            {
                PreparedStatement ps2 = connection.prepareStatement(sql2);
                ps2.setInt(1, id);
                ps2.setString(2, destinatia);
                ps2.setObject(3, anul);
                int nr_randuri = ps2.executeUpdate();
                System.out.println("\nRANDURI AFECTATE:" + nr_randuri);
            }
            else
                System.out.println("PERSOANA NU EXISTA!");
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }

    }

    public static void AfisareExcursiiPers(Connection connection) {
        String sql = "select p.id, p.nume, p.varsta, e.id_excursie, e.destinatia, e.anul  from persoane p left join excursii e on p.id=e.id_persoana";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next())
                if(rs.getInt(4)==0)
                    System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ", varsta="
                            + rs.getInt(3));
                else
                    System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ", varsta="
                            + rs.getInt(3)+", id_excursie=" + rs.getInt(4)+", destinatia="+rs.getString(5)+", anul="+rs.getObject(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int get_varsta(Connection connection,int id) {

        String sql="select varsta from persoane where id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
        return 0;
    }

    public static void ExcursiileUneiPersoane(Connection connection,String nume) {
        String sql1 = "select id from persoane where nume=?";
        String sql2 = "select id_excursie, destinatia, anul  from excursii where id_persoana=?";
        try (PreparedStatement ps=connection.prepareStatement(sql1)) {
            ps.setString(1, nume);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                PreparedStatement ps2 = connection.prepareStatement(sql2);
                ps2.setInt(1, rs.getInt(1));
                rs = ps2.executeQuery();
                while (rs.next())
                    System.out.println("id=" + rs.getInt(1) + ", destinatia=" + rs.getString(2) + ", anul=" + rs.getObject(3));
            }
            else
                System.out.println("NU EXISTA PERSOANA!");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AfisarePersoaneDestinatie(Connection connection,String destinatie) {
        String sql = "select id, nume, varsta from persoane p, excursii e where p.id=e.id_persoana and destinatia=?";
        try (PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setString(1, destinatie);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ", varsta="
                        + rs.getInt(3));
                while (rs.next())
                    System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ", varsta="
                            + rs.getInt(3));
            }
            else
                System.out.println("NU EXISTA DESTINATIA!");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AfisarePersoaneAn(Connection connection,int an) {
        String sql = "select id, nume, varsta from persoane p, excursii e where p.id=e.id_persoana and anul=?";
        try (PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, an);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ", varsta="
                        + rs.getInt(3));
                while (rs.next())
                    System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ", varsta="
                            + rs.getInt(3));
            }
            else
                System.out.println("NU SUNT EXCURSII IN ACEST AN!");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws SQLException, verificare_varsta {
        String url = "jdbc:mysql://localhost:3306/lab8";
        Connection connection = DriverManager.getConnection(url,"root","alexandra");
        Statement statement = connection.createStatement();
        Scanner scanner= new Scanner(System.in);
        String nume, destinatia;
        Integer OPT, varsta, id, anul;

        do {
            System.out.println("0.Iesire");
            System.out.println("1.Adăugarea unei persoane în tabela persoane");
            System.out.println("2.Adăugarea unei excursii în tabela excursii");
            System.out.println("3.Afișarea tuturor persoanelor şi pentru fiecare persoană a excursiilor în care a fost");
            System.out.println("4.Afișarea excursiilor în care a fost o persoană al cărei nume se citește de la tastatură");
            System.out.println("5.Afișarea tuturor persoanelor care au vizitat o anumita destinație");
            System.out.println("6.Afișarea persoanelor care au făcut excursii într-un an introdus ");
            System.out.println("7.Stergerea excursiE");
            System.out.println("8.Ștergerea unei persoane (împreună cu excursiile în care a fost)");
            System.out.println("DATI OPTIUNEA DORITA:");
            OPT=scanner.nextInt();

            switch (OPT) {
                case 0:
                    System.out.println("EXIT");
                    break;
                case 1:
                    System.out.println("DATI NUMELE PERSOANEI:");
                    nume= scanner.next();
                    try {
                        System.out.println("DATI VARSTA PERSOANEI:");
                        varsta = scanner.nextInt();
                        if(varsta<0 || varsta>120)
                            throw new verificare_varsta("VARSTA ESTE INCORECTA");
                        AdaugarePersoana(connection, nume, varsta);
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("TREBUIA CIFRE");
                        scanner.nextLine();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    AfisarePersoane(connection);
                    System.out.println("ID PERSOANA:");
                    id= scanner.nextInt();
                    System.out.println("DDESTINATIE EXCURSIE:");
                    destinatia= scanner.next();
                    try {
                        System.out.println("AnN EXCURSIE:");
                        anul = scanner.nextInt();
                        if(LocalDateTime.now().getYear()-get_varsta(connection,id)>anul && anul > LocalDateTime.now().getYear())
                            throw new verificare_AnulExcursiei("ANUL NU ESTE VERIFICAT");
                        AdaugareExcursie(connection, id, destinatia, anul);
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("TREBUIA CIFRE");
                        scanner.nextLine();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    AfisareExcursiiPers(connection);
                    break;
                case 4:
                    AfisarePersoane(connection);
                    System.out.println("DATI NUMELE PERSOANEI:");
                    nume= scanner.next();
                    ExcursiileUneiPersoane(connection, nume);

                    break;
                case 5:
                    AfisareExcursii(connection);
                    System.out.println("DATI DESTINATIA EXCURSIEI:");
                    destinatia= scanner.next();
                    AfisarePersoaneDestinatie(connection, destinatia);
                    break;
                case 6:
                    AfisareExcursii(connection);
                    try {
                        System.out.println("DATI ANUL EXCURSIEI:");
                        anul = scanner.nextInt();
                        if(anul > LocalDateTime.now().getYear())
                            throw new verificare_AnulExcursiei("ANUL NU ESTE VERIFICAT");
                        AfisarePersoaneAn(connection, anul);
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("TREBUIA CIFRE");
                        scanner.nextLine();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    AfisareExcursii(connection);
                    System.out.println("DATI ID-UL EXCURSIEI:");
                    id= scanner.nextInt();
                    StergerePersoana(connection, id);
                    break;
                case 8:
                    AfisarePersoane(connection);
                    System.out.println("DATI ID UL PERSOANEI:");
                    id= scanner.nextInt();
                    StergerePersoana(connection, id);
                    break;
                default:
                    System.out.println("NU EXISTA OPTIUNEA");
                    break;
            }


        }while(OPT!=0);
        connection.close();
        statement.close();
    }
}