package DS.RMI;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Registry {
    protected HashMap<String,Remote> objTable;

    public void bind(String name , Remote obj) throws IOException {
        objTable = new HashMap<>();
        Account a = (Account) obj;
        objTable.put(name, a);
        System.out.println("server ready");
        ServerSocket listener = new ServerSocket(6666);
        while (true) {
            Socket s = listener.accept();
            RegistryHandler rg = new RegistryHandler(s,objTable);
            rg.run();
        }
    }


    public static Remote find(String name, Class reg) throws IOException, ClassNotFoundException, InterruptedException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Handler handler = new Handler(name);

        return (Remote) Proxy.newProxyInstance(reg.getClassLoader(),
                new Class[]{reg},
                handler);

    }


}
