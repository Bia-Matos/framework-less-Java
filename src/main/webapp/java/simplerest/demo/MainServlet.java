package simplerest.demo;

import simplerest.demo.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Collectors;


public class MainServlet extends HttpServlet {

    private StudentService studentService;

    public MainServlet() {
        this.studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonResponse = this.studentService.getStudents();
        this.outputResponse(response, jsonResponse, 200);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        int status = HttpServletResponse.SC_CREATED;
        boolean isStudentCreated = this.studentService.createStudent(requestBody);
        if (!isStudentCreated) {
            status = HttpServletResponse.SC_BAD_REQUEST;
        }
        this.outputResponse(response, requestBody, status);
    }

    private void outputResponse(HttpServletResponse response, String payload, int status) {
        response.setHeader("Content-Type", "application/json");

        try {
            response.setStatus(status);
            if (payload != null) {
                OutputStream outputStream = response.getOutputStream();
                outputStream.write(payload.getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


