package com.mohistmc.util;

import com.mohistmc.util.i18n.i18n;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EulaUtil {
    public static void writeInfos() throws IOException {
        new File("eula.txt").createNewFile();
        BufferedWriter b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("eula.txt"), "UTF-8"));
        b.write(i18n.get("eula.text", "https://account.mojang.com/documents/minecraft_eula") + "\n" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "\neula=true");
        b.close();
    }

    public static boolean hasAcceptedEULA() throws IOException {
        if(new File("eula.txt").exists())
            return FileUtil.readContent(new File("eula.txt")).contains("eula=true");
        return false;
    }
}