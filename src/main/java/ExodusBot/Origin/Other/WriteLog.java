//package ExhibitBot.Origin.Other;
//
//import java.io.*;
//import java.util.logging.FileHandler;
//import java.util.logging.Logger;
//import java.util.logging.SimpleFormatter;
//
///**
// * Created by josep on 10/06/2017.
// */
//public class WriteLog {
//
//    public static void writeToFile(String text){
//
//        Logger logger = Logger.getLogger("MyLog");
//        FileHandler fh;
//
//        try {
//
//            // This block configure the logger with handler and formatter
//            fh = new FileHandler("MyLogFile.log");
//            logger.addHandler(fh);
//            SimpleFormatter formatter = new SimpleFormatter();
//            fh.setFormatter(formatter);
//
//            // the following statement is used to log any messages
//            logger.info(text);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//    }
//
//}
