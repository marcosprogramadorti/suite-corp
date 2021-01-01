package br.suite.honra.service;

import javax.ejb.Stateless;

@Stateless
public class CalculatorService {

    public int doubleOf(int number) {
        return number * 2;
    }
}