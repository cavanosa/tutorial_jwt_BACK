package com.tutorial.crud.service;

import java.util.List;

public interface IAll <O>{
    O create(O o);
    O update(O o);
    void delete(int id);
    O read(int id);
    List<O> readAll();
}
