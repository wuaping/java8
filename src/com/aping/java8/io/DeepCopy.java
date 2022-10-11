package com.aping.java8.io;

import com.aping.java8.stream.User;

import java.io.*;
import java.math.BigDecimal;

/**
 * 深拷贝
 *
 * @author Aping
 * @since 2022/9/19 17:09
 */
public class DeepCopy {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User(4L, "D", 25, new BigDecimal("400"));
        User.AccountInfo accountInfo = new User.AccountInfo();
        accountInfo.setAccountNo("4");
        accountInfo.setAccountName("4");
        user.setAccountInfo(accountInfo);

        User copy = deepCopyObj(user);

        user.getAccountInfo().setAccountName("changed !");

        System.out.println(user.getAccountInfo().getAccountName());
        System.out.println(copy.getAccountInfo().getAccountName());
    }


    public static <T> T deepCopyObj(T object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(object);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        return (T) in.readObject();
    }
}
