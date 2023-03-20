/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.Major;
import dal.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.ClassDAO;
import model.MajorDAO;
import model.StudentDAO;

/**
 *
 * @author ADMIN
 */
public class StudentLoad extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Major> getAllMajor = new MajorDAO().getAllMajor();
        req.setAttribute("getAllMajor", getAllMajor);
        HttpSession session = req.getSession();
        session.setAttribute("majorid", getAllMajor);
        
        List<dal.Class> getAllClass = new ClassDAO().getAllClass();
        req.setAttribute("getAllClass", getAllClass);
        session.setAttribute("classid", getAllClass);
//        List<Student> getAll = new StudentDAO().getAllStudent();
//        req.setAttribute("getAll", getAll);
//        req.getRequestDispatcher("student.jsp").forward(req, resp);

// Truy vấn dữ liệu từ cơ sở dữ liệu
        List<Student> getAll = new StudentDAO().getAllStudent();

// Số lượng bản ghi trên mỗi trang
        int recordsPerPage = 5;

// Tính tổng số trang
        int totalNoOfPages = (int) Math.ceil(getAll.size() * 1.0 / recordsPerPage);

// Lấy trang hiện tại từ request
        String currentPageParam = req.getParameter("currentPage");
        int currentPage = 1; // giá trị mặc định là 1
        if (currentPageParam != null && !currentPageParam.isEmpty()) {
            currentPage = Integer.parseInt(currentPageParam);
        }

// Tính vị trí bắt đầu và kết thúc của trang hiện tại
        int startRecord = (currentPage - 1) * recordsPerPage;
        int endRecord;
        if(currentPage * recordsPerPage > getAll.size()) {
            endRecord = getAll.size();
        } else
        endRecord = startRecord + recordsPerPage;

// Lấy danh sách dữ liệu của trang hiện tại
        List<Student> currentPageDataList = getAll.subList(startRecord, endRecord);

// Truyền dữ liệu trang hiện tại và tổng số trang đến JSP
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalNoOfPages", totalNoOfPages);
        req.setAttribute("currentPageDataList", currentPageDataList);

// Forward request đến JSP
        req.getRequestDispatcher("student.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
