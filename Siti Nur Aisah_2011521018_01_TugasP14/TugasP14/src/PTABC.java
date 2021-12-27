import java.sql.*;

public interface PTABC {
    void menampilkandatabase() throws SQLException;
    void insertdata() throws SQLException;
    void ubahdata() throws SQLException;
    void delete();
    void searchdata() throws SQLException;
}

