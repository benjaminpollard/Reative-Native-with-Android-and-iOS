package com.demo.controllers;

public abstract class ControllerGetCallBack<T> {
    public abstract void Update(T object,  String error, int code);
}
