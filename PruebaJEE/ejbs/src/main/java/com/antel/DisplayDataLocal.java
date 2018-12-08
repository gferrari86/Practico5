package com.antel;

import com.antel.entities.Publicacion;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DisplayDataLocal {

    public List<Publicacion> DisplayAllPublicaciones();
}
