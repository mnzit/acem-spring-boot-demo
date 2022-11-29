package com.acem.demo.utils;

import org.modelmapper.ModelMapper;

public class ModelMapperUtil {

    private static ModelMapper modelMapper = null;


    static {
        modelMapper = new ModelMapper();
    }

    public static <T> T map(Object object, Class<T> clazz) {
        return modelMapper.map(object, clazz);
    }

}
