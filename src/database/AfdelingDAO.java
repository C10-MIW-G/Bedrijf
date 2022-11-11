package database;

import model.Afdeling;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Haal Afdeling uit de Database en schrijf ze er in weg
 */
public class AfdelingDAO {
    private final DBaccess DB_ACCESS;

    public AfdelingDAO(DBaccess dBaccess) {
        this.DB_ACCESS = dBaccess;
    }

    public void slaAfdelingOp(Afdeling afdeling) {
        String sql = "INSERT INTO Afdeling VALUES (?, ?);";

        try {
            PreparedStatement preparedStatement = DB_ACCESS.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, afdeling.getAfdelingsNaam());
            preparedStatement.setString(2, afdeling.getAfdelingsPlaats());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }
    }

    public ArrayList<Afdeling> geefAfdelingen() {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        String sql = "SELECT afdelingsnaam, afdelingsplaats FROM Afdeling;";
        try {
            PreparedStatement preparedStatement = DB_ACCESS.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String afdelingsNaam = resultSet.getString(1);
                String afdelingsPlaats = resultSet.getString(2);
                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));
            }
        } catch (SQLException e) {
            System.out.println("Sql foutmelding: " + e.getMessage());
        }

        return afdelingen;
    }
}
