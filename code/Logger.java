import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
/**
 * Logger tool used to create log file and log actions / exceptions respectively
 * 
 * @author YBZ
 * @version 1.0.0
 */
public class Logger
{
    private final Date INSTANCE;
    private final String LOGFOLDER;
    
    /**
     * simple constructor initializes current version of logger
     * 
     * @since 1.0.0
     */
    public Logger()
    {
        this("logs");
    }

    /**
     * simple constructor initializes current version of logger and a specified folder for logs
     * 
     * @param logFolder user specified log folder
     * @since 1.0.0
     */
    public Logger(String logFolder)
    {
        this(new Date(), logFolder);
    }

    /**
     * full constructor initializes all fields
     * 
     * @param instance date instance
     * @param logFolder log folder name
     * @since 1.0.0
     */
    private Logger(Date instance, String logFolder)
    {
        this.INSTANCE = instance;
        this.LOGFOLDER = logFolder;
    }

    /**
     * get the date instance version of the logger
     * 
     * @return String of format YYYY-MM-DD
     * @since 1.0.0
     */
    public String getInstance()
    {
        return formatDate(this.INSTANCE);
    }

    /**
     * get the folder name of logger
     * 
     * @return LOGFOLDER field
     * @since 1.0.0
     */
    public String getFolder()
    {
        return this.LOGFOLDER;
    }

    private Path getFile()
    {
        return Paths.get(this.LOGFOLDER+"//"+getInstance()+".log");
    }

    /**
     * logs exceptions with message and stack trace
     * 
     * @param e Exception with or without a message
     * @return success of log
     * @since 1.0.0
     */
    public boolean log(Exception e)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String s = sw.toString();
        return log(s);
    }

    /**
     * adds a log line with a message
     * 
     * @param message message to be logged
     * @return success of log
     * @since 1.0.0
     */
    public boolean log(String message)
    {
        Date time = new Date();
        String t = formatTime(time);
        String text = String.format("[%s] %s\n",t,message);
        try{
            if (!(Files.exists(getFile())))
                Files.createFile(getFile());
            Files.write(getFile(), text.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * returns the formated time like HH-MM-SS
     * 
     * @param date Date object to be formated
     * @return formated string
     * @since 1.0.0
     */
    private static String formatTime(Date date)
    {
        int hours = date.getHours();
        String h = String.format("%s",hours);
        if (hours<10)
            h = "0"+h;
        int minutes = date.getMinutes();
        String m = String.format("%s", minutes);
        if (minutes<10)
            m = "0"+m;
        int seconds = date.getSeconds();
        String s = String.format("%s",seconds);
        if (seconds<10)
            s = "0"+s;
        return String.format("%s:%s:%s", h,m,s);
    }
    
    /**
     * returns the formated date like YYYY-MM-DD
     * 
     * @param date Date object to be formated
     * @return formated string
     * @since 1.0.0
     */
    private static String formatDate(Date date)
    {
        int year = date.getYear()+1900;
        String y = String.format("%s",year);
        int months = date.getMonth()+1;
        String m = String.format("%s", months);
        if (months<10)
            m = "0"+m;
        int days = date.getDate();
        String d = String.format("%s",days);
        if (days<10)
            d = "0"+d;
        return String.format("%s-%s-%s", y,m,d);
    }
}