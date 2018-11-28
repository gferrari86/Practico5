package com.antel;

import com.antel.entities.Editorial;

import javax.ejb.Local;

@Local
public interface PlaceEditorialLocal {

    Editorial addEditorial(Editorial editorial);

}
