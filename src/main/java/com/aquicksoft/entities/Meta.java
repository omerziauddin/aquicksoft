package com.aquicksoft.entities;

import java.util.List;

import lombok.Data;

@Data
public class Meta {

    public Thumbs thumbs;
    public String urlScheme;
    public Boolean allowsAnonymousAccess;
    public Boolean indexable;
    public List<RedirectEntity> redirectEntity;


}
