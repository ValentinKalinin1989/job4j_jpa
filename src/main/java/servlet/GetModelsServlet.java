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

@WebServlet("/models")
public class GetModelsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InteracWithDB interacWithDB = new InteracWithDB();
        ObjectMapper mapper = new ObjectMapper();
        String brand = request.getParameter("brand");
        List<String> stateList = interacWithDB.getAllUniqModels(brand);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println(mapper.writeValueAsString(stateList));
        writer.flush();
    }
}
