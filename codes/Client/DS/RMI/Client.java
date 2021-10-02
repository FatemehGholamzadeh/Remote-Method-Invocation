package DS.RMI;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Client {

    public static void main(String[] args) {
        try {

            Account stub = (Account) Registry.find("Account", Account.class);
            double a = stub.check(1234);
            System.out.println(a);
//            System.out.println(stub.deposit(1234, 1000));

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