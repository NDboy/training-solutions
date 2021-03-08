package blob;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImagesDao {

    private DataSource source;

    public ImagesDao(DataSource source) {
        this.source = source;
    }

    public void saveImage(String fileName, InputStream is) {
        try (Connection connection = source.getConnection();
                PreparedStatement stmt = connection.prepareStatement("insert into images(filename, content) values (?,?)")){
            stmt.setString(1, fileName);
            Blob blob = connection.createBlob();
            fillBlob(is, blob);
            stmt.setBlob(2, blob);
            stmt.executeUpdate();

        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot insert image", se);
        }
    }

    private void fillBlob(InputStream is, Blob blob) throws SQLException {
        try (OutputStream os = blob.setBinaryStream(1)){
            is.transferTo(os);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not write blob", ioe);
        }
    }
}
