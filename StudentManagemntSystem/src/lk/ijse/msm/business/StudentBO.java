/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.msm.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import lk.ijse.msm.db.DBConnection;
import lk.ijse.msm.dto.StudentDTO;

/**
 *
 * @author LAHIRU SASANKA
 */
public class StudentBO {
    private final static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final File file;
    private static final LinkedList<String> idList = new LinkedList<>();

    public StudentBO() {
        this.file = new File("User/DataFile/Student.txt");
    }
    
    
    public static void getStudent(StudentDTO studentDTO) throws Exception{
        FileWriter fw= new FileWriter("User/DataFile/Student.txt",true);
        int id=studentDTO.getSid();
        String name=studentDTO.getName();
        String address=studentDTO.getAddress();
        String email=studentDTO.getEmail();
        String tell=studentDTO.getTell();
        String rowLine = id+","+name+","+address+","+email+","+tell+"\n";
        fw.write(rowLine);
        fw.flush();
    }
    
    public static ArrayList<StudentDTO> getAllStudent() throws Exception{
        FileReader fr=new FileReader("User/DataFile/Student.txt");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<StudentDTO> studentDTOs=new ArrayList<>();
        String rowLine;
        while((rowLine=br.readLine())!=null){
            String[] rowData=rowLine.split(",");
            int id=Integer.parseInt(rowData[0]);
            String name=rowData[1];
            String address=rowData[2];
            String tell=rowData[3];
            String email=rowData[4];
            StudentDTO sdto= new StudentDTO(id, name, address, email, tell);
            studentDTOs.add(sdto);
        }
        return studentDTOs;
    }
    
    public static StudentDTO serachStudent(int sid) throws Exception{
        FileReader fr=new FileReader("User/DataFile/Student.txt");
        BufferedReader br = new BufferedReader(fr);
        String rowLine;
        int id=000;
        String name = null;
        String address = null;
        String tell = null;
        String email = null;
        StudentDTO studentDTO=null ;
        while ((rowLine=br.readLine())!=null) {
            String[] rowData=rowLine.split(",");
            id=Integer.parseInt(rowData[0]);
            if (id==sid) {
                name=rowData[1];
                address=rowData[2];
                tell=rowData[3];
                email=rowData[4];
                studentDTO= new StudentDTO(id, name, address, email, tell);
            }
        }
        return studentDTO;
    }
    
    public boolean deleteStudent(String sid) throws Exception{
        BufferedReader bufferedReader =null;
        BufferedWriter bufferedWriter = null;
        boolean isDelete=false;
        FileReader fileReader = new FileReader("User/DataFile/Student.txt");
        bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> newData = new ArrayList<>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            if (!data[0].equals(sid)) {
                newData.add(line);
                isDelete=true;
            }
        }
        FileWriter fileWriter = new FileWriter("User/DataFile/Student.txt");
        bufferedWriter = new BufferedWriter(fileWriter);
        for (String string : newData) {
            bufferedWriter.write(string);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
        return isDelete;
            
    }
    
    public boolean updateStudent(StudentDTO player) throws Exception{
        BufferedReader bufferedReader =null;
        BufferedWriter bufferedWriter = null;
        boolean isDelete=true;
        FileReader fileReader = new FileReader("User/DataFile/Student.txt");
        bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> newData = new ArrayList<>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            if (!data[0].equals(player.getSid())) {
                isDelete=false;
                newData.add(line);
            }else{
                String modifyData = "";
                System.out.println("afdsf "+modifyData);
                modifyData += player.getSid() + ",";
                modifyData += player.getName() + ",";
                modifyData += player.getAddress() + ",";
                modifyData += player.getTell() + ",";
                modifyData += player.getEmail();
                newData.add(modifyData);
                System.out.println("afdsf "+modifyData);
                isDelete=true;
            }
        }
            
        FileWriter fileWriter = new FileWriter("User/DataFile/Student.txt");
        bufferedWriter = new BufferedWriter(fileWriter);
        for (String string : newData) {
            bufferedWriter.write(string);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
        return isDelete;
    }
}
