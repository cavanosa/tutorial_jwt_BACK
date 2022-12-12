package com.tutorial.crud.service;
import java.util.List;

import com.tutorial.crud.entity.Requisito;




public interface IRequisito {
 List<Requisito> getAllRequisito();    
 Requisito save(Requisito rqt);
    void deleteById(int id);
}
