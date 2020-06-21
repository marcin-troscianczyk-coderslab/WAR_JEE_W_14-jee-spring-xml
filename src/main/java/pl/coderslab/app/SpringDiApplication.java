package pl.coderslab.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.coderslab.beans.HelloWorld;
import pl.coderslab.beans.MessageSender;
import pl.coderslab.beans.MessageService;

public class SpringDiApplication {

    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml")) {

            System.out.println("Test");
            HelloWorld hw = context.getBean("hw", HelloWorld.class);
            System.out.println("Message from bean " + hw.getMessage());

            System.out.println("EmailService");

            MessageService es = context.getBean("emailService", MessageService.class);
            es.send();

            System.out.println("MessageSender");
            MessageSender messageSender = context.getBean("messageSender", MessageSender.class);
            messageSender.sendMessage();

            System.out.println("MessageSender with configurable message");
            messageSender.sendMessageFromProperty();

            System.out.println("MessageSender2");
            MessageSender messageSender2 = context.getBean("messageSender2", MessageSender.class);
            messageSender2.sendMessageFromProperty();
        }
    }
}
