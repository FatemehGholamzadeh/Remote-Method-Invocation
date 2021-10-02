package DS.RMI;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Client2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        try {

            Account stub = (Account) Registry.find("Account", Account.class);
            int a = stub.getBalance(1234);
            System.out.println(a);
            System.out.println(stub.getName(1234));
            System.out.println(stub.startsWith(1234,'F'));

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}