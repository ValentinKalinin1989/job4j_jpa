package servlet;

import entities.address.Address;
import entities.car.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/save")
public class SaveCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        //получение даных из request
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items;
        Map<String, String> mapItems = new HashMap<>(10);
        byte[] imageData = null;
        //получение даных из request
        try {
            request.setCharacterEncoding("UTF-8");
            items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    System.out.println("Имя: " + item.getFieldName() + "  Содержимое : " + Streams.asString(item.getInputStream(), "UTF-8"));
                    mapItems.put(item.getFieldName(), Streams.asString(item.getInputStream(), "UTF-8"));
                } else {
                    imageData = item.getInputStream().readAllBytes();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        String state = mapItems.get("state"); 
        String town = mapItems.get("town");

        EntityManager manager = Persistence.createEntityManagerFactory("car").createEntityManager();
        manager.getTransaction().begin();
        Car newCar = new Car(
                mapItems.get("brand"),
                mapItems.get("model"),
                TypeBody.valueOf(mapItems.get("typeBody")),
                GearBox.valueOf(mapItems.get("gearBox")),
                TypeEngine.valueOf(mapItems.get("typeEngine")),
                Drive.valueOf(mapItems.get("drive")),
                Float.parseFloat(mapItems.get("volumeEngine")),
                Integer.parseInt(mapItems.get("yearOfRelease")),
                Integer.parseInt(mapItems.get("millage")),
                Integer.parseInt(mapItems.get("price")),
                mapItems.get("vin"),
                imageData,
                LocalDate.now(),
                StatusCar.SALES,
                mapItems.get("description")
        );
        Address addressFirst = new Address(state, town);
        newCar.setAddress(addressFirst);
        manager.persist(newCar);
        manager.getTransaction().commit();
        manager.close();

        request.getRequestDispatcher("index.html").forward(request, response);
    }
}

