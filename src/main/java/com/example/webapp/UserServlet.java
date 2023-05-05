package com.example.webapp;

import Model.Student;
import PasswordHashing.HashPassword;
import Service.UserService;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String page = req.getParameter("page");

        if (page.equalsIgnoreCase("newUser")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/register.jsp");
            requestDispatcher.forward(req, resp);
        }

        if (page.equalsIgnoreCase("index")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);
        }

        if (page.equalsIgnoreCase("register")) {

            Student student = new Student();

            student.setUsername(req.getParameter("userName"));
            student.setAddress(req.getParameter("address"));
            student.setPassword(HashPassword.Hash(req.getParameter("password")) );

            new UserService().insertUser(student);
            System.out.println("data inserted: ");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);

//            System.out.println(student.getUsername());
//            System.out.println(student.getAddress());
//            System.out.println(student.getPassword());
//
//            req.getParameter("userName");
//            req.getParameter("address");
//            req.getParameter("password");
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
//            requestDispatcher.forward(req,resp);
        }
        if (page.equalsIgnoreCase("login")) {
            String name = req.getParameter("userName");
            String password = HashPassword.Hash(req.getParameter("password")) ;

            Student student = new UserService().getStudent(name, password);

            if (student != null) {
                HttpSession session = req.getSession();
                session.setAttribute("username", name);
                Cookie cookie = new Cookie("username", name);
                resp.addCookie(cookie);


                RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/dash.jsp");
                requestDispatcher.forward(req, resp);
            }
            else {
                printWriter.println("invalid credential");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
                requestDispatcher.include(req, resp);
            }

        }

        if (page.equalsIgnoreCase("userList")) {
            try {
                Student student =new Student();
                req.setAttribute("student",student);
                List<Student>studentList =new UserService().getStudentList();
                req.setAttribute("studentList",studentList);

            }catch (SQLException e){
                e.printStackTrace();
            }

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/userlist.jsp");
            requestDispatcher.forward(req, resp);
        }
        if (page.equalsIgnoreCase("dash")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/dash.jsp");
            requestDispatcher.forward(req, resp);
        }
        //logout

        if (page.equalsIgnoreCase("logout")) {

            //destroy session
            HttpSession session = req.getSession(false);
            session.invalidate();

            //destroy cookie
            Cookie cookie =new Cookie("username",null);
            cookie.setMaxAge(0);
            resp.addCookie(cookie);

            //logout
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);
        }
        if(page.equalsIgnoreCase("userDetails")){

            int id =Integer.parseInt(req.getParameter("id")) ;
            try{
              Student student =  new UserService().getStudentRow(id);
                req.setAttribute("student",student);
            }catch (SQLException e){
                e.printStackTrace();
            }
            req.setAttribute("id",id);
            System.out.println("id is " +id);

            RequestDispatcher requestDispatcher =req.getRequestDispatcher("pages/userDetails.jsp");
            requestDispatcher.forward(req,resp);
        }

        if(page.equalsIgnoreCase("deleteuser")){
            int id = Integer.parseInt(req.getParameter("id"));
            new UserService().deleteUser(id);

            List<Student>studentList = null;
            try {
                studentList = new UserService().getStudentList();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("studentList",studentList);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/userlist.jsp");
            requestDispatcher.forward(req,resp);
        }

        if(page.equalsIgnoreCase("userEditRow")) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("id",id);
            Student student = null;
            try {
                student = new UserService().getStudentRow(id);
                req.setAttribute("student",student);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/editUser.jsp");
            requestDispatcher.forward(req,resp);

        }

        if(page.equalsIgnoreCase("editUser")){
            Student student = new Student();
            int id=Integer.parseInt(req.getParameter("id"));
         student.setUsername(req.getParameter("username"));
         student.setAddress(req.getParameter("address"));
         student.setPassword(req.getParameter("password"));

            try {
                new UserService().editUser(id,student);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            List<Student>studentList = null;
            try {
             studentList = new UserService().getStudentList();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("studentList",studentList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/userlist.jsp");
            requestDispatcher.forward(req,resp);

        }
        if(page.equalsIgnoreCase("AddUser")){
            RequestDispatcher requestDispatcher =req.getRequestDispatcher("pages/addUser.jsp");
            requestDispatcher.forward(req,resp);
        }
        if(page.equalsIgnoreCase("addNewUser")){
            HttpSession session = req.getSession(false);
            Student student = new Student();

            student.setUsername(req.getParameter("username"));
            student.setAddress(req.getParameter("address"));
            student.setPassword(HashPassword.Hash(req.getParameter("password")));

            new UserService().insertUser(student);
        }
        List<Student>studentList = null;
        try {
            studentList = new UserService().getStudentList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("studentList",studentList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/userlist.jsp");
        requestDispatcher.forward(req,resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        doPost(req, resp);
    }
}