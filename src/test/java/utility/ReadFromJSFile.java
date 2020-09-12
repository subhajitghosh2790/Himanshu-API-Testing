package utility;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFromJSFile {
    Object result;
    ReadProperties p = new ReadProperties();
    List<String> l = new ArrayList<String>();
    FileReader file;
    ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");

    public FileReader loadJSFile(String JSFile) {
        // Reading Nashorn file
        try {
            System.out.println("debug 1".toString());
            if (ee == null) {
                throw new UnsupportedOperationException("JS scripting engine not found");
            }
            file = new FileReader(JSFile);
            ee.eval(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }


    public String invokeJSMethod(String JSfunctionName) {
        System.out.println("debug 2".toString());
        Invocable invocable = (Invocable) ee;
        System.out.println("debug 3".toString());

        try {
            result = invocable.invokeFunction(JSfunctionName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String S = result + "";
        return S;
    }


    public List<String> writePaymentHeaders(String msgSign, String clientReq, String timeStp) {
        FileReader f = loadJSFile("src/test/java/utility/signature.js");
        System.out.println("File value -->" + f);
        String[] s = invokeJSMethod("allHeaders").split("::", 3);
        for (String a : s)
            l.add(a);

        p.writeprop(msgSign, l.get(0));
        p.writeprop(clientReq, l.get(1));
        p.writeprop(timeStp, l.get(2));

        return l;

    }


    public List<String> attestrationHeaders(String correlationID, String timestmp) {
        FileReader f = loadJSFile("src/test/java/utility/attestration.js");
        System.out.println("File value -->" + f);
        String[] s = invokeJSMethod("allHeaders").split("::", 2);
        for (String a : s)
            l.add(a);

        System.out.println("C is  = " + l.get(0));
        System.out.println("T is = " + l.get(1));

        p.writeprop(correlationID, l.get(0));
        p.writeprop(timestmp, l.get(1));

        return l;

    }

    public static void main(String[] args) {
       // System.out.println(attestrationHeaders());

    }

}
