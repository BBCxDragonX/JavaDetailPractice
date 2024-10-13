package com.dreamboat.serviceNmain;

import com.dreamboat.practiceModel.StudentBio;

public class studentService {
    public static void main(String[] args){
        StudentBio stuBio = new StudentBio();
        stuBio.setName("Nihal");
        stuBio.setAge("28");
        stuBio.setSubject("Mathematics");
        stuBio.setRollNo("2451-13-735-180");
        stuBio.setTotalMarks(99);

        System.out.println(stuBio.getName()+" "+stuBio.getAge()+" "+stuBio.getSubject()+" "+stuBio.getRollNo()+" "+stuBio.getTotalMarks());
    }
}
