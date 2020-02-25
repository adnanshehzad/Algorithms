package util;

public class Util {
	public static String getClassNameNoPackage(Class aClass){ 
        
        String fullClassName = aClass.getName();
        int index = fullClassName.lastIndexOf('.');
        String className = null;
        String packageName = null;
        
        
        //in this case, there is no package name
        if(index==-1) {
            return fullClassName;
        }
        else {
				  //for other apps, may be useful to have this
            packageName = fullClassName.substring(0,index);

            className = fullClassName.substring(index+1);
            return className;
        }    
    }
	public static double log2(double x) {
		return (Math.log(x)/Math.log(2));
	}
}


