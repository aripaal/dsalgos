package designpatterns;

import lombok.*;

public class ChainOfResponsiblity {
    public static void main(String ...args){
        ChainLogger logger = new FileLogger();
        logger.setNextLogger(new ConsoleLogger());

        logger.write(0,"From filelogger INFO");
        logger.write(1,"From filelogger DEBUG");
        logger.write(2,"From ConsoleLogger");
    }
}
abstract class ChainLogger {
    public static final int INFO = 0;
    public static final int DEBUG = 1;
    @Setter
    @Getter
    ChainLogger nextLogger;
    int level;
    abstract void write(int level, String message);
}

class FileLogger extends ChainLogger{

    @Override
    void write(int level, String message) {
        if(level == INFO || level == DEBUG)
            System.out.println("ChainLog: "+level+": "+message);
        else
            getNextLogger().write(level,message);
    }
}
class ConsoleLogger extends ChainLogger{

    @Override
    void write(int level, String message) {
        System.out.println("ConsoleLog: "+level+": "+message);
    }
}