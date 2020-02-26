package com.librairie.reservation.dto;

import com.librairie.reservation.beans.LivreBean;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class ReservDto implements Serializable {
    private List<LivreBean>     collection;
    private Map<String, String> user;
}
