package com.github.moodtodie.lab1.entities;

import java.util.Date;

public record Error(Date timestamp, int statusCode, String message) {
}
