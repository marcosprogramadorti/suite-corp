package br.suite.honra.negocio.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class Conversor {
    private static Conversor conversor;
    private static ModelMapper modelMapper;

    public static Conversor getInstancia() {
        if (conversor == null) {
            conversor = new Conversor();
        }
        return conversor;
    }

    public static ModelMapper getInstanciaModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }
        return modelMapper;
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> getInstanciaModelMapper().map(element, targetClass))
                .collect(Collectors.toList());
    }
}
