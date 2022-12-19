package com.tutorial.crud.service;


import com.tutorial.crud.entity.OrganizacionesNueva;

import java.util.List;

public interface INuevaOrg {

    List<OrganizacionesNueva> getAllOrganizaciones();
    OrganizacionesNueva save(OrganizacionesNueva organizacionesNueva);

}
