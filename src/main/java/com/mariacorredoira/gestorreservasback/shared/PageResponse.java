package com.mariacorredoira.gestorreservasback.shared;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class PageResponse<T> {
    private List<T> data;
    private Integer page; // numero de pagina en el que me encuentro
    private Long total; // total de elementos que existen
}
