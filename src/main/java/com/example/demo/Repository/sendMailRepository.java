package com.example.demo.Repository;

import com.example.demo.Model.Mail;

import javax.mail.MessagingException;

/**
 * 
 * @author RaisAhmad
 * @date 29/10/2021
 * @Discription Mail Repository
 * 
 */
public interface sendMailRepository {
	void sendMail(Mail mail);

    void sendMailWithAttachments(Mail mail) throws MessagingException;
}
