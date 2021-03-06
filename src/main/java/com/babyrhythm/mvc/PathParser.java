package com.babyrhythm.mvc;

import org.apache.commons.lang3.StringUtils;

public class PathParser {

    private String rest;

    public PathParser(String string) {
        this.rest = string;
    }

    public static PathParser pathInfoParser(String pathInfo) {
        if (pathInfo == null)
            pathInfo = "";

        if (pathInfo.startsWith("/")) {
            pathInfo = pathInfo.substring(1);
        }

        return new PathParser(pathInfo);
    }

    public static String[] parseTail(String a) {
        if (StringUtils.isBlank(a))
            return new String[] { null, null };

        int idx = a.indexOf('/');
        if (idx == -1)
            return new String[] { a, null };

        String head = a.substring(0, idx);
        String tail = a.substring(idx + 1);
        return new String[] { head, tail };
    }

    public String getRest() {
        return this.rest;
    }

    public String cutNext() {
        String[] all = parseTail(this.rest);
        this.rest = all[1];
        return all[0];
    }

}
