package com.demo.repos;

public abstract class RepoCallBack<T> {
    public abstract void RepoResult(T data, String error, int code);
}



