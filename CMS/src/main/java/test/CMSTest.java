package test;

import utils.DBUtils;
import dao.CustomerDao;
import entity.*;
import java.util.*;

public class CMSTest {
    public static void main(String[] args){

        CustomerDao dao = new CustomerDao();
        List<Customer> list = dao.findAll();
        Iterator<Customer> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getName());
        }


    }


}
