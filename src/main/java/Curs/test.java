package Curs;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.Properties;


public class test {

    public static void main(String[] args) throws IOException {

        String url = "https://cbr.ru/currency_base/daily/";

        Document doc = Jsoup.connect(url).get();
        Elements tables = doc.getElementsByTag("tbody");
        Element ourTable = tables.get(0);
        Elements elementsFromTable = ourTable.children();
        Element dollar = elementsFromTable.get(14);
        Elements dollarElements = dollar.children();
        Element euro = elementsFromTable.get(15);
        Elements euroElements = euro.children();

        String USD = dollarElements.get(4).text();
        String EUR = euroElements.get(4).text();
        System.out.println("Курс Доллара США в рублях по курсу ЦБ: " + USD);
        System.out.println("Курс Евро в рублях по курсу ЦБ: " + EUR);


        {

            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet("Курсы валют ЦБ");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Валюта");
            headerRow.createCell(1).setCellValue("Курс(руб)");

            Row headerRow1 = sheet.createRow(1);
            headerRow1.createCell(0).setCellValue("Доллар США");
            headerRow1.createCell(1).setCellValue(USD);

            Row headerRow2 = sheet.createRow(2);
            headerRow2.createCell(0).setCellValue("Евро");
            headerRow2.createCell(1).setCellValue(EUR);


            String filePath = "C:\\Users\\lerak\\IdeaProjects\\JavaEducation\\src\\exchange.xlsx";
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            System.out.println("Данные записаны в файл, путь: " + filePath);


        }

        final String username = "podosinovik777@gmail.com";
        final String password = "rafkiqcrmoqakpdw";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.starttls.enable", "true");


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("podosinovik777@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("andrey.ilyuk2@mail.ru"));
            message.setSubject("Уведомление с курсами валют");

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();

            String file = "C:\\Users\\lerak\\IdeaProjects\\JavaEducation\\src\\exchange.xlsx";
            String fileName = "exchange rate.xlsx";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            System.out.println("Отправка началась...");

            Transport.send(message);

            System.out.println("Отправка завершена успешно!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
