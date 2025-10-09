package com.labSync.LabSync.infra;

import org.springframework.http.HttpStatus;

public record RestErrorMessage(int code, HttpStatus status, String message) {
}
