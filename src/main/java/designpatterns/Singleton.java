package designpatterns;

import lombok.*;

public class Singleton {
    public static void main(String ...args){
        SingletonSimple singletonSimple = SingletonSimple.getInstance();
        SingletonLazy singletonLazy = SingletonLazy.getInstance();
        SingletonDoubleLocked singletonDoubleLocked =SingletonDoubleLocked.getInstance();
        SingletonEnum singletonEnum = SingletonEnum.getInstance();
    }
}

class SingletonSimple {
    private SingletonSimple() {
    }

    @Getter
    @Setter
    private String value;
    private static SingletonSimple singleton = new SingletonSimple();

    public static SingletonSimple getInstance() {
        return singleton;
    }
}

class SingletonLazy {
    private SingletonLazy() {
    }

    @Getter
    @Setter
    private String value;
    private static SingletonLazy singleton = null;

    public static SingletonLazy getInstance() {
        if (singleton == null) {
            singleton = new SingletonLazy();
        }
        return singleton;
    }
}
// Thread safe
class SingletonDoubleLocked {
    private SingletonDoubleLocked() {
    }

    @Getter
    @Setter
    private String value;
    private static SingletonDoubleLocked singleton = null;

    public static SingletonDoubleLocked getInstance() {
        if (singleton == null) {
            synchronized (SingletonDoubleLocked.class) {
                if (singleton == null) {
                    singleton = new SingletonDoubleLocked();
                }
            }
        }
        return singleton;
    }
}
//Thread safe
enum SingletonEnum {
    INSTANCE;
    @Getter
    @Setter
    private String value;

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }
}