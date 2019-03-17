package com.infogain.petclinic.controllers;

import com.infogain.petclinic.exceptions.ValueNotFoundException;

public class IndexController {

    public String index(){

        return "index";
    }

    public String oopsHandler(){
    	throw new ValueNotFoundException();
    }
}
