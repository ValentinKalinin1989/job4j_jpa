package servlet;

import entities.address.Address;
import entities.car.Drive;
import entities.car.GearBox;
import entities.car.TypeBody;
import entities.car.TypeEngine;
import persistence.InteracWithDB;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cars")
public class GetCarsServlet extends HttpServlet {
    private final InteracWithDB interacWithDB = new InteracWithDB();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        String string = interacWithDB.getAllCarsInJson();
        writer.println(string);
        writer.flush();
    }

    /*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        TypeBody typeBody = TypeBody.valueOf(request.getParameter("typeBody"));
        GearBox gearBox = GearBox.valueOf(request.getParameter("gearBox"));
        TypeEngine typeEngine = TypeEngine.valueOf(request.getParameter("typeEngine"));
        Drive drive = Drive.valueOf(request.getParameter("drive"));
        float volumeEngine = Float.parseFloat(request.getParameter("volumeEngine"));
        int yearOfRelease = Integer.parseInt(request.getParameter("yearOfRelease"));
        int millage = Integer.parseInt(request.getParameter("millage"));
        int price = Integer.parseInt(request.getParameter("price"));
        String vin = request.getParameter("vin");
        String state = request.getParameter("state");
        String town = request.getParameter("town");
        //imageData           byte[]

        //try to save in DB
        EntityManager manager = Persistence.createEntityManagerFactory("car").createEntityManager();
        manager.getTransaction().begin();
        Address addressFirst = new Address(state, town);
        manager.persist(addressFirst);
        manager.getTransaction().commit();
        manager.close();
       // request.getRequestDispatcher("WEB-INF/index.html");
    }
     */
}
