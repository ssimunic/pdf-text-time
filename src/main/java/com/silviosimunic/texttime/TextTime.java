package com.silviosimunic.texttime;

public class TextTime {
    private final int WORDS_PER_MINUTE = 275;

    private String text;
    private int hours;
    private int minutes;
    private int seconds;

    public TextTime(String text) throws IllegalArgumentException {
        if (text.length() == 0) {
            throw new IllegalArgumentException();
        }

        this.text = text;

        calculateTime();
    }

    private void calculateTime() {
        float milliseconds = averageReadMinutes(wordCount()) * 60 * 1000;

        hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
        minutes = (int) ((milliseconds / (1000 * 60)) % 60);
        seconds = (int) (milliseconds / 1000) % 60;
    }

    public String readTimeHuman(TimeType type) {
        String averageReadTime = "";

        switch (type) {
            case HOURS:
                averageReadTime = hours + "h";
                break;
            case MINUTES:
                averageReadTime = minutes + "m";
                break;
            case HOURS_AND_MINUTES:
                averageReadTime = hours + "h " + minutes + "m";
                break;
            case MINUTES_AND_SECONDS:
                averageReadTime = minutes + "m " + seconds + "s";
                break;
            case FULL:
                averageReadTime = hours + "h " + minutes + "m " + seconds + "s";
                break;
        }

        return averageReadTime;
    }

    public int wordCount() {
        String trimmed = text.trim();
        int words = trimmed.split("\\s+").length;

        return words;
    }

    private float averageReadMinutes(float words) {
        return words / WORDS_PER_MINUTE;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return text;
    }
}
