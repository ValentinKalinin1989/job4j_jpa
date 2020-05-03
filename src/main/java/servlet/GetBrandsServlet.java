package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import persistence.InteracWithDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/brands")
public class GetBrandsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InteracWithDB interacWithDB = new InteracWithDB();
        ObjectMapper mapper = new ObjectMapper();
        List<String> branList = interacWithDB.getAllUniqBrands();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println(mapper.writeValueAsString(branList));
        writer.flush();
    }
}
