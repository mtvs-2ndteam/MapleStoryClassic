package com.contrabass.mapleclassic.utils;

public class MainException {
    public void validateInputValue(String readLine) {
        if (!readLine.matches("^[0-9]*?")) {
            throw new IllegalArgumentException("0~9 숫자만 입력하세요.");
        }
    }

    public int solveInputValueException(String readLine) {
        try {
            validateInputValue(readLine);
        } catch (IllegalArgumentException ie) {
            return -1;
        }
        return Integer.parseInt(readLine);
    }
}
