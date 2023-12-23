package com.example.parkingproviderservice.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableBuilder {
	public static Pageable build(int pageNo, int size, String sortBy) {
		List<Sort.Order> sorts = new ArrayList<>();
		String[] _fields = sortBy.split(",");
		for (String field : _fields) {
			String[] _field = field.split("_");
			sorts.add(new Sort.Order(Sort.Direction.fromString(_field[1].toUpperCase()), _field[0]));
		}
		Pageable pageable = PageRequest.of(pageNo, size, Sort.by(sorts));
		return pageable;
    }
}
