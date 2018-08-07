package com.terms.config;


import com.terms.domen.MailInfo;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;


@Service
@Transactional
public class EmailService {

    private final static Logger log = Logger.getLogger(EmailService.class);
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Autowired
    public EmailService(MailConfig mailConfig) {
        this.javaMailSender = mailConfig.getMailSender();
    }


    @Async
    @Transactional
    public void sendMail(String toEmail, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }

    //@Async
    @Transactional
    public void sendMailHtml(MailInfo mail, Map<String, Object> params, String template, String image, String imageType, String... type) {

        try {

            InputStream inputStream = null;
            final Context ctx = new Context();
            ctx.setVariables(params);

            String html = springTemplateEngine.process(template, ctx);

            MimeMessage message = javaMailSender.createMimeMessage();

            if (type[0].equals("create"))
                message.setSubject(mail.getSubject()) ;

             else
                message.setSubject(mail.getChangePasswordSubject());

            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());
            helper.setText(html, true);

            inputStream = this.getClass().getClassLoader().getResourceAsStream("templates/img/" + image);
            byte[] imageByteArray = this.extract(inputStream);
            final InputStreamSource inputStreamSource = new ByteArrayResource(imageByteArray);
            helper.addInline(image, inputStreamSource, imageType);

            javaMailSender.send(message);

        } catch (MessagingException e) {

            throw new MailErrorException(e.getMessage());
        }

    }

    private byte[] extract(final InputStream input) {
        try {
            final byte[] buffer = new byte[(int) Math.min(Integer.MAX_VALUE, input.available() * 1.25)];
            try (final ByteArrayOutputStream baos = new ByteArrayOutputStream(buffer.length); //
                 final InputStream autoCloseInputStream = input) { // because it is fully consumed here
                for (int read; (read = autoCloseInputStream.read(buffer, 0, buffer.length)) != -1; ) {
                    baos.write(buffer, 0, read);
                }
                baos.flush();
                return baos.toByteArray();
            }
        } catch (IOException e) {

            throw new MailErrorException(e.getMessage());
        }

    }
}
