package controller.customer;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet("/sendEmail")
public class ManagermentSendEmailController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String subject, email, msg;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        email = req.getParameter("email");
        msg = req.getParameter("message");
        subject="Funiture Shop";

        if (email == null || email.isEmpty() ||
                msg == null || msg.isEmpty()) {
            out.println("<center><h2 style='color:red;'>Error: All fields are required.</h2></center>");
            return;
        }

        final String username = "furnitureshop267@gmail.com";
        final String password = "mhtl zdjn hyaj udsa";

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            // Tạo nội dung email dưới dạng HTML và thiết lập mã hóa UTF-8
            MimeBodyPart textPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            String final_Text = "<h3>Furniture Shop</h3>"
                    + "<p><b>Thông báo khóa tài khoản tại Furniture Shop</b></p>"
                    + "<p>Chúng tôi xin thông báo rằng tài khoản của bạn trên Furniture Shop đã bị khóa.</p>"
                    + "<p>Nguyên nhân: " + msg + ".</p>"
                    + "<p>Quyết định này được đưa ra sau khi chúng tôi ghi nhận một số hoạt động không đúng quy định, gây ảnh hưởng đến quy trình hoạt động của cửa hàng.</p>"
                    + "<p>Tài khoản bị khóa, bạn sẽ không thể truy cập và sử dụng dịch vụ trên Furniture Shop.</p>"
                    + "<p>Trân trọng,<br>Furniture Shop</p>";
            textPart.setContent(final_Text, "text/html; charset=UTF-8");
            multipart.addBodyPart(textPart);
            message.setContent(multipart);

            Transport.send(message);
            out.println("<center><h2 style='color:Blue;'>Email Sent Successfully.</h2>");
            out.println("Thank you ,your message has been submitted to the recipient.</center>");
        } catch (MessagingException e) {
            e.printStackTrace();
            out.println("<center><h2 style='color:red;'>Error: Unable to send email. " + e.getMessage() + "</h2></center>");
        }
    }
}
