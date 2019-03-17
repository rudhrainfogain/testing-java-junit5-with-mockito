package com.infogain.petclinic.fauxspring;

import java.text.ParseException;
import java.util.Locale;

import com.infogain.petclinic.model.PetType;


public interface Formatter<T> {

    String print(PetType petType, Locale locale);

    PetType parse(String text, Locale locale) throws ParseException;
}
