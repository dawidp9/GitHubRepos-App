package com.piwko.dawid.searchgithubrepos;

import com.piwko.dawid.searchgithubrepos.model.AdapterFactory;
import com.piwko.dawid.searchgithubrepos.model.ZonedDateTimeAdapter;
import com.squareup.moshi.Moshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Objects;

public class TestUtilities {
    private static TestUtilities testUtilities = new TestUtilities();
    private static  Moshi moshi = init();

    private TestUtilities() {

    }

    public static <T> T loadJson(String path, Type type) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    Objects.requireNonNull(
                            testUtilities
                                    .getClass()
                                    .getClassLoader())
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


    private static Moshi init() {
        Moshi.Builder builder = new Moshi.Builder();
        builder.add(AdapterFactory.create());
        builder.add(new ZonedDateTimeAdapter());
        return builder.build();
    }
}
