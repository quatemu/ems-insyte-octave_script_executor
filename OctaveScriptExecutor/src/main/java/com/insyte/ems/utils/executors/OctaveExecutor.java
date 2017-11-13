package com.insyte.ems.utils.executors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OctaveExecutor {
    /**
     * На вход подается путь до октава-файла,
     * На выходе имеем список значений, которые были напечатаны(printf, putch, ...)
     * в результате выполнения скрипта
     * @param pathToOctaveScriptFile - путь файловой системы до октава-скрипта
     */
    public List<String> Execute(String pathToOctaveScriptFile){
        List<String> results = null;
        try
        {
            //Для линукса использовать bash -c
            Process p=Runtime.getRuntime().exec(String.format(
                    "cmd.exe /c octave --no-gui -f \"%s\"",
                    pathToOctaveScriptFile
            ));
            p.waitFor();
            BufferedReader reader=new BufferedReader(
                    new InputStreamReader(p.getInputStream())
            );
            String line;
            results = new ArrayList<>();
            while((line = reader.readLine()) != null){
                results.add(line);
            }
        }
        catch(IOException e1) {e1.printStackTrace();}
        catch(InterruptedException e2) {e2.printStackTrace();}
        return results;
    }
}
