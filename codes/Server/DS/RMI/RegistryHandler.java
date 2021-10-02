package DS.RMI;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.HashMap;
import java.lang.reflect.Method;

public class RegistryHandler extends Registry implements Runnable {

    protected Socket socket = null;

    public RegistryHandler(Socket s, HashMap table) {
        super();
        this.socket = s;
        this.objTable = table;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            RMIMessage message = (RMIMessage) ois.readObject();
            if (message != null) {
                Remote server = objTable.get(message.InterfaceName);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Object[] inputs = message.inputs;
                Class[] classes = new Class[inputs.length];
                TypeFinder TF = new TypeFinder();

                for (int i = 0; i < inputs.length; i++) {
                    classes[i] = TF.classTabel.get(inputs[i].getClass());
                }

                System.out.println("Client connected with id : " + inputs[0]);
                Method method = server.getClass().getMethod(message.methodName, classes);
                Object[] output = new Object[1];
                output[0] = method.invoke(server, inputs);
                RMIMessage rmiMessage = new RMIMessage(message.InterfaceName, message.methodName, output);
                oos.writeObject(rmiMessage);
                Thread.sleep(4000);
                ois.close();
                oos.close();
                socket.close();
            }

        } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Error closing server", e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
