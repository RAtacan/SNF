package com.searchandfound.snf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ridvan on 18.08.2016.
 */
public class EntryDB {

    private final static Entry [] ENTRYS = {

            new Entry("Artikel1",0)
    };

    private final static Map<String, Entry> ENTRY_MAP = new HashMap<>();

    private final static String[] ENTRY_LIST;

    static {

        for (Entry r : ENTRYS) {
            ENTRY_MAP.put(r.getName(), r);
        }
        ENTRY_LIST = new String[ENTRY_MAP.size()];

        ENTRY_MAP.keySet().toArray(ENTRY_LIST);
        Arrays.sort(ENTRY_LIST);

    }

    public String[] getEntryNames(){

        return ENTRY_LIST;
    }

}
