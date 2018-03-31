
package application;
import java.sql.*;
public class LoginModel {
    Connection conection;
    public LoginModel () {
        conection = DBConnection.Connector();
        if (conection == null) {

            System.out.println("connection not successful");
            System.exit(1);}
    }

    public boolean isDbConnected() {
        try {
            return !conection.isClosed();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

//basic login to populate
    public boolean isLogin(String user) {
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        String query = "SELECT * FROM Project WHERE UserID = ?";
        //result = query_param(query, 's', [&UserID]);
        try {
            preparedStatement = conection.prepareStatement(query);
            //PreparedStatement.setString(1,user);
            result = preparedStatement.executeQuery();
            if (result == null) {
                return true;
            } else
                return false;

        }catch(SQLException e){
                return false;
        } finally {
            //preparedStatement.close();
            //result.close();
        }


        }
    }


