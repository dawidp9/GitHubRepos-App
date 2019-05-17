package com.piwko.dawid.searchgithubrepos.model;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.threeten.bp.ZonedDateTime;

import javax.annotation.Nullable;


@AutoValue
public abstract class Repo {

    public abstract long id();

    @Json(name = "node_id")
    public abstract String nodeId();

    public abstract String name();

    @Nullable
    public abstract String description();

    @Json(name = "html_url")
    public abstract String htmlUrl();

    @Json(name = "ssh_url")
    public abstract String sshUrl();

    public abstract long size();

    @Nullable
    public abstract String language();

    @Json(name = "stargazers_count")
    public abstract long stargazersCount();

    @Json(name = "watchers_count")
    public abstract long watchersCount();

    @Json(name = "forks_count")
    public abstract long forksCount();

    @Json(name = "created_at")
    public abstract ZonedDateTime createdDate();

    @Json(name = "updated_at")
    public abstract ZonedDateTime updatedDate();

    @Json(name = "default_branch")
    public abstract String defaultBranch();

    public static JsonAdapter<Repo> jsonAdapter(Moshi moshi) {
        return new AutoValue_Repo.MoshiJsonAdapter(moshi);
    }
}
