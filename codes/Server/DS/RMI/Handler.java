package DS.RMI;

import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Handler implements InvocationHandler{

    String InterfaceName = null;

    public Handler(String InterfaceName){
        this.InterfaceName = InterfaceName;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        RMIMessage rmiMessage = new RMIMessage(InterfaceName,method.getName(),args);
        InetAddress host = InetAddress.getLocalHost();
        Socket s =  new Socket(host.getHostName(), 6666);
        OutputStream os = s.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(rmiMessage);
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        RMIMessage message = (RMIMessage) ois.readObject();
        Object returnValue =  message.inputs[0];
        ois.close();
        oos.close();
        Thread.sleep(1000);
        return returnValue;
    }

}
