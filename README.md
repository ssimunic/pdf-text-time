# PDF Text Time
Get PDF word count and estimated reading time required. Assumed reading time is 275 WPM.

Project is using [Apache PDFBox](https://pdfbox.apache.org/).

## Example

### Usage

#### Input args
```
/path/to/file.pdf
```

#### Input (compiled as JAR)
```
java -jar pdf-text-time.jar /path/to/file.pdf
```

#### Output
```
Given PDF has 403 words.
It will take about 0h 1m 27s to read it.
```

### Code
```java
...
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No file name given.");
            return;
        }

        String fileName = args[0];

        try {
            String text = getText(new File(fileName));
            TextTime textTime = new TextTime(text);

            System.out.println("Given PDF has " + textTime.wordCount() + " words.");
            System.out.println("It will take about " + textTime.readTimeHuman(TimeType.FULL) + " to read it.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
...
```
