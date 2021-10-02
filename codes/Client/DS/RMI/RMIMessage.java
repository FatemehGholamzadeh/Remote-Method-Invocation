package DS.RMI;

import java.io.Serializable;

public class RMIMessage implements Serializable {

    public static final long serialVersionUID =2L;

    protected String methodName = null;
    protected String InterfaceName = null;
    protected Object[] inputs = null;

    public RMIMessage(String InterfaceName,String methodName,Object[] inputs) {
        this.InterfaceName = InterfaceName;
        this.methodName = methodName;
        this.inputs = inputs;
    }

}
