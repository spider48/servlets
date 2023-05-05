package Service;

import DBConnection.DBConnection;
import Model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public void insertUser(Student student){
        String query = "insert into student(userName,address,password)" + "Values(?,?,?)";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1,student.getUsername());
            preparedStatement.setString(2,student.getAddress());
            preparedStatement.setString(3,student.getPassword());
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }



    }
    public Student getStudent(String username,String password){

        Student student = null;
     String query ="select * from student  where userName=? and password =?";
     PreparedStatement preparedStatement = new DBConnection().getStatement(query);
     try{
         preparedStatement.setString(1,username);
         preparedStatement.setString(2,password);

         ResultSet resultSet = preparedStatement.executeQuery();
         while (resultSet.next()){
             student =new Student();
             student.setId(resultSet.getInt("id"));
             student.setUsername(resultSet.getString("username"));
             student.setAddress(resultSet.getString("address"));
             student.setPassword(resultSet.getString("password"));
         }
     } catch (SQLException e){
         e.printStackTrace();
     }

     return student;

    }

    //deleteuser
    public void deleteUser(int id){
        String query ="delete from student where id=?";
        PreparedStatement preparedStatement = new  DBConnection().getStatement(query);

        try {
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
       //edit
    public void  editUser(int id,Student student) throws SQLException {
        String query ="update student set username=?, address=? , password=? " + "where id = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

//        Student student = new Student();
        preparedStatement.setString(1,student.getUsername());
       preparedStatement.setString(2,student.getAddress());
       preparedStatement.setString(3,student.getPassword());
       preparedStatement.setInt(4,id);
       preparedStatement.execute();


//        return (List<Student>) student;
    }
    public List<Student>getStudentList() throws SQLException{

        List<Student>studentList = new ArrayList<>();
        String query ="select * from student";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setUsername(resultSet.getString("userName"));
            student.setAddress(resultSet.getString("address"));
            student.setPassword(resultSet.getString("password"));
            studentList.add(student);
        }
        return studentList;
    }

    public Student getStudentRow(int id) throws SQLException {
        Student student =new Student();
        String query="select * from student where id=? ";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            student.setId(resultSet.getInt("id"));
            student.setUsername(resultSet.getString("userName"));
            student.setAddress(resultSet.getString("address"));
            student.setPassword(resultSet.getString("password"));

        }
        return student;
    }



}
