package com.start;

import com.student.manage.Student;
import com.student.manage.Student_Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class start1 {
    public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    System.out.println(" Welcome to Student Management App ");
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    while(true) {
        System.out.println("PRESS 1 to ADD student");
        System.out.println("PRESS 2 to DELETE student");
        System.out.println("PRESS 3 to DISPLAY student");
        System.out.println("PRESS 4 TO UPDATE");
        System.out.println("PRESS 5 to EXIT app");
        int c=Integer.parseInt(br.readLine());

        if(c==1)
        {
            //add student..
            System.out.println("Enter user name :");
            String name=br.readLine();

            System.out.println("Enter user phone :");
            String phone=br.readLine();

            System.out.println("Enter user city :");
            String city=br.readLine();

            //create student object to store student
            Student st =new Student(name, phone, city);
             Student_Dao StudentDao;
            boolean answer= Student_Dao.insertStudentToDatabase(st);
            if(answer) {
                System.out.println("Student is added successfully...");
            }
            else {
                System.out.println("Something went Wrong try again....");
            }
            System.out.println(st);

        }
        else if(c==2)
        {
            //delete student..
            System.out.println("Enter Student id to delete: ");
            int userId=Integer.parseInt(br.readLine());
           boolean f= Student_Dao.deleteStudent(userId);
           if(f){
               System.out.println("Deleted");
           }else
           {
               System.out.println("Something went Wrong.......");
           }
        }
        else if(c==3) {
            //display student..
            Student_Dao.showAllStudent();
        }

        else if(c==4) {
            //exit..
            break;
        }
        else {

        }
    }
    System.out.println("Thank you for using my application...........");
    System.out.println("See you soon...bye-bye..........");
}
}

