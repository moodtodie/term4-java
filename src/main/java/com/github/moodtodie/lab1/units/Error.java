package com.github.moodtodie.lab1.units;

import java.util.Date;

public record Error(Date timestamp, int statusCode, String message) {
}
