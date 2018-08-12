package com.dan.boot.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping(value = "/email")
public class EmailController {

//    有两种发送邮件的方式：1. Java Mail API 2.使用Spring提供的发送邮件的帮助类
    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value = "/mail",method = RequestMethod.GET)
    public String sendEmail(){
        try {
//            sendMail1();
//            pictureMail();
//            sendMail2();
            resourceMail();
            return "success";
        } catch (MessagingException e) {
            return "failed";
        }
    }

    public void sendMail1() throws MessagingException {
//        第一种方法 使用JavaMailSender API
       MimeMessage mimeMessage= mailSender.createMimeMessage();
       //设置收件人
       mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("2296560776@qq.com"));
       mimeMessage.setFrom(new InternetAddress("2296560776@qq.com"));
       mimeMessage.setText("hello this is a good offer");
       mimeMessage.setSubject("Spring Boot send email");
        mailSender.send(mimeMessage);
    }

    public void sendMail2() throws MessagingException {
         //spring提供的帮助类
        MimeMessage mimeMessage= mailSender.createMimeMessage();
        MimeMessageHelper helper= new MimeMessageHelper(mimeMessage);
        helper.setFrom("2296560776@qq.com");
        helper.setTo("2296560776@qq.com");
        helper.setSubject("Spring Boot send Email");
        helper.setText("hello this is second send for you");
        mailSender.send(mimeMessage);
    }

//    以上是发送简单邮件，总结三步

//    对下是发送复杂邮件

//    1、夹带附件--图片
     public void pictureMail() throws MessagingException {
       MimeMessage mimeMessage=mailSender.createMimeMessage();
       MimeMessageHelper helper= new MimeMessageHelper(mimeMessage,true);
       helper.setFrom("2296560776@qq.com");
       helper.setTo("2296560776@qq.com");
       helper.setSubject("Spring Boot send mail");
       helper.setText("hello this is third send email for you ");


         ClassPathResource file=new ClassPathResource("dan.jpg");
         helper.addAttachment("picture.jpg",file);
         mailSender.send(mimeMessage);
     }

//     2.内联资源
    public void resourceMail() throws MessagingException {
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper= new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("2296560776@qq.com");
//        普通发送
        helper.setTo("2296560776@qq.com");
//        密送
        helper.setBcc("17691032732@163.com");
//        转发
        helper.setCc("17691032732@163.com");
        helper.setSubject("Spring Boot sendInnerResource");


        //资源引用处设置cid,资源标识
        helper.setText("<html><body><img src='cid:dan'></body></html>",true);
        ClassPathResource file=new ClassPathResource("dan.jpg");
        //添加资源时指定cid,资源标识符
        helper.addInline("dan",file);
        mailSender.send(mimeMessage);

    }
}
