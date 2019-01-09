package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phonenum = req.getParameter("phonenum");
        String sex = req.getParameter("sex");
        System.out.println(username);
        System.out.println(password);
        System.out.println(phonenum);
        System.out.println(sex);
        String un="[a-zA-Z0-9]{4,14}";
        String ph="[1-9][35789][0-9]{9}";
        String pa="[a-zA-Z0-9\\.\\*\\$]{6,15}";

        if (username.matches(un) && phonenum.matches(ph) && password.matches(pa)) {
            BigInteger phIn = new BigInteger(phonenum);
            int phnum = phIn.intValue();
            try (Connection conn = jdbcUtils.getConnection()) {
                String sql = "insert into  information(id,username,sex,phonenum,password) values(null,?,?,?,?)";
                try (PreparedStatement prst = conn.prepareStatement(sql)) {
                    prst.setString(1,username);
                    prst.setString(2,sex);
                    prst.setInt(3,phnum);
                    prst.setString(4,password);
                    int rows = prst.executeUpdate();
                    System.out.println("影像行数："+rows);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
