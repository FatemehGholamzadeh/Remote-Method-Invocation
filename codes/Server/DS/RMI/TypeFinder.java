package DS.RMI;

import java.util.HashMap;

public class TypeFinder {
    protected HashMap<Class, Class> classTabel;

    public TypeFinder(){
        classTabel = new HashMap<>();
        classTabel.put(Integer.class,int.class);
        classTabel.put(Character.class,char.class);
        classTabel.put(Boolean.class,boolean.class);
        classTabel.put(String.class,String.class);
        classTabel.put(Long.class,long.class);
        classTabel.put(Short.class,short.class);
        classTabel.put(Double.class,double.class);
        classTabel.put(Float.class,float.class);
        classTabel.put(Byte.class,byte.class);
    }

}