package com.piwko.dawid.searchgithubrepos.test;

import com.squareup.moshi.Moshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import javax.inject.Inject;

public class TestUtilities {

    private Moshi moshi;

    @Inject
    TestUtilities(Moshi moshi) {
        this.moshi = moshi;
    }

    public <T> T loadJson(String path, Type type) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                                    getClass()
                                    .getClassLoader()
                                            .getResourceAsStream(path)));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String json = stringBuilder.toString();
            //noinspection unchecked
            return (T) moshi.adapter(type).fromJson(json);
        } catch (IOException e) {
            throw new IllegalArgumentException("Error deserialize");
        }
    }
}
